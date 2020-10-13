package ui.cli;

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

        /*add Product to store*/
//        try {
//            mngr.update(new Book.BookBuilder()
//                .setName("Юрий Дудь - не тупой.")
//                .setPrice(100.0)
//                .setReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2019"))
//                .setAuthor("Юрий Дудь")
//                .setProductID(6)
//                .setPages(1)
//                .setSales(0)
//                .setStockBalance(1)
//                .buildBook());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        //get all products
//        mngr.getAllProducts().forEach(System.out::println);
//        System.out.println("\n\n");

        //sale product with ID = 1 and show result
//        mngr.saleProduct(1);
//        System.out.println(mngr.getProductByID(1));


        //take new product (count=100) and show result
//        mngr.stockReplenishment(mngr.getProductByID(3), 100);
//        System.out.println(mngr.getProductByID(3));

        /*
        edit product name
        method editName() return a new Product
        update it
         */
        mngr.update(mngr.getProductByID(1).editName("БОГАТЫЙ ПАПА, БЕДНЫЙ ПАПА - ТОП КНИГА (нет)"));
        mngr.getAllProducts().forEach(System.out::println);
        System.out.println("\n\n");
    }
}