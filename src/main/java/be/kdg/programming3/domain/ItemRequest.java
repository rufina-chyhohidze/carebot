package be.kdg.programming3.domain;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "ITEM_REQUESTS")
public class ItemRequest implements Comparable<ItemRequest> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private PathName path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    private LocalDateTime requestTime;

    @Enumerated(EnumType.STRING)
    private ItemRequestStatus status;

    @Transient
    private int orderInLast5ItemRequests;

    public int getOrderInLast5ItemRequests() {
        return orderInLast5ItemRequests;
    }

    public void setOrderInLast5ItemRequests(int orderInLast5ItemRequests) {
        this.orderInLast5ItemRequests = orderInLast5ItemRequests;
    }

    protected ItemRequest() {
    }

    public ItemRequest(String itemName, PathName path, ItemRequestStatus status) {
        this.itemName = itemName;
        this.path = path;
        this.status = status;
        this.requestTime = LocalDateTime.now();
    }

    public ItemRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ItemRequestStatus status) {
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

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Employee getEmployee() {return employee;}
    public void setEmployee(Employee employee) {this.employee = employee;}
    public LocalDateTime getRequestTime() {return requestTime;}

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
    @Override
    public int compareTo(@NotNull ItemRequest o) {
        return this.getId() - o.getId();
    }
}