package com.web.dto;

import com.domain.ViewType;
import lombok.Getter;

@Getter
public class ViewTypeDto {

//    private final int naviId;
    private final String viewType;
    private final String component;
    private final String description;
    private final int exposePriority;

    public ViewTypeDto(ViewType entity) {
//        this.naviId = entity.getNaviId();
        this.viewType = entity.getViewType();
        this.component = entity.getComponent();
        this.description = entity.getDescription();
        this.exposePriority = entity.getExposePriority();
    }
}
