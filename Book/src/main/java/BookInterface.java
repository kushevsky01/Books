import java.sql.SQLException;
import java.sql.Statement;

public interface BookInterface {

    String getName();

    void exec(Statement statement) throws SQLException;

    String showHelp();
}
