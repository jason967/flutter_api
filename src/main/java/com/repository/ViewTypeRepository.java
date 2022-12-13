package com.repository;

import com.domain.ViewType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewTypeRepository extends JpaRepository<ViewType, Long> {
//    List<ViewType> findAllByN (int naviId, Pageable pageable);
    List<ViewType> findAllByNavigation_Id(Long id,Pageable pageable);
}
