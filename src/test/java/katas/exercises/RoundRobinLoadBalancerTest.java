package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoundRobinLoadBalancerTest
{
    private RoundRobinLoadBalancer loadBalancer;

    @BeforeEach
    public void setUp()
    {
        loadBalancer = new RoundRobinLoadBalancer();
    }

    @Test
    public void testAddServer()
    {
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("165.123.0.1"));
        assertNotNull(loadBalancer.routeRequest());
    }

    @Test
    public void testRemoveServer()
    {
        RoundRobinLoadBalancer.IP server = new RoundRobinLoadBalancer.IP("165.123.0.1");
        loadBalancer.addServer(server);
        loadBalancer.removeServer(server);
        assertNull(loadBalancer.routeRequest());
    }

    @Test
    public void testRouteRequest() {
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("165.123.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("165.123.0.2"));

        assertEquals("165.123.0.1", loadBalancer.routeRequest().toString());
        assertEquals("165.123.0.2", loadBalancer.routeRequest().toString());
        assertEquals("165.123.0.1", loadBalancer.routeRequest().toString());
    }


    @Test
    public void testNoServersAvailable()
    {
        assertNull(loadBalancer.routeRequest());
    }


    @Test
    public void testRoundRobinBehavior() {
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("165.123.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("165.123.0.2"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("165.123.0.3"));

        assertEquals("165.123.0.1", loadBalancer.routeRequest().toString());
        assertEquals("165.123.0.2", loadBalancer.routeRequest().toString());
        assertEquals("165.123.0.3", loadBalancer.routeRequest().toString());
        assertEquals("165.123.0.1", loadBalancer.routeRequest().toString());
    }


}
