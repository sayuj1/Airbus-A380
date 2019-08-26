package factory;

import configuration.Configuration;
import recorder.FlightRecorder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class IceDetectorProbeFactory {
    public static Object build() {
        Object iceDetectorProbePort = null;

        try {
            URL[] urlList = {new File(Configuration.instance.pathToIceDetectorProbeJavaArchive).toURI().toURL()};
            URLClassLoader urlLoader = new URLClassLoader(urlList, IceDetectorProbeFactory.class.getClassLoader());

            Class iceDetectorProbeClass = Class.forName("IceDetectorProbe", true, urlLoader);
            FlightRecorder.instance.insert("IceDetectorProbeFactory", "iceDetectorProbeClass: " + iceDetectorProbeClass.hashCode());

            Object iceDetectorProbeInstance = iceDetectorProbeClass.getMethod("getInstance").invoke(null);
            FlightRecorder.instance.insert("IceDetectorProbeFactory", "iceDetectorProbeInstance: " + iceDetectorProbeInstance.hashCode());

            iceDetectorProbePort = iceDetectorProbeClass.getDeclaredField("port").get(iceDetectorProbeInstance);
            FlightRecorder.instance.insert("IceDetectorProbeFactory", "iceDetectorProbePort: " + iceDetectorProbePort.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return iceDetectorProbePort;
    }
}