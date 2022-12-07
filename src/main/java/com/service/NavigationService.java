package com.service;

import com.domain.navigation.NavigationRepository;
import com.domain.navigation.Navigations;
import com.web.dto.NavigationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NavigationService {
    private final NavigationRepository navigationRepository;

    @Transactional(readOnly = true)
    public List<NavigationDto> findAll() {

        return navigationRepository.findAll().stream().map(NavigationDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NavigationDto findById(Long id) {
        Navigations navigations = navigationRepository.findById(id).get();

        return new NavigationDto(navigations);
    }

    @Transactional(readOnly = true)
    public List<NavigationDto> findAllNaviType(String type) {

        return navigationRepository.findNavigationsByNaviType(type).stream().map(NavigationDto::new).collect(Collectors.toList());
    }
}
