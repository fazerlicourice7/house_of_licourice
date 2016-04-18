/*
 * Copyright (C) 2016 18balanagav
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
package elochessrater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author 18balanagav
 */
public class fileCommunicator {

    private ArrayList<Player> players = new ArrayList<>();
    String f;
    File dir;
    File file;

    public fileCommunicator() throws IOException {
        f = System.getProperty("user.home");
        dir = new File(f + "ChessRater");
        if (!dir.exists()) {
            System.out.println("dir doesn't exist");
            dir.mkdir();
            System.out.println("created dir");
        }
//        System.out.println(dir.toString() + "\\" + "chessRater.txt");
        file = new File(dir.toString() + "\\" + "chessRater.txt");

        if (!file.isFile()) {
            System.out.println("file doesnt exist");
            file.createNewFile();
            System.out.println("created file");
        }
    }

    public ArrayList<Player> readFile() {
        ArrayList<Player> players = new ArrayList<>();
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.toString()), charset)) {
            String info = reader.readLine();
            while (info != null) {
                String[] infoP = info.split(" ");
                String name = infoP[0] + " " + infoP[1];
                Integer rating = Integer.parseInt(infoP[2]);
                players.add(new Player(rating, name));
                info = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return players;
    }

    public void writeFile(ArrayList<Player> players) {
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toString()), charset)) {

            for (Player p : players) {
                String wr = p.getName() + " " + p.getRating();
                writer.write(wr);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
