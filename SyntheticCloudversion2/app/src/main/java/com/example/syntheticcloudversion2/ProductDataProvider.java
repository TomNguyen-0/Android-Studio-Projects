package com.example.syntheticcloudversion2;

import android.widget.CheckBox;

/**
 * Created by tom on 6/20/2016.
 */
public class ProductDataProvider

{
    private int product_poster_resource;
    private String product_label;
    private String product_cost;



    public ProductDataProvider (int product_poster_resource, String product_label, String product_cost)
    {

        this.setProduct_poster_resource(product_poster_resource);
        this.setProduct_label(product_label);
        this.setProduct_cost(product_cost);
    }


    public int getProduct_poster_resource() {
        return product_poster_resource;
    }

    public void setProduct_poster_resource(int product_poster_resource) {
        this.product_poster_resource = product_poster_resource;
    }

    public String getProduct_label() {
        return product_label;
    }

    public void setProduct_label(String product_label) {
        this.product_label = product_label;
    }

    public String getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(String product_cost) {
        this.product_cost = product_cost;
    }
}
