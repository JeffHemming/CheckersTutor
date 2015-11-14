import java.sql.Struct;
import java.util.ArrayList;

/**
 * Created by Dad on 11/14/2015.
 */
public class Jumps {

    public static ArrayList<Move> findJumps(char[] board, int piece, char me, ArrayList<Move> takerList){
        int type=-1;
        char enemy='e',enemyKing='E';
        if(me=='b'||me=='B'){
            enemy='r';
            enemyKing='R';
            if(me=='b')type=1;
            else type=3;
        }
        if(me=='r'||me=='R'){
            enemy='b';
            enemyKing='B';
            if(me=='r')type=2;
            else type=3;
        }
        int row=piece/4%2;
        if(type==1||type==3){
            if(piece>8&&piece%4!=0&&board[piece-9]=='x'&&(board[piece-4-row]==enemy||board[piece-4-row]==enemyKing)) {//can jump up left;
                takerList.add(new Move(piece,piece-9,piece-4-row,me));
            }
            if(piece>7&&(piece+1)%4!=0&&board[piece-7]=='x'&&(board[piece-3-row]==enemy||board[piece-3-row]==enemyKing)) {//can jump up right
                takerList.add(new Move(piece,piece-7,piece-3-row,me));
            }
        }
        if(type==2||type==3){
            if(piece<24&&piece%4!=0&&board[piece+7]=='x'&&(board[piece+4-row]==enemy||board[piece+4-row]==enemyKing)) {//can jump down left;
                takerList.add(new Move(piece, piece +7, piece + 4 - row,me));
            }
                if(piece<24&&(piece+1)%4!=0&&board[piece+9]=='x'&&(board[piece+5-row]==enemy||board[piece+5-row]==enemyKing)) {//can jump up right
                    takerList.add(new Move(piece, piece + 9, piece + 5 - row,me));
                }
        }
        return takerList;
    }

    public static boolean isMine(char[] board, int piece, boolean player){
        if(player&&board[piece]=='b')return true;
        if(player&&board[piece]=='B')return true;
        if(!player&&board[piece]=='r')return true;
        if(!player&&board[piece]=='R')return true;
        return false;
    }

    public static void lengthenMove(char[]board,Move curr,boolean player,StateList state){
        int type=-1;
        char enemy='e',enemyKing='E';
        if(curr.me=='b'||curr.me=='B'){
            enemy='r';
            enemyKing='R';
            if(curr.me=='b')type=1;
            else type=3;
        }
        if(curr.me=='r'||curr.me=='R'){
            enemy='b';
            enemyKing='B';
            if(curr.me=='r')type=2;
            else type=3;
        }
        if(Logic.newKing(board,curr.end,player,type==3)){
            state.moveList.add(curr);
            return;
        }
        boolean added=false;
        int row=curr.end/4%2;
        if(type==1||type==3){
            if(curr.end>8&&curr.end%4!=0&&board[curr.end-9]=='x'&&(board[curr.end-4-row]==enemy||board[curr.end-4-row]==enemyKing)&&!curr.takenlist.contains(curr.end-4-row)) {//can jump up left;
                Move m=new Move(curr);
                m.takenlist.add(m.end-4-row);
                m.end-=9;
                state.takerList.add(m);
                added=true;
            }
            if(curr.end>7&&(curr.end+1)%4!=0&&board[curr.end-7]=='x'&&(board[curr.end-3-row]==enemy||board[curr.end-3-row]==enemyKing)&&!curr.takenlist.contains(curr.end-3-row)) {//can jump up right
                Move m=new Move(curr);
                m.takenlist.add(m.end-3-row);
                m.end-=7;
                state.takerList.add(m);
                added=true;
            }
        }
        if(type==2||type==3){
            if(curr.end<24&&curr.end%4!=0&&board[curr.end+7]=='x'&&(board[curr.end+4-row]==enemy||board[curr.end+4-row]==enemyKing)&&!curr.takenlist.contains(curr.end+4-row)) {//can jump down left;
                Move m=new Move(curr);
                m.takenlist.add(m.end+4-row);
                m.end+=7;
                state.takerList.add(m);
                added=true;
            }
            if(curr.end<24&&(curr.end+1)%4!=0&&board[curr.end+9]=='x'&&(board[curr.end+5-row]==enemy||board[curr.end+5-row]==enemyKing)&&!curr.takenlist.contains(curr.end+5-row)) {//can jump up right
                Move m=new Move(curr);
                m.takenlist.add(m.end+5-row);
                m.end+=9;
                state.takerList.add(m);
                added=true;
            }
        }
        if(!added)state.moveList.add(curr);
    }

    public static ArrayList<Move> createTakeList(char[]board,boolean player){
        StateList state=new StateList();
        for(int i=0;i<32;i++){
            if(isMine(board,i,player)){
                state.takerList=findJumps(board,i,board[i],state.takerList);
            }
        }
        while(!state.takerList.isEmpty()){
            //Add to takerListMoves
            Move curr=new Move(state.takerList.get(0));
            state.takerList.remove(0);
            lengthenMove(board, curr, player,state);
        }
        return state.moveList;
    }
}
