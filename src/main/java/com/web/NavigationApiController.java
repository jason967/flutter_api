package com.web;

import com.service.NavigationService;
import com.web.dto.NavigationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NavigationApiController {
    private final NavigationService navigationService;

    @GetMapping("/api/navigation")
    public List<NavigationDto> getAllNavigation() {
        System.out.println("asdasdasd->"+navigationService.toString());

        return navigationService.findAll();
    }

    @GetMapping("/api/navigation/{id}")
    public NavigationDto findById(@PathVariable Long id) {
        return navigationService.findById(id);
    }

}
