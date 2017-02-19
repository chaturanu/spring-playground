package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by chaturanu on 2/19/17.
 */
@RestController
public class FormDataController {

    @PostMapping("/individual-example")
    public String getIndividualParams(@RequestParam int productId, @RequestParam double cost, @RequestParam String purchasedBy) {
        return String.format("%s bought:%d for:%f", purchasedBy, productId, cost);
    }

    @PostMapping("/map")
    public String postRequestBodyAsMap(@RequestParam Map<String, String> map) {
        return map.toString();
    }

    @PostMapping("/object-example")
    public String showFormDataObject(Product p) {
        return String.format("%s bought %d for $%f", p.getPurchasedBy(), p.getProductId(), p.getCost());
    }

    public static class Product
    {
        private int productId;
        private double cost;
        private String purchasedBy;

        public int getProductId() {
            return productId;
        }

        public String getPurchasedBy() {
            return purchasedBy;
        }

        public void setPurchasedBy(String purchasedBy) {
            this.purchasedBy = purchasedBy;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }
}
