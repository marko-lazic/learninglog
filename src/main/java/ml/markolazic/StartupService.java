package ml.markolazic;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Startup
@Singleton
public class StartupService {

//    @Resource
//    private DataSource dataSource;
//
//    @PostConstruct
//    public void init() {
//        try (Connection connection = dataSource.getConnection()) {
//            System.out.println(
//                    connection.getMetaData().getDatabaseProductName() + "-" +
//                            connection.getCatalog()
//            );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}