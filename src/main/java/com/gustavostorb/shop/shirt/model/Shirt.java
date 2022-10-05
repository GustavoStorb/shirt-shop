package com.gustavostorb.shop.shirt.model;

import com.gustavostorb.shop.shirt.enums.ShirtStatus;
import com.gustavostorb.shop.shirt.enums.ShirtType;
import lombok.*;

import javax.persistence.*;

@Entity(name = "shirts")
@Getter @Setter
@Data @RequiredArgsConstructor
public class Shirt {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String color;
    private String description;
    private ShirtType type;
    private Double price;
    private ShirtStatus status;

    public Shirt(String title, String color, String description, ShirtType type, Double price, ShirtStatus status) {
        this.title = title;
        this.color = color;
        this.description = description;
        this.type = type;
        this.price = price;
        this.status = status;
    }
}
