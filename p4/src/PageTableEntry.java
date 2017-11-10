class PageTableEntry {
    boolean used;
    int processID;
    int pageID;
//    int frameID;
    int lastReferenceTime;
    int frequency;

    boolean lockOnThisRound;

    public PageTableEntry() {
        this.used = false;
        this.lockOnThisRound = false;
    }


    public String toString() {
        return String.format(
                "{u: %b, pid: %d, pgid: %d, lrt: %d}", this.used, this.processID, this.pageID, this.lastReferenceTime
        );
    }
}