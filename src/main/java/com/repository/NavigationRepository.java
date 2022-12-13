package com.repository;

import com.domain.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NavigationRepository extends JpaRepository<Navigation, Long> {
    List<Navigation> findAllByStoreType_StoreType(String storeType);
}
