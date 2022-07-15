package pl.owsianka.magazyn.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.owsianka.magazyn.database.IProductsDAO;
import pl.owsianka.magazyn.model.Products;
import pl.owsianka.magazyn.services.IProductsService;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    IProductsDAO productsDAO;

    public List<Products> getAllProducts() {
        return this.productsDAO.getProducts();
    }
}
