package com.example.simplewebapp.Controller;

import com.example.simplewebapp.Model.Product;
import com.example.simplewebapp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{prdId}")
    public   Product getProductById(@PathVariable int prdId) {
        return service.getProductById(prdId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prd){
        service.addProduct(prd);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prd) {
        service.updateProduct(prd);
    }

    @DeleteMapping("/products/{prdId}")
    public void deleteProduct(@PathVariable int prdId) {
        service.deleteProduct(prdId);
    }
}
