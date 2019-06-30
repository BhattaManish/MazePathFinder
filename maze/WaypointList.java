package maze;
public class WaypointList{
    protected int x;
    protected int y;
    protected WaypointList next;

    public WaypointList(int x, int y){
        this(x,y,null);
    }
    public WaypointList(int x, int y,WaypointList tmp){
        this.x = x;
        this.y = y;
        this.next = tmp;
    }

    // getters and setters;

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x =x;
    }

    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }

    public void setNext(WaypointList next){
        this.next = next;
    }
    public WaypointList getNext(){
        return next;
    }


}