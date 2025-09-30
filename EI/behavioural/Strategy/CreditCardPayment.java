import java.util.logging.Level;
import java.util.logging.Logger;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private static final Logger logger = Logger.getLogger(CreditCardPayment.class.getName());

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        logger.log(Level.INFO, "Paid {0} using Credit Card: {1}", new Object[]{amount, cardNumber});
    }
}
