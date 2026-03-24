package com.myorg.vibehub.repository;

import com.myorg.vibehub.model.SocialMediaPage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class PageRepository {

    //Dummy DB for page
    private Map<Long , SocialMediaPage> socialMediaPages = new HashMap<>();

    private static Long currentPageID = 0L;

    //adding Page
    // it is receiving User SocialMediaPage object(POJO) from service layer

    public SocialMediaPage addPage(SocialMediaPage socialMediaPage) {
        Long id = ++currentPageID;
        socialMediaPage.setId(id);

        socialMediaPages.put(id, socialMediaPage);

        return socialMediaPages.get(id);

    }

    public SocialMediaPage getPage(Long id) {

        return socialMediaPages.get(id);

    }

    public List<SocialMediaPage> getAllSocialMediaPage() {

        return new LinkedList<>(socialMediaPages.values());

    }

    public SocialMediaPage updatePage(SocialMediaPage socialMediaPage) {

        if(socialMediaPage.getId()!= null){

            socialMediaPages.put(socialMediaPage.getId(), socialMediaPage);

        }

        return socialMediaPages.get(socialMediaPage.getId());

    }

    public void removePage(Long id) {

        socialMediaPages.remove(id);
    }
}
