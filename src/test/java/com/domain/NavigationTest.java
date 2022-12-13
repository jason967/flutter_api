package com.domain;

import com.repository.ContentRepository;
import com.repository.NavigationRepository;
import com.repository.StoreTypeRepository;
import com.repository.ViewTypeRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NavigationTest {

    @Autowired
    private NavigationRepository navigationRepository;

    @Autowired
    private ViewTypeRepository viewTypeRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private StoreTypeRepository storeTypeRepository;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    //    @BeforeEach
    @Test
    public void 연관관계_주인() throws Exception {

        List<String> stores = new ArrayList<>(Arrays.asList("market", "beauty"));
        List<String> navigations_1 = new ArrayList<>(Arrays.asList("컬리추천", "신상품", "베스트", "알뜰쇼핑", "특가/혜택"));
        List<String> navigations_2 = new ArrayList<>(Arrays.asList("컬리추천", "신상품", "베스트", "특가/혜택", "브랜드관"));

        for (String store : stores) {
            StoreType market = StoreType.builder().storeType(store).build();
            storeTypeRepository.save(market);
            if (store.contains("market")) {
                for (String navi_title : navigations_1) {
                    Navigation navigation = Navigation.builder().title(navi_title).build();
                    market.addNavigation(navigation);
                    navigationRepository.save(navigation);
                    for (int i = 0; i <= 10; i++) {
                        ViewType viewType = ViewType.builder()
                                .viewType("viewType_" + i)
                                .title("viewType_title_" + i)
                                .component("viewType_component_" + i)
                                .build();
                        navigation.addViewType(viewType);
                        viewTypeRepository.save(viewType);
                        for (int j = 100; j <= 110; j++) {
                            Content content = Content.builder()
                                    .title("content_title_" + j)
                                    .subtitle("content_subtitle_" + i)
                                    .build();
                            viewType.addContent(content);
                            contentRepository.save(content);
                        }
                    }
                }
            } else {
                for (String navi_title : navigations_2) {
                    Navigation navigation = Navigation.builder().title(navi_title).build();
                    market.addNavigation(navigation);
                    navigationRepository.save(navigation);
                    for (int i = 0; i <= 10; i++) {
                        ViewType viewType = ViewType.builder()
                                .viewType("viewType_" + i)
                                .title("viewType_title_" + i)
                                .component("viewType_component_" + i)
                                .build();
                        navigation.addViewType(viewType);
                        viewTypeRepository.save(viewType);
                        for (int j = 100; j <= 110; j++) {
                            Content content = Content.builder()
                                    .title("content_title_" + j)
                                    .subtitle("content_subtitle_" + i)
                                    .build();
                            viewType.addContent(content);
                            contentRepository.save(content);
                        }
                    }
                }
            }

        }

//
//        StoreType market = StoreType.builder().storeType("market").build();
//        storeTypeRepository.save(market);
//        Navigation n_1 = Navigation.builder().title("컬리추천").build();
//        navigationRepository.save(n_1);
//        for (int i = 0; i <= 10; i++) {
//            ViewType viewType = ViewType.builder()
//                    .viewType("viewType_" + i)
//                    .title("viewType_title_"+i)
//                    .component("viewType_component_"+i)
//                    .build();
//            n_1.addViewType(viewType);
//            viewTypeRepository.save(viewType);
//            for (int j = 100; j <= 110; j++) {
//                Content content = Content.builder()
//                        .title("content_title_" + j)
//                        .subtitle("content_subtitle_"+i)
//                        .build();
//                viewType.addContent(content);
//                contentRepository.save(content);
//            }
//        }
//
//        Navigation navigation = Navigation.builder()
//                .title("테스트 1")
//                .build();
//        navigationRepository.save(navigation);
//        for (int i = 0; i <= 10; i++) {
//            ViewType viewType = ViewType.builder()
//                    .viewType("viewType_test_" + i)
//                    .build();
//            navigation.addViewType(viewType);
//            viewTypeRepository.save(viewType);
//            for (int j = 100; j <= 110; j++) {
//                Content content = Content.builder().title("content_test_" + j).build();
//                viewType.addContent(content);
//                contentRepository.save(content);
//            }
//        }
    }

    @Test
    public void findViewTypesByNavigationId() throws Exception {

        List<ViewType> viewTypes = viewTypeRepository.findAllByNavigation_Id(Long.valueOf(1000));
        for (ViewType viewType : viewTypes) {
//            System.out.println("[test]"+viewType.getViewType());
            originalOut.println("[test]" + viewType.getViewType());
        }
    }

    @Test
    public void 삭제() throws Exception {

//        Long viewTypeId = new Long(1000) ;
        viewTypeRepository.deleteById(Long.valueOf(1000));
    }


}