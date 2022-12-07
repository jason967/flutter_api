package com.web.dto;

import com.domain.navigation.Navigations;
import lombok.Getter;

import java.util.List;

@Getter
public class NavigationDto {
    private final int naviId;
    private final String title;
    private final String subtitle;
    private final String apiUrl;
    private final String naviType;

    public NavigationDto(Navigations entity) {
        this.naviId = entity.getNaviId();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.apiUrl = entity.getApiUrl();
        this.naviType=entity.getNaviType();
    }

}
