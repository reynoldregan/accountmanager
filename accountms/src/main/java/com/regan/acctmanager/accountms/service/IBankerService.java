package com.regan.acctmanager.accountms.service;

import com.regan.acctmanager.accountms.dto.BankerDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBankerService {
    List<BankerDTO> getAllBankers();
    Optional<BankerDTO> getBankerById(UUID id);
    BankerDTO saveBanker(BankerDTO productDTO);
    BankerDTO updateBanker(UUID id, BankerDTO productDTO);
    void deleteBanker(UUID id);
}
