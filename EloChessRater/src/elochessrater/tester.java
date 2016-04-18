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

/**
 *
 * @author 18balanagav
 */
public class tester {

    public static void main(String args[]) {
        Rater rater = new Rater();
        Player player1 = new Player(2000, "player1");
        Player player2 = new Player(2400, "player2");

        rater.setRating1(player1.getRating());
        rater.setRating2(player2.getRating());
        rater.setResult1(1);
        rater.setResult2(0);

        rater.compute();

        System.out.println("Player1 new rating: " + rater.getRating1());
        System.out.println("Player2 new rating: " + rater.getRating2());
    }
}
