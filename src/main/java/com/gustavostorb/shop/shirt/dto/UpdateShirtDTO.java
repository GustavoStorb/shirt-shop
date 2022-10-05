package com.gustavostorb.shop.shirt.dto;

import com.gustavostorb.shop.shirt.enums.ShirtType;
import com.gustavostorb.shop.shirt.model.Shirt;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@ToString()
@Data
public class UpdateShirtDTO {

    private String title;
    private String color;
    private String description;

    @Pattern(regexp = "SHIRT|T_SHIRT|TANK_TOP", message = "Available types: SHIRT, T_SHIRT, TANK_TOP")
    private String type;

    @Digits(integer = 5, fraction = 2, message = "Not a valid price")
    @Positive
    private Double price;

    public void updateShirt(Shirt shirt) {
        if(this.title != null) {
            shirt.setTitle(this.title);
        }

        if(this.color != null) {
            shirt.setColor(this.color);
        }

        if(this.description != null) {
            shirt.setDescription(this.description);
        }

        if(this.type != null) {
            shirt.setType(ShirtType.valueOf(this.type));
        }

        if(this.price != null) {
            shirt.setPrice(shirt.getPrice());
        }
    }
}
