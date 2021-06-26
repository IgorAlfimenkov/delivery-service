package Dao;

import entity.Product;
import entity.ProductType;

public interface IProductDao {

    void editType(Product product, String newType);
    void editName(Product product, String newName);
    void editBrand(Product product, String newBrand);
    void editColor(Product product, String newColor);
    void editPrice(Product product, double newPrice);
    void editSize(Product product, double newSize);
    void editQuantity(Product product, int newQuantity);
    ProductType getType(String type);

}
