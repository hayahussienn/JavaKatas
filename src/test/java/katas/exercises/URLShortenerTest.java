package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class URLShortenerTest
{

    // Test Empty URL
    @Test
    public void testEmptyURL()
    {
        URLShortener shortener = new URLShortener();
        String longUrl = "";
        String shortUrl = shortener.shorten(longUrl);
        assertEquals(longUrl, shortener.retrieve(shortUrl));
    }


     // Test case: Shorten the same URL multiple times
    @Test
    public void testSameURL()
    {
        URLShortener shortener = new URLShortener();
        String longUrl = "https://www.example.com/same";
        String shortUrl1 = shortener.shorten(longUrl);
        String shortUrl2 = shortener.shorten(longUrl);
        assertEquals(shortUrl1, shortUrl2);
        assertEquals(longUrl, shortener.retrieve(shortUrl1));
    }

    @Test
    public void testShortenAndRetrieve()
    {
        URLShortener shortener = new URLShortener();

        String longUrl1 = "https://www.example.com/one";            // Shorten a simple URL and retrieve it
        String shortUrl1 = shortener.shorten(longUrl1);
        assertEquals(longUrl1, shortener.retrieve(shortUrl1));  //The retrieved URL should match the original URL

        String longUrl2 = "https://www.example.com/two";     // Shorten another URL and retrieve it
        String shortUrl2 = shortener.shorten(longUrl2);
        assertEquals(longUrl2, shortener.retrieve(shortUrl2));  //The retrieved URL should match the original URL

        assertNotEquals(shortUrl1, shortUrl2);                  //Ensure different URLs produce different short URLs
    }



}
