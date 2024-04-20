package dataaccess;

import java.util.HashMap;
import java.util.Map;

public interface IClient {
    double getAccountBalance();
    void setAccountBalance(double accountBalance);

    String getName();
    void setName(String name);

    String getClientId();
    void setClientId(String customerId);



    }


