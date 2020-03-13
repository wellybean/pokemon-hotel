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
 * This class contains a method that keeps displaying a menu to the user until
 * they decide to exit the program
 *
 * @author Wellington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class Menu {

    /**
     * This methods receives all data related to the pokemons, the hotel rooms
     * and hotel assistants, and provides an interactive interface with the user
     *
     * @param s holds all the information on pokemons, hotel rooms and hotels
     * assistants created in the <code>Setup</code> class and then modified in
     * the <code>PokemonAccomodator</code> class
     */
    public static void run(Setup s) {

        int menuOption;
        int counter;
        boolean exit = false;

        // Runs until user decides to exit program
        while (!exit) {
            System.out.println("\n**********Welcome to the Pokemon Hotel************"
                    + "\n\nHere are the available options: "
                    + "\n    (1) Display all members of the Pokemon group."
                    + "\n    (2) Display total number of Pokemons that were accomodated."
                    + "\n    (3) List of accommodated Pokemons."
                    + "\n    (4) List of unaccommodated Pokemons."
                    + "\n    (5) List of hotel assistant and their assigned Pokemons."
                    + "\n    (6) Check a particular room."
                    + "\n    (7) Look up information on a specific Pokemon by its stamp no."
                    + "\n    (8) List any unassigned hotel assistants."
                    + "\n    (9) List any unoccupied hotel rooms."
                    + "\n    (10) Exit."
            );
            System.out.print("Please select one of the options above: ");

            menuOption = Utilities.getInstance().optionInputHandler(10);

            switch (menuOption) {

                /*
                 * PRINTS INFORMATION FOR EVERY POKEMON    
                 */
                case 1:
                    for (int i = 0; i < s.getPokemonGroup().size(); i++) {
                        Pokemon pokemon = s.getPokemonGroup().get(i);
                        System.out.print("\nPokemon " + (i + 1) + ": ");
                        Utilities.getInstance().printPokemonInfo(pokemon);
                    }
                    System.out.println("\n");
                    break;

                /*
                 * PRINTS HOW MANY POKEMONS HAVE BEEN ASSIGNED TO A ROOM AND ASSISTANT    
                 */
                case 2:
                    counter = 0;
                    for (int i = 0; i < s.getHotelRooms().size(); i++) {
                        if (s.getHotelRooms().get(i).getGuest() != null) {
                            counter++;
                        }
                    }
                    System.out.println("\nThe number of accomodated Pokemons is: " + counter + "\n");
                    break;

                /*
                 * PRINTS A LIST WITH ALL ACCOMMODATED POKEMONS    
                 */
                case 3:
                    counter = 0; // Used to count accomodated pokemons

                    // Iterates through all hotel rooms
                    for (int i = 0; i < s.getHotelRooms().size(); i++) {

                        // Checks if room is occupied
                        if (s.getHotelRooms().get(i).getGuest() != null) {
                            counter++;
                            Pokemon pokemon = s.getHotelRooms().get(i).getGuest();
                            HotelRoom room = s.getPokemonAndRoomHashMap().get(pokemon);
                            HotelAssistant assistant = s.getPokemonAndAssistantHashMap().get(pokemon);

                            //Printing section
                            System.out.print("\nAccomodated Pokemon " + counter + ": ");
                            Utilities.getInstance().printPokemonInfo(pokemon);
                            System.out.println("This pokemon is assigned to room no. "
                                    + room.getRoomNumber() + " (Resistance Rating = "
                                    + room.getResistanceRating() + ") and assistant "
                                    + assistant.getName() + " (Expert Level = "
                                    + assistant.getExpertLevel() + ")");
                        }
                    }
                    break;

                /*
                 * PRINTS A LIST WITH ALL UNACCOMMODATED POKEMONS    
                 */
                case 4:
                    counter = 0; // Used to count unaccomodated pokemons

                    // Iterates through all pokemons
                    for (int i = 0; i < s.getPokemonGroup().size(); i++) {
                        Pokemon pokemon = s.getPokemonGroup().get(i);

                        // Checks if there's a key with the current pokemon in the hash map pokemonAndAssignedHotelRoom
                        if (s.getPokemonAndRoomHashMap().get(pokemon) == null) {
                            counter++;
                            System.out.print("\nUnaccomodated Pokemon " + counter + ": ");
                            Utilities.getInstance().printPokemonInfo(pokemon);
                        }
                    }
                    break;

                /*
                 * PRINTS INFORMATION ON ALL ASSISTANTS AND THEIR RESPECTIVE ASSIGNED POKEMONS    
                 */
                case 5:
                    // Iterates through each assistant
                    for (int i = 0; i < s.getAssistants().size(); i++) {
                        HotelAssistant assistant = s.getAssistants().get(i);

                        // Does this if at least one pokemon has been assigned to this assistant
                        if (!assistant.getPokemonGuests().isEmpty()) {
                            System.out.println("\nAssistant " + assistant.getName()
                                    + " takes care of:"
                            );

                            // Iterates through all pokemons assigned to this assistant
                            for (int j = 0; j < assistant.getPokemonGuests().size(); j++) {
                                Pokemon pokemon = assistant.getPokemonGuests().get(j);
                                System.out.println("         " + pokemon.getName()
                                        + " (ID: " + pokemon.getStamp() + ")"
                                        + " [" + pokemon.getType() + " ("
                                        + Utilities.getInstance().pokemonCategory(pokemon)
                                        + ")] - Hotel room no. "
                                        + s.getPokemonAndRoomHashMap().get(pokemon).getRoomNumber()
                                );
                            }
                        }
                    }
                    break;

                /*
                 * RETRIVES INFORMATION ON A SPECIFIC HOTEL ROOM SELECTED BY THE USER    
                 */
                case 6:
                    // Asks user for input
                    System.out.print("\nPlease select a hotel room: ");
                    int hotelRoomNumber = Utilities.getInstance().optionInputHandler(s.getHotelRooms().size());

                    // Prints message to user saying that no pokemon was assigned to this room
                    if (s.getHotelRooms().get(hotelRoomNumber - 1).getGuest() == null) {
                        System.out.println("No Pokemon is assigned to this room.");
                    } // Prints info about the pokemon assigned to the room
                    else {
                        Pokemon guest = s.getHotelRooms().get(hotelRoomNumber - 1).getGuest();
                        System.out.println("The Pokemon staying in room no. "
                                + hotelRoomNumber + " is " + guest.getName()
                                + " (ID: " + guest.getStamp() + ") [" + guest.getType()
                                + " (" + Utilities.getInstance().pokemonCategory(guest)
                                + ")], which is being assisted by "
                                + s.getPokemonAndAssistantHashMap().get(guest).getName()
                        );
                    }
                    break;

                /*
                 * RETRIEVES INFORMATION ON A SPECIFIC POKEMON SELECTED BY THE USER THROUGH ITS STAMP NUMBER    
                 */
                case 7:
                    // Asks user to input a stamp number
                    System.out.print("\nPlease type in a valid stamp number: ");
                    int pokemonStamp = Utilities.getInstance().optionInputHandler(1000);

                    boolean isThereSuchPokemon = false;
                    Pokemon pokemon = null;

                    // Iterates through every pokemon in the group
                    for (int i = 0; i < s.getPokemonGroup().size(); i++) {

                        // Checks if the input stamp matches any of the stamps in the group
                        if (s.getPokemonGroup().get(i).getStamp() == pokemonStamp) {
                            isThereSuchPokemon = true;
                            pokemon = s.getPokemonGroup().get(i);
                            break;
                        }
                    }

                    if (isThereSuchPokemon) {
                        // Used to check if pokemon has been assigned to any room
                        HotelRoom room = s.getPokemonAndRoomHashMap().get(pokemon);

                        // If pokemon has been assigned to a room, prints this
                        if (room != null) {
                            System.out.println("\n" + pokemon.getName() + " (ID: "
                                    + pokemon.getStamp() + ") [" + pokemon.getType()
                                    + " (" + Utilities.getInstance().pokemonCategory(pokemon)
                                    + ")] is staying in room no. "
                                    + s.getPokemonAndRoomHashMap().get(pokemon).getRoomNumber()
                                    + " and is being assisted by "
                                    + s.getPokemonAndAssistantHashMap().get(pokemon).getName()
                            );
                        } // If pokemon hasn't been assigned to any room, prints this
                        else {
                            System.out.println("\n" + pokemon.getName() + " (ID: "
                                    + pokemon.getStamp() + ") [" + pokemon.getType()
                                    + " (" + Utilities.getInstance().pokemonCategory(pokemon)
                                    + ")] is not assigned to any room or assistant."
                            );
                        }
                    } // Prints this if no pokemon was found with the stamp number that was input
                    else {
                        System.out.println("\nNo such Pokemon exists.");
                    }
                    break;

                /*
                 * LISTS ALL UNASSIGNED ASSISTANTS, IF ANY    
                 */
                case 8:
                    System.out.println("");
                    boolean isThereAnyUnassignedAssistant = false;

                    // Iterates through all assistants
                    for (int i = 0; i < s.getAssistants().size(); i++) {
                        HotelAssistant assistant = s.getAssistants().get(i);

                        // Does this if assistant hasn't been assigned to any pokemons
                        if (assistant.getPokemonGuests().isEmpty()) {
                            System.out.println("Assistant " + assistant.getName()
                                    + " is not assigned to any Pokemon."
                            );
                            isThereAnyUnassignedAssistant = true;
                        }
                    }

                    // Does this if no unassigned assistant was found
                    if (!isThereAnyUnassignedAssistant) {
                        System.out.println("There are no unassigned assistants.");
                    }
                    break;

                /*
                 * LISTS ALL UNOCCUPIED ROOMS    
                 */
                case 9:
                    System.out.println("");
                    boolean isThereAnyUnoccupiedRoom = false;

                    // Iterates through all hotel rooms
                    for (int i = 0; i < s.getHotelRooms().size(); i++) {
                        HotelRoom room = s.getHotelRooms().get(i);

                        // Does this if room hasn't been assigned to any pokemons
                        if (room.getGuest() == null) {
                            System.out.println("Hotel room no. " + room.getRoomNumber()
                                    + " is not occupied by any Pokemon."
                            );
                            isThereAnyUnoccupiedRoom = true;
                        }
                    }

                    // Does this if no unassigned room was found
                    if (!isThereAnyUnoccupiedRoom) {
                        System.out.println("There are no unoccupied rooms.");
                    }
                    break;

                /*
                 * EXITS PROGRAM    
                 */
                case 10:
                    exit = true;
                    break;
            }
        }
    }
}
