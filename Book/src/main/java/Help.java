;

import java.sql.SQLException;
import java.sql.Statement;

public class Help implements BookInterface {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void exec(Statement statement) throws SQLException {
        for (BookInterface com : Main.getCommands()) {
            System.out.println(com.showHelp());
        }

    }

    @Override
    public String showHelp() {
        return "help";
    }
}
