import java.util.Random;

public class Item {
    public String name;
    public int number;
    public float cost;
    public String description;

    // Constructor for Item without parameters (default)
    public Item() {
        Random rand = new Random();
        name = "";
        number = rand.nextInt(1000);
        cost = 0.0f;
        description = "";
    }

    // Constructor for Item with name parameter
    public Item(String inName) {
        Random rand = new Random();
        name = inName;
        number = rand.nextInt(1000);
        cost = 0.0f;
        description = "";
    }

    // Constructor for Item with number parameter
    public Item(int inNumber) {
        name = "";
        number = inNumber;
        cost = 0.0f;
        description = "";
    }

    // Constructor for Item with cost parameter
    public Item(float inCost) {
        Random rand = new Random();
        name = "";
        number = rand.nextInt(1000);
        cost = inCost;
        description = "";
    }

    // Constructor for Item with name and number parameters
    public Item(String inName, int inNumber) {
        name = inName;
        number = inNumber;
        cost = 0.0f;
        description = "";
    }

    // Constructor for Item with name, number and cost parameters
    public Item(String inName, int inNumber, float inCost) {
        name = inName;
        number = inNumber;
        cost = inCost;
        description = "";
    }

    // Constructor for Item with all parameters
    public Item(String inName, int inNumber, float inCost, String inDescription) {
        name = inName;
        number = inNumber;
        cost = inCost;
        description = inDescription;
    }

    // Function that provides a string for the data contained in the object that is based as this class
    public String toString() {
        return "Name: " + name + " (" + number + "): $" + cost;
    }

    // Function that provides a string for the data contained in the object that is based as this class with the description
    public String toStringWithDescription() {
        return "Name: " + name + " (" + number + "): $" + cost + "\n\t" + description;
    }

    // Function to get the name of a Item
    public String getName() {
        return name;
    }

    // Function to get the number of a Item
    public int getNumber() {
        return number;
    }
}
