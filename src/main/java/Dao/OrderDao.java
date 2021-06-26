package Dao;

import entity.Client;
import entity.Order;
import entity.Product;
import entity.Store;

import java.util.List;

public class OrderDao implements IOrderDao {

    Database db = Database.getInstance();

    @Override
    public void add(List<Order> orders, Order order) {
        db.addOrder(orders,order);
    }

    @Override
    public void delete(List<Order> orders, Order order) {

        db.deleteOrder(orders,order);
    }

    @Override
    public void editNumber(Order order, int newNumber) {

        order.setNumber(newNumber);
    }

    @Override
    public void editClientName(Order order, String newName) {

        order.setClientName(newName);
    }

    @Override
    public void editClientPhone(Order order, String newPhone) {

        order.setClientPhone(newPhone);
    }

    @Override
    public void editStoreName(Order order, String newStoreName) {

        order.setStoreName(newStoreName);
    }

    @Override
    public Order makeOrder(Store store, Client client, Product product, int quantity, int number) {
        Product newProduct = new Product(product.getType(),product.getName(),product.getBrand(),product.getColor(),product.getPrice(),product.getSize(),quantity);
        Order order = new Order(number,client.getName(),client.getPhone(), client.getAddress(),store.getName(),newProduct);
        return order;
    }

    @Override
    public Order get(List<Order> orders,int number) {
        for (Order order : orders) {
            if(order.getNumber() == number)
            {
                return order;
            }
        }
        return null;
    }

}
