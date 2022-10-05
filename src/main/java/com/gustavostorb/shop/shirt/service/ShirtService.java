package com.gustavostorb.shop.shirt.service;

import com.gustavostorb.shop.shirt.dto.CreateShirtDTO;
import com.gustavostorb.shop.shirt.dto.UpdateShirtDTO;
import com.gustavostorb.shop.shirt.dto.UpdateShirtStatusDTO;
import com.gustavostorb.shop.shirt.enums.ShirtStatus;
import com.gustavostorb.shop.shirt.enums.ShirtType;
import com.gustavostorb.shop.shirt.model.Shirt;
import com.gustavostorb.shop.shirt.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ShirtService {

    @Autowired
    private ShirtRepository shirtRepository;

    public List<Shirt> findAll() {
        return this.shirtRepository.findAll();
    }
    public List<Shirt> findAllByStatus(ShirtStatus status) {
        return this.shirtRepository.findAllByStatus(status);
    }
    public List<Shirt> findAllByType(String type) {
        ShirtType shirtType = ShirtType.getType(type);
        if(shirtType == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Available types: SHIRT, T_SHIRT, TANK_TOP.");
        }

        return this.shirtRepository.findAllByType(shirtType);
    }
    public Shirt findById(Long id) {
        Optional<Shirt> shirt = this.shirtRepository.findById(id);

        if(!shirt.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This shirt does not exists.");
        }

        return shirt.get();
    }
    public Shirt store(CreateShirtDTO createShirtDTO) {
        if(createShirtDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        Shirt shirt = createShirtDTO.toShirt();
        return this.shirtRepository.save(shirt);
    }
    public Shirt update(Long id, UpdateShirtDTO updateShirtDTO) {
        if(updateShirtDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        Shirt shirt = this.shirtRepository.findById(id).orElse(null);
        if(shirt == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This shirt does not exists.");
        }

        updateShirtDTO.updateShirt(shirt);
        this.shirtRepository.save(shirt);
        return shirt;
    }
    public Shirt updateStatus(Long id, UpdateShirtStatusDTO updateShirtStatusDTO) {
        if(updateShirtStatusDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        Shirt shirt = this.shirtRepository.findById(id).orElse(null);
        if(shirt == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This shirt does not exists.");
        }

        updateShirtStatusDTO.updateShirt(shirt);
        this.shirtRepository.save(shirt);
        return shirt;
    }
    public void delete(Long id){
        Optional<Shirt> shirt = this.shirtRepository.findById(id);
        if(shirt.isPresent()) {
            shirtRepository.deleteById(id);
        }
    }

}
