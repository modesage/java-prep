package _10_recursion._8_backtracking_intro;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
//        System.out.println(count(row,col));
//        path("",row,col);
//        System.out.println(pathList("",row,col));
//        System.out.println(pathListDiagonal("",row,col));
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathRestrictions("",board,0,0);
    }
    static int count(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int left = count(row-1,col);
        int right = count(row,col-1);
        return left + right;
    }
    //Vertical, Horizontal, Diagonal
    private static final String[] MOVES = {"V","H","D"};
    static void path(String p,int row,int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }
        if(row > 1){
            path(p + MOVES[0],row-1,col);
        }
        if(col > 1){
            path(p + MOVES[1],row,col-1);
        }
    }
    static ArrayList<String> pathList(String p, int row, int col){
        if(row == 1 && col == 1){
            //base condition list
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        //local list
        ArrayList<String> myList = new ArrayList<>();
        if(row > 1){
            //answer from below call
            ArrayList<String> list1 = pathList(p + MOVES[0],row-1,col);
            myList.addAll(list1);
        }
        if(col > 1){
            ArrayList<String> list2 = pathList(p + MOVES[1],row,col-1);
            myList.addAll(list2);
        }
        //returning the local list from where it was called
        return myList;
    }
    static ArrayList<String> pathListDiagonal(String p, int row, int col){
        if(row == 1 && col == 1){
            //base condition list
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        //local list
        ArrayList<String> myList = new ArrayList<>();
        if(row > 1 && col > 1){
            ArrayList<String> list3 = pathListDiagonal(p + MOVES[2],row-1,col-1);
            myList.addAll(list3);
        }
        if(row > 1){
            //answer from below call
            ArrayList<String> list1 = pathListDiagonal(p + MOVES[0],row-1,col);
            myList.addAll(list1);
        }
        if(col > 1){
            ArrayList<String> list2 = pathListDiagonal(p + MOVES[1],row,col-1);
            myList.addAll(list2);
        }
        //returning the local list from where it was called
        return myList;
    }
    static void pathRestrictions(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        if(row < maze.length - 1){
            pathRestrictions(p + MOVES[0], maze,row+1,col);
        }
        if(col < maze[0].length - 1){
            pathRestrictions(p + MOVES[1], maze, row,col+1);
        }
    }

}
