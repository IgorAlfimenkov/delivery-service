package entity;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private int id;
    private ProductType type;
    private String name;
    private String brand;
    private String color;
    private double price;
    private double size;
    private int quantity;

    public Product() {

    }

    public Product(ProductType type, String name, String brand, String color, double price, double size, int quantity) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
    }

    public Product(int id, ProductType type, String name, String brand, String color, double price, double size, int quantity) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
       /* if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;*/
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Double.compare(product.size, size) == 0 &&
                quantity == product.quantity &&
                type == product.type &&
                Objects.equals(name, product.name) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, brand, color, price, size, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.price > o.price) {

            // if current object is greater,then return 1
            return 1;
        } else if (this.price < o.price) {

            // if current object is greater,then return -1
            return -1;
        } else {

            // if current object is equal to o,then return 0
            return 0;
        }
    }

}

