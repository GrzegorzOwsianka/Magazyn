package pl.owsianka.magazyn.database.memory;

import org.springframework.stereotype.Component;
import pl.owsianka.magazyn.database.IProductsDAO;
import pl.owsianka.magazyn.model.Products;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDatabase implements IProductsDAO {
    private List<Products> products = new ArrayList<>();

    public ProductDatabase() {
        products.add(new Products(1, "Myjka ciśnieniowa", "23-21/1", 5));
        products.add(new Products(1, "Podbierak jagodowy", "23-22/2", 7));
        products.add(new Products(1, "Wiertarka", "23-3/3", 2));
    }

    public List<Products> getProducts() {
        return products;
    }
}
