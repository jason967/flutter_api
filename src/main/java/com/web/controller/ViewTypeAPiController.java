package com.web.controller;

import com.service.ViewTypeService;
import com.web.dto.ViewTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ViewTypeAPiController {
    private final ViewTypeService viewTypeService;

    @GetMapping(value = "/api/viewtypes/{naviId}", produces = "application/json; charset=utf8")
    public List<ViewTypeDto> getAllViewTypesByNaviId(@PathVariable int naviId, @RequestParam int page) {
        int limited = 4;

        return viewTypeService.findAllNaviType(naviId, page, limited);
    }

}



