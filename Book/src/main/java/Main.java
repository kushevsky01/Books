import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static BookInterface[] commands;

    Main() {
        commands = new BookInterface[9];

        this.commands[6] = new AddAuthor();
        this.commands[7] = new AddBook();
        this.commands[1] = new DeleteAuthor();
        this.commands[2] = new Deletebook();
        this.commands[4] = new FindAuthor();
        this.commands[5] = new FindBook();
        this.commands[0] = new PrintBook();
        this.commands[8] = new Help();
        this.commands[3] = new Exite();

    }


    public static BookInterface[] getCommands() {

        return commands;
    }

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:h2:~/BookTest";
        Connection connection = DriverManager.getConnection(url, "sa", "");
        Statement statement = connection.createStatement();

//        statement.execute("CREATE TABLE Author9(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, author VARCHAR(50) NOT NULL, UNIQUE(author));");
//        statement.execute("CREATE TABLE Books9(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, title VARCHAR(50) NOT NULL, authorId INT NOT NULL );");
//        statement.execute("CREATE TABLE AuthorAndBooks9(idBooks INT NOT NULL, authorId INT NOT NULL,  FOREIGN KEY(authorId) REFERENCES Author9(id)  ON DELETE CASCADE, FOREIGN KEY(idBooks) REFERENCES Books9(id)  ON DELETE CASCADE );");


        Scanner in = new Scanner(System.in);
        System.out.println(Main.commands);
        Main com = new Main();

        while (true) {
            System.out.print("(user)>>");
            String cmd = in.nextLine();

            boolean correct = false;
            for (BookInterface command : com.getCommands()) {
                correct = false;
                if (command.getName().contentEquals(cmd)) {
                    command.exec(statement);
                    correct = true;
                    break;
                }

            }
            if (!correct) {
                System.out.println(cmd + "-  не является внутренней или внешней командой");

            }

        }


    }
}
