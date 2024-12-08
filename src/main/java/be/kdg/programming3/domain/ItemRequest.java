package be.kdg.programming3.domain;

import jakarta.persistence.*;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "ITEM_REQUESTS")
public class ItemRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "item_request_seq", sequenceName = "item_requests_id_seq", allocationSize = 1)
    private int id;

    /* FOR LATER */
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "item_id", referencedColumnName = "id")
//    private Item item;

    private String itemName;

//    @Embedded
//    private Point point;
    @Enumerated(EnumType.STRING)
    private PathName path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    private LocalDateTime requestTime;

//    @Enumerated(EnumType.STRING)
    private String status;

    private int numberOfObstacles;

//    @OneToOne(mappedBy = "itemRequest", fetch = FetchType.LAZY)
//    private Delivery delivery;

    protected ItemRequest() {
    }

    public ItemRequest(String itemName, PathName path, String status) {
        this.itemName = itemName;
        this.path = path;
        this.status = status;
//        this.employee = employee;
        this.requestTime = LocalDateTime.now();
    }


//    public ItemRequest(int id, Item item, Point point, Employee employee, LocalDateTime requestTime, Delivery delivery) {
//        this.id = id;
//        this.item = item;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItem() {
        return itemName;
    }

    public void setItem(String itemName) {
        this.itemName = itemName;
    }

    public PathName getPath() {
        return path;
    }

    public void setPath(PathName path) {
        this.path = path;
    }

    ////        this.point = point;
//        this.employee = employee;
//        this.requestTime = requestTime;
//        this.delivery = delivery;
//    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
//    public Item getItem() {return item;}
//    public void setItem(Item item) {this.item = item;}
//    public Point getPoint() {return point;}
//    public void setPoint(Point point) {this.point = point;}
    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}
    public LocalDateTime getRequestTime() {return requestTime;}
    public void setRequestTime(LocalDateTime requestTime) {this.requestTime = requestTime;}
//    public Delivery getDelivery() {return delivery;}
//    public void setDelivery(Delivery delivery) {this.delivery = delivery;}
    public int getNumberOfObstacles() {return numberOfObstacles;}
    public void setNumberOfObstacles(int numberOfObstacles) {}

//    @Override
//    public String toString() {
//        return "ItemRequest{" +
//                "id=" + id +
////                ", item=" + item +
////                ", point=" + point +
//                ", employee=" + employee +
//                ", requestTime=" + requestTime +
////                ", delivery=" + delivery +
//                '}';
//    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "id=" + id +
                ", item='" + itemName + '\'' +
                ", path=" + path +
                ", employee=" + employee +
                ", requestTime=" + requestTime +
                '}';
    }
}