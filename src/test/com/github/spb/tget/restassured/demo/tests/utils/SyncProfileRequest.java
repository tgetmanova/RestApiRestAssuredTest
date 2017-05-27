package com.github.spb.tget.restassured.demo.tests.utils;

import java.time.LocalDateTime;
import java.util.UUID;

public class SyncProfileRequest {

    private Boolean advertisingOptIn;

    private LocalDateTime dateModified;

    private String countryIsoCode;

    private String locale;

    private UUID userId;

    private UUID requestId;

    public SyncProfileRequest(UUID usersId, UUID requestId, Boolean advertisingOptIn,
                              LocalDateTime dateModified, String countryIsoCode, String locale) {
        this.userId = usersId;
        this.requestId = requestId;
        this.advertisingOptIn = advertisingOptIn;
        this.dateModified = dateModified;
        this.countryIsoCode = countryIsoCode;
        this.locale = locale;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public Boolean getAdvertisingOptIn() {
        return advertisingOptIn;
    }

    public void setAdvertisingOptIn(Boolean advertisingOptIn) {
        this.advertisingOptIn = advertisingOptIn;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}