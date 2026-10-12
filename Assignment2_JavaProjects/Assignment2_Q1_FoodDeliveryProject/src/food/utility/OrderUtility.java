package food.utility;
import food.model.FoodOrder;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }
    public static void generateOrderSummary(FoodOrder order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Base Amount: Rs. " + order.getAmount());
        System.out.println("Final Total (After Discount): Rs. " + order.calculateTotal());
        System.out.println("----------------------------------------------");
    }
}
