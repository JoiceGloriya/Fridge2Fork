package com.example.simplewebapp.Service;

import com.example.simplewebapp.Model.Product;
import com.example.simplewebapp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
//@Component
public class ProductService {

//    List<Product> product = new ArrayList<>(Arrays.asList(new Product(1, "iPhone", 100000.25), new Product(2, "Samsung mobile", 50000)));
    @Autowired
    ProductRepo repo;
//    private int getIndex(Product prd) {
//        int index = 0;
//        for (int i = 0; i < repo.size(); i++) {
//            if(repo.get(i).getPrdId() == prd.getPrdId()) {
//                index = i;
//            }
//        }
//        return index;
//    }
//
//    private int getIndexById(int prdId) {
//        int index = 0;
//        for (int i = 0; i < repo.size(); i++) {
//            if(repo.get(i).getPrdId() == prdId) {
//                index = i;
//            }
//        }
//        return index;
//    }

    public List<Product> getProducts() {
            return repo.findAll();
    }

    public Product getProductById ( int prodId ){
//        for( Product prod : product ){
//            if(prod.getPrdId()  ==  prodId ){
//                return prod;
//            }
//        }
//        (or)
//        return product.stream()
//                .filter(p -> p.getPrdId() == prodId)
//                .findFirst().orElse(new Product(0, "Nothing to show here", 0.0));
        
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prd) {
        repo.save(prd);
    }

    public void updateProduct(Product prd) {
//       int index = getIndex(prd);
//        repo.set(index, prd);
        repo.save(prd);
    }

    public void deleteProduct(int prdId) {
//        int index = getIndexById(prdId);
//        repo.remove(index);
        repo.deleteById(prdId);
    }
}
