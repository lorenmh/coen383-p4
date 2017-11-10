import java.util.Random;

/**
 * Created by loren on 10/30/17.
 */
public class Process {
    public static int counter = 0;
    public final static String achars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public final static String nchars = "123456789";
    public final static int[] pageSizes = {5,11,17,31};

    int id;
    String sid;
    int numPages;
    int totalRunTime;
    int remainingRunTime;
    int lastUsedPage; // for determining locality of reference
    int arrivalTime;

    public Process(int id, String sid, int arrivalTime, int numPages, int totalRunTime) {
        this.id = id;
        this.sid = sid;
        this.arrivalTime = arrivalTime;
        this.numPages = numPages;
        this.totalRunTime = totalRunTime;
        this.remainingRunTime = totalRunTime;
        this.lastUsedPage = 0;
    }

    public int nextPageID() {
        if (lastUsedPage == -1) {
            lastUsedPage = 0;
            return 0;
        }
        Random random = new Random();
        double rnum = random.nextDouble();
        if (rnum < .23333333) {
            lastUsedPage -= 1;
        } else if (rnum >= .23333333 && rnum < .46666666 ) {
            lastUsedPage += 1;
        } else if (rnum >= 0.7) {
            lastUsedPage = random.nextInt(numPages);
        }

//        if (lastUsedPage < 0) {
//            lastUsedPage = numPages + lastUsedPage;
//        } else if (lastUsedPage > numPages) {
//            lastUsedPage = lastUsedPage - numPages;
//        }
        // he said its not a circle

        rnum = random.nextDouble();
        if (lastUsedPage < 0) {
            if (rnum < 0.5) {
                lastUsedPage = 0;
            }else {
                lastUsedPage = 1;
            }
        }else if (lastUsedPage >= numPages) {
            if (rnum < 0.5) {
                lastUsedPage = numPages - 1;
            }else {
                lastUsedPage = numPages - 2;
            }
        }

        return lastUsedPage;
    }

    public static String intToStringID(int id) {
        return "" + achars.charAt(id % achars.length()) + nchars.charAt(id / achars.length());
    }

    @Override
    public String toString() {
        return String.format(
                "{id: %s, at: %d, np: %d, trt: %d, rrt: %d}",
                this.id, this.arrivalTime, this.numPages, this.totalRunTime, this.remainingRunTime
        );
    }

    public static Process createRandomProcess() {
        Random random = new Random();
        int randomNumPages = pageSizes[random.nextInt(pageSizes.length)];
        int randomRunTime = 10 * (random.nextInt(5) + 1);
        int randomArrivalTime = random.nextInt(600);

        int id = counter++;

        return new Process(
                id,
                Process.intToStringID(id), // id
                randomArrivalTime,
                randomNumPages,
                randomRunTime
        );
    }
}
