package ui.cli;

import dao.DAO;
import products.Product;

import java.util.List;
import java.util.Optional;

public class ConsoleUI implements DAO {
    @Override
    public List<Product> selectAll() {
        return null;
    }

    @Override
    public Optional<Product> getProductByID(int productID) {
        return null;
    }

    @Override
    public void update(int productID) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void remove(int productID) {

    }
}
