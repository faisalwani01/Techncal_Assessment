package com.assessment.restservice.dao.repository;

import com.assessment.restservice.Entity.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends JpaRepository<Features, Long> {
    Optional<Features> findByFeatureName(String featureName);
}
