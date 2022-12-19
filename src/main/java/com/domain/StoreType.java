package com.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "STORE_TYPE_SEQ_GEN", sequenceName = "STORE_TYPE_SEQ",initialValue = 10,allocationSize = 10)
@Getter
@NoArgsConstructor
@Entity
public class StoreType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "STORE_TYPE_SEQ_GEN")
    @Column(name = "store_type_id")
    private Long id;
    private String storeType;

    @OneToMany(mappedBy = "storeType", cascade = CascadeType.ALL)
    List<MainTab> mainTabs = new ArrayList<MainTab>();

    public void addMainTabs(MainTab mainTab) {
        mainTabs.add(mainTab);
        if (mainTab.getStoreType() != this) {
            mainTab.setStoreType(this);
        }
    }

    @Builder
    public StoreType(String storeType) {
        this.storeType = storeType;
    }
}
