import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteAuthor implements BookInterface {
    @Override
    public String getName() {
        return "delete author";
    }

    @Override
    public void exec(Statement statement) throws SQLException {
//        System.out.print("Author : ");
//        boolean bool = false;
//        Scanner in = new Scanner(System.in);
//        String author = in.nextLine();
//        statement.execute("DELETE FROM Author9 WHERE author = '"+ author + "' ");


        ResultSet result;
        Scanner scanner = new Scanner(System.in);
        boolean b = false;
        List<Integer> idBookDelete = new ArrayList<>();

        System.out.println("Author: ");
        String author = scanner.nextLine();

        result = statement.executeQuery("SELECT author FROM Author9 WHERE author = '" + author + "';");

        while (result.next()) {
            b = true;
        }

        if (b) {
            result = statement.executeQuery("SELECT COUNT(idBooks) num,idBooks FROM AuthorAndBooks9 WHERE idBooks IN (SELECT idBooks FROM AuthorAndBooks9 WHERE (authorId = (SELECT id FROM Author9 WHERE author = '" + author + "'))) GROUP BY idBooks;");

            while (result.next()) {
                if (result.getInt(1) == 1) {
                    idBookDelete.add(result.getInt(2));
                }
            }

            for (Integer idBook : idBookDelete) {
                statement.execute("DELETE FROM Books9 WHERE id = '" + idBook + "';");
            }

            statement.execute("DELETE FROM Author9 WHERE author = '" + author + "';");
        } else {
            System.out.println("Author is not find");
        }


    }

    @Override
    public String showHelp() {
        return "delete author - delete author into the table";
    }
}
