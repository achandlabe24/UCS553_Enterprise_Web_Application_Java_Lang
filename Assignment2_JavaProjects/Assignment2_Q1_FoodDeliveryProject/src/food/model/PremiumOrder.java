package food.model;
import food.service.Discountable;

public class PremiumOrder extends FoodOrder implements Discountable {

    public PremiumOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    @Override
    public double applyDiscount(double amt) {
        return amt * 0.15; // 15% discount
    }

    @Override
    public double calculateTotal() {
        return amount - applyDiscount(amount);
    }
}