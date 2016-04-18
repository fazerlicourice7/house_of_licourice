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
public class Rater {

    private static int K = 32;

    private int rating1;
    private int rating2;

    private long simpleRating1;
    private long simpleRating2;

    private double expected1;
    private double expected2;

    //1,0 for white win; 0.5, 0.5 for a draw; 0,1 for a black win
    private double result1;
    private double result2;

    public Rater() {
        rating1 = 0;
        rating2 = 0;
        simpleRating1 = 0;
        simpleRating2 = 0;
        expected1 = 0;
        expected2 = 0;
        result1 = 0;
        result2 = 0;
    }

    public void setRating1(int r) {
        rating1 = r;
    }

    public int getRating1() {
        return rating1;
    }

    public void setRating2(int r) {
        rating2 = r;
    }

    public int getRating2() {
        return rating2;
    }

    public void setResult1(double r) {
        result1 = r;
    }

    public void setResult2(double r) {
        result2 = r;
    }

    public void compute() {
        simpleRating1 = computeSimplified(rating1);
        simpleRating2 = computeSimplified(rating2);

        expected1 = computeExpected(simpleRating1, simpleRating2);
        expected2 = computeExpected(simpleRating2, simpleRating1);

        rating1 += K * (result1 - expected1);
        rating2 += K * (result2 - expected2);
    }

    private double computeExpected(long ratingA, long ratingB) {
        //computes expected from rating1 point of view. returns expected for 1
        return (double) ((double) ratingA / (double) (ratingB + ratingA));
    }

    private int computeSimplified(int rating) {
        return (int) Math.pow(10, (rating / 400));
    }
}
