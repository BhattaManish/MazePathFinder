package maze;
public class Maze{
    
    private  MazeEntry mazeEntryArray[][];
    private final int  HEIGHT;
    private final int WIDTH;
    private int [] startPos;

    public Maze(String m1){
        int firstIndex = m1.indexOf('\n');
        String arr [] = m1.substring(0,firstIndex).split(" ");
        m1 = m1.substring(firstIndex+1,m1.length());
        WIDTH = Integer.parseInt(arr[0]);
        HEIGHT = Integer.parseInt(arr[1]);
        //array initalise
        mazeEntryArray = new MazeEntry[WIDTH][HEIGHT];
         startPos = new int[2]; // for starting position
        //putting corresponding mazeEntry elements from the String
        String arr1[] = m1.split("\n");
        for(int y = 0; y < arr1.length; y++){
            for (int x = 0; x<WIDTH;x++) {
                switch(arr1[y].charAt(x)){
                        case '#': mazeEntryArray[x][y] = MazeEntry.WALL;break;
                        case 'e': mazeEntryArray[x][y] = MazeEntry.ENTRY;  startPos[0] =x; startPos[1] =y;break;
                        case 'E': mazeEntryArray[x][y] = MazeEntry.EXIT;break;
                        case ' ' : mazeEntryArray[x][y] = MazeEntry.PATH;break;
                    }
            }
        }

    }

    //setter and getter 

    public void setPos(int x, int y, MazeEntry ele){
        this.mazeEntryArray[x][y]=ele;
    }
    public MazeEntry getPos(int x, int y){
        return this.mazeEntryArray[x][y];
    }

    public int getHeight(){
        return HEIGHT;
    }
    public int getWidth(){
        return WIDTH;
    }
    public int[] getStart(){
        return startPos;
    }

    //printing the Maze

    public void print(){
        for (int y = 0; y<HEIGHT;y++ ) {
            for (int x = 0; x<WIDTH; x++) {
                switch(mazeEntryArray[x][y]){
                    case WALL:System.out.print("#");break;
                    case ENTRY:System.out.print("e");break;
                    case EXIT:System.out.print("E");break;
                    case SOLUTION:System.out.print("*");break;
                    default : System.out.print(" ");break;
                }
                    
             }
          System.out.println(" ");
        }
    }

    public void setSolution(WaypointList path){
        if(path.next == null){
            System.err.println("This path is Empty");
        }
        while(path.next != null){
            mazeEntryArray[path.x][path.y] = MazeEntry.SOLUTION;
            path=path.next;
        }
    }

    public boolean OutOfBound(int x, int y){
        return  x < 0 && x > WIDTH && y > HEIGHT && y < 0 ;
    }
    


}

