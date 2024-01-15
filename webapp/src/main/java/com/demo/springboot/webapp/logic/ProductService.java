package com.demo.springboot.webapp.logic;

import com.demo.springboot.webapp.domain.product.Product;
import com.demo.springboot.webapp.persistence.ProductEntitySpecifications;
import com.demo.springboot.webapp.persistence.ProductRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * ProductService to get products
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductEntitySpecifications productEntitySpecifications;

    /**
     * @param productRepository cannot be null
     */
    public ProductService(@NonNull ProductRepository productRepository, @NonNull ProductEntitySpecifications productEntitySpecifications) {
        this.productRepository = requireNonNull(productRepository);
        this.productEntitySpecifications = requireNonNull(productEntitySpecifications);
    }

    /**
     * @return all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * @return products by specified input
     */
    public List<String> getProductsByInput1() {

        Specification<Product> spec = productEntitySpecifications.withParams("Gebinde", "(LTR)", List.of("3489-20 GW 306 Sonder FT 41725 3 20", "1807-20 LW-715E/30 Sonder", "1692-20 DW 601/20 Aqua-Stopp Sonder RAL 7006 3 20"), "FT 41705", "weiß", "lasierend 3", "20", "29.08.2023", null);
        return getCodes(spec);
    }

    private List<String> getCodes(Specification<Product> specification) {

        List<Product> products = productRepository.findAll(specification);

        if (products.isEmpty()) {
            return Collections.singletonList("No search results!");
        }

        return products.stream().map(Product::getCode).filter(code -> code != null && !code.isEmpty()).toList();
    }

    /**
     * @return products by specified input
     */
    public List<String> getProductsByInput2() {

        Specification<Product> spec = productEntitySpecifications.withParams("Gebinde", "(LTR)", List.of("1807-20 LW-715E/30 Sonder FT 41242 3 20"), null, null, null, null, "07.12.2023", "BV: Lager");
        return getCodes(spec);
    }

    /**
     * @return products by specified input
     */
    public List<String> getProductsByInput3() {
        Specification<Product> spec = productEntitySpecifications.withParams("Gebinde", "(LTR)", List.of("1807-05 LW-715E/30 Sonder RC 660 1 5"), null, null, null, null, "31.08.2023", "BV: Charlottenbogen");
        return getCodes(spec);
    }

    /**
     * @return products by specified input
     */
    public List<String> getProductsByInput4() {

        Specification<Product> spec = productEntitySpecifications.withParams("Gebinde", "(LTR)", List.of("1692-20 DW 601/20 Aqua-Stopp Sonder RAL 7039 1 20", "1692-20 DW 601/20 Aqua-Stopp Sonder"), "NCS S-2010-", null, "Y20R 1 20", null, "15.09.2023", "BV: Schopenhauer Straße");
        return getCodes(spec);
    }
}
