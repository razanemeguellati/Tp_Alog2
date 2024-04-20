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
            System.out.println("Welcome to Equipment Rental System");
            System.out.println("1. List all equipments");
            System.out.println("2. List non rented Equipements ");
            System.out.println("3. List of rented equipments for a specific client");
            System.out.println("4. Check client balance and overdue equipments");
            System.out.println("5. Rent equipment to a client");
            System.out.println("6. Return equipment by a client");
            System.out.println("7. Add equipment to stock");
            System.out.println("8. Add new client");
            System.out.println("9. Add Category");
            System.out.println("10. Update equipment catalog");
            System.out.println("11. Show List of All Clients: ");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
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
                    // Adding a new equipement to stock
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

                    transactionProcessor.AddStockItem(codeItem, idcategory, price);

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
                    transactionProcessor.AddCategoryItem(idcat, designation, marque, quantity);

                    break;

                case 10:

                      //  Update equipment catalog
                    break;

                case 11:
                    // Iterate through the map and print each key-value pair
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

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
            }
        }


        System.out.println("Exiting Equipment Rental System. Goodbye!");
    }



}

