package app;

import Business.QueryProcessor;
import Business.TransactionProcessor;
import presentation.Gui;

public class Main {
    public static void main(String[] args) {
        QueryProcessor qp = new QueryProcessor();
        TransactionProcessor tp = new TransactionProcessor();
        Gui gui = new Gui(qp,tp);
        gui.start();
    }
}