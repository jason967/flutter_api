package com.web.dto;

import com.domain.MainTab;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MainTabDto {
    private final Long mainTabId;
    private final String title;
    private final String subtitle;
    private final String apiUrl;

    public MainTabDto(MainTab entity) {
        this.mainTabId=entity.getId();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.apiUrl = entity.getApiUrl();
    }

}
