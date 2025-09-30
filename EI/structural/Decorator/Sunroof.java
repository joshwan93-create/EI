import java.util.logging.Logger;

public class Sunroof extends CarDecorator {
    private static final Logger logger = Logger.getLogger(Sunroof.class.getName());

    public Sunroof(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sunroof";
    }

    @Override
    public double getCost() {
        return super.getCost() + 75000;
    }
}
