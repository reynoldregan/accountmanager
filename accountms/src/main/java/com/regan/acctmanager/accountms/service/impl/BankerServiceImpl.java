package com.regan.acctmanager.accountms.service.impl;

import com.regan.acctmanager.accountms.dto.BankerDTO;
import com.regan.acctmanager.accountms.model.Banker;
import com.regan.acctmanager.accountms.repository.BankerRepository;
import com.regan.acctmanager.accountms.service.IBankerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BankerServiceImpl implements IBankerService {

    private final BankerRepository m_BankerRepo;

    public BankerServiceImpl(BankerRepository p_BankerRepo) {
        this.m_BankerRepo = p_BankerRepo;
    }

    @Override
    public List<BankerDTO> getAllBankers() {
        return m_BankerRepo.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());    }

    @Override
    public Optional<BankerDTO> getBankerById(UUID id) {
        return m_BankerRepo.findById(id).map(this::convertEntityToDTO);
    }

    @Override
    public BankerDTO saveBanker(BankerDTO bankerDTO) {
        Banker banker = convertToEntity(bankerDTO);
        Banker savedBanker =  m_BankerRepo.save(banker);
        return convertEntityToDTO(savedBanker);
    }

    @Override
    public BankerDTO updateBanker(UUID id, BankerDTO bankerDTO) {
        Banker banker = m_BankerRepo.findById(id).orElseThrow();
        banker.setBank_name(bankerDTO.bank_name());
        banker.setBranch(bankerDTO.branch());
        banker.setCustomer_id(bankerDTO.customer_id());
        banker.setIfsc_code(bankerDTO.ifsc_code());
        Banker updatedBanker = m_BankerRepo.save(banker);
        return convertEntityToDTO(updatedBanker);
    }

    @Override
    public void deleteBanker(UUID id) {
        m_BankerRepo.deleteById(id);
    }

    BankerDTO convertEntityToDTO(Banker banker) {
        return new BankerDTO(banker.getSysUUID(),
                banker.getCustomer_id(),
                banker.getBank_name(),
                banker.getIfsc_code(),
                banker.getBranch());
    }

    Banker convertToEntity(BankerDTO bankerDTO){
        Banker banker = new Banker();
        banker.setBank_name(bankerDTO.bank_name());
        banker.setBranch(bankerDTO.branch());
        banker.setCustomer_id(bankerDTO.customer_id());
        banker.setIfsc_code(bankerDTO.ifsc_code());
        return banker;
    }
}
