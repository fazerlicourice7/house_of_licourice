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
public class Player {

    private String name;
    private int rating;

    public Player() {
        rating = 1200;
        name = "John Doe";
    }

    public Player(int r, String n) {
        rating = r;
        name = n;
    }

    //=======Accessors and Modifiers=========================
    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String n) {
        name = n;
    }

    public void setRating(int r) {
        rating = r;
    }

    public String toString() {
        String s;
        s = name + " " + rating;
        return s;
    }

}
