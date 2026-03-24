package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.PageRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PageResponseDto;

import java.util.List;

public interface PageService {


    PageResponseDto addPage(PageRequestDto userRequestDto);
    PageResponseDto getPageById(Long id);
    List<PageResponseDto> getAllPage();
    PageResponseDto updatePage(Long id,PageRequestDto userRequestDto);
    GenericResponseDto removePageById(Long id);
}
