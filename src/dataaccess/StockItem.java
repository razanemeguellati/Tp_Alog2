package dataaccess;
import dataaccess.ItemCategory;

import java.util.HashMap;
import java.util.Map;

public class StockItem implements IStock {
    private String codeItem;
    private boolean stat;
    private ItemCategory category;
    private float price; // New attribute: price

    // Constructor
    public StockItem(String codeItem, boolean stat, ItemCategory category, float price) {
        this.codeItem = codeItem;
        this.stat = stat;
        this.category = category;
        this.price = price;
    }

    // Getter and setter methods
    public String getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    public boolean isStat() {
        return stat;
    }

    public void setStat(boolean stat) {
        this.stat = stat;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Static method to retrieve all items
    public static Map<String, StockItem> getStockItems() {
        // In a real-world scenario, you might retrieve items from a database
        // For demonstration purposes, let's create some dummy items with associated categories and prices
        Map<String, StockItem> items = new HashMap<>();

        // Dummy items with associated categories and prices
        ItemCategory category1 = new ItemCategory("cat1", "Category 1", "Brand 1", 10);
        ItemCategory category2 = new ItemCategory("cat2", "Category 2", "Brand 2", 20);
        ItemCategory category3 = new ItemCategory("cat3", "Category 3", "Brand 3", 30);

        items.put("item1", new StockItem("item1", true, category1, 50.0f));
        items.put("item2", new StockItem("item2", false, category2, 100.0f));
        items.put("item3", new StockItem("item3", true, category3, 75.0f));

        return items;
    }
}
