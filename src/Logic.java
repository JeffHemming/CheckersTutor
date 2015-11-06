import java.util.ArrayList;

/**
 * Created by Dad on 10/31/2015.
 */
public class Logic {

    public static boolean checkLegal(char[] iboard,int piece,int target, boolean forceJump, boolean player){
        char[] board=new char[32];
        board=iboard;
        char enemy,enemyK;
        if(player){
            enemy='r';
            enemyK='R';
        }
        else{
            enemy='b';
            enemyK='B';
        }
        if((player||board[piece]=='R')&&piece-target>0){
            int diff=piece-target;
            if(diff==4){
                if(forceJump)return false;
                if(board[target]=='x')return true;
                else return false;
            }
            if(diff==5){
                if(forceJump)return false;
                if(piece%4==0||piece/4%2==0)return false;
                if(board[target]=='x')return true;
                else return false;
            }
            if(diff==3){
                if(forceJump)return false;
                if(piece/4%2==1||piece==3||piece==11||piece==19||piece==27)return false;
                if(board[target]=='x')return true;
                else return false;
            }
            if(diff==7){
                if((piece+1)%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece-3]==enemy||board[piece-3]==enemyK))return true;
                if((piece/4)%2==1&&(board[piece-4]==enemy||board[piece-4]==enemyK))return true;
                return false;
            }
            if(diff==9){
                if(piece%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece-4]==enemy||board[piece-4]==enemyK))return true;
                if((piece/4)%2==1&&(board[piece-5]==enemy||board[piece-5]==enemyK))return true;
                return false;
            }
            return false;
        }
        if((!player||board[piece]=='B')&&piece-target<0){
            int diff=piece-target;
            if(diff==-4){
                if(forceJump)return false;
                if(board[target]=='x')return true;
                else return false;
            }
            if(diff==-5){
                if(forceJump)return false;
                if((piece+1)%4==0||piece/4%2==1)return false;
                if(board[target]=='x')return true;
                else return false;
            }
            if(diff==-3){
                if(forceJump)return false;
                if(piece/4%2==0||piece==4||piece==12||piece==20||piece==28)return false;
                if(board[target]=='x')return true;
                else return false;
            }
            if(diff==-9){
                if((piece+1)%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece+5]==enemy||board[piece+5]==enemyK))return true;
                if((piece/4)%2==1&&(board[piece+4]==enemy||board[piece+4]==enemyK))return true;
                return false;
            }
            if(diff==-7){
                if(piece%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece+4]==enemy||board[piece+4]==enemyK))return true;
                if((piece/4)%2==1&&(board[piece+3]==enemy||board[piece+3]==enemyK))return true;
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean checkMyPiece(char[] board, boolean player, int i){
        if(player&&(board[i]=='b'||board[i]=='B'))return true;
        if(!player&&(board[i]=='r'||board[i]=='R'))return true;
        return false;
    }

    public static char[] movePiece(char[] board,Move m){
        char[] thisboard=new char[32];
        for(int i=0;i<32;i++)thisboard[i]=board[i];
        int dist=m.start-m.end;
        thisboard[m.end]=thisboard[m.start];
        thisboard[m.start]='x';
        if(dist==7){
            if(m.start/4%2==0)thisboard[m.start-3]='x';
            else thisboard[m.start-4]='x';
        }
        if(dist==9){
            if(m.start/4%2==0)thisboard[m.start-4]='x';
            else thisboard[m.start-5]='x';
        }
        if(dist==-7){
            if(m.start/4%2==0)thisboard[m.start+4]='x';
            else thisboard[m.start+3]='x';
        }
        if(dist==-9){
            if(m.start/4%2==0)thisboard[m.start+5]='x';
            else thisboard[m.start+4]='x';
        }
        return thisboard;
    }

    public static boolean checkKing(int i, boolean player, boolean selectedKing){
        if(!selectedKing&&player&&i<4)return true;
        if(!selectedKing&&!player&&i>27)return true;
        return false;
    }

    public static ArrayList<Move> runACheck(boolean player, char[]board, boolean forceJump){
        ArrayList<Move> movelist=new ArrayList<Move>();
        char me,meK;
        if(player){
            me='b';
            meK='B';
        }
        else{
            me='r';
            meK='R';
        }
        for(int i=0;i<32;i++){
            if((player&&board[i]==me)||board[i]==meK){
                if(i-7>=0&&checkLegal(board,i,i-7,forceJump,player)){
                    movelist.add(new Move(i,i-7,true));
                    forceJump=true;
                }
                if(i-9>=0&&checkLegal(board,i,i-9,forceJump,player)){
                    movelist.add(new Move(i,i-9,true));
                    forceJump=true;
                }
            }
            if((!player&&board[i]==me)||board[i]==meK){
                if(i+7<32&&checkLegal(board,i,i+7,forceJump,player)){
                    movelist.add(new Move(i,i+7,true));
                    forceJump=true;
                }
                if(i+9<32&&checkLegal(board,i,i+9,forceJump,player)){
                    movelist.add(new Move(i,i+9,true));
                    forceJump=true;
                }
            }
        }
        if(!forceJump) {
            for (int i = 0; i < 32; i++) {
                if ((player&&board[i] == me)||board[i]==meK) {
                    if (i - 3 >= 0 && checkLegal(board,i, i - 3,forceJump,player)) {
                        movelist.add(new Move(i, i - 3, false));
                    }
                    if (i - 4 >= 0 && checkLegal(board,i, i - 4,forceJump,player)) {
                        movelist.add(new Move(i, i - 4, false));
                    }
                    if (i - 5 >= 0 && checkLegal(board,i, i - 5,forceJump,player)) {
                        movelist.add(new Move(i, i - 5, false));
                    }
                }
                if ((!player&&board[i] == me)||board[i]==meK) {
                    if (i + 3 <32 && checkLegal(board,i, i + 3,forceJump,player)) {
                        movelist.add(new Move(i, i + 3, false));
                    }
                    if (i + 4 <32 && checkLegal(board,i, i + 4,forceJump,player)) {
                        movelist.add(new Move(i, i + 4, false));
                    }
                    if (i + 5 <32 && checkLegal(board,i, i + 5,forceJump,player)) {
                        movelist.add(new Move(i, i + 5, false));
                    }
                }
            }
        }
        return movelist;
    }

    public static boolean checkDouble(int i,char[] board) {
        boolean jumped = false;
        for (int j = 0; j < 32; j++) {
            if (board[i] == 't') {
                board[i] = 'x';
                return true;
            }
        }
        return false;
    }

     public static ArrayList<Move> getDoubleMoves(int i, char[] board,boolean player){
        ArrayList<Move> movelist=new ArrayList<Move>();
        if(player||board[i]=='R'){
            if(i-7>=0&&checkLegal(board,i,i-7,true,player)){
                movelist.add(new Move(i,i-7,true));
            }
            if(i-9>=0&&checkLegal(board,i,i-9,true,player)){
                movelist.add(new Move(i,i-9,true));
            }
        }
        if(!player||board[i]=='B'){
            if(i+7<32&&checkLegal(board,i,i+7,true,player)){
                movelist.add(new Move(i,i+7,true));
            }
            if(i+9<32&&checkLegal(board,i,i+9,true,player)){
                movelist.add(new Move(i,i+9,true));
            }
        }
        return movelist;
    }

}
