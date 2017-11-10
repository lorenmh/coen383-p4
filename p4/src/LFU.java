/**
 * Created by Ken on 11/5/17.
 */
public class LFU implements ReplacementAlgorithm{
    @Override
    public int getNewFrame(PageTableEntry[] pageTableEntriesArray, int processID, int pageID, boolean isNewProcess){
        int freePageCount = 0;
        int firstFreePageIndex = -1;

        int leastFrequency = Integer.MAX_VALUE;
        int leastFrequencyIndex = -1;

        for (int i = pageTableEntriesArray.length - 1; i >= 0; i--) {
            if (pageTableEntriesArray[i].used) {
                if (pageTableEntriesArray[i].processID == processID) {
                    if (pageTableEntriesArray[i].pageID == pageID) {
                        pageTableEntriesArray[i].frequency += 1;            //Increment counter after page hit
                        return i;
                    }
                }
                if (leastFrequency > pageTableEntriesArray[i].frequency) {
                    leastFrequencyIndex = i;
                    leastFrequency = pageTableEntriesArray[i].frequency;
                }
            }else {
                freePageCount += 1;
                firstFreePageIndex = i;
            }
        }

        if (isNewProcess) {
            if (freePageCount >= 4) {
                return firstFreePageIndex;
            }else {
                return -1;
            }
        }else {
            if (freePageCount > 0) {
                return firstFreePageIndex;
            }else {
                return leastFrequencyIndex;
            }
        }
    }
}
