package configuration;

public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String commonPathToJavaArchive = userDirectory + fileSeparator + "components" + fileSeparator;

    public String lineSeparator = System.getProperty("line.separator");
    public String logFileDirectory = userDirectory + fileSeparator + "log" + fileSeparator;
    public String logFile = logFileDirectory + "ice_detector_probe.log";

    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String databaseFile = dataDirectory + "flight_recorder_airbus_a380.db";

    // ice_detector_probe
    public String pathToIceDetectorProbeJavaArchive = commonPathToJavaArchive + "ice_detector_probe" + fileSeparator + "jar" + fileSeparator + "ice_detector_probe.jar";
    public int numberOfIceDetectorProbeBody = 2;
    public int numberOfIceDetectorProbeWing = 2;
}