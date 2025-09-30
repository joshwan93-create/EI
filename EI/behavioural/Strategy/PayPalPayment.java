import java.util.logging.Level;
import java.util.logging.Logger;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private static final Logger logger = Logger.getLogger(PayPalPayment.class.getName());

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        logger.log(Level.INFO, "Paid {0} using PayPal: {1}", new Object[]{amount, email});
    }
}
