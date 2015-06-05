package misc;

/**
 * @author fazer
 */
import java.io.*;
import java.net.Socket;
public class clientTrial1 {
    public static int PORT = 3080;
    static BufferedReader READ = new BufferedReader(new InputStreamReader(System.in));
    public static String hostName;
    public static void main(String args[]) throws IOException {
        //System.out.println("Enter the name of the computer to which you want to connect.");
        //hostName = READ.readLine(); 
        try(Socket clientsocket = new Socket(hostName, PORT)){
            System.out.println("Enter something.");
            READ.readLine();
            
        }
    }
}
