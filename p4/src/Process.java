import java.util.Random;

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
        this.lastUsedPage = 0;
    }

    public int nextPageID() {
        Random random = new Random();
        double rnum = random.nextDouble();
        if (rnum < .23333333) {
            lastUsedPage -= 1;
        } else if (rnum >= .23333333 && rnum < .46666666 ) {
            lastUsedPage += 1;
        } else if (rnum >= 0.7) {
            lastUsedPage = random.nextInt(numPages);
        }

        if (lastUsedPage < 0) {
            lastUsedPage = numPages + lastUsedPage;
        } else if (lastUsedPage > numPages) {
            lastUsedPage = lastUsedPage - numPages;
        }

        return lastUsedPage;
    }

    @Override
    public String toString() {
        return String.format("{id: %d, np: %d, trt: %d}", this.id, this.numPages, this.totalRunTime);
    }

    public static Process ProcessFactory() {
        // create a random process, id from counter
        return null;
    }
}
