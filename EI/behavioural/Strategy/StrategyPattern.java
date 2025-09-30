import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StrategyPattern {
    private static final Logger logger = Logger.getLogger(StrategyPattern.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        logger.log(Level.INFO, "Enter amount to pay: ");
        int amount = sc.nextInt();
        sc.nextLine();

        logger.log(Level.INFO, "Choose payment method:\n1. Credit Card\n2. UPI\n3. PayPal");
        logger.log(Level.INFO, "Enter choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                logger.log(Level.INFO, "Enter credit card number: ");
                String card = sc.nextLine();
                cart.setPaymentStrategy(new CreditCardPayment(card));
                break;
            case 2:
                logger.log(Level.INFO, "Enter UPI ID: ");
                String upi = sc.nextLine();
                cart.setPaymentStrategy(new UpiPayment(upi));
                break;
            case 3:
                logger.log(Level.INFO, "Enter PayPal email: ");
                String email = sc.nextLine();
                cart.setPaymentStrategy(new PayPalPayment(email));
                break;
            default:
                logger.log(Level.WARNING, "Invalid choice! Defaulting to no payment.");
        }

        cart.checkout(amount);
        sc.close();
    }
}
