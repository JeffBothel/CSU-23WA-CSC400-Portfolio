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
        items = new Stack<Item>();
        number = rand.nextInt(10000);
        lastName = "";
        cost = 0.0f;
    }

    // Constructor for Order with Item parameter
    public Order(Item inItem) {
        Random rand = new Random();
        items = new Stack<Item>();
        items.push(inItem);
        number = rand.nextInt(10000);
        lastName = "";
        cost = 0.0f;
    }

    // Constructor for Order with Item and lastName parameters
    public Order(Item inItem, String inLastName) {
        Random rand = new Random();
        items = new Stack<Item>();
        items.push(inItem);
        number = rand.nextInt(10000);
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with Item, lastName, and number parameters
    public Order(Item inItem, String inLastName, int inNumber) {
        items = new Stack<Item>();
        items.push(inItem);
        number = inNumber;
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with Stack<Item> parameter
    public Order(Stack<Item> inItems) {
        Random rand = new Random();
        items = inItems;
        number = rand.nextInt(10000);
        lastName = "";
        cost = 0.0f;
    }

    // Constructor for order with Stack<Item> and lastName parameters
    public Order(Stack<Item> inItems, String inLastName) {
        Random rand = new Random();
        items = inItems;
        number = rand.nextInt(10000);
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with Stack<Item>, lastName, and number parameters
    public Order(Stack<Item> inItems, String inLastName, int inNumber) {
        items = inItems;
        number = inNumber;
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with Item[] parameter
    public Order(Item[] inItems) {
        Random rand = new Random();
        items = new Stack<Item>();
        for (int i = 0; i < inItems.length; i++) {
            items.push(inItems[i]);
        }
        number = rand.nextInt(10000);
        lastName = "";
        cost = 0.0f;
    }

    // Constructor for Order with Item[] and lastName parameters
    public Order(Item[] inItems, String inLastName) {
        Random rand = new Random();
        items = new Stack<Item>();
        for (int i = 0; i < inItems.length; i++) {
            items.push(inItems[i]);
        }
        number = rand.nextInt(10000);
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with Item[], lastName, and number parameters
    public Order(Item[] inItems, String inLastName, int inNumber) {
        items = new Stack<Item>();
        for (int i = 0; i < inItems.length; i++) {
            items.push(inItems[i]);
        }
        number = inNumber;
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with Order parameter
    public Order(Order inOrder) {
        items = inOrder.exportItems();
        number = inOrder.number;
        lastName = inOrder.lastName;
        cost = inOrder.cost;
    }

    // Constructor for Order with number parameter
    public Order(int inNumber) {
        items = new Stack<Item>();
        number = inNumber;
        lastName = "";
        cost = 0.0f;
    }

    // Constructor for Order with lastName parameter
    public Order(String inLastName) {
        Random rand = new Random();
        items = new Stack<Item>();
        number = rand.nextInt(10000);
        lastName = inLastName;
        cost = 0.0f;
    }

    // Constructor for Order with number and lastName parameters
    public Order(int inNumber, String inLastName) {
        items = new Stack<Item>();
        number = inNumber;
        lastName = inLastName;
        cost = 0.0f;
    }

    // Function for adding items to the order
    public void addItem(Item inItem) {
        items.push(inItem);
    }

    // Function for removing items from the order
    public void removeItem(Item inItem) {
        items.remove(inItem);
    }

    // Function for removing items from the order by index
    public void removeItem(int inIndex) {
        items.remove(inIndex);
    }

    // Function for exporting all items objects contained in the Order
    public Stack<Item> exportItems() {
        return items;
    }

    // Function for getting information on the order in a string
    public String toString() {
        String outString = "";
        outString += "Order Number: " + number + "\n";
        outString += "Last Name: " + lastName + "\n";
        outString += "Cost: " + cost + "\n";
        outString += "Items:\n";
        for (int i = 0; i < items.size(); i++) {
            outString += "\t" + items.get(i).toString() + "\n";
        }
        return outString;
    }
}