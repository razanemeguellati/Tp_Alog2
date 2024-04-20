package dataaccess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface IRentedItem {
    Client getClient();
    void setClient(Client client);

    StockItem getStock();
    void setStock(StockItem stock);

    Date getDueDate();
    void setDueDate(Date dueDate);

}
