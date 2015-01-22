package Battleship;
/*
 * This is a project in which I attempt to recreate the famous Battleship board game. It will eventually be able to play against another person and not just the computer.
 * Phase 1: try to sink the computer's battleship(s)
 * Phase 2: You try to sink opponents batttleship (opponent only sets the location of battleships)
 * Phase 3: A full version of battleship in which you and opponent set and destry battleships. 
 * Phase 4: Phase 1 + computer tries to sink your battleships.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author fazer
 */
public class Battleship_phase_1_1 {
    BufferedReader hi = new BufferedReader (new InputStreamReader(System.in));
    String input;
    int i = 0, column, row, position = 0, number;
    String[][] coordinates = new String[10][10];
    int[][] X = new int[4][3], Y = new int[4][3];
    List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
    private void horizontal()throws IOException{
        System.out.println("Enter a coordinate (x,y). If it hits a battleship, the specific location will show an 'X' else it will show an 'O'");
        for (column = 0; column < 10; column++){
            for (row = 0; row < 10; row++){
                coordinates[row][column] = "~ ";
            }
        }
        for(number = 0; number < 4; number++){
            X[number][0] = ((int) (Math.random() * 9));
            Y[number][0] = ((int) (Math.random() * 9));
            if(X[number][0] == 9){
                X[number][1] = X[number][position] - 1;
                X[number][2] = X[number][position] + 1;
            }
            else if (X[number][0] == 10){
                X[number][1] = X[number][position] - 1;
                X[number][2] = X[number][position] - 2;
            }
            else{
                X[number][1] = X[number][position] + 1;
                X[number][2] = X[number][position] + 2;
            }
        }
        while(i >= 0){
            input = hi.readLine();
            String[] coordinate = input.split(",");
            x.add(Integer.parseInt(coordinate[0]));
            y.add(Integer.parseInt(coordinate[1])); 
            for(number = 0; number < 4; number ++){ 
                for(position = 0; position < 3; position++){
                    if(X[number][position] == (x.get(i)) && Y[number][0] == (y.get(i))){
                        coordinates[x.get(i)][y.get(i)] = "X ";
                    }
                    else if(coordinates[x.get(i)][y.get(i)].equals("X ")){
                        
                    }
                    else{
                        coordinates[x.get(i)][y.get(i)] = "O ";    
                    }
                }
            }
            i++;
            for (column = -1; column < 10; column++){
                if(column > -1){
                    System.out.print(column +" "); 
                }
                for (row = 0; row < 10; row++){
                    if(column == -1){
                        if(row == 0){
                            System.out.print(" "); 
                        }
                        System.out.print(" " +row);
                    }
                    else{
                        System.out.print(coordinates[row][column]);
                    }
                }
                if(row == 10){
                    System.out.println("");
                }
            }
        }
    }
    private void vertical()throws IOException{
        System.out.println("Enter a coordinate (x,y). If it hits a battleship, the specific location will show an 'X' else it will show an 'O'");
        for (column = 0; column < 10; column++){
            for (row = 0; row < 10; row++){
                coordinates[row][column] = "~ ";
            }
        }
        for(number = 0; number < 4; number++){
            position = 0;
            X[number][position] = ((int) (Math.random() * 9));
            Y[number][position] = ((int) (Math.random() * 9));
            if(Y[number][position] == 9){
                Y[number][position + 1] = Y[number][position] - 1;
                Y[number][position + 2] = Y[number][position] + 1;
            }
            else if (Y[number][position] == 10){
                Y[number][position + 1] = Y[number][position] - 1;
                Y[number][position + 2] = Y[number][position] - 2;
            }
            else{
                Y[number][position + 1] = Y[number][position] + 1;
                Y[number][position + 2] = Y[number][position] + 2;
            }
        }
        while(i >= 0){
            input = hi.readLine();
            String[] coordinate = input.split(",");
            x.add(Integer.parseInt(coordinate[0]));
            y.add(Integer.parseInt(coordinate[1]));        
            for(number = 0; number < 4; number++){
                for(position = 0; position < 3; position++){
                    if(X[number][0] == (x.get(i)) && Y[number][position] == (y.get(i))){
                        coordinates[x.get(i)][y.get(i)] = "X ";
                    }
                    else if(coordinates[x.get(i)][y.get(i)].equals("X ")){
                        
                    }
                    else {
                        coordinates[x.get(i)][y.get(i)] = "O ";    
                    }
                }
            }
            i++;
            for (column = -1; column < 10; column++){
                if(column > -1){
                    System.out.print(column +" ");
                }
                for (row = 0; row < 10; row++){
                    if(column == -1){
                        if(row == 0){
                            System.out.print(" "); 
                        }
                        System.out.print(" " +row);
                    }
                    else{
                        System.out.print(coordinates[row][column]);
                    }
                }
                if(row == 10){
                    System.out.println();
                }
            }
        }
    }
    public static void main(String args[])throws IOException{
        Battleship_phase_1_1 obj = new Battleship_phase_1_1();
        int vh = ((int) (Math.random() * 1));
        if(vh == 0){
            obj.horizontal();
        }
        else {
            obj.vertical();
        }
    }
}