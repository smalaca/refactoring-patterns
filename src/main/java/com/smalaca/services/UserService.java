package com.smalaca.services;

import com.smalaca.domain.User;
import com.smalaca.domain.UserRepository;
import com.smalaca.dto.AddressDto;

class UserService {
    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createAdmin(String login) {
        User user = User.admin(login);
        repository.save(user);

        return user;
    }

    public User createContributor(String login) {
        User user = User.contributor(login);
        repository.save(user);

        return user;
    }

    public User createWatcher(String login) {
        User user = User.watcher(login);
        repository.save(user);

        return user;
    }

    public AddressDto getUserAddress(String id) {
        User user = repository.findById(id);
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(user.getStreet());
        addressDto.setPostalCode(user.getPostalCode());
        addressDto.setCity(user.getCity());
        addressDto.setCountry(user.getCountry());
        return addressDto;
    }
}
