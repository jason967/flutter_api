package com.domain.navigation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NavigationRepositoryTest {
    @Autowired
    private NavigationRepository navigationRepository;

    @AfterEach
    public void deleteAll(){
        navigationRepository.deleteAll();
    }

    @Test
    public void get_saved_navigation(){
        int naviId = 1234;
        String title ="컬리추천";
        String subtitle="자신있게 추천해요";
        String apiUrl = "https://www.naver.com";
        ///save : 존재 O-> update, 존재 X -> insert & update
        navigationRepository.save(Navigation.builder()
                .naviId(naviId)
                .title(title)
                .subtitle(subtitle)
                .apiUrl(apiUrl)
                .build());

        //when
        List<Navigation> navigationsList = navigationRepository.findAll();

        Navigation navigation = navigationsList.get(0);
        assertThat(navigation.getNaviId()).isEqualTo(naviId);
        assertThat(navigation.getTitle()).isEqualTo(title);

    }

    @Test
    public void get_navigation(){
        //given
        int naviId = 1234;
        String title ="컬리추천";
        String subtitle="자신있게 추천해요";
        String apiUrl = "https://www.naver.com";

        ///save : 존재 O-> update, 존재 X -> insert & update
        navigationRepository.save(Navigation.builder()
                .naviId(naviId)
                .title(title)
                .subtitle(subtitle)
                .apiUrl(apiUrl)
                .build());
        //when
        List<Navigation> navigationList = navigationRepository.findAll();

        Navigation navigation = navigationList.get(0);
        assertThat(navigation.getNaviId()).isEqualTo(naviId);
        assertThat(navigation.getTitle()).isEqualTo(title);
        assertThat(navigation.getSubtitle()).isEqualTo(subtitle);
        assertThat(navigation.getApiUrl()).isEqualTo(apiUrl);

    }


}