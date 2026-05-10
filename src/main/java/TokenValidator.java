public class TokenValidator {

    public String resolveToken_before() {
        String token = System.getProperty("token", "b191dd443ab1800fc1e09ef23e50cdb0");
        return token;
    }

    public String resolveToken_after() {
        String token = System.getProperty("token", System.getenv("IMPORT_TOKEN") != null ? System.getenv("IMPORT_TOKEN") : "");
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Token must be provided via -Dtoken=... or the IMPORT_TOKEN environment variable");
        }
        return token;
    }
}