# CSU Global - CSC400: Data Structures & Algorithms - Course Portfolio Project
This project was completed as part of the CSU Global course CSC400: Data Structures & Algorithms. This was completed during the university's 2023 Winter semester, term A. The instructor for this course was Angelo Luo. This work is posted as part of my online portfolio of public project work. The code in this repository will not be updated or maintained beyond the use for this course.

## Course Portfolio Prompt
The following is the prompt that was provided for the course portfolio project. This prompt was copied as-is from the course to this page for evaluation below.

<em>Your Portfolio Project for CSC400 consists of the following:

* Write a program that handles the order list for an online retailer. Your program should contain a minimum of three classes:
    * Order Class
    * Display Class
    * Main Class
* Create a ***Order Class*** that uses a queue to hold the orders in the order they were taken. The queue should contain the customer last name, order number, and order total cost.
* Create a ***Display Class*** that will store a copy of the order queue in two arrays. Each array will contain the order list but one will be sorted by name and the other sorted by order number. When a order is taken and stored in the Order Class the program will update the
Display Class arrays automatically and sort them in descending order using quick sort and outputs the the contents to the console upon each entry of new data.
* Create a ***Main Class*** that will handle operator data input and when an order is added or removed, the program will update the Order Class and Display Class. The user will be presented a menu to add a order, remove a order and display the order list from the queue.

Assemble your source code, and screenshots of the application executing with console output into a single document. Submit your completed Portfolio Project by the posted due date.</em>

## Portfolio Prompt Evaluation
This was my evaluation of the requirements needed to complete the project.
* :white_square_button::white_square_button: Program ```Main``` class executes the program for managing online orders.
    * :white_square_button::white_square_button: Take input from the user for creating and managing orders.
    * :white_square_button::white_square_button: Menu to add, remove and dsiplay orders.
* :white_square_button::white_square_button: ```Item``` class that stores the information about the individual items for ordering.
    * :white_square_button::white_square_button: Item name field.
    * :white_square_button::white_square_button: Item number field.
    * :white_square_button::white_square_button: Item cost field.
* :white_square_button::white_square_button: ```ItemsList``` class that stores the various items that are used within the program for various activities.
    * :white_square_button::white_square_button: Queue of various items that are going to be used with their individual item numbers.
    * :white_square_button::white_square_button: Methods to look up items by their ID numbers.
    * :white_square_button::white_square_button: Methods to show the various items in a listing.
* :white_square_button::white_square_button: ```Order``` class that represents the various items that are part of an individual order.
    * :white_square_button::white_square_button: Last name field.
    * :white_square_button::white_square_button: Order number field.
    * :white_square_button::white_square_button: Order total cost field.
    * :white_square_button::white_square_button: Add an item to the order.
    * :white_square_button::white_square_button: Remove an item from the order.
* :white_square_button::white_square_button: ```OrderQueue``` class setups up the methods by which the orders are managed from the systems.
    * :white_square_button::white_square_button: Queue of orders by last name, descending.
    * :white_square_button::white_square_button: Queue of orders by order number, descending.
    * :white_square_button::white_square_button: Allow referencing through to the individual items and orders.

## Pusedocode for the Project
The following are the various psuedocode component designs for the project.

### ```Main``` Program Class
```
public class main
    public void main()
        displayQueue = new Display()
        itemsList = {list of items for menu}
        output "CSU Global - CSC400: Data Structures and Algorithms - Portfolio Project"
        output "=======================================================================\n\n"
        output "Online Order Management System"
        output "=======================================================================\n\n"
```

### ```Item``` Program Class
```
public class Item
    public name
    public cost
    public number
    public desc

    public Item()
        this.name = null
        this.cost = null
        this.number = random number
        this.desc = null

    public Item(String inName)
        this.name = inName
        this.cost = null
        this.number = random number
        this.desc = null

    public Item(String inName, float inCost)
        this.name = inName
        this.cost = inCost
        this.number = random number
        this.desc = null
    
    public Item(String inName, float inCost, String inDesc)
        this.name = inName
        this.cost = inCost
        this.number = random number
        this.desc = inDesc
    
    public Item(String inName, float inCost, String inDesc, int inNumber)
        this.name = inName
        this.cost = inCost
        this.number = inNumber
        this.desc = inDesc

    public toString()
        return "Number: " + this.number + "; Name: " + this.name + "; Cost: $" + this.cost
    
    public toStringWithDesc()
        return "Number: " + this.number + "; Name: " + this.name + "; Cost: $" + this.cost + "; Description: " + this.desc
```

