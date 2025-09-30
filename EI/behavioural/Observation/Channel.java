import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Channel {
    private List<Observer> observers = new ArrayList<>();
    private String channelName;
    private static final Logger logger = Logger.getLogger(Channel.class.getName());

    public Channel(String channelName) {
        this.channelName = channelName;
        logger.log(Level.INFO, "Channel {0} created.", channelName);
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
        logger.log(Level.INFO, "Subscriber added. Total subscribers: {0}", observers.size());
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        logger.log(Level.INFO, "Subscriber removed. Total subscribers: {0}", observers.size());
    }

    public void notifyObservers(String message) {
        logger.log(Level.INFO, "Notifying {0} subscribers...", observers.size());
        for (Observer o : observers) {
            o.update(channelName + " -> " + message);
        }
    }
}
