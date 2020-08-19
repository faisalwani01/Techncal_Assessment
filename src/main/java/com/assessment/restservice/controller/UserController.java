package com.assessment.restservice.controller;

import com.assessment.restservice.exceptions.FeatureNotFoundException;
import com.assessment.restservice.exceptions.UserNotFoundException;
import com.assessment.restservice.model.PermissionStatus;
import com.assessment.restservice.model.UserFeatureDTO;
import com.assessment.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.BASE_URL)
class UserController {

    static final String BASE_URL = "/api/v1";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "feature", method = RequestMethod.GET)
    public @ResponseBody
    PermissionStatus getUserPermission(@RequestParam("email") String email, @RequestParam("featureName") String featureName) throws UserNotFoundException, FeatureNotFoundException {
        return userService.getUserPermission(email, featureName);
    }

    @PostMapping("/feature")
    public ResponseEntity<Object> saveUserPermission(@RequestBody UserFeatureDTO userFeatureDTO) throws UserNotFoundException, FeatureNotFoundException {
        if (userService.saveUserPermission(userFeatureDTO)) {
           return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}
