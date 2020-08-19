package com.assessment.restservice.dao.repository;


import com.assessment.restservice.Entity.UserFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFeatureRepository extends JpaRepository<UserFeatureEntity, Long> {
    Optional<UserFeatureEntity> findUserFeatureEntitiesByUserIdAndFeatureId(Long userId, Long featureId);
}
