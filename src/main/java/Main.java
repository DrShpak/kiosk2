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
        mngr.getDao().selectAll().forEach(System.out::println);
        System.out.println("\n\n");

        mngr.saleProduct(1);
        System.out.println(mngr.getDao().getProductByID(1));

        mngr.stockReplenishment(mngr.getDao().getProductByID(3).get(), 100);
        System.out.println(mngr.getDao().getProductByID(3));
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
