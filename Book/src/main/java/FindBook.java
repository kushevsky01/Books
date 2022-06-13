import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FindBook implements BookInterface {

    @Override
    public String getName() {
        return "find book";
    }

    @Override
    public void exec(Statement statement) throws SQLException {
        boolean bool = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Author: ");
        String author = scanner.nextLine();

        ResultSet result = statement.executeQuery("SELECT b.title FROM Author9 a, Books9 b, AuthorAndBooks9 ab WHERE a.author = '" + author + "' AND a.id = ab.authorId AND ab.idBooks = b.id;");

        while (result.next()) {
            System.out.println("Book " + result.getString(1));
            bool = true;
        }

        if (!bool) {
            System.out.println("Author is not found");
        }

    }

    @Override
    public String showHelp() {
        return "find book - find authors books";
    }

}

