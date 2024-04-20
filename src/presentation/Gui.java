package presentation;
import Business.QueryProcessor;
import Business.TransactionProcessor;
import dataaccess.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Gui{
    private QueryProcessor queryProcessor;
    private TransactionProcessor transactionProcessor;
    public Gui(QueryProcessor queryProcessor, TransactionProcessor transactionProcessor) {
        this.queryProcessor = queryProcessor;
        this.transactionProcessor = transactionProcessor;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("~~~~~~~~~~~~~~~ Interface Vendeur ~~~~~~~~~~~~~~");
            System.out.println("1. List all equipments");
            System.out.println("2. List non rented Equipements ");
            System.out.println("3. List of rented equipments for a specific client");
            System.out.println("4. Check client balance and overdue equipments");
            System.out.println("5. Checkout, Rent equipment to a client");
            System.out.println("6. CheckiIn, Return equipment by a client");
            System.out.println("7. Add equipment to stock");
            System.out.println("8. Add new client");
            System.out.println("9. Add Category");
            System.out.println("10. Update equipment catalog");
            System.out.println("11. Show List of All Clients: ");
            System.out.println("12. Show List of All Categories: ");
            System.out.println("0. Exit");

            System.out.print("Choose From the menu: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // list of all equipments
                    Map<String, StockItem> stockItems = QueryProcessor.getStockItems();

                    for (Map.Entry<String, StockItem> entry : stockItems.entrySet()) {
                        String codeItem = entry.getKey();
                        StockItem item = entry.getValue();
                        boolean stat = item.isStat(); // Assuming a method named isStat() to access the stat attribute
                        ItemCategory category = item.getCategory(); // Assuming a method named getCategory() to access the category attribute
                        float price = item.getPrice(); // Assuming a method named getPrice() to access the price attribute
                        System.out.println("Code: " + codeItem + ", Stat: " + stat + ", Category: " + category + ", Price: " + price);
                    }

                    break;


                case 2:
                    // to be imlemented : list of non rented equipements

                    break;


                case 3:

                    System.out.println("- - - - - List of rented equipments for a specific client - - - - -");
                    System.out.print("Enter Client Id:");
                    Scanner Id_Scan = new Scanner(System.in);
                    String clientId = Id_Scan.next();

                    List<RentedItem> rentedItemByClient = queryProcessor.getRentedItemByClient(clientId);

                    if (rentedItemByClient.isEmpty()) {
                        System.out.println("No rented items found for client with ID: " + clientId);
                    } else {
                        System.out.println("> Rented items for client with ID: " + clientId);
                        for (RentedItem rentedItem : rentedItemByClient) {
                            StockItem stock = rentedItem.getStock();
                            Date dueDate = rentedItem.getDueDate();

                            // Display the attributes of each rented item
                            System.out.println("Client ID: " + clientId);
                            System.out.println("Stock Item Code: " + stock.getCodeItem());
                            System.out.println("Stock Item Code: " + stock.getCategory().getIdcat());
                            System.out.println("Stock Item Code: " + stock.getCategory().getDesignation());
                            System.out.println("Due Date: " + dueDate);
                            System.out.println("-----------------------------------");
                        }
                    }

                    break;


                case 4:
                    System.out.println("4. Check client balance and overdue equipments");
                    System.out.println("Enter client ID:");
                    String clientId1 = scanner.nextLine();

                    // Check client balance
                    float clientBalance = queryProcessor.SoldeClient(clientId1);
                    if (clientBalance != -1) {
                        System.out.println("Client balance: " + clientBalance);
                    } else {
                        System.out.println("Client not found.");
                    }
                    // Check overdue equipments
                    List<RentedItem> overdueItems = queryProcessor.OverdueItems(clientId1);
                    if (!overdueItems.isEmpty()) {
                        System.out.println("Overdue equipments:");
                        for (RentedItem item : overdueItems) {
                            System.out.println("Item: " + item.getStock().getCodeItem() + ", Due Date: " + item.getDueDate());
                        }
                    } else {
                        System.out.println("No overdue equipments for this client.");
                    }
                    break;



                case 5:
                    // Rent equipment to a client
                    // Implement renting logic
                    break;


                case 6:
                    // Return equipment by a client
                    // Implement returning logic
                    break;


                case 7:
                    // Adding a new equipment to stock
                    System.out.println("7. - - Add equipment to stock");
                    // Create a Scanner object to read user input
                    Scanner scanner_stock= new Scanner(System.in);

                    // Prompt the user to enter the values
                    System.out.print("Enter codeItem: ");
                    String codeItem = scanner_stock.next();

                    System.out.print("Enter idcategory: ");
                    String idcategory = scanner_stock.next();

                    System.out.print("Enter price: ");
                    float price = scanner_stock.nextFloat();

                    boolean itemAdded = transactionProcessor.AddStockItem(codeItem, idcategory, price);

                    if (itemAdded) {
                        System.out.println("Category Added successfully");
                    }
                    break;


                case 8:
                    //Adding a new client
                    System.out.println("- - - - - Add new client - - - - ");
                    System.out.print("Enter Client Id:");
                    String c_Id = scanner.next();
                    System.out.print("Enter Client name:");
                    String name = scanner.next();
                    System.out.print("Enter Client Balance:");
                    double accountBalance = scanner.nextDouble(); // Read as double
                    boolean isAdded = transactionProcessor.AddClient(accountBalance, name, c_Id);

                    if (isAdded) {
                        System.out.println("Client Added successfully");
                    }
                    break;


                case 9:
                    // Create a new category
                    Scanner sc_cat = new Scanner(System.in);
                    // Prompt the user to enter the values
                    System.out.print("Enter idcat: ");
                    String idcat = sc_cat.next();

                    System.out.print("Enter designation: ");
                    String designation = sc_cat.next();

                    System.out.print("Enter marque: ");
                    String marque = sc_cat.next();

                    System.out.print("Enter quantity: ");
                    int quantity = sc_cat.nextInt();
                    // Call the AddCategoryItem method with the user input parameters
                    boolean catAdded = transactionProcessor.AddCategoryItem(idcat, designation, marque, quantity);

                    if (catAdded) {
                        System.out.println("Client Added successfully");
                    }
                    break;



                case 10:
                      //  Update equipment catalog
                    break;



                case 11:
                    // List of All clients
                    System.out.println(" List of all clients: ");
                    for (Map.Entry<String, Client> entry : StoreClass.getClients().entrySet()) {
                        String ccid = entry.getKey();
                        Client client = entry.getValue();

                        System.out.println("------------------------");
                        System.out.println("Client ID: " + ccid);
                        System.out.println("Client Name: " + client.getName());
                        System.out.println("Client Account Balance: " + client.getAccountBalance());
                        // Add other attributes if needed
                        System.out.println("------------------------");
                    }
                    break;



                case 12:
                    // Get the list of categories
                    List<ItemCategory> categories = StoreClass.getCategories();

                    // Iterate through the list of categories
                    for (ItemCategory category : categories) {
                        System.out.println("------------------------");
                        System.out.println("Category ID: " + category.getIdcat());
                        System.out.println("Category Designation: " + category.getDesignation());
                        System.out.println("Category Marque: " + category.getMarque());
                        System.out.println("Category Quantity: " + category.getQuantity());
                        // Add other attributes if needed
                        System.out.println("------------------------");
                    }

                    break;


                case 13:
                    //initialisations (Remplir la base de donnees)
                    break;


                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(" error in input ");
            }
        }


        System.out.println(" Fin de programme ");
    }



}

