/**
 * Created by loren on 10/30/17.
 */
public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Scheduler.printQueue(scheduler.arrivalQueue);

        PageTable table = new PageTable();


        System.out.print("FIFO algorithm\n");
        runAlgorithm(new FIFO(), scheduler, table);
        System.out.print("LFU algorithm\n");
        runAlgorithm(new LFU(), scheduler, table);
        System.out.print("LRU algorithm\n");
        runAlgorithm(new LRU(), scheduler, table);
        System.out.print("MFU algorithm\n");
        runAlgorithm(new MFU(), scheduler, table);
        System.out.print("Random Pick algorithm\n");
        runAlgorithm(new RandomPick(), scheduler, table);

    }

    static double runAlgorithm(ReplacementAlgorithm algorithm, Scheduler scheduler, PageTable pageTable) {
        double hitMissRatio = 0;
        pageTable.setReplacementAlgorithm(algorithm);
        System.out.print("-------------------------------\n");
        for (int i = 0; i < 5; i++) {
            scheduler.runSchedulerOn(pageTable);
            hitMissRatio += (double)pageTable.hit / (double)pageTable.miss;
            pageTable.cleanPageTable();
            System.out.print("-------------------------------\n");
        }

        System.out.print("average hit miss ratio is ");
        System.out.printf("%.4f\n", hitMissRatio / 5);
        System.out.print("***********************************************\n\n\n");
        return hitMissRatio / 5;
    }

}
