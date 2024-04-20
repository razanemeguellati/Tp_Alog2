package Business;

import dataaccess.Client;
import dataaccess.RentedItem;
import dataaccess.StockItem;
import dataaccess.StoreClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class QueryProcessor implements IQueryProcessor {

    public QueryProcessor() {
    }


    public static Map<String, StockItem> getStockItems() {
        return StoreClass.getStockItems();
    }
    @Override
    public float SoldeClient(String clientId) {

        Map<String, Client> allClients = StoreClass.getClients();

        // Find the client by ID
        Client foundClient = allClients.get(clientId);

        if (foundClient != null) {
            return (float) foundClient.getAccountBalance();
        } else {
            // Handle case where client is not found
            return -1; // Or throw an exception
        }
    }

    @Override
    public List<RentedItem> getRentedItemByClient(String cltId) {
        List<RentedItem> rentedItemsByClient = new ArrayList<>();
        List<RentedItem> allRentedItems = StoreClass.getRentedItems();

        for (RentedItem rentedItem : allRentedItems) {
            if (rentedItem.getClient().getClientId().equals(cltId)) {
                rentedItemsByClient.add(rentedItem);
            }
        }
        return rentedItemsByClient;
    }

    @Override
    public List<RentedItem> OverdueItems(String clientId) {
        List<RentedItem> overdueRentedItems = new ArrayList<>();
        List<RentedItem> allRentedItems = StoreClass.getRentedItems();
        Date today = new Date(); // Get the current date

        for (RentedItem rentedItem : allRentedItems) {
            if (rentedItem.getClient().getClientId().equals(clientId) && rentedItem.getDueDate().before(today)) {
                overdueRentedItems.add(rentedItem);
            }
        }

        return overdueRentedItems;
    }
}


