package com.web.dto;

import com.domain.Content;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentDto {
    private final String title;
    private final String subtitle;
    private final String price;
    private String sellingPrice;
    private final String discount;
    private final String image;
    private final String shoppingBasket;

    public ContentDto(Content entity) {
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.price = String.format("%,d", entity.getPrice());
        this.discount = String.valueOf(entity.getDiscount())+"%";
        this.sellingPrice = String.format("%,d", entity.getPrice());
        this.image = entity.getImage();
        this.shoppingBasket = entity.getShoppingBasket();
    }
}
