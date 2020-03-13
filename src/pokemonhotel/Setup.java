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
import java.io.*;

/**
 * An object of the class <code>Setup</code> holds all the information on the
 * pokemons, assistants and hotel rooms it creates. This info is store in both
 * array lists and hash maps for later retrieval.
 *
 * @author Wellington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class Setup {

    private final ArrayList pokemonTypeArray;
    private final ArrayList pokemonNameArray;
    private final ArrayList assistantNameArray;
    private final ArrayList pokemonGroup;
    private final ArrayList hotelRooms;
    private final ArrayList assistants;
    private final HashMap pokemonAndAssignedAssistant;
    private final HashMap pokemonAndAssignedHotelRoom;

    /**
     * Constructor for the <code>Setup</code> class
     */
    public Setup() {
        this.pokemonTypeArray = new ArrayList<>();
        this.pokemonNameArray = new ArrayList<>();
        this.assistantNameArray = new ArrayList<>();
        this.pokemonGroup = new ArrayList<>();
        this.hotelRooms = new ArrayList<>();
        this.assistants = new ArrayList<>();
        this.pokemonAndAssignedAssistant = new HashMap<>();
        this.pokemonAndAssignedHotelRoom = new HashMap<>();
    }

    /**
     * This method initialises all pokemons, hotel assistants and hotel rooms
     */
    public void setUp() {

        // Reads file containing pokemon types and stores them in array list pokemonTypeArray
        File pokeTypeFile = new File("src/pokemonhotel/resources/poke_types.txt");
        try {
            Scanner sc = new Scanner(pokeTypeFile);
            while (sc.hasNextLine()) {
                pokemonTypeArray.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Pokemon type file not found");
        }

        // Reads file containing pokemon types and stores them in array list pokemonTypeArray
        File pokeNameFile = new File("src/pokemonhotel/resources/pokemon.txt");
        try {
            Scanner scan = new Scanner(pokeNameFile);
            while (scan.hasNextLine()) {
                pokemonNameArray.add(scan.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Pokemon name file not found");
        }

        // Reads file containing names for people and stores them in array list assistantNameArray
        File assistantNameFile = new File("src/pokemonhotel/resources/random_names.txt");
        try {
            Scanner scan = new Scanner(assistantNameFile);
            while (scan.hasNextLine()) {
                assistantNameArray.add(scan.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Assistant name file not found");
        }
        /*
         * RANDOM INITIALISATON OF POKEMONS
         */
        for (int i = 0; i < 80; i++) {

            // Picks random name for the new pokemon
            String name = Utilities.getInstance().RandomStringInArrayList(pokemonNameArray);

            // Picks random type for the new pokemon
            String type = Utilities.getInstance().RandomStringInArrayList(pokemonTypeArray);

            // Picks unique stamp for the new pokemon
            int stamp;
            boolean isStampUnique;
            while (true) {
                stamp = Utilities.getInstance().pickARandomIntegerUpTo(1000);
                isStampUnique = true;
                // Checks all the existing pokemons for repeated stamps
                for (int j = 0; j < this.pokemonGroup.size(); j++) {
                    if (stamp == getPokemonGroup().get(j).getStamp()) {
                        isStampUnique = false;
                    }
                }
                if (isStampUnique) {
                    break;
                }
            }

            // Picks a random Special Attack Rating between 5 and 15
            int specialAttackRating = Utilities.getInstance().RandomIntegerWithinBoundaries(5, 15);

            // Picks a random Speed Rating between 5 and 15
            int speedRating = Utilities.getInstance().RandomIntegerWithinBoundaries(5, 15);

            // Picks a random Expert Level between 1 and 10
            int expertLevel = Utilities.getInstance().RandomIntegerWithinBoundaries(1, 10);

            // Creates new Pokemon and adds it to array list pokemonGroup
            getPokemonGroup().add(new Pokemon(name, type, stamp, specialAttackRating, speedRating, expertLevel));
        }

        /*
         * INITIALISATION OF HOTEL ROOMS
         */
        for (int i = 0; i < 100; i++) {

            // Ordered hotel rooms from 1 to 100
            int roomNumber = i + 1;

            // Picks a random Resistance Rating from 3 to 7 
            int resistanceRating = Utilities.getInstance().RandomIntegerWithinBoundaries(3, 7);

            // Creates new Hotel Room and adds it to array list hotelRooms
            getHotelRooms().add(new HotelRoom(roomNumber, resistanceRating));
        }

        /*
         * INITIALISATION OF HOTEL ASSISTANTS
         */
        for (int i = 0; i < 20; i++) {

            // Picks a random name for the new assistant
            String name = Utilities.getInstance().RandomStringInArrayList(assistantNameArray);

            // Picks a random Expert Level for the new assistant between 1 and 6
            int expertLevel = Utilities.getInstance().RandomIntegerWithinBoundaries(1, 6);

            // Picks up to two different pokemon types that the assistant can assist
            // In case types 1 and 2 are the same, then the assistant can only take care of one type of pokemon
            String pokemonType1 = Utilities.getInstance().RandomStringInArrayList(pokemonTypeArray);
            String pokemonType2 = Utilities.getInstance().RandomStringInArrayList(pokemonTypeArray);

            // Creates new Hotel Assistant and adds it to array list assistants
            getAssistants().add(new HotelAssistant(name, expertLevel, pokemonType1, pokemonType2));
        }
    }

    /**
     * Returns an array list containing pokemon types
     *
     * @return an array list containing strings with pokemon types
     */
    public ArrayList<String> getPokemonTypeArray() {
        return pokemonTypeArray;
    }

    /**
     * Returns an array list containing pokemon names
     *
     * @return an array list containing strings with pokemon names
     */
    public ArrayList<String> getPokemonNameArray() {
        return pokemonNameArray;
    }

    /**
     * Returns an array list containing Pokemons
     *
     * @return an array list containing objects of the class
     * <code>Pokemon</code>
     */
    public ArrayList<Pokemon> getPokemonGroup() {
        return pokemonGroup;
    }

    /**
     * Returns an array list containing Hotel Rooms
     *
     * @return an array list containing objects of the class
     * <code>HotelRoom</code>
     */
    public ArrayList<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Returns array list containing Hotel Assistants
     *
     * @return array list containing objects of the class
     * <code>HotelAssistant</code>
     */
    public ArrayList<HotelAssistant> getAssistants() {
        return assistants;
    }

    /**
     * Returns hash map linking Pokemons with their assigned Hotel Assistants
     *
     * @return a hash map containing <code>Pokemon</code> objects as the keys
     * and <code>HotelAssistant</code> objects as the values
     */
    public HashMap<Pokemon, HotelAssistant> getPokemonAndAssistantHashMap() {
        return pokemonAndAssignedAssistant;
    }

    /**
     * Returns hash map linking pokemons with their assigned Hotel Rooms
     *
     * @return a hash map containing <code>Pokemon</code> objects as the keys
     * and <code>HotelRoom</code> objects as the values
     */
    public HashMap<Pokemon, HotelRoom> getPokemonAndRoomHashMap() {
        return pokemonAndAssignedHotelRoom;
    }
}
