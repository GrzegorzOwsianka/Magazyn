package pl.owsianka.magazyn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.owsianka.magazyn.database.IProductsDAO;
import pl.owsianka.magazyn.model.Products;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    IProductsDAO productsDAO;

    public List<Products> getAllProducts() {
        return this.productsDAO.getProducts();
    }
}
