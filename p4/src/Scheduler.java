import java.util.LinkedList;

/**
 * Created by loren on 10/30/17.
 */
public class Scheduler {
    // contains processes that have not arrived yet
    LinkedList<Process> arrivalQueue;

    // contains processes that have arrived but are waiting to run
    LinkedList<Process> waitingQueue;

    // contains processes that are running
    LinkedList<Process> runningQueue;

    // contains processes that have run and are completed
    LinkedList<Process> completedQueue;

    public Scheduler() {
        arrivalQueue = new LinkedList<Process>();
        waitingQueue = new LinkedList<Process>();
        runningQueue = new LinkedList<Process>();
        completedQueue = new LinkedList<Process>();
    }
}
