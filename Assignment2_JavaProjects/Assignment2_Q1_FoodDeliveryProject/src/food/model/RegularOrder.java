package food.model;
import food.service.Discountable;

public class RegularOrder extends FoodOrder implements Discountable {

    public RegularOrder(int orderId, String customerName, double amount) {
        // Passes the initialization to the parent (FoodOrder) constructor
        super(orderId, customerName, amount);
    }

    @Override
    public double applyDiscount(double amt) {
        return amt * 0.05; // 5% discount
    }

    @Override
    public double calculateTotal() {
        return amount - applyDiscount(amount);
    }
}