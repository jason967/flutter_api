package com.service;

import com.repository.NavigationRepository;
import com.domain.Navigation;
import com.web.dto.NavigationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NavigationServiceImpl implements NavigationService {
    private final NavigationRepository navigationRepository;

    @Transactional(readOnly = true)
    public List<NavigationDto> findAll() {

        return navigationRepository.findAll().stream().map(NavigationDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NavigationDto findById(Long id) {
        Navigation navigation = navigationRepository.findById(id).get();

        return new NavigationDto(navigation);
    }

    @Transactional(readOnly = true)
    public List<NavigationDto> findAllNaviType(String type) {

        return navigationRepository.findNavigationsByNaviType(type).stream().map(NavigationDto::new).collect(Collectors.toList());
    }
}
