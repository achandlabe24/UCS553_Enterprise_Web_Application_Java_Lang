package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

public class Main {
    public static void main(String[] args) {
        // ii. Store orders using an array of FoodOrder
        FoodOrder[] orders = new FoodOrder[6];

        // i. Create at least six orders (mixing Regular and Premium types)
        orders[0] = new RegularOrder(101, "Aman Sharma", 450.0);
        orders[1] = new PremiumOrder(102, "Priya Patel", 1200.0);
        orders[2] = new RegularOrder(103, "Rohan Verma", 250.0);
        orders[3] = new PremiumOrder(104, "Sneha Reddy", 850.0);
        orders[4] = new RegularOrder(105, "Vikram Singh", 600.0);
        orders[5] = new PremiumOrder(106, "Ananya Das", 1500.0);

        System.out.println("==============================================");
        System.out.println("          ONLINE FOOD DELIVERY SYSTEM         ");
        System.out.println("==============================================");

        // Displaying total count of static object counter
        FoodOrder.displayTotalOrders();
        System.out.println("----------------------------------------------");

        // Processing and displaying summary requirements (iii, iv, v, vi)
        for (FoodOrder order : orders) {
            // Use verification utilities before printing summary
            if (OrderUtility.validateAmount(order.getAmount()) && OrderUtility.validateCustomerName(order.getCustomerName())) {
                OrderUtility.generateOrderSummary(order);
            } else {
                System.out.println("Invalid data encountered for Order ID: " + order.getOrderId());
                System.out.println("----------------------------------------------");
            }
        }
    }
}
