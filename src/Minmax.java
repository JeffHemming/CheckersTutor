import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dad on 10/31/2015.
 */
public class Minmax {




    public static String makeReport(char[] board, ArrayList<Move> movelist, int depthWanted, boolean player){
        String report=new String();
        for(int i=0;i<movelist.size();i++){
            report+="Move "+(i+1)+":  From "+movelist.get(i).start+" to "+movelist.get(i).end+
                    ":  ";
            for(int j=1;j<=depthWanted;j++){
                report+=mm(Logic.movePiece(board, movelist.get(i)),!player,j,-1000,1000)+"      ";
            }
            report+="\n";
        }
        return report;
    }

    public static String getBestMoves(char[] board, ArrayList<Move> movelist, int depthWanted, boolean player){
        String report=new String();
        ArrayList<ArrayList<Integer>> moveScores=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<movelist.size();i++){
            moveScores.add(new ArrayList<Integer>());
            for(int j=1;j<=depthWanted;j++){
                char[] doublecheckedboard=new char[32];
                    doublecheckedboard=Logic.movePiece(board,movelist.get(i));
                if(movelist.get(i).take){
                    doublecheckedboard=doublescore(doublecheckedboard,movelist.get(i).end,player);
                }
                moveScores.get(i).add(mm(doublecheckedboard,!player,j,-1000,1000));
            }
        }
        ArrayList<Integer> oneMove=new ArrayList<Integer>();
        ArrayList<Integer> twoMove=new ArrayList<Integer>();
        ArrayList<Integer> threeMove=new ArrayList<Integer>();
        ArrayList<Integer> fourMove=new ArrayList<Integer>();
        ArrayList<Integer> fiveMove=new ArrayList<Integer>();
        ArrayList<Integer> sixMove=new ArrayList<Integer>();
        ArrayList<Integer> sevenMove=new ArrayList<Integer>();
        ArrayList<Integer> eightMove=new ArrayList<Integer>();
        ArrayList<Integer> nineMove=new ArrayList<Integer>();
        ArrayList<Integer> tenMove=new ArrayList<Integer>();
        for(int i=0;i<moveScores.size();i++){
            oneMove.add(moveScores.get(i).get(0));
            twoMove.add(moveScores.get(i).get(1));
            threeMove.add(moveScores.get(i).get(2));
            fourMove.add(moveScores.get(i).get(3));
            fiveMove.add(moveScores.get(i).get(4));
            sixMove.add(moveScores.get(i).get(5));
            sevenMove.add(moveScores.get(i).get(6));
            eightMove.add(moveScores.get(i).get(7));
            nineMove.add(moveScores.get(i).get(8));
            tenMove.add(moveScores.get(i).get(9));
        }
        if(player) {
            //OneMove
            report += "____________________\nLOOKING ONE AHEAD:\n     Best Move: \n";
            int best = Collections.max(oneMove);
            int worst = Collections.min(oneMove);
            String lastBest=new String();
            if(best==worst){lastBest+="          All moves equal\n";
                report+=lastBest;}
            else {
                for (int i = 0; i < oneMove.size(); i++) {
                    if (oneMove.get(i) == best) lastBest += "          " + moveToString(movelist.get(i)) + "\n";
                }
                report+=lastBest;

                report += "     Worst Move:\n";
                for (int i = 0; i < oneMove.size(); i++) {
                    if (oneMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
                }
            }
            report+="\n";
            //TwoMove
            report += "____________________\nLOOKING TWO AHEAD:\n     Best Move: \n";
            best = Collections.max(twoMove);
            worst = Collections.min(twoMove);
            String currBest=new String();
            if(best==worst){currBest+="          All moves equal\n";
                report+=currBest;}
            else{
            for (int i = 0; i < twoMove.size(); i++) {
                if (twoMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            report += "     Worst Move:\n";
            for (int i = 0; i < twoMove.size(); i++) {
                if (twoMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 1 AND 2 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //threeMove
            report += "____________________\nLOOKING THREE AHEAD:\n     Best Move: \n";
            best = Collections.max(threeMove);
            worst = Collections.min(threeMove);
            if(best==worst){currBest+="          All moves equal\n";
                report+=currBest;}
            else{
            for (int i = 0; i < threeMove.size(); i++) {
                if (threeMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(threeMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < threeMove.size(); i++) {
                if (threeMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 2 AND 3 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //fourMove
            report += "____________________\nLOOKING FOUR AHEAD:\n     Best Move: \n";
            best = Collections.max(fourMove);
            worst = Collections.min(fourMove);
            if(best==worst){currBest+="          All moves equal\n";
                report+=currBest;}
            else{
            for (int i = 0; i < fourMove.size(); i++) {
                if (fourMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(fourMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < fourMove.size(); i++) {
                if (fourMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 3 AND 4 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //fiveMove
            report += "____________________\nLOOKING FIVE AHEAD:\n     Best Move: \n";
            best = Collections.max(fiveMove);
            worst = Collections.min(fiveMove);
            if(best==worst){currBest+="          All moves equal\n";
            report+=currBest;}
            else{
            for (int i = 0; i < fiveMove.size(); i++) {
                if (fiveMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(fiveMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < fiveMove.size(); i++) {
                if (fiveMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 4 AND 5 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //sixMove
            report += "____________________\nLOOKING SIX AHEAD:\n     Best Move: \n";
            best = Collections.max(sixMove);
            worst = Collections.min(sixMove);
            if(best==worst){currBest+="          All moves equal\n";
                report+=currBest;}
            else{
            for (int i = 0; i < sixMove.size(); i++) {
                if (sixMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(sixMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < sixMove.size(); i++) {
                if (sixMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 5 AND 6 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //sevenMove
            report += "____________________\nLOOKING SEVEN AHEAD:\n     Best Move: \n";
            best = Collections.max(sevenMove);
            worst = Collections.min(sevenMove);
            if(best==worst){currBest+="          All moves equal\n";
                report+=currBest;}
            else{
            for (int i = 0; i < sevenMove.size(); i++) {
                if (sevenMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(sevenMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < sevenMove.size(); i++) {
                if (sevenMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 6 AND 7 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //eightMove
            report += "____________________\nLOOKING EIGHT AHEAD:\n     Best Move: \n";
            best = Collections.max(eightMove);
            worst = Collections.min(eightMove);
            if(best==worst){currBest+="          All moves equal\n";
                report+=currBest;}
            else{
            for (int i = 0; i < eightMove.size(); i++) {
                if (eightMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(eightMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < eightMove.size(); i++) {
                if (eightMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 7 AND 8 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //nineMove
            report += "____________________\nLOOKING NINE AHEAD:\n     Best Move: \n";
            best = Collections.max(nineMove);
            worst = Collections.min(nineMove);
            if(best==worst){currBest+="          All moves equal\n";
            report+=currBest;}
            else{
            for (int i = 0; i < nineMove.size(); i++) {
                if (nineMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
            }
                report+=currBest;
            worst = Collections.min(nineMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < nineMove.size(); i++) {
                if (nineMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 8 AND 9 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
            //tenMove
            report += "____________________\nLOOKING TEN AHEAD:\n     Best Move: \n";
            best = Collections.max(tenMove);
            worst = Collections.min(tenMove);
            if(best==worst){
                currBest+="          All moves equal\n";
                report+=currBest;
            }
            else {
                for (int i = 0; i < tenMove.size(); i++) {
                    if (tenMove.get(i) == best) currBest += "          " + moveToString(movelist.get(i)) + "\n";
                }
                report+=currBest;
                worst = Collections.min(tenMove);
                report += "     Worst Move:\n";
                for (int i = 0; i < tenMove.size(); i++) {
                    if (tenMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
                }
            }
            report+="\n";
            if(!currBest.equals(lastBest)){
                report+="TEACHING MOMENT FOUND BETWEEN 9 AND 10 MOVES!\n\n";
            }
            lastBest=currBest;
            currBest="";
        }
        else   {
            //OneMove
            report += "____________________\nLOOKING ONE AHEAD:\n     Best Move: \n";
        int best = Collections.min(oneMove);
        int worst = Collections.max(twoMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < oneMove.size(); i++) {
                if (oneMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            report += "     Worst Move:\n";
            for (int i = 0; i < oneMove.size(); i++) {
                if (oneMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //TwoMove
            report += "____________________\nLOOKING TWO AHEAD:\n     Best Move: \n";
            best = Collections.min(twoMove);
            worst = Collections.max(twoMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < twoMove.size(); i++) {
                if (twoMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(twoMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < twoMove.size(); i++) {
                if (twoMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //threeMove
            report += "____________________\nLOOKING THREE AHEAD:\n     Best Move: \n";
            best = Collections.min(threeMove);
            worst = Collections.max(threeMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < threeMove.size(); i++) {
                if (threeMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(threeMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < threeMove.size(); i++) {
                if (threeMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //fourMove
            report += "____________________\nLOOKING FOUR AHEAD:\n     Best Move: \n";
        best = Collections.min(fourMove);
        worst = Collections.max(fourMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < fourMove.size(); i++) {
                if (fourMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(fourMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < fourMove.size(); i++) {
                if (fourMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //fiveMove
            report += "____________________\nLOOKING FIVE AHEAD:\n     Best Move: \n";
            best = Collections.min(fiveMove);
            worst = Collections.max(fiveMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < fiveMove.size(); i++) {
                if (fiveMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(fiveMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < fiveMove.size(); i++) {
                if (fiveMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //sixMove
            report += "____________________\nLOOKING SIX AHEAD:\n     Best Move: \n";
            best = Collections.min(sixMove);
            worst = Collections.max(sixMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < sixMove.size(); i++) {
                if (sixMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(sixMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < sixMove.size(); i++) {
                if (sixMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //sevenMove
            report += "____________________\nLOOKING SEVEN AHEAD:\n     Best Move: \n";
        best = Collections.min(sevenMove);
        worst = Collections.max(sevenMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < sevenMove.size(); i++) {
                if (sevenMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
                worst = Collections.max(sevenMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < sevenMove.size(); i++) {
                if (sevenMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //eightMove
            report += "____________________\nLOOKING EIGHT AHEAD:\n     Best Move: \n";
            best = Collections.min(eightMove);
            worst = Collections.max(eightMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < eightMove.size(); i++) {
                if (eightMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(eightMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < eightMove.size(); i++) {
                if (eightMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //nineMove
            report += "____________________\nLOOKING NINE AHEAD:\n     Best Move: \n";
            best = Collections.min(nineMove);
            worst = Collections.max(nineMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < nineMove.size(); i++) {
                if (nineMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(nineMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < nineMove.size(); i++) {
                if (nineMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
            //tenMove
            report += "____________________\nLOOKING TEN AHEAD:\n     Best Move: \n";
        best = Collections.min(tenMove);
        worst = Collections.max(tenMove);
            if(best==worst)report+="          All moves equal\n";
            else{
            for (int i = 0; i < tenMove.size(); i++) {
                if (tenMove.get(i) == best) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            worst = Collections.max(tenMove);
            report += "     Worst Move:\n";
            for (int i = 0; i < tenMove.size(); i++) {
                if (tenMove.get(i) == worst) report += "          " + moveToString(movelist.get(i)) + "\n";
            }
            }
            report+="\n";
        }

        return report;
    }

    public static String moveToString(Move m){
        String s="";
        String mts="From ";
        switch(m.start){
            case 0:s="B1";
                break;
            case 1:s="D1";
                break;
            case 2:s="F1";
                break;
            case 3:s="H1";
                break;
            case 4:s="A2";
                break;
            case 5:s="C2";
                break;
            case 6:s="E2";
                break;
            case 7:s="G2";
                break;
            case 8:s="B3";
                break;
            case 9:s="D3";
                break;
            case 10:s="F3";
                break;
            case 11:s="H3";
                break;
            case 12:s="A4";
                break;
            case 13:s="C4";
                break;
            case 14:s="E4";
                break;
            case 15:s="G4";
                break;
            case 16:s="B5";
                break;
            case 17:s="D5";
                break;
            case 18:s="F5";
                break;
            case 19:s="H5";
                break;
            case 20:s="A6";
                break;
            case 21:s="C6";
                break;
            case 22:s="E6";
                break;
            case 23:s="G6";
                break;
            case 24:s="B7";
                break;
            case 25:s="D7";
                break;
            case 26:s="F7";
                break;
            case 27:s="H7";
                break;
            case 28:s="A8";
                break;
            case 29:s="C8";
                break;
            case 30:s="E8";
                break;
            case 31:s="G8";
                break;
            default: s="";
                break;
        }
        mts+=s+" to ";
        switch(m.end){
            case 0:s="B1";
                break;
            case 1:s="D1";
                break;
            case 2:s="F1";
                break;
            case 3:s="H1";
                break;
            case 4:s="A2";
                break;
            case 5:s="C2";
                break;
            case 6:s="E2";
                break;
            case 7:s="G2";
                break;
            case 8:s="B3";
                break;
            case 9:s="D3";
                break;
            case 10:s="F3";
                break;
            case 11:s="H3";
                break;
            case 12:s="A4";
                break;
            case 13:s="C4";
                break;
            case 14:s="E4";
                break;
            case 15:s="G4";
                break;
            case 16:s="B5";
                break;
            case 17:s="D5";
                break;
            case 18:s="F5";
                break;
            case 19:s="H5";
                break;
            case 20:s="A6";
                break;
            case 21:s="C6";
                break;
            case 22:s="E6";
                break;
            case 23:s="G6";
                break;
            case 24:s="B7";
                break;
            case 25:s="D7";
                break;
            case 26:s="F7";
                break;
            case 27:s="H7";
                break;
            case 28:s="A8";
                break;
            case 29:s="C8";
                break;
            case 30:s="E8";
                break;
            case 31:s="G8";
                break;
            default: s="";
                break;
        }
        mts+=s;
        return mts;
    }

    public static int mm(char[] ib, boolean ip, int depth, int alpha, int beta){
        ArrayList<Move> ml=new ArrayList<Move>();
        ml=Logic.runACheck(ip,ib,false);
        if(ml.size()<1){
            if(ip)return -999;
            else return 999;
        }
        if(depth<1){
            int myscore=score(ib);
            return myscore;
        }

        ArrayList<Integer> scores=new ArrayList<Integer>();
        for(int i=0;i<ml.size();i++){
            char[] returnedBoard=new char[32];
            returnedBoard=Logic.movePiece(ib,ml.get(i));
            if(ml.get(i).take){
                returnedBoard=doublescore(returnedBoard,ml.get(i).end,ip);
            }
            int sc=mm(returnedBoard,!ip,depth-1,alpha,beta);
            if(ip&&sc>alpha)alpha=sc;
            else if(!ip&&sc<beta)beta=sc;
            scores.add(sc);
            if(alpha>=beta)break;
        }
        if(ip)return Collections.max(scores);
        else return Collections.min(scores);
    }

    public static char[] doublescore(char[] b, int pos, boolean player){
        ArrayList<Move> dl=new ArrayList<Move>();
        dl=Logic.getDoubleMoves(pos,b,player);
        if(dl.size()<1)return b;
        char[] db=new char[32];
        db=b;
        ArrayList<char[]> boardlist=new ArrayList<char[]>();
        for(int i=0;i<dl.size();i++){
            char[] nextlevelboard=Logic.movePiece(db,dl.get(i));
            char[] returnedboard=new char[32];
            returnedboard=doublescore(nextlevelboard,pos,player);
            boardlist.add(returnedboard);
        }
        int highscore=score(boardlist.get(0));
        int highpos=0;
        for(int i=1;i<boardlist.size();i++){
            if(score(boardlist.get(i))>highscore){
                highscore=score(boardlist.get(i));
                highpos=i;
            }
        }
        return boardlist.get(highpos);
    }



    public static int score(char[] board){
        int count=0;
        for(int i=0;i<32;i++){
            if(board[i]=='b')count++;
            if(board[i]=='B')count+=2;
            if(board[i]=='r')count--;
            if(board[i]=='R')count-=2;
        }
        return count;
    }


}
