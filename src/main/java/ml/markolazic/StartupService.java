package ml.markolazic;

import ml.markolazic.learninglog.control.PostService;
import ml.markolazic.learninglog.model.Post;
import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

@Startup
@Singleton
public class StartupService {

    @PostConstruct
    public void init() {
        System.out.println(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/logo")))
                .lines().collect(Collectors.joining("\n")));
    }

}