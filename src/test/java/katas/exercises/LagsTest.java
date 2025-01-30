package katas.exercises;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static katas.exercises.Lags.maximizeProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LagsTest
{

    @Test
    void testSingleRequest() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        int maxProfit = maximizeProfit(requests);

        assertEquals(50,maxProfit);
    }

    @Test
    void testMultipleRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 4, 50));
        requests.add(new Lags.Request("REQ02", 3, 7, 80));
        requests.add(new Lags.Request("REQ03", 5, 4, 90));
        requests.add(new Lags.Request("REQ04", 6, 3, 70));
        int maxProfit = maximizeProfit(requests);

        assertEquals(140,maxProfit);
    }

    @Test
    void testAllRequestsOverlap() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 1, 5, 80));
        requests.add(new Lags.Request("REQ03", 2, 5, 90));
        int maxProfit = maximizeProfit(requests);

        assertEquals(90, maxProfit); // Should pick the highest payment
    }

    @Test
    void testNonOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 3, 50));
        requests.add(new Lags.Request("REQ02", 4, 3, 70));
        requests.add(new Lags.Request("REQ03", 8, 3, 90));
        int maxProfit = maximizeProfit(requests);

        assertEquals(210, maxProfit); // 50 + 70 + 90
    }


}
