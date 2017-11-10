/**
 * Created by loren on 10/30/17.
 */
public class PageTable {
    private PageTableEntry[] entries;
    private ReplacementAlgorithm pageReplacement;

    public void setReplacementAlgorithm(ReplacementAlgorithm algorithm) {
        this.pageReplacement = algorithm;
    }
    public void cleanPageTable() {
        for (PageTableEntry page: entries) {
            page.used = false;
        }
    }

    public PageTable() {
        this.entries = new PageTableEntry[100];
        for (int i = 0; i < 100; i++) {
            this.entries[i] = new PageTableEntry();
        }
    }



    public int numFreeFrames() {
        int numFree = 0;

        for (PageTableEntry entry : entries) {
           if (!entry.used) numFree++;
        }

        return numFree;
    }

    public void freeFramesForProcess(Process process) {
        for (PageTableEntry entry : entries) {
            if (entry.processID == process.id) entry.used = false;
        }
    }

    public boolean pageExistsInTable(int processID, int pageID) {
        for (PageTableEntry entry : entries) {
            if (entry.processID == processID && entry.pageID == pageID) return true;
        }
        return false;
    }


    public int getFrameFor(int processID, int pageID, int time) {
        int newFrameNumber = pageReplacement.getNewFrame(entries, processID, pageID);
        double currentTime = (double)time / 10.0;
        System.out.printf("At time: %.1f, process %d, page %d gets referenced, ",currentTime, processID, pageID);
        if (entries[newFrameNumber].processID == processID && entries[newFrameNumber].pageID == pageID) {
            System.out.printf("page already in memory, ");
            entries[newFrameNumber].frequency += 1;
        }else if (!entries[newFrameNumber].used) {
            System.out.printf("assigned a free memory frame, ");
            entries[newFrameNumber].frequency = 1;
        }else {
            System.out.printf("process %d, page %d gets swapped out, ", entries[newFrameNumber].processID, entries[newFrameNumber].pageID);
            entries[newFrameNumber].frequency = 1;
        }
        System.out.printf("memory frame number is %d.\n", newFrameNumber);
        entries[newFrameNumber].used = true;
        entries[newFrameNumber].pageID = pageID;
        entries[newFrameNumber].processID = processID;
        entries[newFrameNumber].lastReferenceTime = time;
        return newFrameNumber;
    }

    public void print() {
        System.out.println("[");
        for (PageTableEntry entry : this.entries) {
            System.out.println("\t" + entry.toString());
        }
        System.out.println("]");
    }

}
