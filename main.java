import java.util.Arrays;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        System.out.println("CSU Global - CSC400: Data Structures and Algorithms - Portfolio Project");
        System.out.println("Author: Jeff Bothel");
        System.out.println("Project: Online Order Management System");
        System.out.println("=======================================================================\n");

        // Create some testing items
        Item[] testingItems = {
            new Item("Item 1", 1, 1.00f, "This is item 1"),
            new Item("Item 2", 2, 2.00f, "This is item 2"),
            new Item("Item 3", 3, 3.00f, "This is item 3"),
            new Item("Item 4", 4, 4.00f, "This is item 4"),
            new Item("Item 5", 5, 5.00f, "This is item 5"),
            new Item("Item 6", 6, 6.00f, "This is item 6"),
            new Item("Item 7", 7, 7.00f, "This is item 7"),
            new Item("Item 8", 8, 8.00f, "This is item 8"),
            new Item("Item 9", 9, 9.00f, "This is item 9"),
            new Item("Item 10", 10, 10.00f, "This is item 10"),
            new Item("Item 11", 11, 11.00f, "This is item 11"),
            new Item("Item 12", 12, 12.00f, "This is item 12"),
            new Item("Item 13", 13, 13.00f, "This is item 13"),
            new Item("Item 14", 14, 14.00f, "This is item 14"),
            new Item("Item 15", 15, 15.00f, "This is item 15"),
            new Item("Item 16", 16, 16.00f, "This is item 16"),
            new Item("Item 17", 17, 17.00f, "This is item 17"),
            new Item("Item 18", 18, 18.00f, "This is item 18"),
            new Item("Item 19", 19, 19.00f, "This is item 19"),
            new Item("Item 20", 20, 20.00f, "This is item 20")
        };

        // Shuffle the items randomly
        Collections.shuffle(Arrays.asList(testingItems));

        // Show in the output the ordering of the items in the testing array
        System.out.println("Testing Items:");
        for (int i = 0; i < testingItems.length; i++) {
            System.out.println("Array[" + (i + 1) + "]: " + testingItems[i].toString());
        }

        // Create an items testing list
        ItemsList testingItemsList = new ItemsList(testingItems);
        System.out.println("\nTesting Items List:");
        for (int i = 0; i < testingItemsList.exportItems().size(); i++) {
            System.out.println("List[" + (i + 1) + "]: " + testingItemsList.exportItems().get(i).toString());
        }

        // Get an individual item from the list
        System.out.println("\nTesting Items List - Get Item ID 10:");
        System.out.println(testingItemsList.getItem(10).toString());
    }
}
