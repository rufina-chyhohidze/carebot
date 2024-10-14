package be.kdg.programming3.domain;

public class RobotCar {
    private int id;
    private String currentLocation;
    private int loadCapacity;
    private int batteryCapacity;
    private Basket basket;
    private RobotStatus robotStatus;
    private DropPoint dropPoint;

    public RobotCar(int id, String currentLocation, int loadCapacity, int batteryCapacity, Basket basket, RobotStatus robotStatus, DropPoint dropPoint) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.loadCapacity = loadCapacity;
        this.batteryCapacity = batteryCapacity;
        this.basket = basket;
        this.robotStatus = robotStatus;
        this.dropPoint = dropPoint;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getCurrentLocation() {return currentLocation;}
    public void setCurrentLocation(String currentLocation) {this.currentLocation = currentLocation;}

    public int getLoadCapacity() {return loadCapacity;}
    public void setLoadCapacity(int loadCapacity) {this.loadCapacity = loadCapacity;}

    public int getBatteryCapacity() {return batteryCapacity;}
    public void setBatteryCapacity(int batteryCapacity) {this.batteryCapacity = batteryCapacity;}

    public Basket getBasket() {return basket;}
    public void setBasket(Basket basket) {this.basket = basket;}

    public RobotStatus getRobotStatus() {return robotStatus;}
    public void setRobotStatus(RobotStatus robotStatus) {this.robotStatus = robotStatus;}

    public DropPoint getDropPoint() {return dropPoint;}
    public void setDropPoint(DropPoint dropPoint) {this.dropPoint = dropPoint;}

    @Override
    public String toString() {
        return "RobotCar{" +
                "id=" + id +
                ", currentLocation='" + currentLocation + '\'' +
                ", loadCapacity=" + loadCapacity +
                ", batteryCapacity=" + batteryCapacity +
                ", basket=" + basket +
                ", robotStatus=" + robotStatus +
                ", dropPoint=" + dropPoint +
                '}';
    }
}
