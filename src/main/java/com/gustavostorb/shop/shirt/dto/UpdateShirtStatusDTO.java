package com.gustavostorb.shop.shirt.dto;

import com.gustavostorb.shop.shirt.enums.ShirtStatus;
import com.gustavostorb.shop.shirt.model.Shirt;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ToString()
@Data
public class UpdateShirtStatusDTO {

    @Pattern(regexp = "AVAILABLE|UNAVAILABLE", message = "Available status: AVAILABLE, UNAVAILABLE")
    @NotNull(message = "Status is required")
    private String status;

    public void updateShirt(Shirt shirt) {
        shirt.setStatus(ShirtStatus.valueOf(status));
    }
}
