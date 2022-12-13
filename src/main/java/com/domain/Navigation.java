package com.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "NAVIGATION_SEQ_GEN", sequenceName = "NAVIGATION_SEQ", initialValue = 100, allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Navigation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAVIGATION_SEQ_GEN")
    @Column(name = "navigation_id")
    private Long id;
    private String title;
    private String subtitle;
    private String apiUrl;
    private String naviType;
    @OneToMany(mappedBy = "navigation", cascade = CascadeType.ALL)
    private List<ViewType> viewTypes = new ArrayList<>();

    public void addViewType(ViewType viewType) {
        viewTypes.add(viewType);
        if (viewType.getNavigation() != this) {
            viewType.setNavigation(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "store_type_id")
    private StoreType storeType;

    public void setStoreType(StoreType storeType) {
        if (this.storeType != null) {
            this.storeType.getNavigations().remove(this);
        }
        this.storeType = storeType;
        if (!storeType.getNavigations().contains(this)) {
            storeType.getNavigations().add(this);
        }
    }

    @Builder
    public Navigation(String title, String subtitle, String apiUrl, String naviType) {
        this.title = title;
        this.subtitle = subtitle;
        this.apiUrl = apiUrl;
        this.naviType = naviType;
    }
}
