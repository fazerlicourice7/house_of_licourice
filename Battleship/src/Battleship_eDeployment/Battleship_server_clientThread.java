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
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author fazerlicourice7
 */
public class Battleship_server_clientThread implements Runnable {

    ArrayList x1 = new ArrayList(), y1 = new ArrayList();
    ArrayList x2 = new ArrayList(), y2 = new ArrayList();
    int player, player1, player2;
    String[][] coordinates1, coordinates2;
    Socket client;

    Battleship_server_clientThread(Socket client, int player) {
        //super("Battleship_server_clientThread");
        this.client = client;
        this.player = player;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int loop = 0; loop < 10; loop++) {
                for (int loop2 = 0; loop2 < 10; loop2++) {
                    coordinates1[loop][loop2] = "~";
                    coordinates2[loop][loop2] = "~";
                }
            }
        }
        if (player == 1) {
            ObjectInputStream in = null;
            ObjectOutputStream out = null;
            try {
                in = new ObjectInputStream(client.getInputStream());
                out = new ObjectOutputStream(client.getOutputStream());
                for (int loop = 0; loop < 5; loop++) {
                    String ship = in.readUTF();
                    //check(in client) if allowed
                    String coordinates[] = ship.split(" ");
                    for (int loop2 = 0; loop2 < coordinates.length; loop2++) {
                        String coordinate[] = coordinates[loop2].split(",");
                        synchronized (this) {
                            x1.add(Integer.parseInt(coordinate[0]));
                            y1.add(Integer.parseInt(coordinate[1]));
                        }
                    }
                }
                //game loop
                while (true) {
                    synchronized (this) {

                        if (player1 == 17) {
                            out.writeUTF("You won!!!");
                            break;
                        } else if (player2 == 17) {
                            out.writeUTF("You lost :(");
                            break;
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(Battleship_server_clientThread.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(Battleship_server_clientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (player == 2) {

        }
    }

}
