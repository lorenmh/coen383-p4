/**
 * Created by Ken on 11/5/17.
 */
public class MFU implements ReplacementAlgorithm{
    @Override
    public int getNewFrame(PageTableEntry[] pageTableEntriesArray, int processID, int pageID, boolean isNewProcess){
        int freePageCount = 0;
        int firstFreePageIndex = -1;

        int mostFrequency = Integer.MIN_VALUE;
        int mostFrequencyIndex = -1;

        for (int i = pageTableEntriesArray.length - 1; i >= 0; i--) {
            if (pageTableEntriesArray[i].used) {
                if (pageTableEntriesArray[i].processID == processID) {
                    if (pageTableEntriesArray[i].pageID == pageID) {
                        pageTableEntriesArray[i].frequency += 1;            //Increment counter after page hit
                        return i;
                    }
                }
                if (mostFrequency < pageTableEntriesArray[i].frequency) {
                    mostFrequencyIndex = i;
                    mostFrequency = pageTableEntriesArray[i].frequency;
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
                return mostFrequencyIndex;
            }
        }
    }
}
