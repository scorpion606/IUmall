package com.scorpion.entity;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author scorpion
 * @date 2022/5/29
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProductToEs {
    private Integer productId;
    private Integer categoryId;
    private Integer tabId;
    private String skuName;
    private String productName;
    private String productContent;
    private String productImage;
    private String oldness;
    private String purchasedTime;
    private String attrName;
    private String attrValue;
    private BigDecimal originalPrice;
    private BigDecimal sellPrice;
}
