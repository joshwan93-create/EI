import java.util.logging.Level;
import java.util.logging.Logger;

public class AudioManager {
    private static AudioManager instance;
    private static final Logger logger = Logger.getLogger(AudioManager.class.getName());

    // Private constructor so no other class can instantiate
    private AudioManager() {
        logger.log(Level.INFO, "AudioManager initialized: Access to speaker granted.");
    }

    // Global access point to get the instance
    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    public void playSound(String soundFile) {
        logger.log(Level.INFO, "Playing sound: {0}", soundFile);
    }

    public void stopSound() {
        logger.log(Level.INFO, "Sound stopped.");
    }
}
