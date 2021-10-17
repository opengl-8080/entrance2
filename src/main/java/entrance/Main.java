package entrance;

import gl.util.ObjectContainer;
import gl.util.config.ConfigResolver;
import gl.util.config.EnvironmentVariableConfigResolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.h2.tools.Console;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static  final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        initializeObjectContainer();
        final EntranceHome entranceHome = ObjectContainer.getInstance().get(EntranceHome.class);

        final List<String> arguments = Arrays.asList(args);
        if (arguments.contains("--dbconsole")) {
            Console.main("-url", "jdbc:h2:" + entranceHome.dbPath(), "-user", "sa");
        } else {
            final Flyway flyway = Flyway.configure().dataSource("jdbc:h2:" + entranceHome.dbPath(), "sa", "").load();
            flyway.migrate();
            FxMain.launch(FxMain.class, args);
        }
    }

    private static void initializeObjectContainer() {
        final ObjectContainer container = ObjectContainer.getInstance();
        final ConfigResolver configResolver = new EnvironmentVariableConfigResolver();
        container.register(ConfigResolver.class, new EnvironmentVariableConfigResolver());
        container.register(EntranceHome.class, new EntranceHome(configResolver));

        logger.info("ObjectContainer initialized.");
    }
}