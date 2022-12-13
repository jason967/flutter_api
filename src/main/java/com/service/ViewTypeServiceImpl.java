package com.service;

import com.domain.ViewType;
import com.repository.ViewTypeRepository;
import com.web.dto.ContentDto;
import com.web.dto.ViewTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ViewTypeServiceImpl implements ViewTypeService {

    private final ViewTypeRepository viewTypeRepository;

    private final ContentServiceImpl contentService;

    @Override
    @Transactional(readOnly = true)
    public List<ViewTypeDto> findAllByNavigationId(Long navigationId, int page, int limited) {

        List<ViewTypeDto> result = new ArrayList<ViewTypeDto>();

        Sort orderByExposePriorityDesc = Sort.by("exposePriority").ascending();
        PageRequest pageRequest = PageRequest.of(page, limited, orderByExposePriorityDesc);

        final List<ViewType> viewTypes = viewTypeRepository.findAllByNavigation_Id(navigationId, pageRequest);

        for (ViewType viewType : viewTypes) {
            final Long viewTypeId = viewType.getId();
            List<ContentDto> contents = contentService.findAllByViewTypeId(viewTypeId);
            ViewTypeDto viewTypeDto = new ViewTypeDto(viewType);
            viewTypeDto.setContents(contents);
            result.add(viewTypeDto);
        }
        return result;
    }

}
