package com.assessment.restservice.Entity;

import javax.persistence.*;

@Entity
@Table(name = "features")
public class Features {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_id_generator")
	@SequenceGenerator(name = "feature_id_generator", sequenceName = "feature_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "feature_name")
	private String featureName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
