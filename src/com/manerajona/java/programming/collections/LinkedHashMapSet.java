package com.manerajona.java.programming.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LinkedHashMapSet {

    /**
     * Generally, unless there is a reason not to, you would use HashMap.
     * That is, if you need to get the keys back in insertion order, then use LinkedHashMap.
     * If you need to get the keys back in their true/natural order, then use TreeMap.
     * Otherwise, HashMap is probably best. It is typically faster and requires less overhead.
     */

    static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        stockList.getList().entrySet().forEach(System.out::println);

    }

    public static class Basket {
        private final String name;
        private final Map<StockItem, Integer> list;

        public Basket(String name) {
            this.name = name;
            this.list = new HashMap<>();
        }

        public int addToBasket(StockItem item, int quantity) {
            if (item != null && quantity > 0) {
                int iBasket = list.getOrDefault(item, 0);
                list.put(item, iBasket + quantity);
                return iBasket;
            }
            return 0;
        }

        public Map<StockItem, Integer> getList() {
            return Collections.unmodifiableMap(list);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Basket{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class StockList {
        private final Map<String, StockItem> list;

        public StockList() {
            this.list = new LinkedHashMap<>();
        }

        public int addStock(StockItem item) {
            if (item != null) {
                StockItem stockItem = list.getOrDefault(item.getName(), item);
                if (stockItem != item) {
                    item.adjustStock(stockItem.getQuantityStock());
                }
                list.put(item.getName(), item);
                return item.getQuantityStock();
            }
            return 0;
        }

        public int sellStock(String item, int quantity) {
            StockItem stockItem = list.getOrDefault(item, null);
            if (stockItem != null && (stockItem.getQuantityStock() >= quantity) && quantity > 0) {
                stockItem.adjustStock(-quantity);
                return quantity;
            }
            return 0;
        }

        public StockItem get(String key) {
            return list.get(key);
        }

        public Map<String, StockItem> getList() {
            return Collections.unmodifiableMap(list);
        }
    }

    public static class StockItem implements Comparable {

        private final String name;
        private double price;
        private int quantityStock = 0;

        public StockItem(String name, double price, int quantityStock) {
            this.name = name;
            this.price = price;
            this.quantityStock = quantityStock;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantityStock() {
            return quantityStock;
        }

        public void setQuantityStock(int quantityStock) {
            this.quantityStock = quantityStock;
        }

        @Override
        public int compareTo(Object o) {
            System.out.println("Entering to StockItem.compareTo");
            if ((o instanceof StockItem)) {
                return this.name.compareTo(((StockItem) o).getName());
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StockItem)) return false;
            StockItem stockItem = (StockItem) o;
            return Objects.equals(getName(), stockItem.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }

        public void adjustStock(int quantityStock) {
            int newQuantity = this.quantityStock + quantityStock;
            if (newQuantity >= 0) {
                this.quantityStock = newQuantity;
            }
        }

        @Override
        public String toString() {
            return "" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", quantityStock=" + quantityStock;
        }
    }
}
