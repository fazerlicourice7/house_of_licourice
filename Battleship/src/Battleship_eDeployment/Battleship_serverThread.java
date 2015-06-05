/*
 * Copyright (C) 2015 fazerlicourice71256
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Battleship_eDeployment;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author fazerlicourice71256
 */
public class Battleship_serverThread extends Thread {

    //initializing required variables
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    private static Socket client1, client2;
    public static int PORT;
    String[][] coordinates1 = new String[10][10]; //holds the state of each location on client1's grid(ie. client2's target grid)
    String[][] coordinates2 = new String[10][10]; //holds the state of each location on client2's grid(ie. client1's target grid)
    /*
     * String arrays to hold the coordinates of each of the battleships. 
     * The first number represents the client number.
     * The second number represents the ship number of the respective client.
     * The first ship will be two points long.
     * The second and third ships will be three points long.
     * The fourth ship will be three points long.
     * The fifth ship will be five points long.
     */
    String[] ship11 = new String[2], ship12 = new String[3], ship13 = new String[3], ship14 = new String[4], ship15 = new String[5];
    String[] ship21 = new String[2], ship22 = new String[3], ship23 = new String[3], ship24 = new String[4], ship25 = new String[5];

    Battleship_serverThread(Socket client1) {
        super("Battleship_ServerThread");
        this.client1 = client1;
    }

    //run method
    @Override
    public void run() {
        //creates a serversocket and listens for a connection
        try (
                ServerSocket serversocket = new ServerSocket(PORT);) {
            //accepts first client to make a request
            client2 = serversocket.accept();
            //catches an Input/Output exception if any, and displays the message: There was an error connecting to the client"
        } catch (IOException ex) {
            System.err.println("There was an error connecting to the client:" + ex);
        }
        //attempts to initialize Object input and Object output streams to both clients.
        try {//initializes input stream between this thread and the first client
            ObjectInputStream in1 = new ObjectInputStream(client1.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Battleship_serverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { //initializes input stream between this thread and the second client
            ObjectInputStream in2 = new ObjectInputStream(client2.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Battleship_serverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {//initializes output stream between this thread and the first client
            ObjectOutputStream out1 = new ObjectOutputStream(client1.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Battleship_serverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {//initializes output stream between this thread and the second client
            ObjectOutputStream out2 = new ObjectOutputStream(client2.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Battleship_serverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //requests the locations of each client's battleships 

        //game loop:consecutively asks each client to target a location and conveys the relevent information to each client
    }
}
