package com.service;

import com.web.dto.ViewDto;

import java.util.List;

public interface ViewService {
    List<ViewDto> findAllByTabId(Long navigationId, int page, int limited);
}
