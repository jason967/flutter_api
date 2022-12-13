package com.service;

import com.web.dto.NavigationDto;

import java.util.List;

public interface NavigationService {
    List<NavigationDto> findAllByStoreType(String storeType);
}
