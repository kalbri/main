package com.demo.springboot.webapp.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Product domain class
 */
@Entity
public class Product {

    @Id
    private long id;
    private String code;
    private String typeGebinde;
    private String typeLTR;
    private String colorVariant;
    private String colorCode;
    private String colorName;
    private String colorType;
    private String quantity;
    private String date;
    private String location;

    /**
     * @param id
     * @param code
     * @param typeGebinde
     * @param typeLTR
     * @param colorVariant
     * @param colorCode
     * @param colorName
     * @param colorType
     * @param quantity
     * @param date
     * @param location
     */
    public Product(int id, String code, String typeGebinde, String typeLTR, String colorVariant, String colorCode, String colorName, String colorType, String quantity, String date, String location) {
//        super();
        this.id = id;
        this.code = code;
        this.typeGebinde = typeGebinde;
        this.typeLTR = typeLTR;
        this.colorVariant = colorVariant;
        this.colorCode = colorCode;
        this.colorName = colorName;
        this.colorType = colorType;
        this.quantity = quantity;
        this.date = date;
        this.location = location;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeGebinde() {
        return typeGebinde;
    }

    public void setTypeGebinde(String typeGebinde) {
        this.typeGebinde = typeGebinde;
    }

    public String getTypeLTR() {
        return typeLTR;
    }

    public void setTypeLTR(String typeLTR) {
        this.typeLTR = typeLTR;
    }

    public String getColorVariant() {
        return colorVariant;
    }

    public void setColorVariant(String colorVariant) {
        this.colorVariant = colorVariant;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", typeGebinde='" + typeGebinde + '\'' +
                ", typeLTR='" + typeLTR + '\'' +
                ", colorVariant='" + colorVariant + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", colorName='" + colorName + '\'' +
                ", colorType='" + colorType + '\'' +
                ", quantity=" + quantity +
                ", deliveryDate=" + date +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product product))
            return false;
        return getId() == product.getId() && Objects.equals(getCode(), product.getCode()) && Objects.equals(getTypeGebinde(), product.getTypeGebinde()) && Objects.equals(getTypeLTR(), product.getTypeLTR()) && Objects.equals(getColorVariant(), product.getColorVariant()) && Objects.equals(getColorCode(), product.getColorCode()) && Objects.equals(getColorName(), product.getColorName()) && Objects.equals(getColorType(), product.getColorType()) && Objects.equals(getQuantity(), product.getQuantity()) && Objects.equals(getDate(), product.getDate()) && Objects.equals(getLocation(), product.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode());
    }
}
