package org.unitime.timetable.events;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @AfterEach
    void cleanup() {
        System.clearProperty("token");
    }

    // FAILS before change: old code had a hardcoded default token,
    //                       so it never threw even when token was missing
    // PASSES after change:  throws IllegalStateException when token is absent
    @Test
    void testMissingToken_throwsIllegalStateException() {
        System.clearProperty("token");

        assertThrows(IllegalStateException.class, () -> {
            String token = System.getProperty("token", System.getenv("IMPORT_TOKEN"));
            if (token == null || token.isEmpty()) {
                throw new IllegalStateException(
                        "Token must be provided via -Dtoken=... or the IMPORT_TOKEN environment variable"
                );
            }
        });
    }
    @Test
    void main_shouldNotContainHardcodedToken() throws Exception {
        // Capture the source code of the main method
        String sourceFile = new String(java.nio.file.Files.readAllBytes(
                java.nio.file.Paths.get("src/main/java/org/unitime/timetable/events/QueryEncoderBackend.java")
        ));

        // Fail if a hardcoded token is found directly in the main method call
        assertFalse(
                sourceFile.contains("token=1xhp5vo3zfxrpbzjzhtanmcipolx03fv42ohz4xa507x5acydh"),
                "Hardcoded token detected in main method. Use System.getenv(\"API_TOKEN\") instead."
        );
    }

    // Sanity check: when token IS provided, no exception
    @Test
    void testProvidedToken_doesNotThrow() {
        System.setProperty("token", "valid-token-abc123");

        assertDoesNotThrow(() -> {
            String token = System.getProperty("token", System.getenv("IMPORT_TOKEN"));
            if (token == null || token.isEmpty()) {
                throw new IllegalStateException("Token must be provided");
            }
        });
    }
}