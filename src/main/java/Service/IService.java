package Service;

import entity.*;

import java.util.List;

public interface IService {

    void editType(Product product, String newType);
    void editName(Product product, String newName);
    void editBrand(Product product, String newBrand);
    void editColor(Product product, String newColor);
    void editPrice(Product product, double newPrice);
    void editSize(Product product, double newSize);
    void editQuantity(Product product, int newQuantity);
    ProductType getType(String type);
    void addStore(List<Store> stores, Store store);
    void deleteStore(List<Store> stores, Store store);
    void addProduct(Store store, Product product);
    void deleteProduct(Store store, Product product);
    void addCategory(Store store, Category category);
    void deleteCategory(Store store, Category category);
    void editName(Store store, String name);
    void buyProduct(Store store, Product product);
    Store getStoreByName(List<Store> stores, String name);
    List<Store> getAll();
    Product getByNameAndSize(Store store, String name, double size);
    Product getProduct(Store store, int id);
    List<Product> getProductsByCategory(Store store, String name);
    List<Product> getByPrice(Store store, double price);
    List<Product> getByName(Store store, String name);
    List<Product> getByType(Store store, String type);
    List<Product> getByTypeAndPrice(Store store, String type, double price);
    List<Product> getByTypePriceAndCategory(Store store, double price, String type, String category);
    List<Product> sortProducts(Store store);
    Category getCategoryByName(Store store,String name);
    void changeType(Store store, Product product, ProductType productType);
    void changeName(Store store, Product product, String name);
    void changeBrand(Store store, Product product, String brand);
    void changeColor(Store store, Product product, String color);
    void changePrice(Store store, Product product, Double price);
    void changeSize(Store store, Product product, Double size);
    void changeQuantity(Store store, Product product, int quantity);
    void addProduct(Category category, Product product);
    void deleteProduct(Category category, Product product);
    void editName(Category category, String newName);
    List<Product> getProducts(Category category);
    void addClient(List<Client> clients,Client client);
    void deleteClient(List<Client> clients,Client client);
    void editName(Client client, String newName);
    void editAddress(Client client, String newAddress);
    void editEmail(Client client, String newEmail);
    void editIndex(Client client, int newIndex);
    void editPhone(Client client, String newPhone);
    Client getClient(List<Client> clients,String name);
    void add(List<Order> orders, Order order);
    void delete(List<Order> orders, Order order);
    void editNumber(Order order, int newNumber);
    void editClientName(Order order, String newName);
    void editClientPhone(Order order, String newPhone);
    void editStoreName(Order order, String newStoreName);
    Order get(List<Order> orders,int number);
    Order makeOrder(Store store, Client client, Product product, int quantity, int number);
    void reduceQuantity(Product product, int count);
}
