package com.web.controller;

import com.service.MainTabServiceImpl;
import com.web.dto.MainTabDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = MainTabDto.class))),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
@Tag(name = "navigation", description = "각 매장으로 이동할 수 있는 탭의 정보들을 제공한다.")
@RequestMapping("/api/main-tab")
@RequiredArgsConstructor
@RestController
public class MainTabApiController {
    private final MainTabServiceImpl mainTabServiceImpl;

    @GetMapping(value = "", produces = "application/json; charset=utf8")
    public List<MainTabDto> getAllNavigation() {
        return mainTabServiceImpl.findAll();
    }

    @Operation(summary = "get navigation list", description = "네비게이션 타입으로 요청된 navigation list를 가져온다 ")

    @Parameters({
            @Parameter(name = "storetype", description = "네비게이션의 타입 ex> 뷰티 , 추천 ... etc", example = "beauty"),
    })

    @GetMapping(value = "/{storetype}", produces = "application/json; charset=utf8")
    public List<MainTabDto> getAllNavigationByNaviType(@PathVariable(value = "storetype") String storetype) {
        return mainTabServiceImpl.findAllByStoreType(storetype);
    }

}
