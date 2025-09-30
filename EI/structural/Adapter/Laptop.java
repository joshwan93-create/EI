import java.util.logging.Logger;

public class Laptop {
    private static final Logger logger = Logger.getLogger(Laptop.class.getName());

    public void connectDevice(USB usbDevice) {
        usbDevice.connectWithUsbCable();
    }
}
