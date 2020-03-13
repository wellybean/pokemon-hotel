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
 * This class contains a static method that uses data coming from the
 * <code>Setup</code> object to assign pokemons to rooms and assistants
 *
 * @author Wellington Regis
 * @author Kate Santos
 * @author Marcus Vinicius
 */
public class PokemonAccommodator {

    /**
     * This method evaluates whether there is a free room and a free hotel
     * assistant that can accommodate each one of the pokemons of the group
     *
     * @param s holds all the information on pokemons, hotel rooms and hotels
     * assistants created in the <code>Setup</code> class
     */
    public static void accommodate(Setup s) {

        // Iterates for esch Pokemon in the group
        for (int i = 0; i < s.getPokemonGroup().size(); i++) {

            Pokemon pokemon = s.getPokemonGroup().get(i); // Pokemon being possibly allocated 
            HotelRoom room = null; // Variable to store a hotel room that can allocate the Pokemon being analysed
            HotelAssistant assistant = null; // Variable to store a hotel assistant that can take care of the pokemon being analysed

            /*
             * CHECKS FOR SUITABLE HOTEL ROOM
             */
            for (int j = 0; j < s.getHotelRooms().size(); j++) {

                // Used to check if this room has already been assigned to a Pokemon
                if (s.getHotelRooms().get(j).getGuest() == null) {

                    // Checks if the Resistance Rating of the hotel room is higher than 1/3 of (the pokemon's Special Attack Rating + the pokemon's Speed Rating)
                    int RR = s.getHotelRooms().get(j).getResistanceRating(); // Resistance Rating of the room
                    int SAR = pokemon.getSpecialAttackRating(); // Special Attack Rating of the Pokemon
                    int SR = pokemon.getSpeedRating(); // Speed Rating of the Pokemon

                    if (RR > ((SAR + SR) / 3)) {
                        room = s.getHotelRooms().get(j);
                        break;
                    }
                }
            }

            /*
             * CHECKS FOR SUITABLE HOTEL ASSISTANT
             */
            for (int j = 0; j < s.getAssistants().size(); j++) {

                String assistantType1 = s.getAssistants().get(j).getPokemonType1();
                String assistantType2 = s.getAssistants().get(j).getPokemonType2();
                String pokemonType = pokemon.getType();
                int assistantExpLevel = s.getAssistants().get(j).getExpertLevel();
                int pokemonExpLevel = pokemon.getExpertLevel();
                int numberOfAssignedPokemons = s.getAssistants().get(j).getPokemonGuests().size();

                // Checks if assistant can take care of that type of pokemon,
                // if the assistant has enough pokemons already,
                // and if the expert level of the assistant is higher than that of the pokemon         
                if (numberOfAssignedPokemons < 5 && assistantExpLevel > pokemonExpLevel
                        && (assistantType1.equals(pokemonType) || assistantType2.equals(pokemonType))) {

                    assistant = s.getAssistants().get(j);
                    break;
                }
            }

            /*
             * ASSIGNS POKEMON TO ASSISTANT AND ROOM IF SUITABLE OPTIONS WERE FOUND
             */
            if (assistant != null && room != null) {

                // Assistant assignment
                assistant.assignGuest(s.getPokemonGroup().get(i));
                s.getPokemonAndAssistantHashMap().put(pokemon, assistant);

                // Hotel Room assignment
                room.assignGuest(s.getPokemonGroup().get(i));
                s.getPokemonAndRoomHashMap().put(pokemon, room);
            }
        }
    }
}
