/* LICENSING HEADER
 * This is open source code, which means that it can be used for any purpose on any platform for free. The consequences of using this code shall 
 * not trace back to the creator.
 * The original creator of this code[Fazerlicourice71256 aka Vamshi Balanaga] shall be mentioned as such where ever this code is used and for whatever reason. 
 */
package Battleship;
/*
 * This is a project in which I attempt to recreate the famous Battleship board game. 
 * Phase 1: try to sink the computer's battleship(s)
 * Phase 2: A full version of battleship in which two players set and destroy respective battleships. 
 * Phase 3: Phase 1 + computer tries to sink your battleships. I will attempt to create an AI that learns and adapts to the situations in game.
 */

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * @author fazerlicourice71256
 */
public class Battleship_phase_2_client {

    public static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    //declare all global variables
    public static int PORT = 12345;
    String input, input2;
    public static String hostName;
    int i = 0, column, row, position = 0, number, hits = 0;
    String[][] coordinates = new String[10][10];
    public static int[][] X = new int[4][3], Y = new int[4][3];
    List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
    //Socket socket = new Socket(hostName, PORT);

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
            String[] coordinate;
            input = read.readLine();
            coordinate = input.split(",");
            try { //failsafe for incorrect input
                x.add(Integer.parseInt(coordinate[0]));
                y.add(Integer.parseInt(coordinate[1]));
            } catch (NumberFormatException e) {
                System.err.println("There was an error in the coordinate you entered." + "[" + e + "]" + "\nPlease Try again: " + "\n");
                continue;
            }
            for (number = 0; number < 4; number++) {
                for (position = 0; position < 3; position++) {
                    System.out.println(X[number][position] + Y[number][position]);
                    //checks whether the target cooridnate corresponds with any of the enemies battleship's cooridnates
                    if (X[number][position] == (x.get(i)) && Y[number][position] == (y.get(i))) {
                        coordinates[x.get(i)][y.get(i)] = "X ";
                        hits++; //counts hits on enemy battleships
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
            if (hits == 12) {
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
            for (int lv = 0; lv < 4; lv++) {
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
            socket.shutdownInput(); // closes input stream
            obj.destroy_battleships(); // calls function to fire missiles 
        }
    }

    public static void main(String args[]) throws IOException, NumberFormatException {
        Battleship_phase_2_client obj = new Battleship_phase_2_client();
        System.out.println("Enter the IP of the device to which you would like to connect.");
        hostName = read.readLine();
        obj.set_get();
        //obj.destroy_battleships();
        for (int initialization = 0; initialization < 4; initialization++) {
            for (int init = 0; init < 3; init++) {
                X[initialization][init] = 0;
                Y[initialization][init] = 0;
            }
        }
    }
}
