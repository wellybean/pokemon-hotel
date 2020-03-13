/* 
 * Copyright (C) 2019 welli
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
package pokemonhotel;

/**
 * An object of the class <code>HotelRoom</code> holds its room number, its
 * resistance rating and its assigned Pokemon in case there is one
 *
 * @author Wellington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class HotelRoom {

    private final int roomNumber;
    private final int resistanceRating;
    private Pokemon guest;

    /**
     * Constructor for the <code>HotelRoom</code> object
     *
     * @param roomNumber holds an integer with the number of the hotel room
     * @param resistanceRating holds an integer with the resistance rating of
     * the hotel room
     */
    public HotelRoom(int roomNumber, int resistanceRating) {
        this.roomNumber = roomNumber;
        this.resistanceRating = resistanceRating;
        this.guest = null;
    }

    /**
     * Gets hotel room number
     *
     * @return an integer with the number of the hotel room
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Gets the Resistance Rating of the hotel room
     *
     * @return an integer with the Resistance Rating of the hotel room
     */
    public int getResistanceRating() {
        return resistanceRating;
    }

    /**
     * Gets guest assigned to hotel room
     *
     * @return an object <code>Pokemon</code> with the guest staying in the room
     * or 'null' if there is no guest assigned to it
     */
    public Pokemon getGuest() {
        return guest;
    }

    /**
     * Receives and assigns a Pokemon to the hotel room in case it had not been
     * assigned a pokemon yet
     *
     * @param pokemon holds an object of class <code>Pokemon</code>
     * @return 1 in case of success and -1 otherwise
     */
    public int assignGuest(Pokemon pokemon) {
        if (this.guest != null) {
            return -1;
        }
        this.guest = pokemon;
        return 1;
    }

}
