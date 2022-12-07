package com.domain.viewType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class ViewType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int naviId;
    private String viewType;
    private String component;
    private String description;
    private int exposePriority;

    @Builder
    public ViewType(int naviId, String viewType, String component, String description, int exposePriority) {
        this.naviId = naviId;
        this.viewType = viewType;
        this.component = component;
        this.description = description;
        this.exposePriority = exposePriority;
    }
}

