package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class QueueWithFailoverTest {

    private QueueWithFailover jobQueue;

    @BeforeEach
    public void setUp() {
        jobQueue = new QueueWithFailover(4); // Job timeout of 4 seconds
    }

    @Test
    public void testGetJob() {
        jobQueue.sendJob("first Job");
        String job = jobQueue.getJob();
        assertEquals("first Job", job);
    }

    @Test
    public void testSendJob()
    {
        jobQueue.sendJob("first Job");
        assertEquals(1, jobQueue.size());
    }

    @Test
    public void testJobDoneSuccessfully()
    {
        jobQueue.sendJob("Job 1");
        String job = jobQueue.getJob();
        jobQueue.jobDone(job);
        assertEquals(0, jobQueue.size());
    }

    @Test
    public void testJobTimeout() throws InterruptedException
    {
        jobQueue.sendJob("first Job");
        String job = jobQueue.getJob();
        TimeUnit.SECONDS.sleep(5); // Simulating job processing time > timeout
        jobQueue.returnExpiredJobsToQueue();
        assertTrue(jobQueue.size() > 0); // The job should return to the queue
    }


    @Test
    public void testEmptyQueueException()
    {
        assertThrows(QueueWithFailover.EmptyQueueException.class, () -> jobQueue.getJob());
    }

    @Test
    public void testJobInFlightSize()
    {
        jobQueue.sendJob("first Job");
        String job = jobQueue.getJob();
        assertEquals(1, jobQueue.inFlightSize()); // 1 job hidden
    }
}

