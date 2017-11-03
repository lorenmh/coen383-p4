public class LRU implements ReplacementAlgorithm {
    @Override
    public int getNewFrame(Page[] pageArray, int processID, int pageID) {
        boolean isNewProcess = true;
        int leastRecentReferenceTime = Integer.MIN_VALUE;
        int leastRecentReferenceIndex = -1;
        int freePageCount = 0;
        int firstFreePageIndex = -1;

        for (int i = pageArray.length - 1; i >= 0; i--) {
            if (pageArray[i].used) {
                if (pageArray[i].processID == processID) {
                    if (pageArray[i].pageID == pageID) {
                        return i;
                    }
                    isNewProcess = false;
                }
                if (leastRecentReferenceTime > pageArray[i].lastReferenceTime) {
                    leastRecentReferenceIndex = i;
                    leastRecentReferenceTime = pageArray[i].lastReferenceTime;
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
            return leastRecentReferenceIndex;
        }
    }
}
