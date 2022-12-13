package com.service;

import com.web.dto.ContentDto;

import java.util.List;

public interface ContentService {
    List<ContentDto> findAllByViewTypeId(Long viewTypeId);
}
