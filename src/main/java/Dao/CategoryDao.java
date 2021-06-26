package Dao;

import entity.Category;
import entity.Product;

import java.util.List;

public class CategoryDao implements ICategoryDao {

    public void addProduct(Category category, Product product)
    {
        category.addProduct(product);
    }

    @Override
    public void deleteProduct(Category category, Product product) {
        category.getProducts().remove(product);
    }

    @Override
    public void editName(Category category, String newName) {

        category.setName(newName);
    }

    @Override
    public List<Product> getProducts(Category category) {
        return category.getProducts();
    }
}
