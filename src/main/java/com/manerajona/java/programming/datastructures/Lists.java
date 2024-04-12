package com.manerajona.java.programming.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();
        groceryList.addGroceryItem("Item");
        String item = groceryList.findItem("Item");
    }

    private static class GroceryList {
        private List<String> groceryList = new ArrayList<>();

        public void addGroceryItem(String item) {
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            }
        }

        public void modifyGroceryIten(String currentItem, String newItem) {
            int position = findItemPosition(currentItem);
            if (position >= 0 && !groceryList.contains(newItem)) { // CurrentItem exists and newItem doesn't
                groceryList.set(position, newItem);
            }
        }

        public void removeGroceryItem(String item) {
            groceryList.remove(item);
        }

        public void printGroceryList() {
            System.out.println("Your grocery list" + groceryList.toString());
        }

        public String findItem(String item) {
            boolean exists = groceryList.contains(item);
            return exists ? item : null;
        }

        public int findItemPosition(String item) {
            return groceryList.indexOf(item);
        }

        public java.util.List<String> copyGroceryList() {
            return new ArrayList<>(groceryList);
        }
    }
}
