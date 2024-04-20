package  dataaccess;
import dataaccess.Client;
import dataaccess.ItemCategory;
import dataaccess.RentedItem;
import dataaccess.StockItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreClass {
    // une classe qui va contenir tous les structures de donnees
    private static Map<String, Client> clients = new HashMap<>();
    private static Map<String, StockItem> stockItems = new HashMap<>();
    private static List<RentedItem> rentedItems = new ArrayList<>();
    private static List<ItemCategory> categories = new ArrayList<>();

    // No constructor needed for a utility class

    // Client methods
    public static void addClient(Client client) {
        clients.put(client.getClientId(), client);
    }

    public static void removeClient(String clientId) {
        clients.remove(clientId);
    }
    public static Client getClientById(String clientId) {
        return clients.get(clientId);
    }

    public static void updateClient(Client client) {
        clients.put(client.getClientId(), client);
    }

    // StockItem methods
    public static void addStockItem(StockItem stockItem) {
        stockItems.put(stockItem.getCodeItem(), stockItem);
    }

    public static void removeStockItem(String codeItem) {
        stockItems.remove(codeItem);
    }

    public static void updateStockItem(StockItem stockItem) {
        stockItems.put(stockItem.getCodeItem(), stockItem);
    }

    // Category methods
    public static void addCategory(ItemCategory category) {
        categories.add(category);
    }

    public static void removeCategory(String idcat) {
        categories.removeIf(category -> category.getIdcat().equals(idcat));
    }

    public static void updateCategory(ItemCategory category) {
        // Update category if it exists
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getIdcat().equals(category.getIdcat())) {
                categories.set(i, category);
                break;
            }
        }
    }

    // RentedItem methods
    public static void addRentedItem(RentedItem rentedItem) {
        rentedItems.add(rentedItem);
    }

    public static void removeRentedItem(RentedItem rentedItem) {
        rentedItems.remove(rentedItem);
    }

    // Getters for accessing data
    public static Map<String, Client> getClients() {
        return clients;
    }

    public static Map<String, StockItem> getStockItems() {
        return stockItems;
    }

    public static StockItem getStockItemById(String codeItem) {
        return stockItems.get(codeItem);
    }

    public static List<RentedItem> getRentedItems() {
        return rentedItems;
    }

    public static List<ItemCategory> getCategories() {
        return categories;
    }
    public static ItemCategory getCategoryById(String id) {
        for (ItemCategory category : categories) {
            if (category.getIdcat().equals(id)) {
                return category;
            }
        }
        return null; // If category with the specified ID is not found
    }
    public static void updateCategory(String categoryId, int quantityChange) {
        for (ItemCategory category : categories) {
            if (category.getIdcat().equals(categoryId)) {
                int newQuantity = category.getQuantity() + quantityChange;
                category.setQuantity(newQuantity);
                break; // Stop searching after finding the category
            }
        }
    }
    public static RentedItem getRentedItemByClientAndStockItem(String clientId, String codeItem) {
        for (RentedItem rentedItem : rentedItems) {
            if (rentedItem.getClient().getClientId().equals(clientId) &&
                    rentedItem.getStock().getCodeItem().equals(codeItem)) {
                return rentedItem;
            }
        }
        return null; // Return null if no matching rented item is found
    }


}
