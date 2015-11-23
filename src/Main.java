import javax.swing.*;
import java.io.IOException;

/**
 * Created by Dad on 10/31/2015.
 */
class Main {
    //public static ArrayList<Move> takerList=new ArrayList<Move>();
    //public static ArrayList<Move> moveList=new ArrayList<Move>();
    public static Player p;
    public static int index;
    public static PlayerStats ps;

    public static void main(String[] args) throws IOException {
        int REALGAME=4;

        ps=new PlayerStats();
        String[] namelist=new String[ps.numberOfPlayers+1];
        for(int i=0;i<ps.numberOfPlayers;i++){
            namelist[i]=ps.pList.get(i).name+": Level "+ps.pList.get(i).lookahead;
        }
        namelist[ps.numberOfPlayers]="New Player";
        String inName = (String) JOptionPane.showInputDialog(null, "Who are you?",
                "Select your name.", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                namelist, // Array of choices
                namelist[0]); // Initial choice
        index=ps.numberOfPlayers;
        for(int i=0;i<ps.numberOfPlayers;i++){
            if(namelist[i].equals(inName))index=i;
        }
        if(index<ps.numberOfPlayers) {
            p = new Player(ps.pList.get(index));
        }
        else{
            String newName= (String) JOptionPane.showInputDialog(null,"Enter your name(no spaces).","Enter Name",JOptionPane.QUESTION_MESSAGE,null,null,"");
            p=new Player(newName);
            ps.pList.add(p);
        }

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

        else if(REALGAME==4){
            //check double
            for (int i = 0; i < 32; i++) {
                bl[i]='x';
            }
            bl[4] = 'r';
            bl[8] = 'r';
            bl[10]='r';
            bl[18]='b';
            bl[19]='r';
            bl[23]='b';
            bl[26] = 'b';
            bl[31] = 'b';
        }
        else if(REALGAME==5){
            //check double
            for (int i = 0; i < 32; i++) {
                bl[i]='x';
            }
            bl[6] = 'r';
            bl[25] = 'b';
            //    bl[11]='B';
            bl[17]='B';
            //    bl[20]='r';
            bl[8]='b';
            bl[6] = 'r';
            bl[1] = 'r';
        }
        else if(REALGAME==6){
            //check double
            for (int i = 0; i < 32; i++) {
                bl[i]='x';
            }
            bl[31] = 'b';
            bl[23] = 'b';
            bl[21]='b';
            bl[13]='r';
            bl[12]='b';
            bl[8]='r';
            bl[5] = 'r';
            bl[0] = 'r';
        }

     //   Jumps.createTakeList(bl,true);
        char[]realBoard=new char[32];
        for(int i=0;i<32;i++)realBoard[i]=bl[i];



       BoardGUI b=new BoardGUI(realBoard);

    }
}
