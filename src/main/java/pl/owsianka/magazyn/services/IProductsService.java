package pl.owsianka.magazyn.services;

import pl.owsianka.magazyn.model.Products;

import java.util.List;

public interface IProductsService {
    List<Products> getAllProducts();
}
