package demo.flywaydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootTest
class FlywayDemoApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ServDbMigration dbMigration;

    @Test
    void contextLoads() {
        dbMigration.migrateAll();
    }

}
