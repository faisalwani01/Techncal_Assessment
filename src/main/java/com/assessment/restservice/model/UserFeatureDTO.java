package com.assessment.restservice.model;

import java.io.Serializable;

public class UserFeatureDTO implements Serializable {

    private String email;

	private String featureName;

    private boolean enable;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public UserFeatureDTO() {

    }

    public UserFeatureDTO(String email, String featureName, boolean enable) {
        this.email = email;
        this.featureName = featureName;
        this.enable = enable;
    }
}
