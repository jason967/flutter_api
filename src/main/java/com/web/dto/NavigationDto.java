package com.web.dto;

import com.domain.navigation.Navigations;
import lombok.Getter;

@Getter
public class NavigationDto {
    private final Long id;
    private final int naviId;
    private final String title;
    private final String subtitle;
    private final String apiUrl;


    public NavigationDto(Navigations entity){
        this.id = entity.getId();
        this.naviId = entity.getNaviId();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.apiUrl = entity.getApiUrl();
    }

}