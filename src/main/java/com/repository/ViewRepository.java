package com.repository;

import com.domain.View;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewRepository extends JpaRepository<View, Long> {
//    List<ViewType> findAllByN (int naviId, Pageable pageable);
    List<View> findAllByMainTab_Id(Long id, Pageable pageable);
}
