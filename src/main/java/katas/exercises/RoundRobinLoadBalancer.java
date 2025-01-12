package katas.exercises;


import java.util.ArrayList;
import java.util.List;

public class RoundRobinLoadBalancer {
    /**
     * In distributed systems, a load balancer is responsible for distributing incoming requests to multiple server instances.
     * A round-robin load balancer assigns requests to server instances in a circular order.
     * <p>
     * You need to implement a RoundRobinLoadBalancer class that:
     * <p>
     * - Adds a server instance to the pool of available instances.
     * - Removes a server instance from the pool of available instances.
     * - Routes incoming requests to server instances in a round-robin manner.
     * - Return null when no servers are available.
     */

    private List<IP> servers;
    private int currentIndex;

    /**
     * Constructor to initialize the load balancer.
     */
    public RoundRobinLoadBalancer()
    {
        servers = new ArrayList<>();         // Initialize the list of servers
        currentIndex = 0;                    // Start the index at the first position

    }

    /**
     * Adds a server instance to the load balancer.
     *
     * @param server the IP object representing the server to add
     */
    public void addServer(IP server)
    {
        servers.add(server);

    }

    /**
     * Removes a server instance from the load balancer.
     *
     * @param server the IP object representing the server to remove
     */
    public void removeServer(IP server)
    {
        servers.remove(server);
        if (currentIndex >= servers.size())
        {
            currentIndex = 0; // Reset index if necessary
        }

    }

    /**
     * Routes a request to the next server in round-robin order.
     *
     * @return the IP object of the server handling the request
     */
    public IP routeRequest()
    {
        if (servers.isEmpty())
        {
            return null; // No servers available
        }

        IP server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size(); // Increment index and wrap around

        return server;
    }


    public static void main(String[] args) {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(new IP("192.168.0.1"));
        loadBalancer.addServer(new IP("192.168.0.2"));
        loadBalancer.addServer(new IP("192.168.0.3"));

        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());

        loadBalancer.removeServer(new IP("192.168.0.2"));

        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
    }

    /**
     * Represents an IP address.
     */
    static class IP {
        private final String address;

        /**
         * Constructor to initialize an IP address.
         *
         * @param address the IP address as a string
         */
        public IP(String address)
        {
            if (!isValidIP(address))
            {
                throw new IllegalArgumentException("Invalid IP address: " + address);
            }

            if (address == null)
            {
                throw new IllegalArgumentException("IP address cannot be null");
            }

            this.address = address;
        }

        /**
         * Validates an IPv4 address.
         *
         * @param address the IP address to validate
         * @return true if the address is valid, false otherwise
         */
        private static boolean isValidIP(String address)
        {
            String[] parts = address.split("\\.");  // Splits the IP address into segments using '.' as delimiter
            if (parts.length != 4)   // Checks if there are exactly 4 segments.
            {
                return false; // Not exactly 4 segments
            }
            for (String part : parts)                // Iterates through each segment to validate its value.
            {
                try {
                    int num = Integer.parseInt(part);  // Converts segment to integer
                    if (num < 0 || num > 255)
                    {
                        return false; // Not in range 0-255
                    }
                }
                catch (NumberFormatException e)
                {
                    return false; // Contains non-numeric characters
                }
            }
            return true;
        }

        @Override
        public String toString()
        {
            return address;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            IP ip = (IP) obj;
            return address.equals(ip.address);
        }

        @Override
        public int hashCode()
        {
            return address.hashCode();
        }
    }

}