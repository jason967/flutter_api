package com.domain.navigation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NavigationRepository extends JpaRepository<Navigations, Long> {
    List<Navigations> findNavigationsByNaviType(String naviType);
}
