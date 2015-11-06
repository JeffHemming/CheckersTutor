/**
 * Created by Dad on 10/31/2015.
 */
public class Move {
    public int start;
    public int end;
    public boolean take;

    Move(){
        start=-1;
        end=-1;
        take=false;
    }
    Move(int s, int e, boolean t){
        start=s;
        end=e;
        take=t;
    }
}
