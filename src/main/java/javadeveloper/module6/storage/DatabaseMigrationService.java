package javadeveloper.module6.storage;

import org.flywaydb.core.Flyway;

public class DatabaseMigrationService {
    public void migrate() {
        String connectionUrl = "jdbc:h2:./megasoft";
        String user = "sa";
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, user, "")
                .load();
        flyway.migrate();
    }
}