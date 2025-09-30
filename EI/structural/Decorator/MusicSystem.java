import java.util.logging.Logger;

public class MusicSystem extends CarDecorator {
    private static final Logger logger = Logger.getLogger(MusicSystem.class.getName());

    public MusicSystem(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Music System";
    }

    @Override
    public double getCost() {
        return super.getCost() + 30000;
    }
}
