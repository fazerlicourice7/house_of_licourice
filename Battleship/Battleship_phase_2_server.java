/* LICENSING HEADER
 * This is open source code, which means that it can be used for any purpose on any platform for free. The consequences of using this code shall not trace back to the creator.
 * The original creator of this code[Fazer aka Vamshi Balanaga] shall be mentioned as such where ever this code is used and for whatever reason. 
 */
package Battleship;
/*
 *This is a project in which I attempt to recreate the famous Battleship board game. It will eventually be able to play against another person and not just the computer.
 * Phase 1: try to sink the computer's battleship(s)
 * Phase 2: A full version of battleship in which you and opponent set and destry battleships. 
 * Phase 3: Phase 1 + computer tries to sink your battleships. I will attempt to create an AI that learns and adapts to the situations in game.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * @author fazer
 */
public class Battleship_phase_2_server {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    //initialize all global variables
    public static int PORT = 4444;
    String input, input2;
    int i = 0, column, row, position = 0, number, hits = 0;
    String[][] coordinates = new String[10][10];
    public static int[][] X = new int[4][3], Y = new int[4][3];
    List<Integer> x = new ArrayList<>(), y = new ArrayList<>();

    private void destroy_battleships() throws IOException {//function that checks to see if the location you targeted is occupied by an enemy battleship
        // initializes 10x10 grid
        for (column = 0; column < 10; column++) {
            for (row = 0; row < 10; row++) {
                coordinates[row][column] = "~ ";
            }
        }
        //prints 10x10 grid to provide visual aid for users
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
        //starts asking for target locations
        System.out.println("Enter a coordinate (x,y). If it hits a battleship, the specific location will show an 'X' else it will show an 'O'");
        while (i >= 0) {
            input = read.readLine(); //reads target as String
            String[] coordinate = input.split(",");
            x.add(Integer.parseInt(coordinate[0])); //stores x coordinate as integer 
            y.add(Integer.parseInt(coordinate[1])); //stores y coordinate as integer
            for (number = 0; number < 4; number++) {
                for (position = 0; position < 3; position++) {
                    System.out.println(X[number][position] + Y[number][position]);
                    if (X[number][position] == (x.get(i)) && Y[number][position] == (y.get(i))) { //checks if target location is occupied by enemy battleship 
                        coordinates[x.get(i)][y.get(i)] = "X "; //prints an X for a hit
                        hits++; //counts hits on enemy battleships
                    } else if (coordinates[x.get(i)][y.get(i)].equals("X ")) {

                    } else {
                        coordinates[x.get(i)][y.get(i)] = "O "; //prints an O for a miss
                    }
                }
            }
            i++; // counts missiles launched
            //prints 10x10 grid with updated information about last missile launch
            System.out.println("Missiles launched:" + i);
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

    private void set_get() throws IOException, NumberFormatException { //function to obtain location of opponent's battleships and to set the location of the user's battleships
        Battleship_phase_2_server obj = new Battleship_phase_2_server();
        try (
                ServerSocket serversocket = new ServerSocket(PORT); //creates a socket on port PORT
                Socket clientsocket = serversocket.accept()) {  //waits for connection to the socket 
            System.out.println("Connected."); // tells user that client has connected
            //reads location of opponents battleships from the socket
            ObjectInputStream in = new ObjectInputStream(clientsocket.getInputStream()); //opens input stream
            System.out.println("Please wait for player to enter their battleships.");
            for (number = 0; number < 4; number++) {
                input2 = in.readUTF(); // reads coordinates as a string
                //System.out.println(input2);
                System.out.println((number + 1));
                String SHIP[];
                //converts string input to individual integers and stores them
                SHIP = input2.split(" ");
                for (int whatever = 0; whatever < 3; whatever++) {
                    String coordinate[] = SHIP[whatever].split(",");
                    X[number][whatever] = Integer.parseInt(coordinate[0]);
                    Y[number][whatever] = Integer.parseInt(coordinate[1]);
                }
            }
            clientsocket.shutdownInput(); // closes input stream
            // initializes 10x10 grid
            for (column = 0; column < 10; column++) {
                for (row = 0; row < 10; row++) {
                    coordinates[row][column] = "~ ";
                }
            }
            //prints grid to add visual aid to the user
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
            //writes the location of the user's battleships to the server
            System.out.println("Enter the coordinates of your battleships (in the format: x,y x,y x,y)(4 battleships, each with a length of 3, either horizontal or vertical ONLY!)");
            ObjectOutputStream out = new ObjectOutputStream(clientsocket.getOutputStream()); //opens output stream
            for (int i = 0; i < 4; i++) {
                input = read.readLine();
                out.writeUTF(input); //writes to outputstream
                out.flush(); //flushes to force write
            }
            clientsocket.shutdownOutput(); // closes output stream
            obj.destroy_battleships(); //calls said function
        }
    }

    public static void main(String args[]) throws IOException, NumberFormatException { //main function of the program
        Battleship_phase_2_server obj = new Battleship_phase_2_server();
        obj.set_get();
        for (int initialization = 0; initialization < 4; initialization++) {
            for (int init = 0; init < 3; init++) {
                X[initialization][init] = 0;
                Y[initialization][init] = 0;
            }
        }
    }
}
