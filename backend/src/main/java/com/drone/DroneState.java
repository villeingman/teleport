package com.drone;

public class DroneState {
    private final long sequenceNumber;
    private final int state;
    private final int vision;
    private float psi;
    private float theta;
    private float phi;
    private int battery;
    private int altitude;
    private int linkQuality;

    public DroneState(long seqNo, int state, int vision) {
        this.sequenceNumber = seqNo;
        this.state = state;
        this.vision = vision;
    }

    public int getStateBits() {
        return state;
    }

    public boolean isVisionDefined() {
        return vision == 1;
    }

    public boolean isFlying() {
        return (state & (1 << 0)) != 0;
    }

    public boolean isVideoEnabled() {
        return (state & (1 << 1)) != 0;
    }

    public boolean isVisionEnabled() {
        return (state & (1 << 2)) != 0;
    }

    public boolean isAltitudeControlActive() {
        return (state & (1 << 4)) != 0;
    }

    public boolean isUserFeedbackOn() { // TODO better name
        return (state & (1 << 5)) != 0;
    }

    public boolean isControlReceived() {
        return (state & (1 << 6)) != 0;
    }

    public boolean isTrimReceived() { // ARDRONE 1.0 only?
        return (state & (1 << 7)) != 0;
    }

    public boolean isCameraReady() { // ARDRONE 2.0 only?
        return (state & (1 << 7)) != 0; // See SDK2.0, config.h
    }

    public boolean isTrimRunning() { // ARDRONE 1.0 only?
        return (state & (1 << 8)) != 0;
    }

    public boolean isTravellingMask() { // ARDRONE 2.0 only?
        return (state & (1 << 8)) != 0; // See SDK2.0, config.h
    }

    public boolean isTrimSucceeded() { // ARDRONE 1.0 only?
        return (state & (1 << 9)) != 0;
    }

    public boolean isUsbKeyReady() { // ARDRONE 2.0 only?
        return (state & (1 << 9)) != 0; // See SDK2.0, config.h
    }

    public boolean isNavDataDemoOnly() {
        return (state & (1 << 10)) != 0;
    }

    public boolean isNavDataBootstrap() {
        return (state & (1 << 11)) != 0;
    }

    public boolean isMotorsDown() {
        return (state & (1 << 12)) != 0;
    }

    public boolean isCommunicationLost() { // ARDRONE 2.0 only?
        return (state & (1 << 13)) != 0; // Communication Lost : (1) com
        // problem, (0) Com is ok
    }

    public boolean isGyrometersDown() { // ARDRONE 1.0 only?
        return (state & (1 << 14)) != 0;
    }

    public boolean isSoftwareFaultDetected() { // ARDRONE 2.0 only?
        return (state & (1 << 14)) != 0;
    }

    public boolean isBatteryTooLow() {
        return (state & (1 << 15)) != 0;
    }

    public boolean isBatteryTooHigh() { // ARDRONE 1.0 only?
        return (state & (1 << 16)) != 0;
    }

    public boolean isUserEmergencyLanding() { // ARDRONE 2.0 only?
        return (state & (1 << 16)) != 0;
    }

    public boolean isTimerElapsed() {
        return (state & (1 << 17)) != 0;
    }

    public boolean isNotEnoughPower() { // ARDRONE 1.0 only?
        return (state & (1 << 18)) != 0;
    }

    public boolean isMagnetoCalibrationNeeded() { // ARDRONE 2.0 only?
        return (state & (1 << 18)) != 0;
    }

    public boolean isAngelsOutOufRange() {
        return (state & (1 << 19)) != 0;
    }

    public boolean isTooMuchWind() {
        return (state & (1 << 20)) != 0;
    }

    public boolean isUltrasonicSensorDeaf() {
        return (state & (1 << 21)) != 0;
    }

    public boolean isCutoutSystemDetected() {
        return (state & (1 << 22)) != 0;
    }

    public boolean isPICVersionNumberOK() {
        return (state & (1 << 23)) != 0;
    }

    public boolean isATCodedThreadOn() {
        return (state & (1 << 24)) != 0;
    }

    public boolean isNavDataThreadOn() {
        return (state & (1 << 25)) != 0;
    }

