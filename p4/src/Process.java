import java.util.Random;

/**
 * Created by loren on 10/30/17.
 */
public class Process {
    public static int counter = 0;
    public final static String achars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public final static String nchars = "123456789";
    public final static int[] pageSizes = {5,11,17,31};

    String id;
    int numPages;
    int totalRunTime;
    int lastUsedPage; // for determining locality of reference
    int arrivalTime;

    public Process(String id, int numPages, int totalRunTime, int arrivalTime) {
        this.id = id;
        this.numPages = numPages;
        this.totalRunTime = totalRunTime;
        this.arrivalTime = arrivalTime;
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

    public static String intToStringID(int id) {
        return "" + achars.charAt(id % achars.length()) + nchars.charAt(id / achars.length());
    }

    @Override
    public String toString() {
        return String.format("{id: %d, np: %d, trt: %d}", this.id, this.numPages, this.totalRunTime);
    }

    public static Process createRandomProcess() {
        Random random = new Random();
        int randomNumPages = pageSizes[random.nextInt(pageSizes.length)];
        int randomRunTime = random.nextInt(5) + 1;
        int randomArrivalTime = random.nextInt(60);

        return new Process(
                Process.intToStringID(counter++), // id
                randomNumPages,
                randomRunTime,
                randomArrivalTime
        );
    }
}
