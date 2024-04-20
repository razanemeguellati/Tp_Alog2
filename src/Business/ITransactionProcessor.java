package Business;

import dataaccess.IItemCategory;
import dataaccess.ItemCategory;
import dataaccess.RentedItem;

import java.util.Date;

public interface ITransactionProcessor {
    public boolean CheckOutItem(String IdCategory, int clientID, Date dueDate);
    public boolean CheckInItem(String iditem, String idclient);
    public  boolean AddStockItem(  String codeItem,String idcategory, float price);
    public boolean AddCategoryItem(String idcat, String designation, String marque, int quantity);
     public boolean removeStockItem(String codeitem);
    public boolean removeCategoryItem(String idcategory);
    public boolean AddClient(double accountBalance, String name, String clientId);
}