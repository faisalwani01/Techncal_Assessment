package com.assessment.restservice.service;


import com.assessment.restservice.dao.UserFeatureDao;
import com.assessment.restservice.exceptions.UserNotFoundException;
import com.assessment.restservice.Entity.UserFeatureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFeatureService {

    @Autowired
    private UserFeatureDao userFeatureDao;

    public Optional<UserFeatureEntity> findUserFeatureEntitiesByUserIdAndFeatureId(Long userId, Long featureId) throws UserNotFoundException {
        return userFeatureDao.findUserFeatureEntitiesByUserIdAndFeatureId(userId, featureId);
    }

    public UserFeatureEntity save(UserFeatureEntity userFeatureEntity) {
        return userFeatureDao.saveUserFeature(userFeatureEntity);
    }

}
