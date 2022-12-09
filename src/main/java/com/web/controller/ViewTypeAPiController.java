package com.web.controller;

import com.service.ViewTypeService;
import com.web.dto.ViewTypeDto;
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


@Tag(name = "view_type", description = "해당 매장의 구좌 리스트를 제공한다.")
@RequestMapping("/api/viewtype")
@RequiredArgsConstructor
@RestController
public class ViewTypeAPiController {
    private final ViewTypeService viewTypeService;

    @Operation(summary = "get view_type list", description = "{navi Id}로 요청된 view_type list를 가져온다 ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ViewTypeDto.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "naviId", description = "네비게이션의 아이디 ex> 100(기본), 101, 102 ... ", example = "100"),
            @Parameter(name = "page", description = "lazy load를 위한 현재의 page", example = "0"),
    })

    @GetMapping(value = "/{naviId}", produces = "application/json; charset=utf8")
    public List<ViewTypeDto> getAllViewTypesByNaviId(@PathVariable int naviId, @RequestParam int page) {
        int limited = 4;

        return viewTypeService.findAllNaviType(naviId, page, limited);
    }

}



