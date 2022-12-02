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
public class Navigations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int naviId;
    private String title;
    private String subtitle;
    private String apiUrl;

    @Builder
    public Navigations(int naviId, String title, String subtitle, String apiUrl) {
        this.naviId = naviId;
        this.title = title;
        this.subtitle = subtitle;
        this.apiUrl = apiUrl;
    }
}
