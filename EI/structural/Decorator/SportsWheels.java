import java.util.logging.Logger;

public class SportsWheels extends CarDecorator {
    private static final Logger logger = Logger.getLogger(SportsWheels.class.getName());

    public SportsWheels(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sports Wheels";
    }

    @Override
    public double getCost() {
        return super.getCost() + 40000;
    }
}
