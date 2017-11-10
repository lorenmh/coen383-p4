import java.util.Random;

public class RandomPick implements ReplacementAlgorithm {
    Random rand = new Random();

    @Override
    public int getNewFrame(PageTableEntry[] pageTableEntriesArray, int processID, int pageID, boolean isNewProcess) {
        int freeFrameCount = 0;
        int firstFreeFrameIndex = -1;
        for (int i = pageTableEntriesArray.length - 1; i >= 0; i--) {
            if (pageTableEntriesArray[i].used) {
                if (pageTableEntriesArray[i].processID == processID) {
                    if (pageTableEntriesArray[i].pageID == pageID) {
                        return i;
                    }
                }
            }else {
                freeFrameCount += 1;
                firstFreeFrameIndex = i;
            }
        }
        if (isNewProcess) {
            if (freeFrameCount >= 4) {
                return firstFreeFrameIndex;
            }else {
                return -1;
            }
        }else {
            if (freeFrameCount > 0) {
                return firstFreeFrameIndex;
            }else {
                return rand.nextInt(pageTableEntriesArray.length);
            }
        }
    }
}
