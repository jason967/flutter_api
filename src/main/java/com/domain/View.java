package com.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "VIEW_SEQ_GEN", sequenceName = "VIEW_SEQ", initialValue = 1000, allocationSize = 1)

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class View {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIEW_SEQ_GEN")
    @Column(name = "view_id")
    private Long id;

    private String view;
    private String component;
    private String title;
    private String subtitle;
    private String closingHour;
    private String viewAll;
    private String image;
    private String description;
    private int exposePriority;

    @OneToMany(mappedBy = "view" ,cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    public void addContent(Content content) {
        contents.add(content);
        if (content.getView() != this) {
            content.setView(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "main_tab_id")
    private MainTab mainTab;

    public void setMainTab(MainTab main_tab) {
        if (this.mainTab != null) {
            this.mainTab.getViews().remove(this);
        }
        this.mainTab = main_tab;
        if (!main_tab.getViews().contains(this)) {
            main_tab.getViews().add(this);
        }
    }

    @Builder
    public View(String view, String component, String title, String subtitle, String closingHour, String viewAll, String image, String description, int exposePriority) {
        this.view = view;
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

