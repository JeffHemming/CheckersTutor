/**
 * Created by Dad on 11/18/2015.
 */
public class Player {
    public int lookahead;
    public final int [] looks=new int[11];
    public final String name;
    public Player(){
        for (int i=0;i<11;i++){
            looks[i]=0;
        }
        name="";
        lookahead=1;
    }
    public Player(String n){
        for (int i=0;i<11;i++){
            looks[i]=0;
        }
        name=n;
        lookahead=1;
    }
    public Player(String n,int a0,int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10, int l){
        looks[0]=a0;
        looks[1]=a1;
        looks[2]=a2;
        looks[3]=a3;
        looks[4]=a4;
        looks[5]=a5;
        looks[6]=a6;
        looks[7]=a7;
        looks[8]=a8;
        looks[9]=a9;
        looks[10]=a10;
        name=n;
        lookahead=l;
    }
    public Player(Player p){
        for (int i=0;i<11;i++){
            looks[i]=p.looks[i];
        }
        name=p.name;
        lookahead=p.lookahead;
    }
    public String toString(){
        return name+" "+looks[0]+" "+looks[1]+" "+looks[2]+" "+looks[3]+" "+looks[4]+" "+looks[5]+" "+looks[6]+" "+looks[7]+" "+looks[8]+" "+looks[9]+" "+looks[10]+" "+lookahead;
    }

    public void updateLookaheada(){
        int max=looks[lookahead];
        int index=lookahead;
        int curr=1;
        while (lookahead-curr>=0||lookahead+curr<11){
            if(lookahead+curr<11&&looks[lookahead+curr]>max){
                max=looks[curr+lookahead];
                index=lookahead+curr;
            }
            if(lookahead-curr>=0&&looks[lookahead-curr]>max){
                max=looks[lookahead-curr];
                index=lookahead-curr;
            }
            curr++;
        }
        lookahead=index;
    }
}
