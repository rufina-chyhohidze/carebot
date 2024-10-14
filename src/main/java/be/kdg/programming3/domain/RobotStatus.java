package be.kdg.programming3.domain;

public enum RobotStatus {
    IDLE("Idle"),
    IN_TRANSIT("In Transit"),
    LOADING("Loading"),
    UNLOADING("Unloading");

    private String status;

    RobotStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
