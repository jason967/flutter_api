package com.service;

import com.domain.MainTab;
import com.repository.MainTabRepository;
import com.repository.MainTabRepository;
import com.domain.MainTab;
import com.web.dto.MainTabDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MainTabServiceImpl implements MainTabService {
    private final MainTabRepository mainTabRepository;

    @Transactional(readOnly = true)
    public List<MainTabDto> findAll() {

        return mainTabRepository.findAll().stream().map(MainTabDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MainTabDto findById(Long id) {
        MainTab mainTab =
        mainTabRepository.findById(id).get();

        return new MainTabDto(mainTab);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainTabDto> findAllByStoreType(String storeType) {
        return mainTabRepository.findAllByStoreType_StoreType(storeType).stream().map(MainTabDto::new).collect(Collectors.toList());
    }
}
