package com.redstevo.ecomerce_app.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String productName;

    private String productDescription;

    private List<String> productUrls;

    private Float productPrice;

    private Float productDiscount;
}
