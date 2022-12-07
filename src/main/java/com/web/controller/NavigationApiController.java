package com.web.controller;

import com.service.NavigationService;
import com.web.dto.NavigationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NavigationApiController {
    private final NavigationService navigationService;

    @GetMapping(value = "/api/navigation", produces = "application/json; charset=utf8")
    public List<NavigationDto> getAllNavigation() {
        return navigationService.findAll();
    }

    @GetMapping(value = "/api/navigation", produces = "application/json; charset=utf8", params = {"type"})
    public List<NavigationDto> getAllNavigationByNaviType(@RequestParam(value = "type") String type) {
        return navigationService.findAllNaviType(type);
    }

    @GetMapping("/api/navigation/{id}")
    public NavigationDto findById(@PathVariable Long id) {
        return navigationService.findById(id);
    }

}
