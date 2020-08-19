package com.assessment.restservice.dao;

import com.assessment.restservice.Entity.Features;
import com.assessment.restservice.dao.repository.FeatureRepository;
import com.assessment.restservice.exceptions.FeatureNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FeatureDao {

    @Autowired
    private FeatureRepository featureRepository;

    public Optional<Features> findById(long id) {
        return featureRepository.findById(id);
    }

    public Optional<Features> findByFeatureName(String featureName) {
        return featureRepository.findByFeatureName(featureName);
    }

    public Features findByFeatureNameOrDie(String featureName) throws FeatureNotFoundException {
        return featureRepository.findByFeatureName(featureName).orElseThrow(() -> new FeatureNotFoundException("Feature with name " + featureName + " does not exist."));
    }
}
