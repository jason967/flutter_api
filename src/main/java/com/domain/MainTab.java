package com.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "MAIN_TAB_SEQ_GEN", sequenceName = "MAIN_TAB_SEQ", initialValue = 100, allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MainTab {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAIN_TAB_SEQ_GEN")
    @Column(name = "main_tab_id")
    private Long id;
    private String title;
    private String subtitle;
    private String apiUrl;
    @OneToMany(mappedBy = "mainTab", cascade = CascadeType.ALL)
    private List<View> views = new ArrayList<>();

    public void addView(View view) {
        views.add(view);
        if (view.getMainTab() != this) {
            view.setMainTab(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "store_type_id")
    private StoreType storeType;

    public void setStoreType(StoreType storeType) {
        if (this.storeType != null) {
            this.storeType.getMainTabs().remove(this);
        }
        this.storeType = storeType;
        if (!storeType.getMainTabs().contains(this)) {
            storeType.getMainTabs().add(this);
        }
    }

    @Builder
    public MainTab(String title, String subtitle, String apiUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.apiUrl = apiUrl;
    }
}
