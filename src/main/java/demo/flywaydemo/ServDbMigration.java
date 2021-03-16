package demo.flywaydemo;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.nio.charset.Charset;

//@Service
public class ServDbMigration {

    @Autowired
    @Qualifier("reportDs")
    DataSource dataSource;

    private Flyway flywayBuilder(DataSource dataSource,String schemas){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .table("flyway_schema_history")
                .baselineOnMigrate(true)
                .baselineVersion("1")
                .locations("classpath:db/migration")
                .encoding(Charset.forName("utf-8"))
                .outOfOrder(false)
                .schemas(schemas)
                .validateOnMigrate(true)
                .load();

        return flyway;
    }


    public void migrate (){

        Flyway flyway = flywayBuilder(dataSource,"flyway");
        flyway.migrate();
    }
}
