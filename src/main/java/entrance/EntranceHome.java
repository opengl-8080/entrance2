package entrance;

import gl.util.Directory;
import gl.util.config.ConfigResolver;

import java.nio.file.Path;

public class EntranceHome {
    private final Directory directory;

    public EntranceHome(ConfigResolver configResolver) {
        final String home = configResolver.resolveOptional("entrance.home").orElse("~/.entrance2");
        this.directory = new Directory(Path.of(home), Directory.InitializeStrategy.CREATE);
    }

    public String stringPath() {
        return directory.path().toString();
    }

    public String dbPath() {
        return stringPath() + "/database";
    }
}
