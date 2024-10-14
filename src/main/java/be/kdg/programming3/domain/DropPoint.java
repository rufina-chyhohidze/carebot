package be.kdg.programming3.domain;

public class DropPoint {
    private int id;
    private String locationName;
    private String coordinates;

    public DropPoint(int id, String locationName, String coordinates) {
        this.id = id;
        this.locationName = locationName;
        this.coordinates = coordinates;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getLocationName() {return locationName;}
    public void setLocationName(String locationName) {this.locationName = locationName;}

    public String getCoordinates() {return coordinates;}
    public void setCoordinates(String coordinates) {this.coordinates = coordinates;}

    @Override
    public String toString() {
        return "DropPoint{" +
                "id=" + id +
                ", locationName='" + locationName + '\'' +
                ", coordinates='" + coordinates + '\'' +
                '}';
    }
}
