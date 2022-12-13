package com.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "VIEW_TYPE_SEQ_GEN", sequenceName = "VIEW_TYPE_SEQ", initialValue = 1000, allocationSize = 1)

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ViewType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIEW_TYPE_SEQ_GEN")
    @Column(name = "view_type_id")
    private Long id;

    private String viewType;
    private String component;
    private String title;
    private String subtitle;
    private String closingHour;
    private String viewAll;
    private String image;
    private String description;
    private int exposePriority;

    @OneToMany(mappedBy = "viewType" ,cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    public void addContent(Content content) {
        contents.add(content);
        if (content.getViewType() != this) {
            content.setViewType(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "navigation_id")
    private Navigation navigation;

    public void setNavigation(Navigation navigation) {
        if (this.navigation != null) {
            this.navigation.getViewTypes().remove(this);
        }
        this.navigation = navigation;
        if (!navigation.getViewTypes().contains(this)) {
            navigation.getViewTypes().add(this);
        }
    }

    @Builder
    public ViewType(String viewType, String component, String title, String subtitle, String closingHour, String viewAll, String image, String description, int exposePriority) {
        this.viewType = viewType;
        this.component = component;
        this.title = title;
        this.subtitle = subtitle;
        this.closingHour = closingHour;
        this.viewAll = viewAll;
        this.image = image;
        this.description = description;
        this.exposePriority = exposePriority;
    }
}

