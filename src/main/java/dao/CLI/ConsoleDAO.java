package dao.CLI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DAO;
import lombok.Getter;
import lombok.SneakyThrows;
import products.Book;
import products.Journal;
import products.Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConsoleDAO implements DAO {
    private final Path PATH = Paths.get("src/main/resources/db.json");
    private final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(Book.class, new ProductSerializerDeserializer())
        .create();

    private final Gson gson2 = new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(Journal.class, new ProductSerializerDeserializer())
        .registerTypeAdapter(Book.class, new ProductSerializerDeserializer())
        .create();
    @Getter
    private final List<Product> products = new ArrayList<>();

//    @SneakyThrows
    public ConsoleDAO() {
//        products = selectAll();
        try {
            products.add(new Book.BookBuilder()
                .setName("book1")
                .setPrice(100.0)
                .setReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/1991"))
                .setAuthor("lox")
                .setProductID(1)
                .setPages(100)
                .setSales(0)
                .setStockBalance(10)
                .buildBook());

            products.add(new Book.BookBuilder()
                .setName("book2")
                .setPrice(200.0)
                .setReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/12/1991"))
                .setAuthor("flower lox")
                .setProductID(2)
                .setPages(2300)
                .setSales(0)
                .setStockBalance(110)
                .buildBook());

            products.add(new Journal.JournalBuilder()
                .setName("journal1")
                .setPrice(250.0)
                .setReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("02/02/2002"))
                .setIssue(10)
                .setProductID(3)
                .setPages(2300)
                .setSales(0)
                .setStockBalance(110)
                .buildJournal());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> selectAll() {
//        var json = "";
//        try {
//            json = Files.readAllLines(PATH).toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        var products = new ArrayList<Product>();

//        var temp = gson.fromJson(json, Product[].class);
//        return Arrays.stream(temp).collect(Collectors.toList());
        return products;
    }

    @Override
    public Optional<Product> getProductByID(int productID) {
        return products.stream()
            .filter(x -> x.getProductID() == productID)
            .findAny();
    }

    @Override
    public void update(int productID) {

    }

    @Override
    public void update(Product product) {
        products.add(product);
//        try (BufferedWriter writer = Files.newBufferedWriter(PATH, StandardCharsets.UTF_8)) {
//            writer.write("[");
//            for (Product elem : products)
//                writer.write(gson2.toJson(elem));
//            writer.write("]");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    @Override
    public void remove(int productID) {
        products.stream()
            .filter(x -> x.getProductID() == productID)
            .findFirst()
            .ifPresent(products::remove);
    }
}