package com.service;

import com.domain.Content;
import com.repository.ContentRepository;
import com.web.dto.ContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public List<ContentDto> findAllByViewTypeId(Long viewTypeId) {
        List<Content> contents = contentRepository.findAllByViewType_Id(viewTypeId);

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
