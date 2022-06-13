import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddAuthor implements BookInterface {
    @Override
    public String getName() {
        return "add author";
    }


    @Override
    public void exec(Statement statement) throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.print("Author : ");
        String author = in.nextLine();

        try {
            statement.execute("INSERT INTO Author9(author) VALUES('" + author + "');");
        } catch (SQLException e) {
            System.out.println("Author is added earlier");
        }

    }

    @Override
    public String showHelp() {

        return "add author - add author to table";
    }
}
