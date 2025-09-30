import java.util.logging.Level;
import java.util.logging.Logger;

public class UpiPayment implements PaymentStrategy {
    private String upiId;
    private static final Logger logger = Logger.getLogger(UpiPayment.class.getName());

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        logger.log(Level.INFO, "Paid {0} using UPI: {1}", new Object[]{amount, upiId});
    }
}
