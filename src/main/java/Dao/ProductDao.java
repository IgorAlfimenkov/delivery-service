package Dao;

import entity.Product;
import entity.ProductType;
import entity.Store;

public class ProductDao implements IProductDao {

    static Database database = Database.getInstance();

    public void editType(Product product, String newType)
    {
        for (ProductType p: ProductType.values()) {
            if(p.toString().toLowerCase().equals(newType.toLowerCase()))
            {
                product.setType(p);
            }
        }

    }

    public void editName(Product product, String newName)
    {
        product.setName(newName);
    }

    public void editBrand(Product product, String newBrand)
    {
        product.setBrand(newBrand);
    }

    public void editColor(Product product, String newColor)
    {
        product.setColor(newColor);
    }

    public void editPrice(Product product, double newPrice)
    {
        product.setPrice(newPrice);
    }

    public void editSize(Product product, double newSize)
    {
        product.setSize(newSize);
    }

    public void editQuantity(Product product, int newQuantity)
    {
        product.setQuantity(newQuantity);
    }

    public ProductType getType(String type)
    {
        for (ProductType p : ProductType.values()) {
            if(type.equalsIgnoreCase(p.toString())) return p;
        }
        return null;
    }
}
