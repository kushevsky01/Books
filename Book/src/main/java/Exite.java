import java.sql.Statement;

public class Exite implements BookInterface {
    @Override
    public String getName() {
        return "exite";
    }

    @Override
    public void exec(Statement statement) {
        System.exit(0);

    }

    @Override
    public String showHelp() {
        return "exite";
    }
}
