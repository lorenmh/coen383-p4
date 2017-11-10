/**
 * Created by loren on 10/30/17.
 */
public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Scheduler.printQueue(scheduler.arrivalQueue);
        PageTable table = new PageTable();
        table.setReplacementAlgorithm(new LRU());
        scheduler.runSchedulerOn(table);
    }
}
