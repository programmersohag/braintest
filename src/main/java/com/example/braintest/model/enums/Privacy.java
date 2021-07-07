package com.example.braintest.model.enums;

public enum Privacy {
    PUBLIC("PUB"), PRIVATE("PRI");

    private final String privacy;

    Privacy(String privacy) {
        this.privacy = privacy;
    }
    public String getPrivacy(){
        return privacy;
    }
}
