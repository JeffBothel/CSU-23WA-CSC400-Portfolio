import java.util.Stack;
import java.util.Random;

public class Order {
    private Stack<Item> items;
    public int number;
    public String lastName;
    public float cost;

    // Constructor for Order without parameters (default)
    public Order() {
        Random rand = new Random();
        buildOrderObject(null, null, rand.nextInt(10000));
    }

    // Constructor for Order with Item parameter
    public Order(Item inItem) {
        Random rand = new Random();
        Stack<Item> tempStack = new Stack<Item>();
        tempStack.push(inItem);
        buildOrderObject(tempStack, null, rand.nextInt(10000));
    }

    // Constructor for Order with Item and lastName parameters
    public Order(Item inItem, String inLastName) {
        Random rand = new Random();
        Stack<Item> tempStack = new Stack<Item>();
        tempStack.push(inItem);
        buildOrderObject(tempStack, inLastName, rand.nextInt(10000));
    }

    // Constructor for Order with Item, lastName, and number parameters
    public Order(Item inItem, String inLastName, int inNumber) {
        Stack<Item> tempStack = new Stack<Item>();
        tempStack.push(inItem);
        buildOrderObject(tempStack, inLastName, inNumber);
    }

    // Constructor for Order with Stack<Item> parameter
    public Order(Stack<Item> inItems) {
        Random rand = new Random();
        Stack<Item> tempStack = inItems;
        buildOrderObject(tempStack, null, rand.nextInt(10000));
    }

    // Constructor for order with Stack<Item> and lastName parameters
    public Order(Stack<Item> inItems, String inLastName) {
        Random rand = new Random();
        Stack<Item> tempStack = inItems;
        buildOrderObject(tempStack, inLastName, rand.nextInt(10000));
    }

    // Constructor for Order with Stack<Item>, lastName, and number parameters
    public Order(Stack<Item> inItems, String inLastName, int inNumber) {
        Stack<Item> tempStack = inItems;
        buildOrderObject(tempStack, inLastName, inNumber);
    }

    // Constructor for Order with Item[] parameter
    public Order(Item[] inItems) {
        Random rand = new Random();
        Stack<Item> tempStack = new Stack<Item>();
        for(int i = 0; i < inItems.length; i++) {
            tempStack.push(inItems[i]);
        }
        buildOrderObject(tempStack, null, rand.nextInt(10000));
    }

    // Constructor for Order with Item[] and lastName parameters
    public Order(Item[] inItems, String inLastName) {
        Random rand = new Random();
        Stack<Item> tempStack = new Stack<Item>();
        for(int i = 0; i < inItems.length; i++) {
            tempStack.push(inItems[i]);
        }
        buildOrderObject(tempStack, inLastName, rand.nextInt(10000));
    }

    // Constructor for Order with Item[], lastName, and number parameters
    public Order(Item[] inItems, String inLastName, int inNumber) {
        Stack<Item> tempStack = new Stack<Item>();
        for(int i = 0; i < inItems.length; i++) {
            tempStack.push(inItems[i]);
        }
        buildOrderObject(tempStack, inLastName, inNumber);
    }

    // Constructor for Order with Order parameter
    public Order(Order inOrder) {
        Random rand = new Random();
        Stack<Item> tempItems = inOrder.exportItems();
        this.buildOrderObject(tempItems, null, rand.nextInt(10000));
    }

    // Constructor for Order with number parameter
    public Order(int inNumber) {
        this.buildOrderObject(null, null, inNumber);
    }

    // Constructor for Order with lastName parameter
    public Order(String inLastName) {
        Random rand = new Random();
        this.buildOrderObject(null, inLastName, rand.nextInt(10000));
    }

    // Constructor for Order with number and lastName parameters
    public Order(int inNumber, String inLastName) {
        this.buildOrderObject(null, inLastName, inNumber);
    }

    // Unified function for spinning up the Order object that will take inputs from the overloaded constructors
    private void buildOrderObject(Stack<Item> inItems, String inLastName, int inNumber) {
        this.items = new Stack<Item>();
        this.number = inNumber;
        this.lastName = inLastName;
        if(inItems != null) {
            while(!inItems.empty()) {
                this.addItem(inItems.pop());
            }
        }
    }

    // Function for adding items to the order
    public void addItem(Item inItem) {
        items.push(inItem);
        this.cost += inItem.cost;
    }

    // Function for adding multiple items to the order from an array
    public void addItems(Item[] inItems) {
        for(int i = 0; i < inItems.length; i++) {
            this.addItem(inItems[i]);
        }
    }

    // Function for removing items from the order
    public void removeItem(Item inItem) {
        this.items.remove(inItem);
        this.cost -= inItem.cost;
    }

    // Function for removing items from the order by index
    public void removeItem(int inIndex) {
        Item removedItem = items.remove(inIndex);
        this.cost -= removedItem.cost;
    }

    // Function for exporting all items objects contained in the Order
    public Stack<Item> exportItems() {
        return items;
    }

    // Function for getting the number of items in the order
    public int getCount() {
        return this.items.size();
    }

    // Function to get the last name on the order
    public String getLastName() {
        return this.lastName;
    }

    // Function to get the number for the order
    public int getNumber() {
        return this.number;
    }

    // Function for getting information on the order in a string
    public String toString() {
        String outString = "";
        outString += "Order Number: " + number + "\n";
        outString += "Last Name: " + lastName + "\n";
        outString += "Cost: $" + cost + "\n";
        outString += "Items:\n";
        for (int i = 0; i < items.size(); i++) {
            outString += "\t" + items.get(i).toString() + "\n";
        }
        return outString;
    }
}