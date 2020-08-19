package com.assessment.restservice.service;


import com.assessment.restservice.Entity.Features;
import com.assessment.restservice.dao.FeatureDao;
import com.assessment.restservice.exceptions.FeatureNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureDao featureDao;

    public Optional<Features> findById(long id) {
        return featureDao.findById(id);
    }

    public Optional<Features> findByFeatureName(String featureName) {
        return featureDao.findByFeatureName(featureName);
    }

    public Features findByFeatureNameorDie(String featureName) throws FeatureNotFoundException {
        return featureDao.findByFeatureNameOrDie(featureName);
    }

}
