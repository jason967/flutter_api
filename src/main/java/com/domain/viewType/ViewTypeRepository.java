package com.domain.viewType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewTypeRepository extends JpaRepository<ViewType, Long> {
    List<ViewType> findAllByNaviId(int naviId, Pageable pageable);
}
