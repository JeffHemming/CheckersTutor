import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by Dad on 10/31/2015.
 */
class Minmax {

    public static String bestReport(char[] board, ArrayList<Move> movelist, int depthWanted, boolean player){
        String report=new String();
        for(int d=1;d<=depthWanted;d++){
            ArrayList<Double> scoreArray=new ArrayList<>();
            report+="\nThe best move(s) looking "+d+" ahead is/are: ";
            for(int i=0;i<movelist.size();i++){
                scoreArray.add(mm(Logic.movePiece(board, movelist.get(i)),!player,d-1,0,20));
            }
            String currentHigh=new String();
            currentHigh+=(movelist.get(0).start+1)+" - "+(movelist.get(0).end+1)+",   ";
            Double highscore=scoreArray.get(0);
            for(int i=1;i<scoreArray.size();i++){
                if(Objects.equals(scoreArray.get(i), highscore)){
                    currentHigh+=(movelist.get(i).start+1)+" - "+(movelist.get(i).end+1)+",   ";
                }
                else if((player&&scoreArray.get(i)>highscore)||(!player&&scoreArray.get(i)<highscore)){
                    highscore=scoreArray.get(i);
                    currentHigh=(movelist.get(i).start+1)+" - "+(movelist.get(i).end+1)+",   ";
                }
            }
            report+=currentHigh;
        }
        return report;
    }


    public static String makeReport(char[] board, ArrayList<Move> movelist, int depthWanted, boolean player){
        String report=new String();
        for(int i=0;i<movelist.size();i++){
            report+="Move "+(i+1)+":  From "+(movelist.get(i).start+1)+" to "+(movelist.get(i).end+1)+
                    ":  ";
            for(int j=1;j<=depthWanted;j++){
                report+=mm(Logic.movePiece(board, movelist.get(i)),!player,j-1,0,20)+"      ";
            }
            report+="\n";
        }
        return report;
    }

    public static double mm(char[] ib, boolean ip, int depth, double alpha, double beta){
        ArrayList<Move> ml=new ArrayList<Move>();
        ml=Logic.createAllMoves(ib,ip);
        if(ml.size()<1){
            if(ip)return 0;
            else return 20;
        }
        if(depth<1){
            double myscore=score(ib);
            return myscore;
        }
        ArrayList<Double> scores=new ArrayList<Double>();
        for(int i=0;i<ml.size();i++){
            char[] returnedBoard=new char[32];
            returnedBoard=Logic.movePiece(ib,ml.get(i));
            double sc=mm(returnedBoard,!ip,depth-1,alpha,beta);
            if(ip&&sc>alpha)alpha=sc;
            else if(!ip&&sc<beta)beta=sc;
            scores.add(sc);
            if(alpha>=beta)break;
        }
        if(ip)return Collections.max(scores);
        else return Collections.min(scores);
    }

    private static double score(char[] board){
        double countB=0;
        double countR=0;
        for(int i=0;i<32;i++){
            if(board[i]=='b')countB++;
            if(board[i]=='B')countB+=1.5;
            if(board[i]=='r')countR++;
            if(board[i]=='R')countR+=1.5;
        }
        return countB/countR;
    }


}
