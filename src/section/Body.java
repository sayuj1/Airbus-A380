package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import configuration.Configuration;
import event.Subscriber;

import event.ice_detector_probe.IceDetectorProbeBodyActivate;
import event.ice_detector_probe.IceDetectorProbeBodyDeactivate;

import factory.IceDetectorProbeFactory;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Body extends Subscriber {
    private ArrayList<Object> iceDetectorProbePortList;

    public Body() {
        iceDetectorProbePortList = new ArrayList<>();
        build();
    }

    //ice_detector_probe
    public void build() {
        for (int i = 0; i < Configuration.instance.numberOfIceDetectorProbeBody; i++)
            iceDetectorProbePortList.add(IceDetectorProbeFactory.build());
    }

    // --- IceDetectorProbe -----------------------------------------------------------------------------------------------

    @Subscribe
    public void receive(IceDetectorProbeBodyActivate iceDetectorProbeBodyActivate) {
        LogEngine.instance.write("+ Body.receive(" + iceDetectorProbeBodyActivate.toString() + ")");
        FlightRecorder.instance.insert("Body", "receive(" + iceDetectorProbeBodyActivate.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfIceDetectorProbeBody; i++) {
                Method activateMethod = iceDetectorProbePortList.get(i).getClass().getDeclaredMethod("activate");
                LogEngine.instance.write("activateMethod = " + activateMethod);

                boolean isIceDetectorProbeBodyActivated = (boolean) activateMethod.invoke(iceDetectorProbePortList.get(i));
                LogEngine.instance.write("isIceDetectorProbeBodyActivated = " + isIceDetectorProbeBodyActivated);

                PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated = isIceDetectorProbeBodyActivated;
                FlightRecorder.instance.insert("Body", "IceDetector (isIceDetectorProbeBodyActivated): " + isIceDetectorProbeBodyActivated);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (isIceDetectorProbeBodyActivated): " + PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isIceDetectorProbeBodyActivated: " + PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);

    }

    @Subscribe
    public void receive(IceDetectorProbeBodyDeactivate iceDetectorProbeBodyDeactivate) {
        LogEngine.instance.write("+ Body.receive(" + iceDetectorProbeBodyDeactivate.toString() + ")");
        FlightRecorder.instance.insert("Body", "receive(" + iceDetectorProbeBodyDeactivate.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfIceDetectorProbeBody; i++) {
                Method deactivateMethod = iceDetectorProbePortList.get(i).getClass().getDeclaredMethod("deactivate");
                LogEngine.instance.write("deactivateMethod = " + deactivateMethod);

                boolean isIceDetectorProbeBodyActivated = (boolean) deactivateMethod.invoke(iceDetectorProbePortList.get(i));
                LogEngine.instance.write("isIceDetectorProbeBodyActivated = " + isIceDetectorProbeBodyActivated);

                PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated = isIceDetectorProbeBodyActivated;
                FlightRecorder.instance.insert("Body", "IceDetectorProbe (isIceDetectorProbeActivated): " + isIceDetectorProbeBodyActivated);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (isIceDetectorProbeBodyActivated): " + PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isIceDetectorProbeBodyActivated: " + PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
    }


    // ----------------------------------------------------------------------------------------------------------------
}