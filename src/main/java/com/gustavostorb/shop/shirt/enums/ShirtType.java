package com.gustavostorb.shop.shirt.enums;

import java.util.Arrays;

public enum ShirtType {

    SHIRT,
    T_SHIRT,
    TANK_TOP;

    public static ShirtType getType(String name) {
        return Arrays.stream(ShirtType.values())
                .filter((shirtType -> shirtType.name().equals(name)))
                .findFirst()
                .orElse(null);
    }
}
