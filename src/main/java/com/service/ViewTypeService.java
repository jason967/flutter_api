package com.service;

import com.domain.ViewType;
import com.web.dto.ViewTypeDto;

import java.awt.print.Pageable;
import java.util.List;

public interface ViewTypeService {
    List<ViewTypeDto> findAllByNavigationId(Long navigationId, int page, int limited);
}
