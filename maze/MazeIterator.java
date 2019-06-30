package maze;
public class MazeIterator{
    public static WaypointList iterateMaze(Maze maze){
        System.out.printf("height = %d && width =%d%n",maze.getHeight(),maze.getWidth());
        int startPos [] = new int[2]; // takes the starting index of the Array 
        startPos = maze.getStart();
        //WaypointList path = null;
        WaypointList path = new WaypointList(startPos[0],startPos[1]);
        System.out.printf("Value at Start of x = %d && y = %d%n",startPos[0],startPos[1]);
        path = iterateMazeRec(startPos[0],startPos[1],maze,path);
        return path;
    }
    public static WaypointList iterateMazeRec(int x, int y, Maze maze, WaypointList path){
        int [][] vectors = {{-1,0},{1,0},{0,1},{0,-1}};
        for (int [] vector : vectors ){
            int newX = x+vector[0];
            int newY = y+vector[1];
            if(!maze.OutOfBound(newX,newY)){
                if(maze.getPos(newX,newY) == MazeEntry.PATH && !MazeIterator.containsPath(newX,newY,path)){
                    WaypointList newPath = new WaypointList(newX,newY,path);
                    if((newPath =MazeIterator.iterateMazeRec(newX,newY,maze,newPath)) != null){
                        return newPath;
                     }                  
                }else if( maze.getPos(newX,newY) == MazeEntry.EXIT){
                    return path;
                }
            }
        
        }
        return null;
    }

    public static boolean containsPath(int x,int y,WaypointList path){
        if(path==null) return false;
        while(path.next != null){
            //System.out.println("Manish!!");
            if(path.x == x && path.y == y) return true;
            path =path.next;
        }
        return false;
    }

   
}