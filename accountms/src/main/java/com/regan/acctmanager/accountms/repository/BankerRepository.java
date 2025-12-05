package com.regan.acctmanager.accountms.repository;

import com.regan.acctmanager.accountms.model.Banker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankerRepository extends JpaRepository<Banker, UUID> {
}
