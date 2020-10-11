package products;

//import lombok.BookBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@BookBuilder(toBuilder = true)
public class Newspaper extends Product {
    @Getter@Setter
    private int newspaperID; // номер газеты

    public Newspaper(int productID, String name, Date releaseDate, int stockBalance, int sales, double price) {
        super(productID, name, releaseDate, stockBalance, sales, price);
    }

    @Override
    public Product editID(int newID) {
        return null;
    }

    @Override
    public Product editName(String newName) {
        return null;
    }

    @Override
    public Product editDate(Date newReleaseDate) {
        return null;
    }

    @Override
    public Product editPrice(double price) {
        return null;
    }

    @Override
    public Product editStockBalance(int stockBalance) {
        return null;
    }

    @Override
    public Product editSales(int sales) {
        return null;
    }
}
