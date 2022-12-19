package com.web.dto;

import com.domain.View;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewDto {

    private final Long viewId;
    private final String view;
    private final String component;
    private final String title;
    private final String subtitle;
    private final String description;
    private final String closingHour;
    private final String viewAll;
    private final String image;

    private List<ContentDto> contents = null;

    public ViewDto(View entity) {
        this.viewId =  entity.getId();
        this.view = entity.getView();
        this.component = entity.getComponent();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.description = entity.getDescription();
        this.closingHour = entity.getClosingHour();
        this.viewAll = entity.getViewAll();
        this.image = entity.getImage();
    }
}
