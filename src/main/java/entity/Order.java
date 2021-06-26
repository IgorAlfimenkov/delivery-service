package entity;

import java.util.Objects;

public class Order {

    private int number;
    private String clientName;
    private String clientPhone;
    private String clientAddress;
    private String storeName;
    private Product product;

    public Order() {

    }

    public Order(int number, String clientName, String clientPhone, String clientAddress, String storeName, Product product) {
        this.number = number;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientAddress = clientAddress;
        this.storeName = storeName;
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return number == order.number &&
                Objects.equals(clientName, order.clientName) &&
                Objects.equals(clientPhone, order.clientPhone) &&
                Objects.equals(clientAddress, order.clientAddress) &&
                Objects.equals(storeName, order.storeName) &&
                Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, clientName, clientPhone, clientAddress, storeName, product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", clientName='" + clientName + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", storeName='" + storeName + '\'' +
                ", product=" + product +
                '}';
    }


}
