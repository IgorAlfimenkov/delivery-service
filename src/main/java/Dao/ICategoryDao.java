package Dao;

import entity.Category;
import entity.Product;

import java.util.List;

public interface ICategoryDao {

    void addProduct(Category category, Product product);
    void deleteProduct(Category category, Product product);
    void editName(Category category, String newName);
    List<Product> getProducts(Category category);
}
