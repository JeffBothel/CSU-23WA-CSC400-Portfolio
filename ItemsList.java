import java.util.Stack;

public class ItemsList {
    private Stack<Item> items;
    
    // Constructor for ItemsList without parameters (default)
    public ItemsList() {
        items = new Stack<Item>();
    }

    // Constructor for ItemsList with a single Item parameter
    public ItemsList(Item inItem) {
        items = new Stack<Item>();
        items.push(inItem);
    }

    // Constructor for ItemsList with a Stack<Item> parameter
    public ItemsList(Stack<Item> inItems) {
        this.items = inItems;
    }

    // Constructor for ItemsList with an ItemsList parameter
    public ItemsList(ItemsList inItems) {
        this.items = inItems.exportItems();
    }

    // Constructor for ItemsList with an Item[] parameter
    public ItemsList(Item[] inItems) {
        items = new Stack<Item>();
        for (int i = 0; i < inItems.length; i++) {
            items.push(inItems[i]);
        }
    }

    // Function that provides all the items contained in the ItemsList in the form of a Stack<Item>
    public Stack<Item> exportItems() {
        return items;
    }

    // Function that adds an item to the list
    public void addItem(Item inItem) {
        items.push(inItem);
    }

    // Function that adds an item to the list
    public void addItem(String inName, int inNumber, float inCost) {
        items.push(new Item(inName, inNumber, inCost));
    }

    // Function that adds an item to the list
    public void addItem(String inName, int inNumber, float inCost, String inDescription) {
        items.push(new Item(inName, inNumber, inCost, inDescription));
    }

    // Function that removes an item from the list
    public void removeItem(Item inItem) {
        items.remove(inItem);
    }

    // Function that removes an item from the list
    public void removeItem(String inName, int inNumber, float inCost) {
        items.remove(new Item(inName, inNumber, inCost));
    }

    // Function that removes an item from the list
    public void removeItem(String inName, int inNumber, float inCost, String inDescription) {
        items.remove(new Item(inName, inNumber, inCost, inDescription));
    }

    // Function that removes an item from the list
    public void removeItem(String inName) {
        items.remove(new Item(inName));
    }

    // Function that removes an item from the list
    public void removeItem(int inNumber) {
        items.remove(new Item(inNumber));
    }

    // Function that removes an item from the list
    public void removeItem(float inCost) {
        items.remove(new Item(inCost));
    }

    // Function that removes an item from the list
    public void removeItem(String inName, int inNumber) {
        items.remove(new Item(inName, inNumber));
    }

    // Function that gets an item based on its number
    public Item getItem(int inNumber) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNumber() == inNumber) {
                return items.get(i);
            }
        }
        return null;
    }

    // Function that gets an item based on its name
    public Item getItem(String inName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(inName)) {
                return items.get(i);
            }
        }
        return null;
    }

    // Function that gets an item based on its name and number
    public Item getItem(String inName, int inNumber) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(inName) && items.get(i).getNumber() == inNumber) {
                return items.get(i);
            }
        }
        return null;
    }

    // Function that gets an item name based on its number
    public String getItemName(int inNumber) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNumber() == inNumber) {
                return items.get(i).getName();
            }
        }
        return null;
    }

    // Function that gets an item number based on its name
    public int getItemNumber(String inName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(inName)) {
                return items.get(i).getNumber();
            }
        }
        return -1;
    }

    // Send the list item contents to string
    public String toString() {
        String outString = "";
        for (int i = 0; i < items.size(); i++) {
            outString += items.get(i).toString() + "\n";
        }
        return outString;
    }
}
