/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleship;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fazer
 */
public class Battleship_2_c_f {

    String input, hostName, input2;
    int i = 0, column, row, position = 0, number, some_number, another_number, PORT = 4444;
    String[][] coordinates = new String[10][10];
    int[][] X = new int[4][3], Y = new int[4][3];
    List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    private void destroy_battleships() throws IOException {
        System.out.println("Enter a coordinate (x,y). If it hits a battleship, the specific location will show an 'X' else it will show an 'O'");
        for (column = 0; column < 10; column++) {
            for (row = 0; row < 10; row++) {
                coordinates[row][column] = "~ ";
            }
        }
        while (i >= 0) {
            input = read.readLine();
            String[] coordinate = input.split(",");
            x.add(Integer.parseInt(coordinate[0]));
            y.add(Integer.parseInt(coordinate[1]));
            for (number = 0; number < 4; number++) {
                for (position = 0; position < 3; position++) {
                    if (X[number][position] == (x.get(i)) && Y[number][0] == (y.get(i))) {
                        coordinates[x.get(i)][y.get(i)] = "X ";
                    } else if (coordinates[x.get(i)][y.get(i)].equals("X ")) {

                    } else {
                        coordinates[x.get(i)][y.get(i)] = "O ";
                    }
                }
            }
            i++;
            System.out.println("Tries:" + i);
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
            for (some_number = 0; some_number < x.size(); some_number++) {
                if (coordinates[x.get(some_number)][y.get(some_number)] == "X ") {
                    another_number++;
                }
            }
            if (another_number == 12) {
                break;
            }
        }
    }

    private void get_set() throws IOException {
        Battleship_2_c_f obj = new Battleship_2_c_f();
        Path PATH2 = Paths.get("/home/fazer/Documents/server_location.txt");
        try (InputStream in = Files.newInputStream(PATH2);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            while (input2 != null) {
                for (number = 0; number < 4; number++) {
                    input2 = reader.readLine();
                    if (input2 != null) {
                        String[] SHIP = input2.split(" ");
                        System.out.println(SHIP.length);
                        for (int whatever = 0; whatever < SHIP.length; whatever++) {
                            String coordinate[] = SHIP[whatever].split(",");
                            X[number][whatever] = Integer.parseInt(coordinate[0]);
                            Y[number][whatever] = Integer.parseInt(coordinate[1]);
                        }
                    }
                }
            }
        }
        System.out.println("Enter the coordinates of your battleships (in the format: x,y x,y x,y)(4 battleships, each with a length of 3, either horizontal or vertical ONLY!)");
        String INPUT = read.readLine();
        while (INPUT != null) {
            byte[] liness = INPUT.getBytes();
            Path PATH1 = Paths.get("/home/fazer/Documents/client_location.txt");
            try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(PATH1, WRITE, APPEND))) {
                out.write(liness);
            }
            INPUT = read.readLine();
        }
        obj.destroy_battleships();
    }

    public static void main(String args[]) throws IOException {
        Battleship_2_c_f obj = new Battleship_2_c_f();
        obj.get_set();
    }
}
