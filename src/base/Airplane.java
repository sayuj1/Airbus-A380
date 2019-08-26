package base;

import com.google.common.eventbus.EventBus;
import event.Subscriber;

import event.ice_detector_probe.IceDetectorProbeBodyActivate;
import event.ice_detector_probe.IceDetectorProbeWingActivate;
import event.ice_detector_probe.IceDetectorProbeBodyDeactivate;
import event.ice_detector_probe.IceDetectorProbeWingDeactivate;

import section.Body;
import section.Wing;

public class Airplane implements IAirplane {
    private EventBus eventBus;
    private Body body;
    private Wing leftWing;
    private Wing rightWing;

    public Airplane() {
        eventBus = new EventBus("EB-A380");
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void build() {
        body = new Body();
        addSubscriber(body);

        leftWing = new Wing();
        addSubscriber(leftWing);

        rightWing = new Wing();
        addSubscriber(rightWing);
    }

    public void startup() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());

    }

    public void taxi() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void takeoff() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void climbing() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void cruise() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void rightTurn() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void leftTurn() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void descent() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void landing() {
         // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }

    public void shutdown() {
        // ice_detector_probe
        eventBus.post(new IceDetectorProbeBodyActivate());
        eventBus.post(new IceDetectorProbeWingActivate());
        eventBus.post(new IceDetectorProbeBodyDeactivate());
        eventBus.post(new IceDetectorProbeWingDeactivate());
    }
}