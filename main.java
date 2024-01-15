import java.util.Scanner;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        System.out.println("CSU Global - CSC400: Data Structures and Algorithms - Portfolio Project");
        System.out.println("Author: Jeff Bothel");
        System.out.println("Project: Online Order Management System");
        System.out.println("=======================================================================\n\n");

        // Setup of the main application components that are used throughout the application
        OrdersQueue mainOrdersQueue = new OrdersQueue();
        ItemsList mainItemsList = new ItemsList();

        // Setup of the user input system for the application
        Scanner inputScanner = new Scanner(System.in);
        String[] userInput = new String[10];
        String userLineIn = "";

        // User input loop that allows successive commands to the application
        while(true) {
            System.out.print("OrderManager: ");
            userLineIn = inputScanner.nextLine();
            userInput = userLineIn.split(" ");
            switch(userInput[0]) {
                // Command to show user interaction help information
                case "help":
                    continue;

                // Command that allows for the screen to be cleared without exiting the program
                case "clear":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("CSU Global - CSC400: Data Structures and Algorithms - Portfolio Project");
                    System.out.println("Author: Jeff Bothel");
                    System.out.println("Project: Online Order Management System");
                    System.out.println("=======================================================================\n\n");
                    continue;
                
                // Command that allows for specific operations to be conducted within the application
                case "run":
                    switch(userInput[1]) {
                        case "unitTest":
                            unitTest();
                            continue;
                        case "loadExamples":
                            loadExamples(mainOrdersQueue, mainItemsList);
                            continue;
                        default:
                            System.out.println("Invalid command.");
                            continue;
                    }

                // Command for showing order information
                case "show":
                    switch(userInput[1]) {
                        case "order":
                            System.out.println(mainOrdersQueue.getOrder(Integer.parseInt(userInput[2])).toString());
                            continue;
                        case "orders":
                            if(userInput.length < 3) {
                                System.out.println(mainOrdersQueue.toString());
                                continue;
                            }
                            switch(userInput[2]) {
                                case "all":
                                    System.out.println(mainOrdersQueue.toString());
                                    continue;
                                case "sort":
                                    switch(userInput[3]) {
                                        case "number":
                                            System.out.println(mainOrdersQueue.toString(false));
                                            continue;
                                        case "name":
                                            System.out.println(mainOrdersQueue.toString(true));
                                            continue;
                                        default:
                                            System.out.println("Invalid command.");
                                            continue;
                                    }
                                default:
                                    System.out.println("Invalid command.");
                                    continue;
                            }
                        case "items":
                            System.out.println(mainItemsList.toString());
                            continue;
                        default:
                            System.out.println("Invalid command.");
                            continue;
                    }
                case "add":
                    switch(userInput[1]) {
                        case "order":
                            mainOrdersQueue.addOrder(addOrder(mainItemsList));
                            continue;
                        default:
                            System.out.println("Invalid command.");
                            continue;
                    }
                case "remove":
                    switch(userInput[1]) {
                        case "order":
                            mainOrdersQueue.removeOrder(Integer.parseInt(userInput[2]));
                            continue;
                        default:
                            System.out.println("Invalid command.");
                            continue;
                    }
                // Commands for ceasing the operation of the application
                case "exit":
                case "end":
                case "quit":
                case "done":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid command.");
                    continue;
            }
        }
    }

    // Method that is acting as a unit test for the application
    private static void unitTest() {
        // Testing Item
        Item testingItem1 = new Item("Cheese Burger", 384, 4.99f, "A delicious cheese burger with all the fixings.");
        Item testingItem2 = new Item("French Fries", 433, 1.99f, "A side of french fries.");
        Item testingItem3 = new Item("Soda", 123, 0.99f, "A refreshing soda.");
        Item testingItem4 = new Item("Ice Cream", 442, 2.99f, "A delicious ice cream cone.");
        Item testingItem5 = new Item("Hot Dog", 23, 3.99f, "A delicious hot dog with all the fixings.");
        Item testingItem6 = new Item("Onion Rings", 19, 1.99f, "A side of onion rings.");
        Item testingItem7 = new Item("Milk Shake", 16, 2.99f, "A delicious milk shake.");
        Item testingItem8 = new Item("Chicken Nuggets", 943, 3.99f, "A delicious chicken nuggets with all the fixings.");
        Item testingItem9 = new Item("Salad", 113, 4.99f, "A delicious salad with all the fixings.");
        Item testingItem10 = new Item("Water", 565, 0.99f, "A refreshing water.");

        // Arrays of testing items
        Item[] testingItems1 = {testingItem1, testingItem2, testingItem3, testingItem4}; // Cheese Burger + French Fries + Soda + Ice Cream = $10.96
        Item[] testingItems2 = {testingItem5, testingItem6, testingItem7, testingItem8}; // Hot Dog + Onion Rings + Milk Shake + Chicken Nuggets = $12.96
        Item[] testingItems3 = {testingItem9, testingItem10}; // Salad + Water = $5.98

        // Stacks of testing items
        Stack<Item> testingItemsStack1 = new Stack<Item>();
        for(int i = 0; i < testingItems1.length; i++) testingItemsStack1.push(testingItems1[i]);
        Stack<Item> testingItemsStack2 = new Stack<Item>();
        for(int i = 0; i < testingItems2.length; i++) testingItemsStack2.push(testingItems2[i]);
        Stack<Item> testingItemsStack3 = new Stack<Item>();
        for(int i = 0; i < testingItems3.length; i++) testingItemsStack3.push(testingItems3[i]);

        // Testing ItemsList
        ItemsList testingItemsList1 = new ItemsList(testingItem1);
        testingItemsList1.addItem(testingItem2);
        testingItemsList1.addItem(testingItem3);
        testingItemsList1.addItem(testingItem4);
        ItemsList testingItemsList2 = new ItemsList(testingItemsStack2);
        testingItemsList2.addItem(testingItem5);
        testingItemsList2.addItem(testingItem6);
        testingItemsList2.addItem(testingItem7);
        testingItemsList2.addItem(testingItem8);
        ItemsList testingItemsList3 = new ItemsList(testingItems3);

        // Testing Order
        Order testingOrder1 = new Order(testingItemsStack1, "Bothel");
        Order testingOrder2 = new Order(testingItemsStack2, "Ander");
        Order testingOrder3 = new Order(testingItemsStack3, "Jefferson");
        Order testingOrder4 = new Order(testingItems1, "Sampson");
        Order testingOrder5 = new Order(testingItems2, "Smith");
        Order testingOrder6 = new Order(testingItems3, "Johnson");

        // Arrays of testing orders
        Order[] testingOrders1 = {testingOrder2, testingOrder4, testingOrder5};
        Order[] testingOrders2 = {testingOrder1, testingOrder3, testingOrder6};

        // Stack of testing orders
        Stack<Order> testingOrdersStack1 = new Stack<Order>();
        for(int i = 0; i < testingOrders1.length; i++) testingOrdersStack1.push(testingOrders1[i]);
        Stack<Order> testingOrdersStack2 = new Stack<Order>();
        for(int i = 0; i < testingOrders2.length; i++) testingOrdersStack2.push(testingOrders2[i]);

        // Testing OrdersQueue
        OrdersQueue testingOrdersQueue1 = new OrdersQueue(testingOrder1);
        testingOrdersQueue1.addOrder(testingOrder6);
        testingOrdersQueue1.addOrder(testingOrder3);
        testingOrdersQueue1.addOrder(testingOrder5);
        OrdersQueue testingOrdersQueue2 = new OrdersQueue(testingOrdersStack2);
        testingOrdersQueue2.addOrder(testingOrder6);
        testingOrdersQueue2.addOrder(testingOrder4);
        testingOrdersQueue2.addOrder(testingOrder1);

        // Testing the toString() functions
        System.out.println("Testing the toString() functions:");
        System.out.println("==================================\n");
        System.out.println("Item.toString():");
        System.out.println("---------------");
        System.out.println(testingItem1.toString());
        System.out.println(testingItem2.toString());

        System.out.println("\nItem.toStringWithDescription():");
        System.out.println("------------------------------");
        System.out.println(testingItem1.toStringWithDescription());
        System.out.println(testingItem2.toStringWithDescription());

        System.out.println("\nItemsList.toString():");
        System.out.println("---------------------");
        System.out.println(testingItemsList1.toString());
        System.out.println(testingItemsList2.toString());

        System.out.println("\nOrder.toString():");
        System.out.println("-----------------");
        System.out.println(testingOrder1.toString());
        System.out.println(testingOrder2.toString());

        System.out.println("\nOrdersQueue.toString():");
        System.out.println("-----------------------");
        System.out.println(testingOrdersQueue1.toString());
        System.out.println(testingOrdersQueue2.toString());

    }

    // Method that is used when creating an order
    private static Order addOrder(ItemsList inItemsList) {
        // Setup of the items list for adding items to the order
        ItemsList orderItemsList = inItemsList;
        Order returnOrder = new Order();

        // Setup of the user input system for the application
        Scanner inputScanner = new Scanner(System.in);
        String[] userInput = new String[10];
        String userLineIn = "";

        System.out.print("Last name for order: ");
        userLineIn = inputScanner.nextLine();
        userInput = userLineIn.split(" ");
        String lastName = userInput[0];

        System.out.print("New order number (optional): ");
        userLineIn = inputScanner.nextLine();
        userInput = userLineIn.split(" ");
        if(userInput[0].equals("")) {
            System.out.println("Generating order number...");
            returnOrder = new Order(lastName);
        }
        else {
            System.out.println("Using order number: " + userInput[0]);
            returnOrder = new Order(Integer.parseInt(userInput[0]), lastName);
        }
        
        while(true) {
            System.out.print("Available items:\n");
            System.out.print(orderItemsList.toString());
            System.out.print("New order number (optional): ");
            userLineIn = inputScanner.nextLine();
            userInput = userLineIn.split(" ");
            switch(userInput[0]) {
                case "add":
                    if(userInput.length < 2) {
                        System.out.println("Invalid command.");
                        continue;
                    }
                    returnOrder.addItem(orderItemsList.getItem(userInput[1]));
                case "remove":
                    if(userInput.length < 2) {
                        System.out.println("Invalid command.");
                        continue;
                    }
                    returnOrder.removeItem(orderItemsList.getItem(userInput[1]));
                case "done":
                    System.out.println("Adding order to queue...");
                    return returnOrder;
                default:
                    System.out.println("Invalid command.");
                    continue;
            }
        }
    }
    // Method that is used to load examples data into the program to work with
    private static void loadExamples(OrdersQueue inOrdersQueue, ItemsList inItemsList) {
        // Base menu items
        Item testingItem1 = new Item("Cheese Burger", 384, 4.99f, "A delicious cheese burger with all the fixings.");
        Item testingItem2 = new Item("French Fries", 433, 1.99f, "A side of french fries.");
        Item testingItem3 = new Item("Soda", 123, 0.99f, "A refreshing soda.");
        Item testingItem4 = new Item("Ice Cream", 442, 2.99f, "A delicious ice cream cone.");
        Item testingItem5 = new Item("Hot Dog", 23, 3.99f, "A delicious hot dog with all the fixings.");
        Item testingItem6 = new Item("Onion Rings", 19, 1.99f, "A side of onion rings.");
        Item testingItem7 = new Item("Milk Shake", 16, 2.99f, "A delicious milk shake.");
        Item testingItem8 = new Item("Chicken Nuggets", 943, 3.99f, "A delicious chicken nuggets with all the fixings.");
        Item testingItem9 = new Item("Salad", 113, 4.99f, "A delicious salad with all the fixings.");
        Item testingItem10 = new Item("Water", 565, 0.99f, "A refreshing water.");

        // Arrays of testing items
        Item[] testingItems1 = {testingItem1, testingItem2, testingItem3, testingItem4}; // Cheese Burger + French Fries + Soda + Ice Cream = $10.96
        Item[] testingItems2 = {testingItem5, testingItem6, testingItem7, testingItem8}; // Hot Dog + Onion Rings + Milk Shake + Chicken Nuggets = $12.96
        Item[] testingItems3 = {testingItem9, testingItem10}; // Salad + Water = $5.98
        Item[] exampleItemsAll = {testingItem1, testingItem2, testingItem3, testingItem4, testingItem5, testingItem6, testingItem7, testingItem8, testingItem9, testingItem10};

        // Example orders to load into the system
        Order testingOrder4 = new Order(testingItems1, "Alexander", 3892);
        Order testingOrder5 = new Order(testingItems2, "Smith", 123);
        Order testingOrder6 = new Order(testingItems3, "Johnson", 1530);
        Order[] exampleOrdersAll = {testingOrder4, testingOrder5, testingOrder6};

        // Load examples to the main system
        inOrdersQueue.addOrders(exampleOrdersAll);
        inItemsList.addItems(exampleItemsAll);
    }
}
