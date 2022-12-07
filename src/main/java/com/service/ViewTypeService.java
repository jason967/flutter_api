package com.service;

import com.domain.viewType.ViewTypeRepository;
import com.web.dto.ViewTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ViewTypeService {

    private final ViewTypeRepository viewTypeRepository;

    @Transactional(readOnly = true)
    public List<ViewTypeDto> findAllNaviType(int naviId, int page, int limited) {
        Sort orderByExposePriorityDesc = Sort.by("exposePriority").ascending();
        PageRequest pageRequest = PageRequest.of(page, limited, orderByExposePriorityDesc);

        return viewTypeRepository.findAllByNaviId(naviId, pageRequest).stream().map(ViewTypeDto::new).collect(Collectors.toList());
    }
}
