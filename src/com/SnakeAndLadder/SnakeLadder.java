package com.SnakeAndLadder;

import java.util.Random;

public class SnakeLadder {
    static int Position = 0;
    static int dieValue;
    static int noOfRoll = 0;
      public static int player1position=0;
    public static int getPlayer2position=0;

    public static  int rollDie(){
        Random r = new Random();
        int Die = r.nextInt(6) + 1;
        return Die;
    }
    public static int playOption(){
        int newPosition = 0;
        while(Position != 100) {
            Position = Position;
            dieValue = rollDie();
            System.out.println("Die Value" + dieValue);
            Random r = new Random();
            int option = r.nextInt(3);

            if (option == 0) {
                System.out.println("No Play");
                newPosition = Position;
            }
            else if (option == 1) {
                System.out.println("You are currently on Ladder");
                newPosition = ladder();
            }
            else if (option == 2) {
                System.out.println("You are currently on snake");
                newPosition = snake();
            }
            if(Position < 0) {
                Position = 0;
            }
            if(Position > 100) {
                Position = Position;
            }
            noOfRoll++;
        }
        System.out.println("Player Position" +Position);
        return newPosition;
    }
    public static int ladder() {
        if (Position + dieValue < 100) {
            Position = Position + dieValue;
            if (Position < 100) {
                dieValue = rollDie();
            }
            if (Position + dieValue <= 100) {
                Position = Position + dieValue;
            }
        }
        return Position;
    }
    public static int snake() {
        if(Position - dieValue < 0) {
            Position = 0;
        }
        else {
            Position = Position - dieValue;
        }
        return Position;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake & Ladder Game");

        SnakeLadder snakeLadder = new SnakeLadder();

        SnakeLadder.rollDie();
        while (player1position < 100 && getPlayer2position < 100) {
            player1position=playOption();
            System.out.println("Number of times the dice played to win the game:" + noOfRoll);
            System.out.println("Position of Player 1 :" + player1position);

            getPlayer2position=playOption();
            System.out.println("Number of times the dice was played to win the game :" + noOfRoll);
            System.out.println("Position of player 2 :" + getPlayer2position);
        }
        if(player1position == 100) {
            System.out.println("Player 1 is Winner");
        }
        else {
            System.out.println("Player 2 is Winner");

        }
    }

}
