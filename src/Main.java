import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dad on 10/31/2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        boolean REALGAME=true;


        char[] bl=new char[32];

        if(REALGAME) {
            //real game
            for (int i = 0; i < 32; i++) {
                if (i < 12) bl[i] = 'r';
                else if (i > 19) bl[i] = 'b';
                else bl[i] = 'x';
            }
        }

        else {
            //check double
            for (int i = 0; i < 32; i++) {
                bl[i]='x';
            }
            bl[18] = 'r';
            bl[9] = 'r';
            bl[22] = 'b';
            bl[23] = 'b';
        }

        BoardGUI b=new BoardGUI(bl,true);

    }
}
