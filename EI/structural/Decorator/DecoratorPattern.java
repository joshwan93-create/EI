import java.util.logging.Level;
import java.util.logging.Logger;

public class DecoratorPattern {
    private static final Logger logger = Logger.getLogger(DecoratorPattern.class.getName());

    public static void main(String[] args) {
        Car car = new BasicCar();
        logger.log(Level.INFO, "{0} => Rs.{1}", new Object[]{car.getDescription(), car.getCost()});

        car = new Sunroof(car);
        logger.log(Level.INFO, "{0} => Rs.{1}", new Object[]{car.getDescription(), car.getCost()});

        car = new SportsWheels(car);
        logger.log(Level.INFO, "{0} => Rs.{1}", new Object[]{car.getDescription(), car.getCost()});

        car = new MusicSystem(car);
        logger.log(Level.INFO, "{0} => Rs.{1}", new Object[]{car.getDescription(), car.getCost()});
    }
}
