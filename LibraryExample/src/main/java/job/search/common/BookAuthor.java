package job.search.common;

import java.util.Map;

public enum BookAuthor {
    JAVA(Map.of("JAVA", "Pradeep")),
    DOTNET(Map.of("DOTNET", "Deepak")),
    CPLUS(Map.of("CPLUS", "Leena")),
    ORACLE(Map.of("ORACLE", "Ashok")),
    MYSQL(Map.of("MYSQL", "Varun"));

    private Map<String, String> map;

    BookAuthor(Map<String, String> map) {
        this.map = map;
    }

    public String value(String key) {
        return this.map.get(key);
    }
}
