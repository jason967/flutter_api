package com.domain.navigation;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Navigation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int naviId;
    private String title;
    private String subtitle;
    private String apiUrl;
    private String naviType;


    @Builder
    public Navigation(int naviId, String title, String subtitle, String apiUrl, String naviType) {
        this.naviId = naviId;
        this.title = title;
        this.subtitle = subtitle;
        this.apiUrl = apiUrl;
        this.naviType = naviType;
    }
}
