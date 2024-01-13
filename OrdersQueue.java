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

    // Function that provides all the orders contained in the OrdersQueue in the form of a Stack<Order>
    public Stack<Order> exportOrders() {
        return orders;
    }

    // Function that performs the sorting of the OrdersQueue by order number or name
    private void sortOrders(Stack<Order> inOrders, boolean isOrderedName) {
        // Begin recusive sorting if necessary for the OrdersQueue to be sorted
        if(inOrders.size() > 3) {
            // Separate the orders into two stacks
            Stack<Order> ordersStackLeft = new Stack<Order>();
            for(int i = 0; i < (inOrders.size() / 2); i++) {
                ordersStackLeft.push(inOrders.get(i));
            }
            Stack<Order> ordersStackRight = new Stack<Order>();
            for(int i = (inOrders.size() / 2); i < inOrders.size(); i++) {
                ordersStackRight.push(inOrders.get(i));
            }

            // Recusively call the sortOrders function on the two stacks to optimize sorting
            sortOrders(ordersStackLeft, isOrderedName);
            sortOrders(ordersStackRight, isOrderedName);

            // Merge the two stacks back together
            inOrders.clear();
            for(int i = 0; i < ordersStackLeft.size(); i++) {
                inOrders.push(ordersStackLeft.get(i));
            }
            for(int i = 0; i < ordersStackRight.size(); i++) {
                inOrders.push(ordersStackRight.get(i));
            }
        }
    }
}