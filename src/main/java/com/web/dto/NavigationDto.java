package com.web.dto;

import com.domain.Navigation;
import lombok.Getter;

@Getter
public class NavigationDto {
    private final String title;
    private final String subtitle;
    private final String apiUrl;
    private final String naviType;

    public NavigationDto(Navigation entity) {
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.apiUrl = entity.getApiUrl();
        this.naviType = entity.getNaviType();
    }

}
