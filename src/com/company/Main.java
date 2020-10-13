package com.company;

import java.util.Arrays;

public class Main {

    public static void main( String[] args ) {
        int[][] maze = new int[][]{
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 },
                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }
        };
        int[] spawnpoint = new int[]{ 0, 6 };
        int[] finishPoint = new int[]{ 6, 6 };
        mazeSolver( maze, spawnpoint, finishPoint );
    }


    //If up then down, restart (wont be fastest)
    //keep moveCount and try 100 times and see which gets lowest move count
    public static void mazeSolver( int[][] maze, int[] spawnPoint, int[] finishPoint ) {

        boolean finish = false;
        boolean firstRun = true;
        String directions = "";
        String fastestDirections = "";
        int[] currLocation = spawnPoint;
        int[] nextLocation = new int[]{ 0, 0 };

        maze[ spawnPoint[ 0 ] ][ spawnPoint[ 1 ] ] = 2;
        maze[ finishPoint[ 0 ] ][ finishPoint[ 1 ] ] = 3;
        for(int i = 0; i < 10; i++){
            while ( finish == false ) {
                int move = ( int ) ( ( Math.random( ) * ( 4 ) ) + 1 );
                if ( move == 1 ) {
                    try {
                        if ( maze[ currLocation[ 0 ] - 1 ][ currLocation[ 1 ] ] == 3 ) {
                            finish = true;
                        }
                        if ( maze[ currLocation[ 0 ] - 1 ][ currLocation[ 1 ] ] == 0 ) {
                            nextLocation[ 0 ] = currLocation[ 0 ] - 1;
                            nextLocation[ 1 ] = currLocation[ 1 ];
                            maze[ nextLocation[ 0 ] ][ nextLocation[ 1 ] ] = 2;
                            maze[ currLocation[ 0 ] ][ currLocation[ 1 ] ] = 0;
                            currLocation = nextLocation;
                            directions = directions + "up\n";
                        }
                    } catch ( Exception e ) {

                    }
                }
                if ( move == 2 ) {
                    try {
                        if ( maze[ currLocation[ 0 ] ][ currLocation[ 1 ] + 1 ] == 3 ) {
                            finish = true;
                        }
                        if ( maze[ currLocation[ 0 ] ][ currLocation[ 1 ] + 1 ] == 0 ) {
                            nextLocation[ 0 ] = currLocation[ 0 ];
                            nextLocation[ 1 ] = currLocation[ 1 ] + 1;
                            maze[ nextLocation[ 0 ] ][ nextLocation[ 1 ] ] = 2;
                            maze[ currLocation[ 0 ] ][ currLocation[ 1 ] ] = 0;
                            currLocation = nextLocation;
                            directions += "right\n";
                        }
                    } catch ( Exception e ) {

                    }
                }
                if ( move == 3 ) {
                    try {
                        if ( maze[ currLocation[ 0 ] + 1 ][ currLocation[ 1 ] ] == 3 ) {
                            finish = true;
                        }
                        if ( maze[ currLocation[ 0 ] + 1 ][ currLocation[ 1 ] ] == 0 ) {
                            nextLocation[ 0 ] = currLocation[ 0 ] + 1;
                            nextLocation[ 1 ] = currLocation[ 1 ];
                            maze[ nextLocation[ 0 ] ][ nextLocation[ 1 ] ] = 2;
                            maze[ currLocation[ 0 ] ][ currLocation[ 1 ] ] = 0;
                            currLocation = nextLocation;
                            directions += "down\n";
                        }
                    } catch ( Exception e ) {

                    }
                }
                if ( move == 4 ) {
                    try {
                        if ( maze[ currLocation[ 0 ] ][ currLocation[ 1 ] - 1 ] == 3 ) {
                            finish = true;
                        }
                        if ( maze[ currLocation[ 0 ] ][ currLocation[ 1 ] - 1 ] == 0 ) {
                            nextLocation[ 0 ] = currLocation[ 0 ];
                            nextLocation[ 1 ] = currLocation[ 1 ] - 1;
                            maze[ nextLocation[ 0 ] ][ nextLocation[ 1 ] ] = 2;
                            maze[ currLocation[ 0 ] ][ currLocation[ 1 ] ] = 0;
                            currLocation = nextLocation;
                            directions += "left\n";
                        }
                    } catch ( Exception e ) {

                    }
                }
            }
            if(firstRun){
                fastestDirections = directions;
                firstRun = false;
            }
            else{
                if(fastestDirections.length() > directions.length()){
                    fastestDirections = directions;
                }
            }
        }
        System.out.println( fastestDirections );
    }

    public static String mazeSolver( int[][] maze, int[] spawnPoint, int[] finishPoint ){

    }
}
