package com.gustavostorb.shop.shirt.dto;

import com.gustavostorb.shop.shirt.enums.ShirtStatus;
import com.gustavostorb.shop.shirt.enums.ShirtType;
import com.gustavostorb.shop.shirt.model.Shirt;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@ToString()
@Data
public class CreateShirtDTO {

    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Color is required")
    private String color;

    @NotNull(message = "Description is required")
    private String description;

    @Pattern(regexp = "SHIRT|T_SHIRT|TANK_TOP", message = "Available types: SHIRT, T_SHIRT, TANK_TOP")
    @NotNull(message = "Type is required")
    private String type;

    @Digits(integer = 5, fraction = 2, message = "Not a valid price")
    @Positive
    @NotNull()
    private Double price;

    @Pattern(regexp = "AVAILABLE|UNAVAILABLE", message = "Available status: AVAILABLE, UNAVAILABLE")
    @NotNull(message = "Status is required")
    private String status;

    public Shirt toShirt() {
        return new Shirt(
                this.title,
                this.color,
                this.description,
                ShirtType.valueOf(this.type),
                this.price,
                ShirtStatus.valueOf(this.status)
        );
    }
}
