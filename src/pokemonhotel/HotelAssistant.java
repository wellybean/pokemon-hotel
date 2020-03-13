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

import java.util.*;

/**
 * An object of class <code>HotelAssistant</code> holds information on
 * assistants that will be potentially taking care of pokemons
 *
 * @author Wellington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class HotelAssistant {

    private final String name;
    private final int expertLevel;
    private final String pokemonType1;
    private final String pokemonType2;
    private final ArrayList pokemonGuests;

    /**
     * Constructor for the <code>HotelAssistant</code> class
     *
     * @param name holds the assistant's name
     * @param expertLevel holds the assistant's Expert Level
     * @param pokemonType1 holds a type of pokemon the assistant can take care
     * of
     * @param pokemonType2 holds a type of pokemon the assistant can take care
     * of
     */
    public HotelAssistant(String name, int expertLevel, String pokemonType1, String pokemonType2) {
        this.name = name;
        this.expertLevel = expertLevel;
        this.pokemonType1 = pokemonType1;
        this.pokemonType2 = pokemonType2;
        this.pokemonGuests = new ArrayList<>();
    }

    /**
     * Gets assistant's name
     *
     * @return a string with the assistant's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets assistant's Expert Level
     *
     * @return an integer with the assistant's Expert Level
     */
    public int getExpertLevel() {
        return expertLevel;
    }

    /**
     * Gets the first type of pokemon the assistant can take care of
     *
     * @return a string with the first type of pokemon the assistant can take
     * care of
     */
    public String getPokemonType1() {
        return pokemonType1;
    }

    /**
     * Gets the second type of pokemon the assistant can take care of
     *
     * @return a string with the second type of pokemon the assistant can take
     * care of
     */
    public String getPokemonType2() {
        return pokemonType2;
    }

    /**
     * Gets array list with pokemons assigned to the assistant
     *
     * @return an array list containing objects of class <code>Pokemon</code>
     * that are assigned to the assistant
     */
    public ArrayList<Pokemon> getPokemonGuests() {
        return pokemonGuests;
    }

    /**
     * Receives and assigns a Pokemon to the assistant in case their limit of 5
     * Pokemons hasn't been reached yet
     *
     * @param pokemon holds an object of class <code>Pokemon</code>
     * @return 1 in case of success and -1 otherwise
     */
    public int assignGuest(Pokemon pokemon) {
        if (this.pokemonGuests.size() == 5) {
            return -1;
        }
        this.pokemonGuests.add(pokemon);
        return 1;
    }

}
