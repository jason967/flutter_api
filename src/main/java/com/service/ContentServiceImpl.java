package com.service;

import com.domain.Content;
import com.repository.ContentRepository;
import com.web.dto.ContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ContentDto> findAllByViewId(Long viewTypeId) {
        List<Content> contents = contentRepository.findAllByView_Id(viewTypeId);

        List<ContentDto> result = new ArrayList<>();
        for (Content content : contents) {
            int discount = content.getDiscount();
            int sellingPrice = content.getPrice();
            if (discount != 0) {
                sellingPrice = (int) (content.getPrice() * (1 - discount * 0.01));
                if (sellingPrice < 0) sellingPrice = 0;
            }
            ContentDto contentDto = new ContentDto(content);
            contentDto.setSellingPrice(String.format("%,d", sellingPrice));
            result.add(contentDto);
        }
        return result;
    }
}
