package be.kdg.programming3.domain;

public class Item {
    private int id;
    private String name;
    private String category;
    private int stockQuantity;
    private String warehouseLocation;

    public Item(int id, String name, String category, int stockQuantity, String warehouseLocation) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.warehouseLocation = warehouseLocation;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public int getStockQuantity() {return stockQuantity;}
    public void setStockQuantity(int stockQuantity) {this.stockQuantity = stockQuantity;}

    public String getWarehouseLocation() {return warehouseLocation;}
    public void setWarehouseLocation(String warehouseLocation) {this.warehouseLocation = warehouseLocation;}

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", warehouseLocation='" + warehouseLocation + '\'' +
                '}';
    }
}
