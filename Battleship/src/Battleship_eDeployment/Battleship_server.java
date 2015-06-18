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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fazerlicourice71256
 */

/**
 * This is the server side of an application called Battleships. It is a virtual
 * recreation of the board game battleship. This is a turn based game in which
 * two players first set the locations of their battleships, then try to
 * calculate and/or guess the location of the opponents battleships.
 *
 * Each player has to set five battleships either horizontally or vertically.
 * They cannot overlap any other of the same player's ships. One battleship is 2
 * 'grid coordinates long' (from here on grid coordinates will be referred to as
 * points). Two battleships have three points, one battleship has four points
 * and the last battleship has five points.
 *
 * The players take turns guessing and/or calculating the location of the
 * opponents battleships, and fire 'missiles' at the targeted location and both
 * players get feedback as to whether their shot hit or missed and whether any
 * of their ships were hit or not.
 *
 *
 */
public class Battleship_server {

    //initializes integer PORT with the value if the port on which the server listens.

    static ArrayList<Thread> list = new ArrayList<>();
    static int PORT = 12345;
    static Socket client;
    static Battleship_serverThread client1;
    public static synchronized void main(String[] args) throws IOException {
        //creates a loop that re-iterates forever(while the program is running).
        while (true) {
            //creates a ServerSocket that listens for requests on port:PORT
            try (
                    ServerSocket serversocket = new ServerSocket(PORT);) {
                //spawns a new thread each time a client connects
                client = serversocket.accept();
                /*list.add(*/client1 = new Battleship_eDeployment.Battleship_serverThread(client)/*)*/;
                client1.start();
                //System.out.println("Connection established");
            }
        }
        
    }
}
