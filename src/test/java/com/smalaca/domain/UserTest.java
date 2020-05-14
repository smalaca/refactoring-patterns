package com.smalaca.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserTest {
    private static final String LOGIN = UUID.randomUUID().toString();

    @Test
    void shouldContainAddress() {
        User admin = User.admin(LOGIN);
        String street = UUID.randomUUID().toString();
        String postalCode = UUID.randomUUID().toString();
        String city = UUID.randomUUID().toString();
        String country = UUID.randomUUID().toString();

        admin.changeAddress(street, postalCode, city, country);

        Assertions.assertThat(admin.getAddressDto().getCity()).isEqualTo(city);
        Assertions.assertThat(admin.getAddressDto().getCountry()).isEqualTo(country);
        Assertions.assertThat(admin.getAddressDto().getStreet()).isEqualTo(street);
        Assertions.assertThat(admin.getAddressDto().getPostalCode()).isEqualTo(postalCode);
    }
}