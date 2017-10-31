/**
 * Created by loren on 10/30/17.
 */
public class PageTableEntry {
    Process owner; // the process which owns this frame
    int pageId; // 0, 1, 2, 3 ... 31
    int lastUsed; // the last time this page was accessed
}
