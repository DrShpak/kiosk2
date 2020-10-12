import com.google.gson.GsonBuilder;
import dao.CLI.ConsoleDAO;
import products.Book;
import products.Journal;
import products.ProductManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        var mngr = new ProductManager(new ConsoleDAO());
//        try {
//            mngr.getDao().update(new Book.BookBuilder()
//                .setName("book1")
//                .setPrice(100.0)
//                .setReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/1991"))
//                .setAuthor("lox")
//                .setProductID(1)
//                .setPages(100)
//                .setSales(0)
//                .setStockBalance(10)
//                .buildBook());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        mngr.getAllProducts().forEach(System.out::println);
        System.out.println("\n\n");

//        mngr.saleProduct(1);
//        System.out.println(mngr.getProductByID(1));

//        mngr.stockReplenishment(mngr.getProductByID(3), 100);
//        System.out.println(mngr.getProductByID(3));
    }
}

class Dog {
    String name;
    Date date;

    public Dog(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "dog: " + name + "; date: " + date;
    }
}