    public boolean isVideoThreadOn() {
        return (state & (1 << 26)) != 0;
    }

    public boolean isAcquisitionThreadOn() {
        return (state & (1 << 27)) != 0;
    }

    public boolean isControlWatchdogDelayed() {
        return (state & (1 << 28)) != 0;
    }

    public boolean isADCWatchdogDelayed() {
        return (state & (1 << 29)) != 0;
    }

    public boolean isCommunicationProblemOccurred() {
        return (state & (1 << 30)) != 0;
    }

    public boolean isEmergency() {
        return (state & (1 << 31)) != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;
        return state == ((DroneState) o).state
                && vision == ((DroneState) o).vision;
    }

    @Override
    public int hashCode() {
        return 31 * state + 15 * vision;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("isVisionDefined: " + isVisionDefined() + "\n");
        sb.append("isFlying: " + isFlying() + "\n");
        sb.append("isVideoEnabled: " + isVideoEnabled() + "\n");
        sb.append("isVisionEnabled: " + isVisionEnabled() + "\n");
        sb.append("AltitudeControlActive: " + isAltitudeControlActive() + "\n");
        sb.append("isUserFeedbackOn: " + isUserFeedbackOn() + "\n");
        sb.append("ControlReceived: " + isControlReceived() + "\n");
        sb.append("isCameraReady: " + isCameraReady() + "\n");
        sb.append("isTravellingMask: " + isTravellingMask() + "\n");
        sb.append("isUsbKeyReady: " + isUsbKeyReady() + "\n");
        sb.append("isSoftwareFaultDetected: " + isSoftwareFaultDetected()
                + "\n");
        sb.append("isUserEmergencyLanding: " + isUserEmergencyLanding() + "\n");
        sb.append("isMagnetoCalibrationNeeded: " + isMagnetoCalibrationNeeded()
                + "\n");
        sb.append("isNavDataDemoOnly: " + isNavDataDemoOnly() + "\n");
        sb.append("isNavDataBootstrap: " + isNavDataBootstrap() + "\n");
        sb.append("isMotorsDown: " + isMotorsDown() + "\n");
        sb.append("isBatteryLow: " + isBatteryTooLow() + "\n");
        sb.append("isTimerElapsed: " + isTimerElapsed() + "\n");
        sb.append("isAngelsOutOufRange: " + isAngelsOutOufRange() + "\n");
        sb.append("isTooMuchWind: " + isTooMuchWind() + "\n");
        sb.append("isUltrasonicSensorDeaf: " + isUltrasonicSensorDeaf() + "\n");
        sb.append("isCutoutSystemDetected: " + isCutoutSystemDetected() + "\n");
        sb.append("isPICVersionNumberOK: " + isPICVersionNumberOK() + "\n");
        sb.append("isATCodedThreadOn: " + isATCodedThreadOn() + "\n");
        sb.append("isNavDataThreadOn: " + isNavDataThreadOn() + "\n");
        sb.append("isVideoThreadOn: " + isVideoThreadOn() + "\n");
        sb.append("isAcquisitionThreadOn: " + isAcquisitionThreadOn() + "\n");
        sb.append("isControlWatchdogDelayed: " + isControlWatchdogDelayed()
                + "\n");
        sb.append("isADCWatchdogDelayed: " + isADCWatchdogDelayed() + "\n");
        sb.append("isCommunicationProblemOccurred: "
                + isCommunicationProblemOccurred() + "\n");
        sb.append("IsEmergency: " + isEmergency() + "\n");
        // for (int n = 0; n < options.length; n++) {
        // sb.append(options[n]);
        // }
        return sb.toString();
    }

    public void setLinkQuality(int linkQuality) {
        this.linkQuality = linkQuality;
    }

    public int getLinkQuality() {
        return linkQuality;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    public void setTheta(float theta) {
        this.theta = theta;
    }

    public float getTheta() {
        return theta;
    }

    public void setPhi(float phi) {
        this.phi = phi;
    }

    public float getPhi() {
        return phi;
    }

    public void setPsi(float psi) {
        this.psi = psi;
    }

    public float getPsi() {
        return psi;
    }
}
