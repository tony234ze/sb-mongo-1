package com.zerot.mongo.form_handler.controller;

import com.zerot.mongo.form_handler.repository.UserRepository;
import com.zerot.mongo.form_handler.model.User;
import com.zerot.mongo.form_handler.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<User> createUser(User user) {
        try {
            List<String> invalidFields = Validator.validateUser(user);

            if (!invalidFields.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            User _user = userRepository.save(new User(user.getName(), user.getEmail(), user.getLicenceCode(), user.getExpirationDate()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, User user) {
        try {
            Optional<User> _findUser= userRepository.findById(id);
            if (_findUser.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            User _user = _findUser.get();
            _user.setName(user.getName());
            _user.setEmail(user.getEmail());
            _user.setLicenceCode(user.getLicenceCode());
            _user.setExpirationDate(user.getExpirationDate());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
