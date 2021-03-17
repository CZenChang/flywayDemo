package demo.flywaydemo;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.nio.charset.Charset;

@Service
public class ServDbMigration {

    @Autowired
    DataSource dataSource;


    private Flyway flywayBuilder(DataSource dataSource,String schema){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .table("flyway_schema_history")
                .baselineOnMigrate(true)
                .baselineVersion("1")
                .locations("classpath:db/migration/"+schema)
                .encoding(Charset.forName("utf-8"))
                .outOfOrder(false)
                .schemas(schema)
                .validateOnMigrate(true)
                .load();

        return flyway;
    }


    public void migrateAll (){
        migschemaA();
        migschemaB();

    }

    public void migschemaA(){
        Flyway flyway = flywayBuilder(dataSource,"schemaA");
        flyway.migrate();
    }

    public void migschemaB(){
        Flyway flyway = flywayBuilder(dataSource,"schemaB");
        flyway.migrate();
    }
}
