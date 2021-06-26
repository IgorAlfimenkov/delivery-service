package Dao;

import entity.Category;
import entity.Product;
import entity.ProductType;
import entity.Store;

import java.util.List;

public interface IStoreDao {

    void addStore(List<Store> stores,Store store);
    void deleteStore(List<Store> stores,Store store);
    void addProduct(Store store, Product product);
    void deleteProduct(Store store, Product product);
    void addCategory(Store store, Category category);
    void deleteCategory(Store store, Category category);
    void editName(Store store, String name);
    void buyProduct(Store store, Product product);
    Store getStoreByName(List<Store> stores,String name);
    List<Store> getAll();
    Product getByNameAndSize(Store store, String name, double size);
    Category getCategoryByName(Store store,String name);
    Product getProduct(Store store, int id);
    List<Product> getProductsByCategory(Store store, String name);
    List<Product> getByPrice(Store store, double price);
    List<Product> getByName(Store store, String name);
    List<Product> getByType(Store store, String type);
    List<Product> getByTypePriceAndCategory(Store store, double price, String type, String category);
    List<Product> getByTypeAndPrice(Store store, String type, double price);
    List<Product> sortProducts(Store store);
    void changeType(Store store, Product product, ProductType productType);
    void changeName(Store store, Product product, String name);
    void changeBrand(Store store, Product product, String brand);
    void changeColor(Store store, Product product, String color);
    void changePrice(Store store, Product product, Double price);
    void changeSize(Store store, Product product, Double size);
    void changeQuantity(Store store, Product product, int quantity);
    void reduceQuantity(Product product, int count);
}
