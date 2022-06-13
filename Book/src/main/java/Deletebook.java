import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deletebook implements BookInterface {
    @Override
    public String getName() {
        return "delete book";
    }

    @Override
    public void exec(Statement statement) throws SQLException {

        boolean bool = false;
        ResultSet result;
        Scanner scanner = new Scanner(System.in);
        boolean b = false;

        System.out.println("Book: ");
        String title = scanner.nextLine();

        result = statement.executeQuery("SELECT title FROM Books9 WHERE title = '" + title + "';");

        while (result.next()) {
            bool = true;
        }
        if (bool) {

            statement.execute("DELETE FROM Books9 WHERE title = '" + title + "';");
        } else {
            System.out.println("Book is not found");
        }
    }

    @Override
    public String showHelp() {
        return "delete book - delete book into the table";
    }
}
