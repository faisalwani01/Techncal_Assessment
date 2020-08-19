package com.assessment.restservice.service;


import com.assessment.restservice.Entity.Features;
import com.assessment.restservice.dao.FeatureDao;
import com.assessment.restservice.exceptions.FeatureNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    @Autowired
    private FeatureDao featureDao;

    public Features findByFeatureNameOrDie(String featureName) throws FeatureNotFoundException {
        return featureDao.findByFeatureNameOrDie(featureName);
    }

}
