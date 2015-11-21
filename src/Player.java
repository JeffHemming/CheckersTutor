/**
 * Created by Dad on 11/18/2015.
 */
public class Player {
    public double skill;
    public int adjustments,lookahead;
    public String name;
    public Player(){
        skill=0.0;
        adjustments=0;
        name="";
        lookahead=5;
    }
    public Player(String n){
        skill=5.0;
        adjustments=0;
        name=n;
        lookahead=5;
    }
    public Player(String n,double s, int a, int l){
        skill=s;
        adjustments=a;
        name=n;
        lookahead=l;
    }
    public Player(Player p){
        skill=p.skill;
        adjustments=p.adjustments;
        name=p.name;
        lookahead=p.lookahead;
    }
    public String toString(){
        return name+" "+skill+" "+adjustments+" "+lookahead;
    }
}
