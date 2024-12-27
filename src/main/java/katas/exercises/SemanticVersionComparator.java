package katas.exercises;

public class SemanticVersionComparator {

    /**
     * Compares two semantic version strings to determine their relative order.
     *
     * @param version1 the first version string (e.g., "MAJOR.MINOR.PATCH")
     * @param version2 the second version string (e.g., "MAJOR.MINOR.PATCH")
     * @return -1 if version1 < version2, 1 if version1 > version2, 0 if they are equal
     */
    public static int compareVersions(String version1, String version2) {
        // Check for null or empty versions
        if (version1 == null || version1.isEmpty()) {
            throw new IllegalArgumentException("Version 1 cannot be null or empty");
        }
        if (version2 == null || version2.isEmpty()) {
            throw new IllegalArgumentException("Version 2 cannot be null or empty");
        }
        // Split both version strings by the dot (.)
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        // Compare each segment numerically
        for (int i = 0; i < Math.max(parts1.length, parts2.length); i++) {
            int v1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int v2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;  // Return 0 if all segments are equal
    }

    public static void main(String[] args) {
        System.out.println(compareVersions("1.0.0", "1.0.1")); // Expected: -1
        System.out.println(compareVersions("2.1.0", "1.9.9")); // Expected: 1
        System.out.println(compareVersions("1.2.3", "1.2.3")); // Expected: 0
    }
}
