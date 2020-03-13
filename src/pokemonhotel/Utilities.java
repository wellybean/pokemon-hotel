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
 * This class contains useful methods that are used throughout the program for
 * optimisation of the code
 *
 * @author Welington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class Utilities {

    private static Utilities INSTANCE = null;
    private static Random r;
    private static Scanner scan;

    /**
     * Constructor for the class <code>Utilities</code>
     */
    private Utilities() {
        r = new Random();
        scan = new Scanner(System.in);
    }

    /**
     * Method used to obtain instance of class <code>Utilities</code>
     *
     * @return the only instance of the class <code>Utilitiea</code> used
     * throughout the entire program
     */
    public static Utilities getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Utilities();
        }
        return INSTANCE;
    }

    /**
     * Receives an array list with strings and returns a randomly selected
     * string
     *
     * @param array holds an array list with strings
     * @return a randomly selected string from the array list 'array'
     */
    public String RandomStringInArrayList(ArrayList<String> array) {

        String string = array.get(r.nextInt(array.size()));

        return string;
    }

    /**
     * Picks a random number between well defined boundaries
     *
     * @param min holds the minimum possible value inclusive
     * @param max holds the maximum possible value inclusive
     * @return an random integer between 'min' (inclusive) and 'max' inclusive
     */
    public int RandomIntegerWithinBoundaries(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Picks a random integer between 1 and the parameter 'limit'
     *
     * @param limit holds the maximum value to be returned
     * @return an integer with a randomly selected number between 1 and 'limit'
     */
    public int pickARandomIntegerUpTo(int limit) {
        int randomNum = (r.nextInt(limit) + 1);
        return randomNum;
    }

    /**
     * Handles user input so that the user has to input a valid option
     *
     * @param size holds the last valid option (from 1 to 'size')
     * @return an integer with a valid option
     */
    public int optionInputHandler(int size) {

        int option;
        while (true) {
            try {
                option = scan.nextInt();
                if (option > 0 && option <= size) {
                    break;
                } else {
                    System.out.print("INVALID OPTION! Please type in a valid option: ");
                }
            } catch (NumberFormatException ex) {
                System.out.print("INVALID OPTION! Please type in a valid option: ");
            } catch (InputMismatchException ex) {
                System.out.print("INVALID OPTION! Please type in a valid option: ");
                scan.next();
            }
        }
        scan.nextLine();
        return option;
    }

    /**
     * Receives an object of class <code>Pokemon</code> an returns its category
     *
     * @param pokemon holds an object of class <code>Pokemon</code>
     * @return a string with the category of the pokemon
     */
    public String pokemonCategory(Pokemon pokemon) {
        String type = pokemon.getType();
        if (type.equals("Normal") || type.equals("Grass") || type.equals("Fighting")
                || type.equals("Poison") || type.equals("Ground") || type.equals("Rock")
                || type.equals("Steel")) {
            return "Land";
        } else if (type.equals("Fire") || type.equals("Electric") || type.equals("Flying")
                || type.equals("Psychic") || type.equals("Bug") || type.equals("Ghost")
                || type.equals("Dragon") || type.equals("Fairy")) {
            return "Air";
        }
        return "Water";
    }

    /**
     * Prints information regarding a specific pokemon
     *
     * @param pokemon holds an object of class <code>Pokemon</code>
     */
    public void printPokemonInfo(Pokemon pokemon) {
        System.out.print(pokemon.getName() + " (ID: " + pokemon.getStamp() + ")"
                + " [" + pokemon.getType() + " (" + Utilities.getInstance().pokemonCategory(pokemon) + ")]"
                + "\n    Special Attack Rating = " + pokemon.getSpecialAttackRating()
                + "\n    Speed Rating = " + pokemon.getSpeedRating()
                + "\n    Expert Level = " + pokemon.getExpertLevel() + "\n"
        );
    }
}
