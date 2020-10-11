package products;

import dao.DAO;
import lombok.Getter;

public class ProductManager {
    @Getter
    private final DAO dao;
    private double income;

    public ProductManager(DAO dao) {
        this.dao = dao;
        income = 0.0;
    }

    public void saleProduct(int productID) {
        var oldProduct = dao.getProductByID(productID).orElseThrow();
        if (oldProduct.getStockBalance() == 0) {
            dao.remove(productID);
        } else {
            var newProduct = oldProduct
                .editSales(oldProduct.getSales() + 1)
                .editStockBalance(oldProduct.getStockBalance() - 1);
            dao.remove(oldProduct.getProductID());
            dao.update(newProduct);
        }
    }

    public void saleProduct(int productID, int count) {
        var oldProduct = dao.getProductByID(productID).orElseThrow();
        if (oldProduct.getStockBalance() - count >= 0) {
            var newProduct = oldProduct
                .editSales(oldProduct.getSales() + count)
                .editStockBalance(oldProduct.getStockBalance() - count);
            dao.remove(oldProduct.getProductID());
            dao.update(newProduct);
        }
    }

    public void stockReplenishment(Product product, int count) {
        if (dao.getProductByID(product.getProductID()).isPresent()) {
            var updatedProduct = product.editStockBalance(count);
            dao.remove(product.getProductID());
            dao.update(updatedProduct);
        }
    }

    public String getInfo(int productID) {
        var product = dao.getProductByID(productID).orElseThrow();
        return product.toString();
    }

    public double getIncome() {
        for (Product product : dao.selectAll())
            income += product.getSales() * product.getPrice();
        return income;
    }
}