package Business;
import java.util.*;

import dataaccess.*;

public class TransactionProcessor implements ITransactionProcessor {

    public boolean CheckOutItem(String IdCategory, int clientID, Date dueDate) {
        // Retrieve all clients        StockItem stock = rentedItem.getStock();

        ItemCategory category = StoreClass.getCategoryById(IdCategory);
        Map<String, Client> allClients = StoreClass.getClients();

        // Find the client by ID
        Client foundClient = allClients.get(String.valueOf(clientID));

        if (foundClient != null) {
            Map<String, StockItem> listOfItems = StoreClass.getStockItems();
            boolean louer = false;
            for (Map.Entry<String, StockItem> entry : listOfItems.entrySet()) {
                StockItem item = entry.getValue();
                if (item.getCategory().equals(category) && !item.isStat()) {
                    item.setStat(true);
                    StoreClass.addRentedItem(new RentedItem(foundClient, item, dueDate));
                    louer = true;
                    StoreClass.updateCategory(category.getIdcat(),-1);

                    break; // Stop the loop once an item is rented
                }
            }
            return louer;
        } else {
            return false;
        }
    }

    public boolean CheckInItem(String iditem, String idclient) {
        // Retrieve the client by ID
        Client client = StoreClass.getClientById(idclient);
        if (client == null) {
            return false;
        }

        // Retrieve the stock item by ID
        StockItem stock = StoreClass.getStockItemById(iditem);
        if (stock == null) {
            return false;
        }

        // Update the stock item status to false
        stock.setStat(false);
        StoreClass.updateStockItem(stock);

        // Remove the rented item associated with the client and stock item
        RentedItem rentedItem = StoreClass.getRentedItemByClientAndStockItem(idclient, iditem);
        if (rentedItem == null) {
            return false;
        }
        StoreClass.removeRentedItem(rentedItem);

        // Increment the quantity of the category associated with the stock item
        ItemCategory category = stock.getCategory();
        if (category != null) {
            StoreClass.updateCategory(category.getIdcat(), 1);
        } else {
            return false;
        }

        return true;
    }

    public boolean AddStockItem(String codeItem, String idcategory, float price) {
        // Retrieve the category by its ID
        ItemCategory category = StoreClass.getCategoryById(idcategory);
        if (category == null) {
            return false; // Category not found, return false
        }

        StockItem newStockItem = new StockItem(codeItem, false, category, price);
        // Add the new stock item to the store
        StoreClass.addStockItem(newStockItem);

        // Update the category quantity
        int newQuantity = category.getQuantity() + 1;
        category.setQuantity(newQuantity);
        StoreClass.updateCategory(category);

        return true;
    }

    public boolean removeStockItem(String codeitem) {
        // Retrieve the item by its code from the stock items map
        Map<String, StockItem> stockItems = StoreClass.getStockItems();
        StockItem item = stockItems.get(codeitem);

        // Check if the item exists in the stock items map
        if (item != null) {
            // Retrieve the category associated with the item
            ItemCategory category = item.getCategory();

            // Remove the item from the stock items map
            StoreClass.removeStockItem(codeitem);

            // Decrease the quantity of the category by 1
            category.setQuantity(category.getQuantity() - 1);
            StoreClass.updateCategory(category);

            return true; // Item successfully removed
        } else {
            return false; // Item not found
        }
    }

    public boolean AddCategoryItem(String idcat, String designation, String marque, int quantity) {
        // Create a new ItemCategory object
        ItemCategory category = new ItemCategory(idcat, designation, marque, quantity);

        // Check if the category already exists
        if (StoreClass.getCategories().contains(category)) {
            return false; // Category already exists
        } else {
            // Add the category to the categories list
            StoreClass.addCategory(category);
            return true; // Category successfully added
        }
    }

    public boolean removeCategoryItem(String idcategory) {
        // Find the category by its ID
        ItemCategory category = StoreClass.getCategoryById(idcategory);

        // Check if the category exists
        if (category != null) {
            // Remove the category from the categories list
            StoreClass.removeCategory(category.getIdcat());

            // Remove all items associated with the category from the stock items map
            Map<String, StockItem> stockItems = StoreClass.getStockItems();
            for (StockItem stockItem : stockItems.values()) {
                if (stockItem.getCategory().getIdcat().equals(idcategory)) {
                    StoreClass.removeStockItem(stockItem.getCodeItem());
                }
            }

            return true; // Category successfully removed along with associated items
        } else {
            return false; // Category not found
        }
    }

    public boolean AddClient(double accountBalance, String name, String clientId) {
        // Check if the client already exists
        if (StoreClass.getClientById(clientId) != null) {
            return false; // Client already exists
        } else {
            // Create a new Client object
            Client client = new Client(accountBalance, name, clientId);

            // Add the client to the clients map
            StoreClass.addClient(client);

            return true; // Client successfully added
        }
    }






}
