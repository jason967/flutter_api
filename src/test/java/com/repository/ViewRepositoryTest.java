package com.repository;

import com.domain.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ViewRepositoryTest {

    @Autowired
    private ViewRepository viewRepository;

    @AfterEach
    void cleanUpData(){
        viewRepository.deleteAll();
    }
    @Test
    void findAllByNaviId() {
        int naviId = 100;
        for(int i=1;i<=10;i++) {
            String view = "auto_carousel_0"+i;
            String description = "viewType_test_0"+i;
            String component = "product_0"+i;
            int exposePriority = i;
            ///save : 존재 O-> update, 존재 X -> insert & update
            viewRepository.save(View.builder()
//                    .naviId(naviId)
                    .view(view)
                    .description(description)
                    .exposePriority(exposePriority)
                    .component(component)
                    .build());
        }
        Sort orderByExposePriorityDesc = Sort.by("exposePriority").ascending();
        PageRequest pageRequest = PageRequest.of(0,10, orderByExposePriorityDesc);

        //when
//        List<ViewType> viewTypeList = viewTypeRepository.findAllByNaviId(naviId,pageRequest);
        System.out.println("야호 ----------------------------------------");

//        for(ViewType viewType:viewTypeList){
//            System.out.println(viewType.getExposePriority());
//        }

    }
}