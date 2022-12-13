package com.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class StoreType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "store_type_id")
    private Long id;
    private String storeType;

    @OneToMany(mappedBy = "storeType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Navigation> navigations = new ArrayList<Navigation>();

    public void addNavigation(Navigation navigation) {
        navigations.add(navigation);
        if (navigation.getStoreType() != this) {
            navigation.setStoreType(this);
        }
    }

    @Builder
    public StoreType(String storeType) {
        this.storeType = storeType;
    }
}
