package com.myorg.vibehub.repository;

import com.myorg.vibehub.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletReposetory extends JpaRepository<Wallet,Long> {
}
