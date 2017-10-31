/**
 * Created by loren on 10/30/17.
 */
public class Process {
    public static int counter = 0;

    String id;
    int numPages;
    int totalRunTime;
    int lastUsedPage; // for determining locality of reference

    public Process(String id, int numPages, int totalRunTime) {
        this.id = id;
        this.numPages = numPages;
        this.totalRunTime = totalRunTime;
    }

    public static Process ProcessFactory() {
        // create a random process, id from counter
    }
}
