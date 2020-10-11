package products;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(makeFinal = true)
public class Book extends Product {
    @Getter
    private String author;
    @Getter
    private int pages;

    public Book(int productID, String name,
                Date releaseDate, int stockBalance,
                int sales, double price,
                String author, int pages) {
        super(productID, name, releaseDate, stockBalance, sales, price);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public Product editID(int newID) {
        return new Book(newID, getName(),
            getReleaseDate(), getStockBalance(),
            getSales(), getPrice(),
            getAuthor(), pages);
    }

    @Override
    public Product editName(String newName) {
        return new Book(getProductID(), newName,
            getReleaseDate(), getStockBalance(),
            getSales(), getPrice(),
            getAuthor(), pages);
    }

    @Override
    public Product editDate(Date newReleaseDate) {
        return new Book(getProductID(), getName(),
            newReleaseDate, getStockBalance(),
            getSales(), getPrice(),
            getAuthor(), pages);
    }

    @Override
    public Product editPrice(double price) {
        return new Book(getProductID(), getName(),
            getReleaseDate(), getStockBalance(),
            getSales(), price,
            getAuthor(), pages);
    }

    @Override
    public Product editStockBalance(int stockBalance) {
        return new Book(getProductID(), getName(),
            getReleaseDate(), stockBalance,
            getSales(), getPrice(),
            author, pages);
    }

    @Override
    public Product editSales(int sales) {
        return new Book(getProductID(), getName(),
            getReleaseDate(), getStockBalance(),
            sales, getPrice(),
            getAuthor(), pages);
    }

    public static class BookBuilder {
        private int productID;
        private String name;
        private Date releaseDate;
        private int stockBalance;
        private int sales;
        private double price;
        private String author;
        private int pages;

        public BookBuilder setProductID(int productID) {
            this.productID = productID;
            return this;
        }

        public BookBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder setReleaseDate(Date date) {
            this.releaseDate = date;
            return this;
        }

        public BookBuilder setStockBalance(int balance) {
            this.stockBalance = balance;
            return this;
        }

        public BookBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setSales(int sales) {
            this.sales = sales;
            return this;
        }

        public BookBuilder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book buildBook() {
            return new Book(productID, name, releaseDate, stockBalance, sales, price, author, pages);
        }
    }

    @Override
    public String toString() {
        return "Book[" +
            "{ID=" + getProductID() +
            "}, {name='" + getName() + '\'' +
            "}, {releaseDate=" + getReleaseDate() +
            "}, {stockBalance=" + getStockBalance() +
            "}, {sales=" + getSales() +
            "}, {price=" + getPrice() +
            "}, {author=" + author +
            "}, {pages=" + pages +
            ']';
    }
}