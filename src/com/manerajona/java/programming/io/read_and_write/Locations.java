package com.manerajona.java.programming.io.read_and_write;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/com/manerajona/java/programming/io/read_and_write/locations.dat")))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }

        /*try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/com/manerajona/java/programming/io/read_and_write/locations.dat")))) {
            for (Location loc : locations.values()) {
                locFile.writeInt(loc.getLocationID());
                locFile.writeUTF(loc.getDescription());
                System.out.printf("Writing location %s", loc.getLocationID());

                locFile.writeInt(loc.getExits().size() -1 );
                for(String direction : loc.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        System.out.printf("\t\t %s:", direction);
                        locFile.writeUTF(direction);
                        locFile.writeInt(loc.getExits().get(direction));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    static {

        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/com/manerajona/java/programming/io/read_and_write/locations.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch(EOFException e) { // END OF FILE exception
                    eof = true;
                }
            }
        } catch(IOException| ClassNotFoundException e) {
            System.out.println("Exception :" + e.getMessage());
        }

        /*try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("src/com/manerajona/java/programming/io/read_and_write/locations.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for(int i=0; i<numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));

                } catch(EOFException e) { // END OF FILE exception
                    eof = true;
                }

            }
        } catch(IOException io) {
            System.out.println("IO Exception");
        }*/

        // Locations
        /*try (BufferedReader locFile = new BufferedReader(
                new FileReader("src/com/manerajona/io/read_and_write/locations_big.txt"))) {
            String input;
            while ((input = locFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String desc = data[1];
                System.out.printf("Imported loc:%d: %s%n", loc, desc);

                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, desc, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exits
        try (BufferedReader dirFile = new BufferedReader(
                new FileReader("src/com/manerajona/io/read_and_write/directions_big.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.printf("%d: %s: %d%n", loc, direction, destination);

                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
