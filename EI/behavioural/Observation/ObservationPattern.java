import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObservationPattern {
    private static final Logger logger = Logger.getLogger(ObservationPattern.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        logger.log(Level.INFO, "Enter channel name: ");
        String channelName = sc.nextLine();

        Channel channel = new Channel(channelName);

        logger.log(Level.INFO, "Enter number of subscribers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            logger.log(Level.INFO, "Enter subscriber {0} name: ", i);
            String userName = sc.nextLine();
            channel.subscribe(new User(userName));
        }

        String choice;
        do {
            logger.log(Level.INFO, "Enter message to notify subscribers: ");
            String message = sc.nextLine();
            channel.notifyObservers(message);

            logger.log(Level.INFO, "Do you want to send another message? (yes/no): ");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        sc.close();
        logger.log(Level.INFO, "Program terminated.");
    }
}
