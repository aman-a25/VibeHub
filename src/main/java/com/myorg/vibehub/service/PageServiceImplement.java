package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.PageRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PageResponseDto;
import com.myorg.vibehub.model.SocialMediaPage;
import com.myorg.vibehub.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Service
public class PageServiceImplement implements PageService {

    @Autowired
    private PageRepository pageRepository;
    @Override
    public PageResponseDto addPage(PageRequestDto pageRequestDto) {

        SocialMediaPage socialMediaPage =mapPageRequestDtoToPage(pageRequestDto);
        socialMediaPage.setCreatedDate(Instant.now());
        return mapPageToPageResponseDto(pageRepository.save(socialMediaPage));

    }

    @Override
    public PageResponseDto getPageById(Long id) {

        SocialMediaPage socialMediaPage = pageRepository.findById(id).orElse(null);

        if (socialMediaPage == null) {
            return null;
        }
        return mapPageToPageResponseDto(socialMediaPage);
    }

    @Override
    public List<PageResponseDto> getAllPage() {
        List<SocialMediaPage>  socialMediaPageList = pageRepository.findAll();

        List<PageResponseDto> pageResponseDtoList = new LinkedList<>();
        for(SocialMediaPage page : socialMediaPageList){
            pageResponseDtoList.add(mapPageToPageResponseDto(page));
        }
        return pageResponseDtoList;
    }

    @Override
    public PageResponseDto updatePage(Long id, PageRequestDto pageRequestDto) {
        SocialMediaPage socialMediaPage = mapPageRequestDtoToPage(pageRequestDto);
        socialMediaPage.setId(id);
        return mapPageToPageResponseDto(pageRepository.save(socialMediaPage));
    }

    @Override
    public GenericResponseDto removePageById(Long id) {

        SocialMediaPage socialMediaPage = pageRepository.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();

        if (socialMediaPage != null) {

            pageRepository.delete(socialMediaPage);

            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage("Remove page successfully");

        }else{
            genericResponseDto.setSuccess(false);
            genericResponseDto.setMessage("Remove page failed / page not found");
        }

        return genericResponseDto;


    }

    //helper methods
    // Map User to UserResponseDto
    private PageResponseDto mapPageToPageResponseDto(SocialMediaPage socialMediaPage) {

        PageResponseDto pageResponseDto = new PageResponseDto();

        pageResponseDto.setId(socialMediaPage.getId());
        pageResponseDto.setName(socialMediaPage.getName());
        pageResponseDto.setPageCatagory(socialMediaPage.getPageCatagory());
        pageResponseDto.setDescription(socialMediaPage.getDescription());
        pageResponseDto.setCreatedDate(socialMediaPage.getCreatedDate());

        return pageResponseDto;

    }

    //Map UserRequestDto to user
    private SocialMediaPage mapPageRequestDtoToPage(PageRequestDto userRequestDto) {

        SocialMediaPage page = new SocialMediaPage();
        page.setName(userRequestDto.getName());
        page.setPageCatagory(userRequestDto.getPageCatagory());
        page.setDescription(userRequestDto.getDescription());
        page.setPassword(userRequestDto.getPassword());


        return page;
    }

}
