import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintBook implements BookInterface {
    @Override
    public String getName() {
        return "print";
    }

    @Override
    public void exec(Statement statement) throws SQLException {
        ResultSet result = statement.executeQuery("SELECT A.author, B.title, B.authorId FROM Author9 A, Books9 B, AuthorAndBooks9 t3 WHERE A.id = t3.authorId  and B.id = t3.idBooks;");
        while (result.next()) {
            System.out.println("Author " + result.getString(1) + " BOOK " + result.getString(2));
        }

    }

    @Override
    public String showHelp() {
        return "prtint - print table";
    }
}
