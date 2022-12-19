package com.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SequenceGenerator(name = "CONTENT_SEQ_GEN", sequenceName = "CONTENT_SEQ", initialValue = 10000, allocationSize = 1)

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTENT_SEQ_GEN")
    @Column(name = "content_id")
    private Long id;

    private String title;
    private String subtitle;
    private int price;
    private int discount;
    private String image;
    private String shoppingBasket;

    @ManyToOne
    @JoinColumn(name = "view_id")
    private View view;

    public void setView(View view) {
        if (this.view != null) {
            this.view.getContents().remove(this);
        }
        this.view = view;
        if (!view.getContents().contains(this)) {
            view.getContents().add(this);
        }
    }

    @Builder
    public Content(String title, String subtitle, int price, int discount, String image, String shoppingBasket) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.shoppingBasket = shoppingBasket;
    }

}
