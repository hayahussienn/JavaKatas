package katas.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * DroneFly Inc. operates a fleet of drones for package deliveries. Each drone can carry only one package at a time.
 * Customers send requests with the delivery start time, delivery duration,
 * and the payment they are willing to make for the delivery.
 *
 * Your task is to help DroneFly Inc. maximize its profit by finding the best combination of delivery
 * requests that a single drone can fulfill.
 *
 * Requests are sorted by their start times. Here's a sample input file with 4 delivery requests:
 *
 *  REQ01 0 5 50
 *  REQ02 3 7 80
 *  REQ03 5 9 60
 *  REQ04 6 9 70
 *
 *  The best combination is REQ01 and REQ04, with a total payment of 50+70=120.
 */
public class Lags {

    /**
     * Represents a delivery request.
     */
    static class Request {
        String id;
        int startTime;
        int duration;
        int payment;

        public Request(String id, int startTime, int duration, int payment) {
            this.id = id;
            this.startTime = startTime;
            this.duration = duration;
            this.payment = payment;
        }
        //return the end time of the request
        public int getEndTime() {
            return startTime + duration;
        }
    }

    /**
     * Finds the maximum profit from a list of delivery requests that do not overlap.
     *
     * @param requests the list of delivery requests, sorted by start time
     * @return the maximum profit
     */
    public static int maximizeProfit(List<Request> requests) {
        int n = requests.size();
        Collections.sort(requests, Comparator.comparingInt(Request::getEndTime)); // Step 1: Sort requests by end time

        ArrayList<Integer> endTimes = new ArrayList<>();           // Step 2: Compute end times after sorting
        for (Request request : requests) {
            endTimes.add(request.getEndTime());
        }

        int[] dp = new int[n];              // Step 3: DP Array
        dp[0] = requests.get(0).payment;            // Base Case

        // Step 4: Fill DP table
        for (int i = 1; i < n; i++) {
            int lastIndex = findLastNonOverlapping(endTimes, requests.get(i).startTime);

            int includeProfit = requests.get(i).payment + (lastIndex == -1 ? 0 : dp[lastIndex]);
            int excludeProfit = dp[i - 1]; // Skipping current request

            dp[i] = Math.max(includeProfit, excludeProfit);
        }

        return dp[n - 1];          // Step 5: Return the maximum profit from the last entry
    }

    private static int findLastNonOverlapping(List<Integer> endTimes, int startTime) {
        int left = 0, right = endTimes.size() - 1;
        int result = -1;
        //binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (endTimes.get(mid) <= startTime) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("REQ01", 0, 5, 50));
        requests.add(new Request("REQ02", 3, 7, 80));
        requests.add(new Request("REQ03", 5, 4, 60));
        requests.add(new Request("REQ04", 6, 3, 70));

        int maxProfit = maximizeProfit(requests);

        System.out.println("Maximum Profit: " + maxProfit); // Output: 120
    }
}


