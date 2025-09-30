import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private static final Logger logger = Logger.getLogger(ShoppingCart.class.getName());

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        logger.log(Level.INFO, "Payment strategy set to: {0}", paymentStrategy.getClass().getSimpleName());
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            logger.log(Level.WARNING, "No payment method selected!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
