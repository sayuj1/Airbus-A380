public class IceDetectorProbe {

    //static instance
    private static IceDetectorProbe instance = new IceDetectorProbe();

    //port
    public Port port;

    private String manufacturer = "Sumit Yadav";
    private String type = "21";
    private String id = "161b240";
    private boolean isActivated = false;
    private boolean isIceDetected = false;

    private IceDetectorProbe() {
        port = new Port();
    }

    public static IceDetectorProbe getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "IceDetectorProbe " + manufacturer + "-" + type + "-" + id;
    }

    public boolean innerActivate() {
        isActivated = true;
        return isActivated;
    }

    public boolean innerDetect() {
        isIceDetected = true;
        return isIceDetected;
    }

    public boolean innerDetect(String surface) {
        return surface.contains("ice");
    }

    public boolean innerDetect(String surface, String pattern) {
        if (surface.contains("ice")) {
            return pattern.contains("heavy ice");
        } else {
            return false;
        }
    }

    public boolean innerDeactivate() {
        isActivated = false;
        return isActivated;
    }

    //inner class port
    public class Port implements IIceDetectorProbe {
        public String version() {
            return innerVersion();
        }

        public boolean activate() {
            return innerActivate();
        }

        public boolean detect() {
            return innerDetect();
        }

        public boolean detect(String surface) {
            return innerDetect(surface);
        }

        public boolean detect(String surface, String pattern) {
            return innerDetect(surface, pattern);
        }

        public boolean deactivate() {
            return innerDeactivate();
        }
    }
}