package com.domain;

import com.repository.ContentRepository;
import com.repository.MainTabRepository;
import com.repository.StoreTypeRepository;
import com.repository.ViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class dummyTest {

    @Autowired
    private MainTabRepository mainTabRepository;

    @Autowired
    private ViewRepository viewRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private StoreTypeRepository storeTypeRepository;



//    @Test
//    public void generate_sample_data() throws Exception {
//
//        List<String> stores = new ArrayList<>(Arrays.asList("market", "beauty"));
//        List<String> main_tab_market = new ArrayList<>(Arrays.asList("컬리추천", "신상품", "베스트", "알뜰쇼핑", "특가/혜택"));
//        List<String> main_tab_beauty = new ArrayList<>(Arrays.asList("컬리추천", "신상품", "베스트", "특가/혜택", "브랜드관"));
//
//        List<String> views_01 = new ArrayList<>(Arrays.asList("carousel_auto", "carousel", "banner", "product_single", "product_single", "carousel", "banner", "carousel", "carousel", "banner", "carousel", "carousel", "banner", "carousel"));
//        List<String> component_01 = new ArrayList<>(Arrays.asList("image_W375_H400_fitWidth", "product_W140_H210", "image_W375_H60_fitWidth", "image_W335_H120", "image_W335_H120", "product_W140_H210", "image_W375_H60_fitWidth", "product_W140_H210", "product_W140_H210", "image_W375_H60_fitWidth", "product_W140_H210", "product_W140_H210", "image_W375_H60_fitWidth", "product_W140_H210"));
//
//        List<String> views_02 = new ArrayList<>(Arrays.asList("carousel", "banner", "product_single", "product_single", "carousel", "banner", "carousel", "carousel", "banner", "carousel", "carousel", "banner", "carousel"));
//        List<String> component_02 = new ArrayList<>(Arrays.asList("product_W140_H210", "image_W375_H60_fitWidth", "image_W335_H120", "image_W335_H120", "product_W140_H210", "image_W375_H60_fitWidth", "product_W140_H210", "product_W140_H210", "image_W375_H60_fitWidth", "product_W140_H210", "product_W140_H210", "image_W375_H60_fitWidth", "product_W140_H210"));
//
//        for (String storeType : stores) {
//            StoreType market = StoreType.builder().storeType(storeType).build();
//            storeTypeRepository.save(market);
//            for (String main_tab_title : (storeType.equals("market")) ? main_tab_market : main_tab_beauty) {
//                MainTab mainTab = MainTab.builder().title(main_tab_title).build();
//                market.addMainTabs(mainTab);
//                mainTabRepository.save(mainTab);
//                if ("컬리추천".equals(main_tab_title)) {
//                    for (int i = 0; i < 14; i++) {
//                        View view = View.builder()
//                                .view(views_01.get(i))
//                                .component(component_01.get(i))
//                                .build();
//                        mainTab.addView(view);
//                        viewRepository.save(view);
//                        for (int j = 0; j < 8; j++) {
//                            Content content = Content.builder()
//                                    .title(views_01.get(i) + "_title_" + j)
//                                    .price(10000)
//                                    .discount(j * 10)
//                                    .subtitle("content_subtitle_" + j)
//                                    .build();
//                            view.addContent(content);
//                            contentRepository.save(content);
//                        }
//                    }
//                } else {
//                    for (int i = 0; i < 13; i++) {
//                        View view = View.builder()
//                                .view(views_02.get(i))
//                                .component(component_02.get(i))
//                                .build();
//                        mainTab.addView(view);
//                        viewRepository.save(view);
//                        for (int j = 0; j < 8; j++) {
//                            Content content = Content.builder()
//                                    .title(views_02.get(i) + "_title_" + j)
//                                    .price(10000)
//                                    .discount(j * 10)
//                                    .subtitle("content_subtitle_" + j)
//                                    .build();
//                            view.addContent(content);
//                            contentRepository.save(content);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//    @Test
//    public void findViewTypesByNavigationId() throws Exception {
//        int page = 0;
//        int limited = 4;
//        Sort orderByExposePriorityDesc = Sort.by("exposePriority").ascending();
//        PageRequest pageRequest = PageRequest.of(page, limited, orderByExposePriorityDesc);
//
//        List<View> views = viewRepository.findAllByMainTab_Id(Long.valueOf(1000), pageRequest);
//    }
//
//    @Test
//    public void 삭제() throws Exception {
//
////        Long viewTypeId = new Long(1000) ;
//        viewTypeRepository.deleteById(Long.valueOf(1000));
//    }


}