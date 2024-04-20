package dataaccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemCategory implements IItemCategory {
    private String idcat;
    private String designation;
    private String marque;
    private int quantity;

    // Constructor
    public ItemCategory(String idcat, String designation, String marque, int quantity) {
        this.idcat = idcat;
        this.designation = designation;
        this.marque = marque;
        this.quantity = quantity;
    }

    // Implementing methods from IItemCategory interface
    @Override
    public String getIdcat() {
        return idcat;
    }

    @Override
    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    @Override
    public String getDesignation() {
        return designation;
    }

    @Override
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String getMarque() {
        return marque;
    }

    @Override
    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
