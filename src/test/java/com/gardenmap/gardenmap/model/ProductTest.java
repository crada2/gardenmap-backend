package com.gardenmap.gardenmap.model;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.equalTo;

public class ProductTest {

    @Test
    void ProductHaveProperties() {
        Product product = new Product();
        assertThat(product, hasProperty("id"));
    }

}
