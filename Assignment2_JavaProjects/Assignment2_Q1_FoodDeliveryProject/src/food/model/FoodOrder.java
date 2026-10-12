package food.model;

public abstract class FoodOrder {
    protected int orderId;
    protected String customerName;
    protected double amount;

    // Static counter to keep track of total objects created
    private static int totalOrders = 0;

    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        totalOrders++; // Increment every time a new order is instantiated
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public static void displayTotalOrders() {
        System.out.println("Total Orders Placed: " + totalOrders);
    }

    // Abstract method for subclasses to define specific total calculations
    public abstract double calculateTotal();
}
