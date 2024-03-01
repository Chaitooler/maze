import java.io.*;
import java.util.Arrays;



public class Main {

    public static int Y_AXIS = 1;
    public static int X_AXIS = 0;

    public static int X_LIMIT = 4;
    public static int Y_LIMIT = 4;

    public static int [][] stop_points = {
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0}
    };

    public static void main(String args[]) {
        
        int [][] maze = {
          {0,0,1,0,0},
          {0,0,0,0,0},
          {0,0,0,1,0},
          {1,1,0,1,1},
          {0,0,0,0,0}
        };
        
        int[] start = {0,0};
        int[] destination = {4,4};

        System.out.println("Maze:");
        System.out.println(Arrays.deepToString(maze));
        System.out.println("Start coords:");
        System.out.println(Arrays.toString(start));
        System.out.println("Dest coords:");
        System.out.println(Arrays.toString(destination));

        boolean result = runThrough(maze, start, destination);

        System.out.println("Possible solution: ");
        System.out.println(result);
    }

    public static boolean runThrough(int[][] maze, int[] start, int[] destination) {
        return moveDown(maze, start, destination) ||
                moveLeft(maze, start, destination) ||
                moveRight(maze, start, destination) ||
                moveDown(maze, start, destination);
    }

    public static boolean moveRight(int[][] maze, int[] point, int[] destination) {

        int point_x = point[X_AXIS];
        int point_y = point[Y_AXIS];

        int[] future_point = {point_x+1, point_y};

        if (Arrays.equals(future_point, destination)) {
            //cut condition
            return true;
        }


        if ( (future_point[X_AXIS] > X_LIMIT) || (maze[future_point[Y_AXIS]][future_point[X_AXIS]] == 1) ) {
            //ball stopped
            if ( stop_points[point_y][point_x] == 0) {
                //turn
                stop_points[point_y][point_x] = 1;
                return moveDown(maze, point, destination) || moveUp(maze, point, destination);
            } else {
                //cut condition
                return false;
            }
        } else {
            //ball did not stop
            return moveRight(maze, future_point, destination);
        }     
    }

    public static boolean moveDown(int[][] maze, int[] point, int[] destination) {

        int point_x = point[X_AXIS];
        int point_y = point[Y_AXIS];

        int[] future_point = {point_x, point_y + 1};

        if (Arrays.equals(future_point, destination)) {
            //cut condition
            return true;
        }


        if ( (future_point[Y_AXIS] > Y_LIMIT) || (maze[future_point[Y_AXIS]][future_point[X_AXIS]] == 1) ) {
            //ball stopped
            if ( stop_points[point_y][point_x] == 0) {
                //turn
                stop_points[point_y][point_x] = 1;
                return moveRight(maze, point, destination) || moveLeft(maze, point, destination);
            } else {
                //cut condition
                return false;
            }
        } else {
            //ball did not stop
            return moveDown(maze, future_point, destination);
        }     
    }

    public static boolean moveUp(int[][] maze, int[] point, int[] destination) {

        int point_x = point[X_AXIS];
        int point_y = point[Y_AXIS];

        int[] future_point = {point_x, point_y -1};

        if (Arrays.equals(future_point, destination)) {
            //cut condition
            return true;
        }


        if ( (future_point[Y_AXIS] < 0 ) || (maze[future_point[Y_AXIS]][future_point[X_AXIS]] == 1) ) {
            //ball stopped
            if ( stop_points[point_y][point_x] == 0) {
                //turn
                stop_points[point_y][point_x] = 1;
                return moveRight(maze, point, destination) || moveLeft(maze, point, destination);
            } else {
                //cut condition
                return false;
            }
        } else {
            //ball did not stop
            return moveDown(maze, future_point, destination);
        }     
    }

    public static boolean moveLeft(int[][] maze, int[] point, int[] destination) {

        int point_x = point[X_AXIS];
        int point_y = point[Y_AXIS];

        int[] future_point = {point_x-1, point_y};

        if (Arrays.equals(future_point, destination)) {
            //cut condition
            return true;
        }


        if ( (future_point[X_AXIS] < 0) || (maze[future_point[Y_AXIS]][future_point[X_AXIS]] == 1) ) {
            //ball stopped
            if ( stop_points[point_y][point_x] == 0) {
                //turn
                stop_points[point_y][point_x] = 1;
                return moveDown(maze, point, destination) || moveUp(maze, point, destination);
            } else {
                //cut condition
                return false;
            }
        } else {
            //ball did not stop
            return moveLeft(maze, future_point, destination);
        }     
    }
}
