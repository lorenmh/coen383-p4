import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by loren on 10/30/17.
 */
public class Scheduler {
    public static final int NUM_PROCS = 150;

    // contains processes that have not arrived yet
    public LinkedList<Process> arrivalQueue;

    // contains processes that have arrived but are waiting to run
    public LinkedList<Process> waitingQueue;

    // contains processes that are running
    public LinkedList<Process> runningQueue;

    // contains processes that have run and are completed
    public LinkedList<Process> completedQueue;

    public static LinkedList<Process> createRandomArrivalQueue() {
        LinkedList<Process> arrivalQueue = new LinkedList<Process>();
        for (int i = 0; i < NUM_PROCS; i++) {
            arrivalQueue.add(Process.createRandomProcess());
        }
        Collections.sort(arrivalQueue, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return p1.arrivalTime - p2.arrivalTime;
            }
        });
        return arrivalQueue;
    }

    public static void printQueue(LinkedList<Process> ll) {
        System.out.println("[");
        for (Process process : ll) {
            System.out.println("\t" + process.toString());
        }
        System.out.println("[");
    }

    public Scheduler() {
        arrivalQueue = createRandomArrivalQueue();
        waitingQueue = new LinkedList<Process>();
        runningQueue = new LinkedList<Process>();
        completedQueue = new LinkedList<Process>();
    }

    public void runSchedulerOn(PageTable pageTable) {
        int time = 0;   // 1 unit stands for 100ms
        while (!(arrivalQueue.isEmpty() && waitingQueue.isEmpty() && runningQueue.isEmpty()) {
            for (Process process : runningQueue) {


            }


        }

    }

}
