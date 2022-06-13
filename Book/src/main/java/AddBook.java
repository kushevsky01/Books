import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static java.util.Optional.empty;

public class AddBook implements BookInterface {
    @Override
    public String getName() {
        return "add book";
    }

    @Override
    public void exec(Statement statement) throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.print("Author : ");
        String author = in.nextLine();
        System.out.print("Title : ");
        String title = in.nextLine();
        ResultSet result4;
        boolean b = true;
        boolean books = true;
        boolean authorA = true;
        int k = 0;


        ResultSet result = statement.executeQuery("Select id From Author9 WHERE author = '" + author + "'");

        while (result.next()) {
            authorA = false;
        }
        if (authorA) {
            statement.execute("INSERT INTO Author9(author) VALUES('" + author + "');");
        }

        result = statement.executeQuery("Select id From Author9 WHERE author = '" + author + "'");
        while (result.next()) {
            k = result.getInt(1);
        }

        result = statement.executeQuery("Select id From Books9 WHERE title = '" + title + "'");
        while (result.next()) {
            books = false;
        }
        if (books) {
            statement.execute("INSERT INTO Books9(title, authorId) VALUES('" + title + "', '" + k + "');");
        }


//        result4 = statement.executeQuery("SELECT idBooks, authorId FROM AuthorAndBooks9 WHERE (SELECT Books9.id FROM Books9 WHERE ((Books9.title='"+title+"') AND (Books9.authorId = '"+k+"')))= idBooks AND (SELECT Author9.id from Author9 WHERE Author9.author = '" + author + "') = authorId ; ");
        result4 = statement.executeQuery("SELECT idBooks, authorId FROM AuthorAndBooks9 WHERE (SELECT Books9.id FROM Books9 WHERE Books9.title='" + title + "')= idBooks AND (SELECT Author9.id from Author9 WHERE Author9.author = '" + author + "') = authorId ; ");
        while (result4.next() && b) {
            b = false;
        }

        if (b) {

//            statement.execute("INSERT INTO Books9(title, authorId) VALUES('" + title + "',(SELECT Author9.id From Author9 WHERE Author9.author = '" + author + "'));");
            ResultSet result1 = statement.executeQuery("Select id From Books9 WHERE title = '" + title + "'");
            result1.next();
            k = result1.getInt(1);

            statement.execute("INSERT INTO AuthorAndBooks9(idBooks, authorId) VALUES( '" + k + "' ,  (SELECT Author9.id From Author9 WHERE Author9.author = '" + author + "'));");
        } else {
            System.out.println("Book with this author was added earlier");
        }
    }


    @Override
    public String showHelp() {

        return "add book - add book to table";
    }
}
