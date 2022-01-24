package webpagetable.service;

import mapcomparator.MapComparator;
import mapcomparator.MapComparatorImpl;
import webpagetable.WebPageTable;

public class WebPageTableService {

    private final WebPageTable yesterdayTable;

    private final WebPageTable todayTable;

    private final MapComparator<String, String> mapComparator;

    public WebPageTableService(WebPageTable yesterdayTable, WebPageTable todayTable) {
        this.yesterdayTable = yesterdayTable;
        this.todayTable = todayTable;
        this.mapComparator = new MapComparatorImpl<>();
    }

    public void formattedOutput() {
        System.out.println("Здравствуйте, дорогая и.о. секретаря\n" +
            "\n" +
            "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n" +
            "\n" +
            "\n" +
            "Исчезли следующие страницы: " + getRemovedPages().toString() + "\n" +
            "\n" +
            "Появились следующие новые страницы " + getNewPages().toString() + "\n" +
            "\n" +
            "Изменились следующие страницы " + getModifiedPages().toString() + "\n" +
            "\n" +
            "\n" +
            "С уважением,\n" +
            "\n" +
            "автоматизированная система\n" +
            "\n" +
            "мониторинга.");
    }

    public WebPageTable getRemovedPages() {
        return new WebPageTable(mapComparator.leftDiff(yesterdayTable.getPageTable(), todayTable.getPageTable()));
    }

    public WebPageTable getNewPages() {
        return new WebPageTable(mapComparator.rightDiff(yesterdayTable.getPageTable(), todayTable.getPageTable()));
    }

    public WebPageTable getModifiedPages() {
        return new WebPageTable(mapComparator.valueDiff(yesterdayTable.getPageTable(), todayTable.getPageTable()));
    }

}
