package Battleship;
/*
 * This is a project in which I attempt to recreate the famous Battleship board game. It will eventually be able to play against another person and not just the computer.
 * Phase 1: try to sink the computer's battleship(s)
 * Phase 2: A full version of battleship in which two players set and destroy respective battleships. 
 * Phase 3: Phase 1 + computer tries to sink your battleships. I will attempt to create an AI that learns and adapts to the situations in game.
 */

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/*
 * @author fazer
 */

public class Battleship_phase_2_client {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    //declare all global variables
    public static int PORT = 4444;
    String input, input2, hostName;
    int i = 0, column, row, position = 0, number, some_number, another_number;
    String[][] coordinates = new String[10][10];
    int[][] X = new int[4][3], Y = new int[4][3];
    List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
    int MISSILES = 50;

    private void destroy_battleships() throws IOException {  //function that checks to see if the location you targeted is occupied by an enemy battleship
        //initializes 10x10 grid  
        for (column = 0; column < 10; column++) {
            for (row = 0; row < 10; row++) {
                coordinates[row][column] = "~ ";
            }
        }
        //prints 10x10 grid with respective indices to add visual aid for players 
        for (column = -1; column < 10; column++) {
            if (column > -1) {
                System.out.print(column + " ");
            }
            for (row = 0; row < 10; row++) {
                if (column == -1) {
                    if (row == 0) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + row);
                } else {
                    System.out.print(coordinates[row][column]);
                }
            }
            if (row == 10) {
                System.out.println("");
            }
        }
        //starts asking for target locations.
        System.out.println("Enter a coordinate (x,y). If it hits a battleship, the specific location will show an 'X' else it will show an 'O'");
        while (i >= 0) {
            input = read.readLine();
            String[] coordinate = input.split(",");
            x.add(Integer.parseInt(coordinate[0]));
            y.add(Integer.parseInt(coordinate[1]));
            for (number = 0; number < 4; number++) {
                for (position = 0; position < 3; position++) {
                    System.out.println(X[number][position] + Y[number][position]);
                    //checks whether the target cooridnate coresponds with any of the enemies battleship's cooridnates
                    if (X[number][position] == (x.get(i)) && Y[number][position] == (y.get(i))) {
                        coordinates[x.get(i)][y.get(i)] = "X ";
                    } else if (coordinates[x.get(i)][y.get(i)].equals("X ")) {

                    } else {
                        coordinates[x.get(i)][y.get(i)] = "O ";
                    }
                }
            }
            i++; // counts number of missiles used
            System.out.println("Missiles launched:" + i);
            //prints the grid with updated information about the last missile launch
            for (column = -1; column < 10; column++) {
                if (column > -1) {
                    System.out.print(column + " ");
                }
                for (row = 0; row < 10; row++) {
                    if (column == -1) {
                        if (row == 0) {
                            System.out.print(" ");
                        }
                        System.out.print(" " + row);
                    } else {
                        System.out.print(coordinates[row][column]);
                    }
                }
                if (row == 10) {
                    System.out.println("");
                }
            }
            //counts number of hits on enemy battleships
            for (some_number = 0; some_number < x.size(); some_number++) {
                if (coordinates[x.get(some_number)][y.get(some_number)] == "X ") {
                    another_number++;
                }
            }
            if (another_number == 12) {
                System.out.println("YOU WIN!");
                break;
            }
        }
    }

    private void set_get() throws IOException, NumberFormatException {
        Battleship_phase_2_client obj = new Battleship_phase_2_client();
        try (Socket socket = new Socket(hostName, PORT)) { //creates socket and connects to device: hostName on port:PORT
            // initializes 10x10 grid
            for (column = 0; column < 10; column++) {
                for (row = 0; row < 10; row++) {
                    coordinates[row][column] = "~ ";
                }
            }
            //prints grid to add visual aid to players 
            for (column = -1; column < 10; column++) {
                if (column > -1) {
                    System.out.print(column + " ");
                }
                for (row = 0; row < 10; row++) {
                    if (column == -1) {
                        if (row == 0) {
                            System.out.print(" ");
                        }
                        System.out.print(" " + row);
                    } else {
                        System.out.print(coordinates[row][column]);
                    }
                }
                if (row == 10) {
                    System.out.println("");
                }
            }
            //writes location of user's battleships to the socket
            System.out.println("Enter the coordinates of your battleships (in the format: x,y x,y x,y)(4 battleships, each with a length of 3, either horizontal or vertical ONLY!)");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); //opens output stream
            for (int i = 0; i < 4; i++) {
                input = read.readLine();
                out.writeUTF(input); // writes to output stream
                out.flush(); //flushes to force write
            }
            socket.shutdownOutput(); // closes output stream
            //reads location of opponents battleships from server
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); // opens input stream
            System.out.println("Please wait for player to enter their battleships.");
            for (number = 0; number < 4; number++) {
                input2 = in.readUTF(); // reads String of coordinates
                //System.out.println(input2);
                System.out.println((number + 1));
                String SHIP[];
                //converts string to individual integers and stores them
                SHIP = input2.split(" ");
                for (int whatever = 0; whatever < 3; whatever++) {
                    String coordinate[] = SHIP[whatever].split(",");
                    X[number][whatever] = Integer.parseInt(coordinate[0]);
                    Y[number][whatever] = Integer.parseInt(coordinate[1]);
                }
            }
            /*for (int loop = 0; loop < 4; loop++) {
                for (int loop2 = 0; loop2 < 3; loop2++) {
                    System.out.println(X[loop][loop2] + " " + Y[loop][loop2]);
                }
                System.out.println();
            }*/
            socket.shutdownInput(); // closes input stream
            obj.destroy_battleships(); // calls function to fire missiles 
        }
    }

    public static void main(String args[]) throws IOException, NumberFormatException {
        Battleship_phase_2_client obj = new Battleship_phase_2_client();
        obj.set_get();
    }
}
