package com.assessment.restservice.dao;

import com.assessment.restservice.dao.repository.UserRepository;
import com.assessment.restservice.exceptions.UserNotFoundException;
import com.assessment.restservice.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> find(long id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    public UserEntity findByEmailAddressOrDie(String emailAddress) throws UserNotFoundException {
        return findByEmailAddress(emailAddress).orElseThrow(() -> new UserNotFoundException("User with email address " + emailAddress + " does not exist."));
    }
}
