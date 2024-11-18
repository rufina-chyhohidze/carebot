package be.kdg.programming3.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Point {
    private int pointNumber;
    private PathName pathName;
    private String currentLocation;
    private boolean delivered;

    public Point() {}

    public Point(int pointNumber, PathName pathName, String currentLocation, boolean delivered) {
        this.pointNumber = pointNumber;
        this.pathName = pathName;
        this.currentLocation = currentLocation;
        this.delivered = delivered;
    }

    public int getPointNumber() {return pointNumber;}
    public void setPointNumber(int pointNumber) {this.pointNumber = pointNumber;}
    public PathName getPathName() {return pathName;}
    public void setPathName(PathName pathName) {this.pathName = pathName;}
    public String getCurrentLocation() {return currentLocation;}
    public void setCurrentLocation(String currentLocation) {this.currentLocation = currentLocation;}
    public boolean isDelivered() {return delivered;}
    public void setDelivered(boolean delivered) {this.delivered = delivered;}

    @Override
    public String toString() {
        return "Point{" +
                "pointNumber=" + pointNumber +
                ", pathName=" + pathName +
                ", currentLocation='" + currentLocation + '\'' +
                ", delivered=" + delivered +
                '}';
    }
}
