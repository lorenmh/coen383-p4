class PageTableEntry {
    boolean used;
    int processID;
    int pageID;
//    int frameID;
    int lastReferenceTime;
    int frequency;

    public String toString() {
        return String.format(
                "{u: %b, pid: %d, pgid: %d, lrt: %d}", this.used, this.processID, this.pageID, this.lastReferenceTime
        );
    }
}