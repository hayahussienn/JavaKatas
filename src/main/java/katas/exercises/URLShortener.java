package katas.exercises;

import java.util.HashMap;
import java.util.Map;

public class URLShortener
{
    /**
     * A URL Shortener is a service that converts a long URL into a shorter, more manageable URL.
     * Implement a simple URL shortener system with the following functionality:
     *
     *  - Convert a long URL into a short URL.
     *  - Retrieve the original long URL from a given short URL.
     *  - The system should handle the cases where multiple long URLs may share the same short URL, such as through hash collisions (you can assume no collisions for simplicity in this exercise).
     *  - The class should use a hash map to store the mapping between short and long URLs.
     *  - The short URL should be a base62 string (characters A-Z, a-z, 0-9).
     */

    private Map<String, String> urlMap;
    private static final String BASE_URL = "http://short.ly/";
    private static final String base62Chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = base62Chars.length();



    /**
     * Constructor to initialize the URL shortener system.
     */
    public URLShortener()
    {
        urlMap = new HashMap<>();
    }

    /**
     * Shortens the provided long URL.
     *
     * @param longUrl the long URL to shorten
     * @return the shortened URL
     */
    public String shorten(String longUrl)
    {
        int hashCode = longUrl.hashCode();                // Generate a hash code for the URL
        String shortUrl = encodeBase62(hashCode);         // Convert the hash code to a base62 string
        urlMap.put(BASE_URL + shortUrl, longUrl);         // Map the shortened URL to the original URL
        return BASE_URL + shortUrl;                       // Return the complete shortened URL


    }

    private String encodeBase62(int number)
    {

        StringBuilder encoded = new StringBuilder();
        long num = number < 0 ? (2L * Integer.MAX_VALUE) + number + 2 : number; // Handle negative hash codes

        while (num > 0)
        {
            int remainder = (int) (num % BASE);               // Get the remainder for base62 conversion
            encoded.append(base62Chars.charAt(remainder));    // Append the corresponding base62 character
            num /= BASE;                                      // Divide the number by BASE for next iteration
        }
        return encoded.reverse().toString();                 // Reverse the string to get the final base62 result

    }

    /**
     * Retrieves the original long URL from the shortened URL.
     *
     * @param shortUrl the shortened URL
     * @return the original long URL
     */
    public String retrieve(String shortUrl)
    {
        return urlMap.get(shortUrl); // Implement logic to retrieve long URL
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl = shortener.shorten(longUrl);

        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Original URL: " + shortener.retrieve(shortUrl));
    }
}