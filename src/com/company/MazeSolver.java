package com.company;

//Empty space = 0
//Wall = 1
//Character location = 2
//Finish Point = 3
public class MazeSolver {
    //Defining Variables
    int[][] _maze;
    int[] _spawnPoint;
    int[] _finishPoint;
    String directions = "";

    //Constructor
    public MazeSolver(int[][] maze, int[] spawnPoint, int[] finishPoint){
        _maze = maze;
        _spawnPoint = spawnPoint;
        _finishPoint = finishPoint;
    }

    public String solveMaze(){
        //Stuff here
        return directions;
    }

    //Changes the numbers to keep track of the player
    private void move(int[] curPos, int[] nextPos){
        _maze[curPos[0]][curPos[1]] =  0;
        _maze[nextPos[0]][nextPos[1]] =  2;

    }

    private boolean checkCanMove(int[] curPos, int[] nextPos){

        char direction = getDirection( curPos, nextPos );

        if(direction == 'd' && nextPos[0] == 1){
            return false;
        }
        else if(direction == 'u' && nextPos[0] == 1){
            return false;
        }
        else if(direction == 'r' && nextPos[1] == 1){
            return false;
        }
        else if(direction == 'l' && nextPos[1] == 1){
            return false;
        }
        else{
            return true;
        }
    }

    private char getDirection((int[] curPos, int[] nextPos){
        char direction = ' ';
        if(nextPos[0] > curPos[0]){
            direction = 'd';
        }
        if(nextPos[0] < curPos[0]){
            direction = 'u';
        }
        if(nextPos[1] > curPos[1]){
            direction = 'r';
        }
        if(nextPos[1] > curPos[1]){
            direction = 'l';
        }
    }
}
