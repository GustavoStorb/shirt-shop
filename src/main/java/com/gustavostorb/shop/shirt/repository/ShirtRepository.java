package com.gustavostorb.shop.shirt.repository;

import com.gustavostorb.shop.shirt.enums.ShirtStatus;
import com.gustavostorb.shop.shirt.enums.ShirtType;
import com.gustavostorb.shop.shirt.model.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Long> {

    List<Shirt> findAll();
    List<Shirt> findAllByStatus(ShirtStatus status);
    List<Shirt> findAllByType(ShirtType type);

}
