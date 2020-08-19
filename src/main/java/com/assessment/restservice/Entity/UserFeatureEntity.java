package com.assessment.restservice.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_features")
public class UserFeatureEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_feature_id_generator")
	@SequenceGenerator(name = "user_feature_id_generator", sequenceName = "user_feature_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "feature_id")
	private Long featureId;

    @Column(name = "status")
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
