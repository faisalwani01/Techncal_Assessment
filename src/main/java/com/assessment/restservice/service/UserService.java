package com.assessment.restservice.service;


import com.assessment.restservice.Entity.Features;
import com.assessment.restservice.Entity.UserEntity;
import com.assessment.restservice.Entity.UserFeatureEntity;
import com.assessment.restservice.dao.UserDao;
import com.assessment.restservice.exceptions.FeatureNotFoundException;
import com.assessment.restservice.exceptions.UserNotFoundException;
import com.assessment.restservice.model.PermissionStatus;
import com.assessment.restservice.model.UserFeatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private UserFeatureService userFeatureService;

    public Optional<UserEntity> getUser(long id) {
        return userDao.find(id);
    }

    public PermissionStatus getUserPermission(String emailAddress, String featureName) throws UserNotFoundException, FeatureNotFoundException {
        UserEntity userEntity = userDao.findByEmailAddressOrDie(emailAddress);
        Features features = featureService.findByFeatureNameOrDie(featureName);

        Optional<UserFeatureEntity> userFeatureEntity = userFeatureService.findUserFeatureEntitiesByUserIdAndFeatureId(userEntity.getId(), features.getId());

        return new PermissionStatus(userFeatureEntity.isPresent() && userFeatureEntity.get().isStatus()) ;
    }

    public boolean saveUserPermission(UserFeatureDTO userFeatureDTO) throws UserNotFoundException, FeatureNotFoundException {
        UserEntity userEntity = userDao.findByEmailAddressOrDie(userFeatureDTO.getEmail());
        Features features = featureService.findByFeatureNameOrDie(userFeatureDTO.getFeatureName());

        Optional<UserFeatureEntity> userFeatureEntity = userFeatureService.findUserFeatureEntitiesByUserIdAndFeatureId(userEntity.getId(), features.getId());

        if (!userFeatureEntity.isPresent()) {
            UserFeatureEntity newUserEntity = new UserFeatureEntity();
            newUserEntity.setUserId(userEntity.getId());
            newUserEntity.setFeatureId(features.getId());
            newUserEntity.setStatus(userFeatureDTO.isEnable());
            userFeatureService.save(newUserEntity);
            return true;
        }

        if (userFeatureEntity.get().isStatus() != userFeatureDTO.isEnable()) {
            userFeatureEntity.get().setStatus(userFeatureDTO.isEnable());
            userFeatureService.save(userFeatureEntity.get());
            return true;
        } else {
            return false;
        }


    }

}
