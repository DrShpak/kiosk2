package dao;

import products.Product;

import java.util.List;
import java.util.Optional;

public interface DAO {
    List<Product> selectAll();

    Optional<Product> getProductByID(int productID);

    void update(int productID);

    void update(Product product);

    void remove(int productID);
}
