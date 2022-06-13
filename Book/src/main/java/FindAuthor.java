import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FindAuthor implements BookInterface {
    @Override
    public String getName() {
        return "find author";
    }

    @Override
    public void exec(Statement statement) throws SQLException {

        System.out.print("Book : ");
        boolean bool = false;
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();

        ResultSet result = statement.executeQuery("SELECT a.author FROM Author9 a, Books9 b, AuthorAndBooks9 ab WHERE b.title = '" + title + "' AND b.id = ab.idBooks AND ab.authorId = a.id;");

        while (result.next()) {
            System.out.println("Author " + result.getString(1));
            bool = true;
        }

        if (!bool) {
            System.out.println("");
        }

    }

    @Override
    public String showHelp() {
        return "find author - find author bu book";
    }
}
