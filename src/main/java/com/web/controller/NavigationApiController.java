package com.web.controller;

import com.service.NavigationService;
import com.web.dto.NavigationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "navigation", description = "각 매장으로 이동할 수 있는 탭의 정보들을 제공한다.")
@RequestMapping("/api/navigation")
@RequiredArgsConstructor
@RestController
public class NavigationApiController {
    private final NavigationService navigationService;

    @GetMapping(value = "", produces = "application/json; charset=utf8")
    public List<NavigationDto> getAllNavigation() {
        return navigationService.findAll();
    }

    @Operation(summary = "get navigation list", description = "네비게이션 타입으로 요청된 navigation list를 가져온다 ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = NavigationDto.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "type", description = "네비게이션의 타입 ex> 뷰티 , 추천 ... etc", example = "beauty"),
    })
    @GetMapping(value = "", produces = "application/json; charset=utf8", params = {"type"})
    public List<NavigationDto> getAllNavigationByNaviType(@RequestParam(value = "type") String type) {
        return navigationService.findAllNaviType(type);
    }

}
