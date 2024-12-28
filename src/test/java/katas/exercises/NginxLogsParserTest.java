package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NginxLogsParserTest {
    @Test
    public void testInvalidLogFormat() {
        String logEntry = "Invalid log format";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NginxLogsParser.parseLog(logEntry);
        });

        assertEquals("Invalid log format", exception.getMessage());
    }

    @Test
    public void testValidLog() {
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        Map<String, String> parsedLog = NginxLogsParser.parseLog(logEntry);

        assertEquals("122.176.223.47", parsedLog.get("client_ip"));
        assertEquals("05/Feb/2024:08:29:40 +0000", parsedLog.get("date"));
        assertEquals("GET", parsedLog.get("http_method"));
        assertEquals("/web-enabled/Enhanced-portal/bifurcated-forecast.js", parsedLog.get("path"));
        assertEquals("1.1", parsedLog.get("http_version"));
        assertEquals("200", parsedLog.get("status"));
        assertEquals("1684", parsedLog.get("response_bytes"));
        assertEquals("Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00", parsedLog.get("user_agent"));
    }

    @Test
    public void testLogWithMissingFields() {
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NginxLogsParser.parseLog(logEntry);
        });

        assertEquals("Invalid log format", exception.getMessage());
    }


    @Test
    public void testLogWithDifferentStatusCode() {
        String logEntry = "192.168.1.1 - - [10/Dec/2024:10:45:22 +0000] " +
                "\"POST /api/v1/resource HTTP/1.1\" 404 512 " +
                "\"-\" \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36\"";

        Map<String, String> parsedLog = NginxLogsParser.parseLog(logEntry);

        assertEquals("192.168.1.1", parsedLog.get("client_ip"));
        assertEquals("10/Dec/2024:10:45:22 +0000", parsedLog.get("date"));
        assertEquals("POST", parsedLog.get("http_method"));
        assertEquals("/api/v1/resource", parsedLog.get("path"));
        assertEquals("1.1", parsedLog.get("http_version"));
        assertEquals("404", parsedLog.get("status"));
        assertEquals("512", parsedLog.get("response_bytes"));
        assertEquals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36", parsedLog.get("user_agent"));
    }





}
