package katas.exercises;

import java.util.*;

public class QueueWithFailover {
    /**
     * A job queue data structure with failover support.
     *
     * A job queue is a messaging system used to manage the flow of work between components or applications.
     * In this system, jobs (or messages) are sent to the queue by PRODUCERS and retrieved by CONSUMERS for processing.
     *
     * When a job is consumed by a consumer, they have `jobTimeout` seconds to finish the job.
     * The job is not permanently deleted from the queue; instead, it is temporarily hidden.
     * If the consumer completes processing the job within the allocated time, they mark the job as done (jobDone()),
     * and the job should be permanently deleted.
     * Otherwise, if they fail to process the job and the job processing times out, the job should be returned
     * to the end of the queue (by the returnExpiredJobsToQueue()), allowing it to be consumed again.
     */

    private int jobTimeout;
    private Queue<String> jobs;
    private Map<String, Long> hiddenJobs;


    //Initialize an empty job queue.
    public QueueWithFailover(int jobTimeout)
    {
        this.jobTimeout = jobTimeout;
        this.jobs = new LinkedList<>();
        this.hiddenJobs = new HashMap<>();
    }

    //Initialize an empty job queue.
    public boolean isEmpty()
    {
        return jobs.isEmpty();
    }

    //Send a job to the job queue.
    public void sendJob(String job)
    {
        jobs.add(job);
    }

    //Retrieve and return a job from the front of the job queue.
    public String getJob() throws EmptyQueueException {
        if (jobs.isEmpty())
        {
            throw new EmptyQueueException("The job queue is empty.");
        }
        else
        {
            String job = jobs.poll(); // Retrieve and remove the job from the front of the queue.
            hiddenJobs.put(job, System.currentTimeMillis()); // Temporarily hide the job with its timestamp.
            return job; // Return the job.
        }
    }


    /**
     * This function is called when a consumer completes a consumed job.
     * The job should be deleted permanently (from the hidden).
     *
     * @param job The job to be deleted permanently from the queue.
     * @throws IllegalArgumentException: If the job is not found in the hidden jobs.
     */
    public void jobDone(String job) throws IllegalArgumentException {
        if (hiddenJobs.containsKey(job))
        {
            long jobRetrievedTime = hiddenJobs.get(job);
            long currentTime = System.currentTimeMillis();

            // Check if the job was completed within the allowed timeout.
            if ((currentTime - jobRetrievedTime) <= jobTimeout * 1000)
            {
                hiddenJobs.remove(job); // Remove the job from hiddenJobs permanently.
            } else
            {
                // If the job has timed out, return expired jobs to the queue.
                returnExpiredJobsToQueue();
                throw new IllegalArgumentException("Job has expired and returned to the main queue.");
            }
        }
        else
        {
            // Job not found in the hidden jobs.
            throw new IllegalArgumentException("Job not found in the hidden jobs.");
        }

    }


    //Return the number of jobs in the job queue.
    public int size()
    {
        return jobs.size();
    }


    //Return the number of hidden jobs.
    public int inFlightSize()
    {
        return hiddenJobs.size();

    }

    //Return hidden jobs that were retrieved more than `jobTimeout` seconds ago back to the job queue.
    public void returnExpiredJobsToQueue() {
        long currentTime = System.currentTimeMillis();

        // Iterate through the hiddenJobs map
        for (Iterator<Map.Entry<String, Long>> iterator = hiddenJobs.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Long> entry = iterator.next();
            String job = entry.getKey();
            long jobRetrievedTime = entry.getValue();

            // Check if the job has expired
            if ((currentTime - jobRetrievedTime) > jobTimeout * 1000) {
                jobs.add(job); // Add the expired job back to the main queue
                iterator.remove(); // Remove the job from hiddenJobs
            }
        }
    }



    public static void main(String[] args) {
        QueueWithFailover jobQueue = new QueueWithFailover(3);

        jobQueue.sendJob("Job 1");
        jobQueue.sendJob("Job 2");
        jobQueue.sendJob("Job 3");

        System.out.println("Job Queue Size: " + jobQueue.size());

        String currentJob = jobQueue.getJob();
        jobQueue.jobDone(currentJob);

        currentJob = jobQueue.getJob();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        jobQueue.returnExpiredJobsToQueue();

        try {
            jobQueue.jobDone(currentJob);
        } catch (IllegalArgumentException e) {
            System.out.println("Job not found as it was expired and returned to the main queue");
        }
    }

    static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String s) {
            super(s);
        }
    }
}
