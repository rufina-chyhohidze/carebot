package be.kdg.programming3.domain;

import java.sql.Timestamp;

public class ItemRequest {
    private int id;
    private String title;
    private String description;
    private Timestamp requestTime;
    private Timestamp deliveryTime;
    private Employee employee;
    private DropPoint dropPoint;
    private RequestStatus requestStatus;

    public ItemRequest(int id, String title, String description, Timestamp requestTime, Timestamp deliveryTime, Employee employee, DropPoint dropPoint, RequestStatus requestStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requestTime = requestTime;
        this.deliveryTime = deliveryTime;
        this.employee = employee;
        this.dropPoint = dropPoint;
        this.requestStatus = requestStatus;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Timestamp getRequestTime() {return requestTime;}
    public void setRequestTime(Timestamp requestTime) {this.requestTime = requestTime;}

    public Timestamp getDeliveryTime() {return deliveryTime;}
    public void setDeliveryTime(Timestamp deliveryTime) {this.deliveryTime = deliveryTime;}

    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}

    public DropPoint getDropPoint() {return dropPoint;}
    public void setDropPoint(DropPoint dropPoint) {this.dropPoint = dropPoint;}

    public RequestStatus getRequestStatus() {return requestStatus;}
    public void setRequestStatus(RequestStatus requestStatus) {this.requestStatus = requestStatus;}

    @Override
    public String toString() {
        return "ItemRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requestTime=" + requestTime +
                ", deliveryTime=" + deliveryTime +
                ", employee=" + employee +
                ", dropPoint=" + dropPoint +
                ", requestStatus=" + requestStatus +
                '}';
    }
}
