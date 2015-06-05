package misc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fazer
 */

public class serverTrial1 {

    public static int PORT = 3080;
    public static String input = "";
    public static void main(String args[]) throws IOException {
        try (ServerSocket serversocket = new ServerSocket(PORT);
                Socket clientsocket = serversocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))) {
            System.out.println("Connected");
            while (input != null) {
                input = in.readLine();
                System.out.println(input);
            }
        }
    }
}
