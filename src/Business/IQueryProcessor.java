
package Business;
import dataaccess.Client;
import dataaccess.RentedItem;
import dataaccess.StockItem;
import dataaccess.StoreClass;

import java.util.Map;
import java.util.List;


    public interface IQueryProcessor {
        //1 . getAllitems
        public static Map<String, StockItem> getStockItems() {
            return StoreClass.getStockItems();
        }

        //2 . getRenteditems
         static List <RentedItem> getAllRentedItems() {
            return StoreClass.getRentedItems();
        }

        //3. getRentedItemsbyClient
        List<RentedItem> getRentedItemByClient(String cltId);

        //4. SoldeClient
        public float SoldeClient(Client client);

        //5. OverdueItems
        public List<RentedItem> OverdueItems(Client client);


    }

