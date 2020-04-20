package com.example.xyz;

public class DataProduct {
    private String product_id;
    private String product_name;
    private String product_description;
    private String product_quantity;

    public DataProduct(){

    }


    public DataProduct(String product_name, String product_description, String product_quantity) {
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_quantity = product_quantity;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }
}
