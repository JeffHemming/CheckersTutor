import java.util.ArrayList;

/**
 * Created by Dad on 10/31/2015.
 */
public class Move {
    public final int start;
    public int end;
    public final char me;
    public final ArrayList<Integer> takenlist;

    Move(){
        me='d';
        start=-1;
        end=-1;
        takenlist=new ArrayList<Integer>();
    }
    Move(int s, int e, int t,char m){
        start=s;
        end=e;
        me=m;
        takenlist=new ArrayList<Integer>();
        takenlist.add(t);
    }
    Move(Move m){
        me=m.me;
        start=m.start;
        end=m.end;
        takenlist=new ArrayList<Integer>();
        for(int i=0;i<m.takenlist.size();i++){
            takenlist.add(m.takenlist.get(i));
        }
    }
    Move(int s, int e, char t){
        me=t;
        start=s;
        end=e;
        takenlist=new ArrayList<Integer>();
    }
}
