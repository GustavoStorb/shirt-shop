package com.gustavostorb.shop.shirt.controller;

import com.gustavostorb.shop.shirt.dto.CreateShirtDTO;
import com.gustavostorb.shop.shirt.dto.UpdateShirtDTO;
import com.gustavostorb.shop.shirt.dto.UpdateShirtStatusDTO;
import com.gustavostorb.shop.shirt.enums.ShirtStatus;
import com.gustavostorb.shop.shirt.model.Shirt;
import com.gustavostorb.shop.shirt.service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shirts")
public class ShirtController {

    @Autowired
    public ShirtService shirtService;

    @GetMapping()
    public ResponseEntity<List<Shirt>> findAll() {
        return ResponseEntity.ok(this.shirtService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Shirt> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.shirtService.findById(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Shirt>> findAllByType(@PathVariable String type) {
        return ResponseEntity.ok(this.shirtService.findAllByType(type));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Shirt>> findAllAvailable() {
        return ResponseEntity.ok(this.shirtService.findAllByStatus(ShirtStatus.AVAILABLE));
    }

    @PostMapping()
    public ResponseEntity<Shirt> store(@Valid @RequestBody CreateShirtDTO createShirtDTO) {
        return new ResponseEntity<>(this.shirtService.store(createShirtDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Shirt> update(@PathVariable Long id, @Valid @RequestBody UpdateShirtDTO updateShirtDTO){
        return new ResponseEntity<>(this.shirtService.update(id, updateShirtDTO), HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Shirt> updateStatus(@PathVariable Long id, @Valid @RequestBody UpdateShirtStatusDTO updateShirtStatusDTO){
        return new ResponseEntity<>(this.shirtService.updateStatus(id, updateShirtStatusDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Shirt> delete(@PathVariable Long id) {
        shirtService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
