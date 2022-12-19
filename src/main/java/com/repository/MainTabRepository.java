package com.repository;

import com.domain.MainTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MainTabRepository extends JpaRepository<MainTab, Long> {
    List<MainTab> findAllByStoreType_StoreType(String storeType);
}
