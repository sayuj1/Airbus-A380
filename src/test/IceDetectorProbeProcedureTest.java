package test;

import base.Airplane;
import base.Cockpit;
import base.PrimaryFlightDisplay;
import logging.LogEngine;
import org.junit.jupiter.api.*;
import recorder.FlightRecorder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IceDetectorProbeProcedureTest {
    private Airplane airplane;
    private Cockpit cockpit;

    @BeforeEach
    public void init() {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        airplane = new Airplane();
        airplane.build();

        cockpit = new Cockpit(airplane);
    }

    @Test
    @Order(1)
    public void startUp() {
        cockpit.startup();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(2)
    public void taxi() {
        cockpit.taxi();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(3)
    public void takeOff() {
        cockpit.takeoff();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(4)
    public void climbing() {
        cockpit.climbing();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(5)
    public void cruise() {
        cockpit.cruise();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }


    @Test
    @Order(6)
    public void rightTurn() {
        cockpit.rightTurn();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(7)
    public void leftTurn() {
        cockpit.leftTurn();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(8)
    public void descent() {
        cockpit.descent();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(9)
    public void landing() {
        cockpit.landing();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @Test
    @Order(10)
    public void shutdown() {
        cockpit.shutdown();

        // ice_detector_probe
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeBodyActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetectorProbeWingActivated);
        assertFalse(PrimaryFlightDisplay.instance.isIceDetected);
    }

    @AfterAll
    public static void finish() {
        FlightRecorder.instance.shutdown();
        LogEngine.instance.close();
    }
}