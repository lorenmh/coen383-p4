/**
 * Created by loren on 10/30/17.
 */
public class PageTable {
    private PageTableEntry[] entries = new PageTableEntry[100];
    private ReplacementAlgorithm pageReplacement;

    public void setReplacementAlgorithm(ReplacementAlgorithm algorithm) {
        this.pageReplacement = algorithm;
    }
    public void cleanPageTable() {
        for (PageTableEntry page: entries) {
            page.used = false;
        }
    }


    public boolean pageExistsInTable(int processID, int pageID) {
        for (PageTableEntry entry : entries) {
            if (entry.processID == processID && entry.pageID == pageID) return true;
        }
        return false;
    }

    public void lockFrameFor(int processID, int pageID) {
        for (PageTableEntry entry : entries) {
            if (entry.processID == processID && entry.pageID == pageID) {
                entry.lockOnThisRound = true;
            }
        }
    }


    public int getFrameFor(int processID, int pageID) {
        return pageReplacement.getNewFrame(entries, processID, pageID);
    }

    public void print() {
        System.out.println("[");
        for (PageTableEntry entry : this.entries) {
            System.out.println("\t" + entry.toString());
        }
        System.out.println("]");
    }

}
