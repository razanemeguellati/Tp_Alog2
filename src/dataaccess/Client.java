package dataaccess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Client implements IClient{
    private double accountBalance;
    private String name;
    private String clientId;

    // Constructor
    public Client(double accountBalance, String name, String clientId) {
        this.accountBalance = accountBalance;
        this.name = name;
        this.clientId = clientId;
    }



    // Getter and setter methods
    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


}