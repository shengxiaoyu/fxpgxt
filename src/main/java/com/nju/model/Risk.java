package com.nju.model;

public class Risk {
    private int riskId;
    private String riskName;
    private String riskContent;
    private String riskLevel;
    private String riskPossibility;
    private String riskGate;
    private String riskCreator;
    private String riskFollower;
    private String riskCreatedTime;

    public Risk(int riskId, String riskName, String riskContent, String riskLevel, String riskPossibility, String riskGate, String riskCreator, String riskFollower, String riskCreatedTime) {
        this.riskId = riskId;
        this.riskName = riskName;
        this.riskContent = riskContent;
        this.riskLevel = riskLevel;
        this.riskPossibility = riskPossibility;
        this.riskGate = riskGate;
        this.riskCreator = riskCreator;
        this.riskFollower = riskFollower;
        this.riskCreatedTime = riskCreatedTime;
    }


    public int getRiskId() {
        return riskId;
    }

    public void setRiskId(int riskId) {
        this.riskId = riskId;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getRiskContent() {
        return riskContent;
    }

    public void setRiskContent(String riskContent) {
        this.riskContent = riskContent;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskPossibility() {
        return riskPossibility;
    }

    public void setRiskPossibility(String riskPossibility) {
        this.riskPossibility = riskPossibility;
    }

    public String getRiskGate() {
        return riskGate;
    }

    public void setRiskGate(String riskGate) {
        this.riskGate = riskGate;
    }

    public String getRiskCreator() {
        return riskCreator;
    }

    public void setRiskCreator(String riskCreator) {
        this.riskCreator = riskCreator;
    }

    public String getRiskFollower() {
        return riskFollower;
    }

    public void setRiskFollower(String riskFollower) {
        this.riskFollower = riskFollower;
    }

    public String getRiskCreatedTime() {
        return riskCreatedTime;
    }

    public void setRiskCreatedTime(String riskCreatedTime) {
        this.riskCreatedTime = riskCreatedTime;
    }
}
