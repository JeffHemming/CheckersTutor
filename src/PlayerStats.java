import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PlayerStats {
    boolean tutorMode=false;
    int compLevel=5;
    ArrayList<Player> pList;
    int numberOfPlayers;

    public PlayerStats() throws IOException {
        FileInputStream playerin=null;
        pList=new ArrayList<Player>();
        playerin=new FileInputStream("src/image/playerRecord.txt");
        BufferedReader input=new BufferedReader(new InputStreamReader(playerin));
        numberOfPlayers=Integer.parseInt(input.readLine());
        for(int i=0;i<numberOfPlayers;i++){
            String [] inP=input.readLine().split(" ");
            Player ptemp=new Player(inP[0],Integer.parseInt(inP[1]),Integer.parseInt(inP[2]),Integer.parseInt(inP[3]),
                    Integer.parseInt(inP[4]),Integer.parseInt(inP[5]),Integer.parseInt(inP[6])
                    ,Integer.parseInt(inP[7]),Integer.parseInt(inP[8]),Integer.parseInt(inP[9])
                    ,Integer.parseInt(inP[10]),Integer.parseInt(inP[11]),Integer.parseInt(inP[12]));
            pList.add(ptemp);
        }
        playerin.close();
    }
}
