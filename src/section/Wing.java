package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import configuration.Configuration;
import event.Subscriber;

import event.ice_detector_probe.IceDetectorProbeWingActivate;
import event.ice_detector_probe.IceDetectorProbeWingDeactivate;

import factory.IceDetectorProbeFactory;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Wing extends Subscriber {
    private ArrayList<Object> iceDetectorProbePortList;

    public Wing() {
        iceDetectorProbePortList = new ArrayList<>();
        build();
    }

    //ice_detector_probe
    public void build() {
        for (int i = 0; i < Configuration.instance.numberOfIceDetectorProbeWing; i++)
            iceDetectorProbePortList.add(IceDetectorProbeFactory.build());
    }

    // --- IceDetectorProbe -----------------------------------------------------------------------------------------------

    @Subscribe
    public void receive(IceDetectorProbeWingActivate iceDetectorProbeWingActivate) {
        LogEngine.instance.write("+ Wing.receive(" + iceDetectorProbeWingActivate.toString() + ")");
        FlightRecorder.instance.insert("Wing", "receive(" + iceDetectorProbeWingActivate.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfIceDetectorProbeWing; i++) {
                Method activateMethod = iceDetectorProbePortList.get(i).getClass().getDeclaredMethod("activate");
                LogEngine.instance.write("activateMethod = " + activateMethod);

                boolean isIceDetectorProbeWingActivated = (boolean) activateMethod.invoke(iceDetectorProbePortList.get(i));
                LogEngine.instance.write("isIceDetectorProbeWingActivated = " + isIceDetectorProbeWingActivated);

                PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated = isIceDetectorProbeWingActivated;
                FlightRecorder.instance.insert("Wing", "IceDetector (isIceDetectorProbeWingActivated): " + isIceDetectorProbeWingActivated);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (isIceDetectorProbeWingActivated): " + PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isIceDetectorProbeWingActivated: " + PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);

    }

    @Subscribe
    public void receive(IceDetectorProbeWingDeactivate iceDetectorProbeWingDeactivate) {
        LogEngine.instance.write("+ Wing.receive(" + iceDetectorProbeWingDeactivate.toString() + ")");
        FlightRecorder.instance.insert("Wing", "receive(" + iceDetectorProbeWingDeactivate.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfIceDetectorProbeWing; i++) {
                Method deactivateMethod = iceDetectorProbePortList.get(i).getClass().getDeclaredMethod("deactivate");
                LogEngine.instance.write("deactivateMethod = " + deactivateMethod);

                boolean isIceDetectorProbeWingActivated = (boolean) deactivateMethod.invoke(iceDetectorProbePortList.get(i));
                LogEngine.instance.write("isIceDetectorProbeWingActivated = " + isIceDetectorProbeWingActivated);

                PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated = isIceDetectorProbeWingActivated;
                FlightRecorder.instance.insert("Wing", "IceDetectorProbe (isIceDetectorProbeActivated): " + isIceDetectorProbeWingActivated);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (isIceDetectorProbeWingActivated): " + PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isIceDetectorProbeWingActivated: " + PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
    }


    // ----------------------------------------------------------------------------------------------------------------
}