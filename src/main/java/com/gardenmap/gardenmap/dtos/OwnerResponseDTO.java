package com.gardenmap.gardenmap.dtos;

import com.gardenmap.gardenmap.model.Owner;

public class OwnerResponseDTO {
    public Long id;
    public String name;
    public String email;

    public OwnerResponseDTO mapFromOwner(Owner owner) {
        this.id = owner.getId();
        this.name = owner.getName();
        this.email = owner.getEmail();
        return this;
    }
}
