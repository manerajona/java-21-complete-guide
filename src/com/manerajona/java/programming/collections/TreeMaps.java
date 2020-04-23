package com.manerajona.java.programming.collections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMaps {

    /**
     * Generally, unless there is a reason not to, you would use HashMap.
     * That is, if you need to get the keys back in insertion order, then use LinkedHashMap.
     * If you need to get the keys back in their true/natural order, then use TreeMap.
     * Otherwise, HashMap is probably best. It is typically faster and requires less overhead.
     */
    static StockList stockList = new StockList();

    public static void main(String[] args) {
        LinkedHashMapSet.Basket timsBasket = new LinkedHashMapSet.Basket("Tim");
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(sellItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        stockList.getList().keySet().forEach(System.out::println);
    }

    public static int sellItem(LinkedHashMapSet.Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        LinkedHashMapSet.StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static class StockList {
        private final Map<String, LinkedHashMapSet.StockItem> list;

        public StockList() {
            this.list = new TreeMap<>();
        }

        public int addStock(LinkedHashMapSet.StockItem item) {
            if(item != null) {
                LinkedHashMapSet.StockItem stockItem = list.getOrDefault(item.getName(), item);
                if(stockItem != item) {
                    item.adjustStock(stockItem.getQuantityStock());
                }
                list.put(item.getName(), item);
                return item.getQuantityStock();
            }
            return 0;
        }

        public int sellStock(String item, int quantity) {
            LinkedHashMapSet.StockItem stockItem = list.getOrDefault(item, null);
            if(stockItem != null && (stockItem.getQuantityStock() >= quantity) && quantity>0) {
                stockItem.adjustStock(-quantity);
                return quantity;
            }
            return 0;
        }

        public LinkedHashMapSet.StockItem get(String key) {
            return list.get(key);
        }

        public Map<String, LinkedHashMapSet.StockItem> getList() {
            return Collections.unmodifiableMap(list);
        }
    }

}
