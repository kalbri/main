package com.demo.springboot.webapp.persistence;

import com.demo.springboot.webapp.domain.product.Product;
import jakarta.annotation.Nullable;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductEntitySpecifications to construct queries by provides parameters
 */
@Repository
public class ProductEntitySpecifications implements Specification<Product> {

    /**
     * @param typeGebinde  assuming it cannot be null
     * @param typeLTR      can be null
     * @param colorVariant can be null
     * @param colorCode    can be null
     * @param colorName    can be null
     * @param colorType    can be null
     * @param quantity     can be null
     * @param date         can be null
     * @param location     can be null
     * @return Specification of constructed query
     */
    public Specification<Product> withParams(@NonNull String typeGebinde, @Nullable String typeLTR, @Nullable List<String> colorVariant,
                                             @Nullable String colorCode, @Nullable String colorName, @Nullable String colorType,
                                             @Nullable String quantity, @Nullable String date, @Nullable String location) {
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("typeGebinde"), typeGebinde));

            if (typeLTR != null) {
                predicates.add(criteriaBuilder.equal(root.get("typeLTR"), typeLTR));
            }

            if (colorVariant != null) {
                predicates.add(root.get("colorVariant").in(colorVariant));
            }

            if (colorCode != null) {
                predicates.add(criteriaBuilder.equal(root.get("colorCode"), colorCode));
            }

            if (colorName != null) {
                predicates.add(criteriaBuilder.equal(root.get("colorName"), colorName));
            }

            if (colorType != null) {
                predicates.add(criteriaBuilder.equal(root.get("colorType"), colorType));
            }

            if (quantity != null) {
                predicates.add(criteriaBuilder.equal(root.get("quantity"), quantity));
            }

            if (date != null) {
                predicates.add(criteriaBuilder.equal(root.get("date"), date));
            }

            if (location != null) {
                predicates.add(criteriaBuilder.equal(root.get("location"), location));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * ANDs the given {@link Specification} to the current one.
     *
     * @param other can be {@literal null}.
     * @return The conjunction of the specifications
     * @since 2.0
     */
    @Override
    public Specification<Product> and(Specification<Product> other) {
        return Specification.super.and(other);
    }

    /**
     * ORs the given specification to the current one.
     *
     * @param other can be {@literal null}.
     * @return The disjunction of the specifications
     * @since 2.0
     */
    @Override
    public Specification<Product> or(Specification<Product> other) {
        return Specification.super.or(other);
    }

    /**
     * Creates a WHERE clause for a query of the referenced entity in form of a {@link Predicate} for the given
     * {@link Root} and {@link CriteriaQuery}.
     *
     * @param root            must not be {@literal null}.
     * @param query           must not be {@literal null}.
     * @param criteriaBuilder must not be {@literal null}.
     * @return a {@link Predicate}, may be {@literal null}.
     */
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
