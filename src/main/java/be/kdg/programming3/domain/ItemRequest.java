package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_request_table")
public class ItemRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Embedded
    private Point point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_username", referencedColumnName = "username")
    private Employee employee;

    @Column(name = "request_time")
    private LocalDateTime requestTime;

    @OneToOne(mappedBy = "itemRequest", fetch = FetchType.LAZY)
    private Delivery delivery;


    public ItemRequest() {}

    public ItemRequest(int id, Item item, Point point, Employee employee, LocalDateTime requestTime, Delivery delivery) {
        this.id = id;
        this.item = item;
        this.point = point;
        this.employee = employee;
        this.requestTime = requestTime;
        this.delivery = delivery;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Item getItem() {return item;}
    public void setItem(Item item) {this.item = item;}
    public Point getPoint() {return point;}
    public void setPoint(Point point) {this.point = point;}
    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}
    public LocalDateTime getRequestTime() {return requestTime;}
    public void setRequestTime(LocalDateTime requestTime) {this.requestTime = requestTime;}
    public Delivery getDelivery() {return delivery;}
    public void setDelivery(Delivery delivery) {this.delivery = delivery;}

    @Override
    public String toString() {
        return "ItemRequest{" +
                "id=" + id +
                ", item=" + item +
                ", point=" + point +
                ", employee=" + employee +
                ", requestTime=" + requestTime +
                ", delivery=" + delivery +
                '}';
    }
}