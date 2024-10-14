package be.kdg.programming3.domain;

public class StartingPoint {
    private int id;
    private String coordinates;

    public StartingPoint(int id, String coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getCoordinates() {return coordinates;}
    public void setCoordinates(String coordinates) {this.coordinates = coordinates;}

    @Override
    public String toString() {
        return "StartingPoint{" +
                "id=" + id +
                ", coordinates='" + coordinates + '\'' +
                '}';
    }
}
