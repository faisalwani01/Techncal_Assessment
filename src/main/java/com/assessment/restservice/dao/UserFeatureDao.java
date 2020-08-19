package com.assessment.restservice.dao;

import com.assessment.restservice.dao.repository.UserFeatureRepository;
import com.assessment.restservice.Entity.UserFeatureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserFeatureDao {

    @Autowired
	private UserFeatureRepository userFeatureRepository;

	public Optional<UserFeatureEntity> findUserFeatureEntitiesByUserIdAndFeatureId(Long userId, Long featureId) {
		return userFeatureRepository.findUserFeatureEntitiesByUserIdAndFeatureId(userId, featureId);
	}

	public UserFeatureEntity saveUserFeature(UserFeatureEntity userFeatureEntity) {
		return userFeatureRepository.save(userFeatureEntity);
	}
}
