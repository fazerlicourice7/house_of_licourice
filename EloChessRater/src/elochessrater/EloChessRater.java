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

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 18balanagav
 */
public class EloChessRater {

    private String player1Name, player2Name;
    private double player1Result, player2Result;
    ArrayList<Player> players;
    fileCommunicator fileCom;
    Rater r;

    public EloChessRater(String p1N, String p2N, double p1R, double p2R) throws IOException {
        player1Name = p1N;
        player2Name = p2N;
        player1Result = p1R;
        player2Result = p2R;
        fileCom = new fileCommunicator();
        players = fileCom.readFile();
        r = new Rater();
    }

    public void run() {
        Player player1 = new Player(), player2 = new Player();
        player1.setName(player1Name);
        player2.setName(player2Name);
        r.setResult1(player1Result);
        r.setResult2(player2Result);
        for (Player p : players) {
            System.out.println(p.getName() + " " + p.getRating());
            if (p.getName().equals(player1Name)) {
                r.setRating1(p.getRating());
                player1.setRating(p.getRating());
            } else if (p.getName().equals(player2Name)) {
                r.setRating2(p.getRating());
                player2.setRating(p.getRating());
            }
        }
        if (r.getRating1() == 0) {
            r.setRating1(1200);
            player1.setRating(1200);
        }
        if (r.getRating2() == 0) {
            r.setRating2(1200);
            player2.setRating(1200);
        }
        players.remove(player1);
        players.remove(player2);
        r.compute();
        player1.setRating(r.getRating1());
        player2.setRating(r.getRating2());
        players.add(player1);
        players.add(player2);
        fileCom.writeFile(players);
    }

}
