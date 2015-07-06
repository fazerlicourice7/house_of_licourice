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
package Battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author fazer
 */
public class testRowColumn {

    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static String[][] coordinate = new String[10][10];

    public static void main(String args[]) throws IOException, NullPointerException {
        int x, y;
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                coordinate[row][column] = "~ ";
                System.out.print(coordinate[row][column]);
            }
            System.out.println();
        }
        while (true) {
            System.out.println("Enter the x and the y coordinates");
            String input = read.readLine();
            x = (int)(input.charAt(0));
            y = (int)(input.charAt(1));
            for (int row = 0; row < 10; row++) {
                for (int column = 0; column < 10; column++) {
                    if (row == y && column == x) {
                        coordinate[row][column] = "X ";
                    } else {
                        coordinate[row][column] = "~ ";
                    }
                    System.out.print(coordinate[row][column]);
                }
                System.out.println();
            }
        }
    }
}
