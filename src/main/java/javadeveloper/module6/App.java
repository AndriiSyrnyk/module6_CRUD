package javadeveloper.module6;

import javadeveloper.module6.client.ClientService;
import javadeveloper.module6.storage.*;

public class App {
    public static void main(String[] args) {
        new DatabaseMigrationService().migrate();
    }
}