import org.junit.Test;
import webpagetable.WebPageTable;
import webpagetable.service.WebPageTableService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WebPageTableServiceTest {

    private WebPageTable yesterdayTable;

    private WebPageTable todayTable;

    @Test
    public void checkIdenticalTables() {
        yesterdayTable = new WebPageTable(
            Map.of(
                "url1", "lol",
                "url2", "kek",
                "url3", "chebyrek"
            )
        );

        todayTable = new WebPageTable(
            Map.of(
                "url1", "lol",
                "url2", "kek",
                "url3", "chebyrek"
            )
        );

        WebPageTableService webPageTableService = new WebPageTableService(yesterdayTable, todayTable);
        webPageTableService.formattedOutput();

        assertEquals(webPageTableService.getRemovedPages().getPageTable(), new HashMap<>());
        assertEquals(webPageTableService.getNewPages().getPageTable(), new HashMap<>());
        assertEquals(webPageTableService.getModifiedPages().getPageTable(), new HashMap<>());
    }

    @Test
    public void checkTablesWithRemovedPages() {
        yesterdayTable = new WebPageTable(
            Map.of(
                "url1", "lol",
                "url2", "kek",
                "url3", "chebyrek"
            )
        );

        todayTable = new WebPageTable(
            Map.of(
                "url1", "lol",
                "url3", "chebyrek"
            )
        );

        WebPageTableService webPageTableService = new WebPageTableService(yesterdayTable, todayTable);
        webPageTableService.formattedOutput();

        assertEquals(webPageTableService.getRemovedPages().getPageTable(), Map.of("url2", "kek"));
        assertEquals(webPageTableService.getNewPages().getPageTable(), new HashMap<>());
        assertEquals(webPageTableService.getModifiedPages().getPageTable(), new HashMap<>());
    }

    @Test
    public void checkTablesWithNewPages() {
        yesterdayTable = new WebPageTable(
            Map.of(
                "url2", "kek",
                "url3", "chebyrek"
            )
        );

        todayTable = new WebPageTable(
            Map.of(
                "url1", "lol",
                "url2", "kek",
                "url3", "chebyrek"
            )
        );

        WebPageTableService webPageTableService = new WebPageTableService(yesterdayTable, todayTable);
        webPageTableService.formattedOutput();

        assertEquals(webPageTableService.getRemovedPages().getPageTable(), new HashMap<>());
        assertEquals(webPageTableService.getNewPages().getPageTable(), Map.of("url1", "lol"));
        assertEquals(webPageTableService.getModifiedPages().getPageTable(), new HashMap<>());
    }

    @Test
    public void checkTablesWithModifiedPages() {
        yesterdayTable = new WebPageTable(
            Map.of(
                "url1", "kek",
                "url2", "lol",
                "url3", "kek"
            )
        );

        todayTable = new WebPageTable(
            Map.of(
                "url1", "lol",
                "url2", "kek",
                "url3", "chebyrek"
            )
        );

        WebPageTableService webPageTableService = new WebPageTableService(yesterdayTable, todayTable);
        webPageTableService.formattedOutput();

        assertEquals(webPageTableService.getRemovedPages().getPageTable(), new HashMap<>());
        assertEquals(webPageTableService.getNewPages().getPageTable(), new HashMap<>());
        assertEquals(
            webPageTableService.getModifiedPages().getPageTable(),
            Map.of(
                "url1", "lol",
                "url2", "kek",
                "url3", "chebyrek"
            ));
    }

}
