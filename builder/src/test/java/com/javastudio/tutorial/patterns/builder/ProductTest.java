package com.javastudio.tutorial.patterns.builder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;
import static org.assertj.core.util.DateUtil.monthOf;
import static org.assertj.core.util.DateUtil.parse;
import static org.assertj.core.util.DateUtil.parseDatetime;
import static org.assertj.core.util.DateUtil.parseDatetimeWithMs;
import static org.assertj.core.util.DateUtil.tomorrow;
import static org.assertj.core.util.DateUtil.yesterday;

class ProductTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTest.class);

    @Test
    void whenCreateWithProductBuilder_thenAllFieldsShouldBeTheSame() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Product product = new Product.Builder("Nail")
                .orderDate(dateFormat.parse("2019-10-13"))
                .price(100)
                .build();
        assertThat(product.getName()).startsWith("Nail");
        assertThat(product.getOrderDate()).isEqualTo(parse("2019-10-13"));
        assertThat(product.getPrice()).isEqualTo(100);
    }
}