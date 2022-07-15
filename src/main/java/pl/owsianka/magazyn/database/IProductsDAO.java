package pl.owsianka.magazyn.database;

import pl.owsianka.magazyn.model.Products;

import java.util.List;

public interface IProductsDAO {
    List<Products> getProducts();
}
