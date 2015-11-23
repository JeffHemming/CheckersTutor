import java.util.ArrayList;

/**
 * Created by Dad on 11/9/2015.
 */
class State {
    private final char[] board;
    private double score;
    private final boolean playerturn;
    private final Move lastmove;
    private final boolean lastJump;
    private boolean jumpAvailable;
    private ArrayList<Move> moveList;

    public State(){
        board=new char[32];
        for (int i = 0; i < 32; i++) {
            if (i < 12) board[i] = 'r';
            else if (i > 19) board[i] = 'b';
            else board[i] = 'x';
        }
        setScore();
        playerturn=true;
        lastmove=null;
        lastJump=false;
        jumpAvailable=false;
        setMoveList();
    }

    public State(State s){
        board=new char[32];
        for(int i=0;i<32;i++){
            board[i]=s.board[i];
        }
        setScore();
        playerturn=s.playerturn;
        lastmove=s.lastmove;
        lastJump=s.lastJump;
        jumpAvailable=false;
        setMoveList();
    }

    private void setScore(){
        double countB=0;
        double countR=0;
        for(int i=0;i<32;i++){
            if(board[i]=='b')countB++;
            if(board[i]=='B')countB+=1.5;
            if(board[i]=='r')countR++;
            if(board[i]=='R')countR+=1.5;
        }
        score=countB/countR;
    }

    private void setMoveList(){
        char me,meK;
        if(playerturn){
            me='b';
            meK='B';
        }
        else{
            me='r';
            meK='R';
        }
        for(int i=0;i<32;i++){
            if((playerturn&&board[i]==me)||board[i]==meK){
                if(i-7>=0&&checkLegal(i,i-7)){
                    moveList.add(new Move(i,i-7,board[i]));
                    jumpAvailable=true;
                }
                if(i-9>=0&&checkLegal(i,i-9)){
                    moveList.add(new Move(i,i-9,board[i]));
                    jumpAvailable=true;
                }
            }
            if((!playerturn&&board[i]==me)||board[i]==meK){
                if(i+7<32&&checkLegal(i,i+7)){
                    moveList.add(new Move(i,i+7,board[i]));
                    jumpAvailable=true;
                }
                if(i+9<32&&checkLegal(i,i+9)){
                    moveList.add(new Move(i,i+9,board[i]));
                    jumpAvailable=true;
                }
            }
        }
        if(!jumpAvailable) {
            for (int i = 0; i < 32; i++) {
                if ((playerturn&&board[i] == me)||board[i]==meK) {
                    if (i - 3 >= 0 && checkLegal(i, i - 3)) {
                        moveList.add(new Move(i, i - 3, board[i]));
                    }
                    if (i - 4 >= 0 && checkLegal(i, i - 4)) {
                        moveList.add(new Move(i, i - 4, board[i]));
                    }
                    if (i - 5 >= 0 && checkLegal(i, i - 5)) {
                        moveList.add(new Move(i, i - 5, board[i]));
                    }
                }
                if ((!playerturn&&board[i] == me)||board[i]==meK) {
                    if (i + 3 <32 && checkLegal(i, i + 3)) {
                        moveList.add(new Move(i, i + 3, board[i]));
                    }
                    if (i + 4 <32 && checkLegal(i, i + 4)) {
                        moveList.add(new Move(i, i + 4, board[i]));
                    }
                    if (i + 5 <32 && checkLegal(i, i + 5)) {
                        moveList.add(new Move(i, i + 5, board[i]));
                    }
                }
            }
        }
    }

    private boolean checkLegal(int piece, int target){
        char enemy,enemyK;
        if(playerturn){
            enemy='r';
            enemyK='R';
        }
        else{
            enemy='b';
            enemyK='B';
        }
        if((playerturn||board[piece]=='R')&&piece-target>0){
            int diff=piece-target;
            if(diff==4){
                if(jumpAvailable)return false;
                return board[target] == 'x';
            }
            if(diff==5){
                if(jumpAvailable)return false;
                if(piece%4==0||piece/4%2==0)return false;
                return board[target] == 'x';
            }
            if(diff==3){
                if(jumpAvailable)return false;
                if(piece/4%2==1||piece==3||piece==11||piece==19||piece==27)return false;
                return board[target] == 'x';
            }
            if(diff==7){
                if((piece+1)%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece-3]==enemy||board[piece-3]==enemyK))return true;
                return (piece / 4) % 2 == 1 && (board[piece - 4] == enemy || board[piece - 4] == enemyK);
            }
            if(diff==9){
                if(piece%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece-4]==enemy||board[piece-4]==enemyK))return true;
                return (piece / 4) % 2 == 1 && (board[piece - 5] == enemy || board[piece - 5] == enemyK);
            }
            return false;
        }
        if((!playerturn||board[piece]=='B')&&piece-target<0){
            int diff=piece-target;
            if(diff==-4){
                if(jumpAvailable)return false;
                return board[target] == 'x';
            }
            if(diff==-5){
                if(jumpAvailable)return false;
                if((piece+1)%4==0||piece/4%2==1)return false;
                return board[target] == 'x';
            }
            if(diff==-3){
                if(jumpAvailable)return false;
                if(piece/4%2==0||piece==4||piece==12||piece==20||piece==28)return false;
                return board[target] == 'x';
            }
            if(diff==-9){
                if((piece+1)%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece+5]==enemy||board[piece+5]==enemyK))return true;
                return (piece / 4) % 2 == 1 && (board[piece + 4] == enemy || board[piece + 4] == enemyK);
            }
            if(diff==-7){
                if(piece%4==0)return false;
                if(board[target]!='x')return false;
                if((piece/4)%2==0&&(board[piece+4]==enemy||board[piece+4]==enemyK))return true;
                return (piece / 4) % 2 == 1 && (board[piece + 3] == enemy || board[piece + 3] == enemyK);
            }
            return false;
        }
        return false;
    }
}
