package com.web.dto;

import com.domain.Navigation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NavigationDto {
    private final Long navigation_id;
    private final String title;
    private final String subtitle;
    private final String apiUrl;
    private final String naviType;

    public NavigationDto(Navigation entity) {
        this.navigation_id=entity.getId();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.apiUrl = entity.getApiUrl();
        this.naviType = entity.getNaviType();
    }

}
