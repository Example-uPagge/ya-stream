package dev.struchkov.yandex.stream;

import java.util.Collection;
import java.util.stream.Stream;

public final class Workers {

    public static final String SEO = "SEO";
    public static final String DEVELOPER = "Разработчик";
    public static final String ZAM_SEO = "Заместитель SEO";
    public static final String DIRECTOR_BY_FINANCE = "Директор по финансам";

    private Workers() {
        throw new IllegalStateException("UtilityClass");
    }

    public static Collection<Worker> getWorkers() {
        return Stream.of(
                Worker.of("Алексей", 35, SEO, 100_000_000L),
                Worker.of("Николай", 40, ZAM_SEO, 50_000_000L),
                Worker.of("Алена", 25, ZAM_SEO, 50_000_000L),
                Worker.of("Георгий", 30, DIRECTOR_BY_FINANCE, 50_000L),
                Worker.of("Дарья", 23, DEVELOPER, 23_000L),
                Worker.of("Михаил", 23, DEVELOPER, 23_000L),
                Worker.of("Алекс", 40, DEVELOPER, 24_000L),
                Worker.of("Илона", 25, DEVELOPER, 24_000L),
                Worker.of("Катя", 26, DEVELOPER, 25_000L),
                Worker.of("Катя", 30, DEVELOPER, 25_000L)
        ).toList();
    }

    public static Collection<Worker> getWorkersTwo() {
        return Stream.of(
                Worker.of("Карина", 60, SEO, 200_000_000L),
                Worker.of("Иван", 55, ZAM_SEO, 100_000_000L),
                Worker.of("Глаша", 34, ZAM_SEO, 100_000_000L),
                Worker.of("Сергей", 55, DIRECTOR_BY_FINANCE, 100_000_000L),
                Worker.of("Николай", 40, DEVELOPER, 50_000L),
                Worker.of("Ксений", 55, DEVELOPER, 50_000L),
                Worker.of("Алекс", 45, DEVELOPER, 50_000L),
                Worker.of("Илона", 50, DEVELOPER, 50_000L),
                Worker.of("Катя", 57, DEVELOPER, 50_000L),
                Worker.of("Катя", 54, DEVELOPER, 50_000L)
        ).toList();
    }

}
