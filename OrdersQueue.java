import java.util.Stack;

public class OrdersQueue {
    private Stack<Order> orders;
    private Stack<Order> ordersSortNum;
    private Stack<Order> ordersSortName;

    // Constructor for OrdersQueue without parameters (default)
    public OrdersQueue() {
        orders = new Stack<Order>();
        ordersSortNum = new Stack<Order>();
        ordersSortName = new Stack<Order>();
    }
    
    // Constructor for OrdersQueue with a single Order parameter
    public OrdersQueue(Order inOrder) {
        orders = new Stack<Order>();
        ordersSortNum = new Stack<Order>();
        ordersSortName = new Stack<Order>();
        orders.push(inOrder);
    }

    // Constructor for OrdersQueue with a Stack<Order> parameter
    public OrdersQueue(Stack<Order> inOrders) {
        this.orders = inOrders;
        ordersSortNum = new Stack<Order>();
        ordersSortName = new Stack<Order>();
    }

    // Constructor for OrdersQueue with an OrdersQueue parameter
    public OrdersQueue(OrdersQueue inOrders) {
        this.orders = inOrders.exportOrders();
        ordersSortNum = new Stack<Order>();
        ordersSortName = new Stack<Order>();
    }

    // Constructor for OrdersQueue with an Order[] parameter
    public OrdersQueue(Order[] inOrders) {
        orders = new Stack<Order>();
        ordersSortNum = new Stack<Order>();
        ordersSortName = new Stack<Order>();
        for (int i = 0; i < inOrders.length; i++) {
            orders.push(inOrders[i]);
        }
    }

    // Function that adds an order to the queue
    public void addOrder(Order inOrder) {
        this.orders.push(inOrder);
        sortOrders(this.ordersSortNum = this.orders, false);
        sortOrders(this.ordersSortName = this.orders, true);
    }

    // Function for adding multiple orders to the queue
    public void addOrders(Order[] inOrders) {
        for(int i = 0; i < inOrders.length; i++) {
            addOrder(inOrders[i]);
        }
    }

    // Function that removes an order from the queue
    public void removeOrder(Order inOrder) {
        orders.remove(inOrder);
        sortOrders(this.ordersSortNum = this.orders, false);
        sortOrders(this.ordersSortName = this.orders, true);
    }

    public void removeOrder(int inOrderNumber) {
        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getNumber() == inOrderNumber) {
                orders.remove(i);
                sortOrders(this.ordersSortNum = this.orders, false);
                sortOrders(this.ordersSortName = this.orders, true);
                break;
            }
        }
    }

    // Function that provides all the orders contained in the OrdersQueue in the form of a Stack<Order>
    public Stack<Order> exportOrders() {
        return orders;
    }

    // Function to return an order from the queue
    public Order getOrder(int inNumber) {
        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getNumber() == inNumber) {
                return orders.get(i);
            }
        }
        return null;
    }

    // Default return overload for the toString() function
    public String toString() {
        return toString(false);
    }

    // Function that provides a listing of all the orders in the queue
    public String toString(Boolean byName) {
        //byName = (byName == null) ? false : byName;
        String outString = "";
        if(byName) {
            for(int i = 0; i < ordersSortName.size(); i++) {
                outString += ordersSortName.get(i).toString() + "\n";
            }
        }
        else {
            for(int i = 0; i < ordersSortNum.size(); i++) {
                outString += ordersSortNum.get(i).toString() + "\n";
            }
        }
        return outString;
    }

    // Function that sorts the orders by number or last name
    private void sortOrders(Stack<Order> inOrders, Boolean byName) {
        if(inOrders.size() > 3) {
            // Splitting up the oders between left and right stacks for quick sorting
            Stack<Order> ordersLeft = new Stack<Order>();
            Stack<Order> ordersRight = new Stack<Order>();

            // Splitting the orders between the left and right stacks
            for (int i = 0; i < inOrders.size() / 2; i++) {
                ordersLeft.push(inOrders.pop());
            }
            for (int i = 0; i < inOrders.size(); i++) {
                ordersRight.push(inOrders.pop());
            }

            // Sorting the left and right stacks
            sortOrders(ordersLeft, byName);
            sortOrders(ordersRight, byName);

            // Merging the left and right stacks back into the original stack
            while(ordersLeft.size() > 0) {
                inOrders.push(ordersLeft.pop());
            }
            while(ordersRight.size() > 0) {
                inOrders.push(ordersRight.pop());
            }
        }

        // Sorting the orders by last name
        if(byName) {
            for(int i = 0; i < inOrders.size(); i++) {
                for(int j = 0; j < inOrders.size(); j++) {
                    if(inOrders.get(i).getLastName().compareTo(inOrders.get(j).getLastName()) < 0) {
                        Order tempOrder = inOrders.get(i);
                        inOrders.set(i, inOrders.get(j));
                        inOrders.set(j, tempOrder);
                    }
                }
            }
            this.ordersSortName = inOrders;
        }

        // Sorting the orders by number
        else {
            for(int i = 0; i < inOrders.size(); i++) {
                for(int j = 0; j < inOrders.size(); j++) {
                    if(inOrders.get(i).getNumber() < inOrders.get(j).getNumber()) {
                        Order tempOrder = inOrders.get(i);
                        inOrders.set(i, inOrders.get(j));
                        inOrders.set(j, tempOrder);
                    }
                }
            }
            this.ordersSortNum = inOrders;
        }
    }
}