package dataaccess;

import java.util.Date;

public class RentedItem {
    private Client client;
    private StockItem stock;
    private Date dueDate;

    // Constructor
    public RentedItem(Client client, StockItem stock, Date dueDate) {
        this.client = client;
        this.stock = stock;
        this.dueDate = dueDate;
    }

    // Getter and setter methods
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public StockItem getStock() {
        return stock;
    }

    public void setStock(StockItem stock) {
        this.stock = stock;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}