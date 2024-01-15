package com.demo.springboot.webapp.logic;

import com.demo.springboot.webapp.domain.product.Product;
import com.demo.springboot.webapp.persistence.ProductEntitySpecifications;
import com.demo.springboot.webapp.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    public static final String CODE_1 = "code1";
    public static final Product PRODUCT_1 = new Product(1, CODE_1, "type", "type", "colorVariant", "colorCode", "colorName", "colorType", "quantity", "date", "location");
    public static final String CODE_2 = "code2";
    public static final Product PRODUCT_2 = new Product(2, CODE_2, "type", "type", "colorVariant", "colorCode", "colorName", "colorType", "quantity", "date", "location");
    public static final List<Product> PRODUCTS = Arrays.asList(PRODUCT_1, PRODUCT_2);
    private static final Product PRODUCT_WITHOUT_CODE = new Product(3, "", "type", "type", "colorVariant", "colorCode", "colorName", "colorType", "quantity", "date", "location");
    private final ProductRepository productRepositoryMock = mock(ProductRepository.class);
    private final ProductEntitySpecifications productEntitySpecificationsMock = mock(ProductEntitySpecifications.class);
    private Specification<Product> productSpecification;
    private final ProductService classUnderTest = new ProductService(productRepositoryMock, productEntitySpecificationsMock);

    @BeforeEach
    void setUp() {

        productSpecification = productEntitySpecificationsMock.withParams("type", null, List.of(), null, null, "colorType", null, null, null);
        when(productEntitySpecificationsMock.withParams(any(), any(), any(), any(), any(), any(), any(), any(), any())).thenReturn(productSpecification);
    }

    @Test
    void givenProducts_whenGetAllProducts_thenProductsAreReturned() {

        // given
        when(productRepositoryMock.findAll()).thenReturn(PRODUCTS);

        // when
        List<Product> actualResult = classUnderTest.getAllProducts();

        // then
        assertEquals(2, actualResult.size());
        assertEquals(PRODUCTS, actualResult);
        assertEquals(CODE_1 , PRODUCTS.get(0).getCode());
        assertEquals(CODE_2 , PRODUCTS.get(1).getCode());
    }

    @Test
    void givenProductsWithCodes_whenGetProductsByInput4_thenCodesAreReturned() {

        // given
        List<Product> products = Arrays.asList(PRODUCT_1, PRODUCT_2);
        when(productRepositoryMock.findAll(productSpecification)).thenReturn(products);

        // when
        List<String> actualResult = classUnderTest.getProductsByInput4();

        // then
        assertEquals(Arrays.asList(CODE_1, CODE_2), actualResult);
    }

    @Test
    void givenNoProducts_whenGetProductsByInput4_thenNoResultsMsgIsReturned() {

        // given
        when(productRepositoryMock.findAll(productSpecification)).thenReturn(Collections.emptyList());

       // when
        List<String> actualResult = classUnderTest.getProductsByInput4();

        // then
        assertEquals(Collections.singletonList("No search results!"), actualResult);
    }

    @Test
    void givenProductWithNoCode_whenGetProductsByInput4_thenEmptyListIsReturned() {

        // given
        List<Product> products = List.of(PRODUCT_WITHOUT_CODE);
        when(productRepositoryMock.findAll(productSpecification)).thenReturn(products);

        // when
        List<String> actualResult = classUnderTest.getProductsByInput4();

        // then
        assertTrue(actualResult.isEmpty());
    }
}