### ```ItemsList``` Program Class
```
public class ItemsList
    public items

    public ItemsList()
        this.items = new stack

    public ItemsList(Item inItem)
        this.items = new stack
        this.items.Add(inItem)

    public ItemsList(Item[] inItems)
        this.items = new stack
        foreach(item in inItems)
            this.items.Add(item)

    public ItemsList(ItemsList inItemsList)
        this.items = new stack
        foreach(item in inItemsList.items)
            this.items.add(item)

    public Item GetItem()
        return this.items.peek()

    public Item GetItem(int inItemID)
        foreach(i; i < this.items.count; i++)
            if(this.items[i].number == inItemID)
                return this.items[i]

    public Item GetItem(Item inItem)
        foreach(i; i < this.items.count; i++)
            if(this.items[i] == inItem)
                return this.items[i]

    public String toString()
        returnValue = ""
        foreach(item in this.items)
            returnValue += item.toString() + "\n"
        return returnValue

    public String toString(int inNumber)
        foreach(i; i < this.items.count; i++)
            if(this.items[i].number == inNumber)
                return this.items[i].toString()
```

### ```Order``` Program Class
```
public class Order
    private items
    public number
    public lastName
    public cost

    public Order()
        this.items = new stack
        this.number = random number
        this.lastName = null
        this.cost = null

    public Order(Item inItem)
        this.items = new stack
        this.items.Add(inItem)
        this.number = random number
        this.lastName = null
        this.cost = null

    public Order(Item inItem, int inNumber)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = inNumber
        this.lastName = null
        this.cost = null
    
    public Order(Item inItem, String inLastName)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = random number
        this.lastName = inLastName
        this.cost = null

    public Order(Item inItem, String inLastName, int inNumber)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = inNumber
        this.lastName = null
        this.cost = null

    public Order(Item[] inItems)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = random number
        this.lastName = null
        this.cost = null
    
    public Order(Item[] inItems, int inNumber)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = inNumber
        this.lastName = null
        this.cost = null
    
    public Order(Item[] inItems, String inLastName)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = random number
        this.lastName = inLastName
        this.cost = null

    public Order(Item[] inItems, String inLastName, int inNumber)
        this.items = new stack
        foreach(inItem in inItems)
            this.items.Add(inItem)
        this.number = inNumber
        this.lastName = null
        this.cost = null

    public Order(int inNumber)
        this.items = new stack
        this.number = inNumber
        this.lastName = null
        this.cost = null

    public Order(int inNumber, String inLastName)
        this.items = new stack
        this.number = inNumber
        this.lastName = inLastName
        this.cost = null

    public void AddItem(Item inItem)
        this.items.Add(inItem)

    public void AddItem(ItemsList inItemsList, int inItemNum)
        inItemsList.GetItems(inItemNum)

    public void RemoveItem(int inItemID)
        foreach(i; i < this.items.count; i++)
            if(this.items[i].number == inItemID)
                this.items.Remove(i)
    
    public void RemoveItem(Item inItem)
        foreach(i; i < this.items.count; i++)
            if(this.items[i] == inItem)
                this.items.Remove(i)

    public String toString()
        return "Order: " + this.number + "; Last Name: " + this.lastName + "; Cost: " + this.cost + "\n"
```

### ```OrdersQueue``` Program Class
```
public class OrderQueue
    private orders
    private ordersSortNum
    private ordersSortName

    public OrderQueue()
        orders = new stack
        ordersSortNum = new stack
        ordersSortName = new stack

    public OrderQueue(Order inOrder)
        orders = new stack
        ordersSortNum = new stack
        ordersSortName = new stack
        this.AddOrder(inOrder)

    public void AddOrder(Order inOrder)
        this.orders.Add(inOrder)

    private void SortOrders(Stack inOrdersStack, bool isOrderedName)
        if(inOrderedStack > 3)
            ordersStackLeft = (inOrdersStack.count / 2)
            ordersStackRight = (inOrderStack.count - ordersStackLeft.count)
            SortOrders(ordersStackLeft, isOrderedName)
            SortOrders(ordersStackRight, isOrderedName)
            ii = 0
            foreach(i; i < ordersStackLeft.count; i++)
                inOrdersStack[ii] = ordersStackLeft[i]
                ii++
            foreach(i; i < ordersStackRight.count; i++)
                inOrdersStack[ii] = ordersStackRight[i]
                ii++
        i = 0
        while(i < (inOrdersStack.count-1))
            if(isOrderedName)
                if(inOrdersStack[i].lastName < inOrdersStack[i+1].lastName)
                    tempOrder = inOrderStack[i]
                    inOrdersStack[i] = inOrdersStack[i+1]
                    inOrdersStack[i+1] = tempOrder
                else
                    i++
            else
                if(inOrdersStack[i].number < inOrdersStack[i+1].number)
                    tempOrder = inOrderStack[i]
                    inOrdersStack[i] = inOrdersStack[i+1]
                    inOrdersStack[i+1] = tempOrder
                else
                    i++
```