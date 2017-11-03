/**
 * Created by loren on 10/30/17.
 */
public class PageTable {
    private Page[] entries = new Page[100];
    private ReplacementAlgorithm pageReplacement;

    public void setReplacementAlgorithm(ReplacementAlgorithm algorithm) {
        this.pageReplacement = algorithm;
    }
    public void cleanPageTable() {
        for (Page page: entries) {
            page.used = false;
        }
    }
    public int getFrame(int processID, int pageID) {
        return pageReplacement.getNewFrame(entries, processID, pageID);
    }

}
