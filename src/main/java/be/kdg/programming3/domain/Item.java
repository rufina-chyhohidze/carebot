package be.kdg.programming3.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "item_table")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    private float price;

//    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<ItemRequest> itemRequests;

    public Item() {}

    public Item(int id, String name, String category, int stockQuantity, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
//    public List<ItemRequest> getItemRequests() { return itemRequests; }
//    public void setItemRequests(List<ItemRequest> itemRequests) { this.itemRequests = itemRequests; }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", price=" + price +
                '}';
    }
}
