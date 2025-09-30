import java.util.logging.Level;
import java.util.logging.Logger;

public class Singleton {
    private static final Logger logger = Logger.getLogger(Singleton.class.getName());

    public static void main(String[] args) {
        AudioManager player1 = AudioManager.getInstance();
        player1.playSound("music.mp3");

        AudioManager player2 = AudioManager.getInstance();
        player2.playSound("notification.wav");

        if (player1 == player2) {
            logger.log(Level.INFO, "Both players share the SAME AudioManager instance.");
        }
    }
}
