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
 * An object of the class <code>Pokemon</code> holds the pokemon's name, its
 * type, its unique stamp number, its Special Attack Rating, its Speed Rating
 * and its Expert Level
 *
 * @author Wellington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class Pokemon {

    private final String name;
    private final String type;
    private final int stamp;
    private final int specialAttackRating;
    private final int speedRating;
    private final int expertLevel;

    /**
     * Constructor for the class <code>Pokemon</code>
     *
     * @param name holds the pokemon's name
     * @param type holds the pokemon's type
     * @param stamp holds the pokemon's unique stamp number
     * @param specialAttackRating holds the pokemon's Special Attack Rating
     * @param speedRating holds the pokemon's Speed Rating
     * @param expertLevel holds the pokemon's Expert Level
     */
    public Pokemon(String name, String type, int stamp, int specialAttackRating, int speedRating, int expertLevel) {
        this.name = name;
        this.type = type;
        this.stamp = stamp;
        this.specialAttackRating = specialAttackRating;
        this.speedRating = speedRating;
        this.expertLevel = expertLevel;
    }

    /**
     * Gets the pokemon's name
     *
     * @return a String with the pokemon's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pokemon's type
     *
     * @return a Strign with the pokemon's type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the pokemon's unique stamp number
     *
     * @return an integer with the pokemon's unique stamp number
     */
    public int getStamp() {
        return stamp;
    }

    /**
     * Gets the pokemon's Special Attack Rating
     *
     * @return an integer with the pokemon's Special Attack Rating
     */
    public int getSpecialAttackRating() {
        return specialAttackRating;
    }

    /**
     * Gets the pokemon's Speed Rating
     *
     * @return an integer with the pokemon's Speed Rating
     */
    public int getSpeedRating() {
        return speedRating;
    }

    /**
     * Gets the pokemon's Expert Level
     *
     * @return an integer with the pokemon's Expert Level
     */
    public int getExpertLevel() {
        return expertLevel;
    }

}
