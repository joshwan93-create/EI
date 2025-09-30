import java.util.logging.Logger;

public class BasicCar implements Car {
    private static final Logger logger = Logger.getLogger(BasicCar.class.getName());

    @Override
    public String getDescription() {
        return "Basic Car";
    }

    @Override
    public double getCost() {
        return 500000; // base price in INR
    }
}
