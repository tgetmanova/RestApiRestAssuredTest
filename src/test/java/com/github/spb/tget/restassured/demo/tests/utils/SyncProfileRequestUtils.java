package com.github.spb.tget.restassured.demo.tests.utils;

import java.util.UUID;

public class SyncProfileRequestUtils {
    public static SyncProfileRequest generateValidSyncProfileRequest() {
        return new SyncProfileRequest(UUID.randomUUID(), UUID.randomUUID(), true,
                null, "FI", "HU");
    }
}
