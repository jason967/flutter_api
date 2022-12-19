package com.service;

import com.web.dto.MainTabDto;

import java.util.List;

public interface MainTabService {
    List<MainTabDto> findAllByStoreType(String storeType);
}
