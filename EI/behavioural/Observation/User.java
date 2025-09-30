import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Observer {
    private String name;
    private static final Logger logger = Logger.getLogger(User.class.getName());

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        logger.log(Level.INFO, "{0} received update: {1}", new Object[]{name, message});
    }
}
