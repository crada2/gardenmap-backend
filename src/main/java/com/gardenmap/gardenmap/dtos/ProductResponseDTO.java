/*package com.gardenmap.gardenmap.dtos;

import com.gardenmap.gardenmap.model.Product;

public class ProductResponseDTO {

    public Long id;
    public String title;
    public String description;
    public Double price;
    public OwnerResponseDTO owner;

    public ProductResponseDTO mapFromProduct(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.owner = new OwnerResponseDTO().mapFromOwner(product.getOwner());

        return this;
    }
}
 */
