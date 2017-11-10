public interface ReplacementAlgorithm {
    int getNewFrame(PageTableEntry[] pageTableEntriesArray, int processID, int pageID, boolean isNewProcess);
}
