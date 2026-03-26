package com.myorg.vibehub.repository;

import com.myorg.vibehub.model.SocialMediaPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<SocialMediaPage,Long> {

}
