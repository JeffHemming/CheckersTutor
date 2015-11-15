import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dad on 10/31/2015.
 */
public class Main {
    //public static ArrayList<Move> takerList=new ArrayList<Move>();
    //public static ArrayList<Move> moveList=new ArrayList<Move>();

    public static void main(String[] args) throws IOException {
        int REALGAME=1;


        char[] bl=new char[32];

        if(REALGAME==1) {
            //real game
            for (int i = 0; i < 32; i++) {
                if (i < 12) bl[i] = 'r';
                else if (i > 19) bl[i] = 'b';
                else bl[i] = 'x';
            }
        }

        else if(REALGAME==2){
            //check double
            for (int i = 0; i < 32; i++) {
                bl[i]='x';
            }
            bl[5] = 'b';
            bl[6] = 'r';
            //    bl[11]='B';
            bl[14]='R';
            //    bl[20]='r';
            bl[23]='r';
            bl[25] = 'b';
            bl[30] = 'b';
        }

        else if(REALGAME==3){
            //check double
            for (int i = 0; i < 32; i++) {
                bl[i]='x';
            }
            bl[8] = 'r';
            bl[17] = 'r';
            bl[18]='r';
            bl[22]='b';
        }

     //   Jumps.createTakeList(bl,true);
        char[]realBoard=new char[32];
        for(int i=0;i<32;i++)realBoard[i]=bl[i];



       BoardGUI b=new BoardGUI(realBoard,true);

    }
}
