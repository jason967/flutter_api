package com.service;

import com.domain.View;
import com.repository.ViewRepository;
import com.web.dto.ContentDto;
import com.web.dto.ViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ViewServiceImpl implements ViewService {

    private final ViewRepository viewRepository;

    private final ContentServiceImpl contentService;

    @Override
    @Transactional(readOnly = true)
    public List<ViewDto> findAllByTabId(Long tabId, int page, int limited) {

        List<ViewDto> result = new ArrayList<ViewDto>();

        Sort orderByExposePriorityDesc = Sort.by("exposePriority").ascending();
        PageRequest pageRequest = PageRequest.of(page, limited, orderByExposePriorityDesc);

        final List<View> views = viewRepository.findAllByMainTab_Id(tabId, pageRequest);

        for (View view : views) {
            final Long viewId = view.getId();
            List<ContentDto> contents = contentService.findAllByViewId(viewId);
            ViewDto viewDto = new ViewDto(view);
            viewDto.setContents(contents);
            result.add(viewDto);
        }
        return result;
    }

}
