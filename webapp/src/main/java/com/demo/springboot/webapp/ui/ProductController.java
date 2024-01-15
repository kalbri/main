package com.demo.springboot.webapp.ui;

import com.demo.springboot.webapp.domain.product.Product;
import com.demo.springboot.webapp.logic.ProductService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(@NonNull ProductService productService) {
        this.productService = requireNonNull(productService);
    }

    @RequestMapping("/products")
    public List<Product> retrieveAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/search/input1")
    public List<String> getInput1() {
        return productService.getProductsByInput1();
    }

    @RequestMapping("/search/input2")
    public List<String> getInput2() {
        return productService.getProductsByInput2();
    }

    @RequestMapping("/search/input3")
    public List<String> getInput3() {
        return productService.getProductsByInput3();
    }

    @RequestMapping("/search/input4")
    public List<String> getInput4() {
        return productService.getProductsByInput4();
    }
}
