package com.regan.acctmanager.accountms.controller;

import com.regan.acctmanager.accountms.dto.BankerDTO;
import com.regan.acctmanager.accountms.service.IBankerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/banker")
public class BankerController {

    private final IBankerService bankerService;

    public BankerController(IBankerService bankerService) {
        this.bankerService = bankerService;
    }

    @GetMapping
    public List<BankerDTO> getAllBankers(){
        return bankerService.getAllBankers();
    }

    @GetMapping("{id}")
    public ResponseEntity<BankerDTO> getBankerById(@PathVariable UUID id){
        Optional<BankerDTO> banker = bankerService.getBankerById(id);
        return banker.map(ResponseEntity::ok).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BankerDTO createProduct(@RequestBody BankerDTO bankerDTO) {
        return bankerService.saveBanker(bankerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankerDTO> updateProduct(@PathVariable UUID id, @RequestBody BankerDTO bankerDTO) {
        try {
            BankerDTO updatedProduct = bankerService.updateBanker(id, bankerDTO);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
