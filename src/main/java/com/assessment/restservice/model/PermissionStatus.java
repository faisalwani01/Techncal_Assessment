package com.assessment.restservice.model;

import java.io.Serializable;

public class PermissionStatus implements Serializable {
    private boolean canAccess;

    public boolean isCanAccess() {
        return canAccess;
    }

    public void setCanAccess(boolean canAccess) {
        this.canAccess = canAccess;
    }

    public PermissionStatus(boolean canAccess) {
        this.canAccess = canAccess;
    }
}
