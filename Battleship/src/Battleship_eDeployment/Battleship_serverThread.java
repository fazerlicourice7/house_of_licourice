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
    
    public final Socket client1;
    public Socket client2;
    public int PORT;
    private Object Battleship_eDeployment;

    Battleship_serverThread(Socket client1) {
        super("Battleship_serverThread");
        this.client1 = client1;
    }

    //run method
    @Override
    public synchronized void run() {
        try (
                ServerSocket serversocket = new ServerSocket(PORT)) {
            client2 = serversocket.accept();
            int player = 2;
            Runnable CLIENT2 = new Battleship_eDeployment.Battleship_server_clientThread(client2, player);
            new Thread(CLIENT2).start();
        }
        catch (IOException ex) {
            Logger.getLogger(Battleship_serverThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            int player = 1;
            Runnable CLIENT1;
            CLIENT1 = new Battleship_eDeployment.Battleship_server_clientThread(client1, player);
            new Thread(CLIENT1).start();
        }
        
        
        
    }
}
