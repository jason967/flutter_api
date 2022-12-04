package com.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class NavigationListDto {
    private final List<NavigationDto> navigationDtoList;

    public NavigationListDto(List<NavigationDto> navigationDtoList) {
        this.navigationDtoList = navigationDtoList;
    }
}