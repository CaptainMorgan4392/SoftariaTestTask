package webpagetable;

import java.util.Map;

public class WebPageTable {

    private final Map<String, String> pageTable;

    public WebPageTable(Map<String, String> pageTable) {
        this.pageTable = pageTable;
    }

    public Map<String, String> getPageTable() {
        return pageTable;
    }

    @Override
    public String toString() {
        StringBuilder stringImpl = new StringBuilder();

        stringImpl.append('[');

        int includedEntries = 0;
        for (Map.Entry<String, String> entry : this.getPageTable().entrySet()) {
            stringImpl.append('{')
                .append(entry.getKey()).append(", ").append(entry.getValue())
                .append('}').append(", ");
            ++includedEntries;
        }

        if (includedEntries != 0) {
            stringImpl.delete(stringImpl.length() - 2, stringImpl.length());
        }

        stringImpl.append(']');

        return stringImpl.toString();
    }
}
