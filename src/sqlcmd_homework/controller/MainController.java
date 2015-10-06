package sqlcmd_homework.controller;

import sqlcmd_homework.model.DatabaseManager;
import sqlcmd_homework.model.InMemoryDatabaseManager;
import sqlcmd_homework.model.JDBCDatabaseManager;
import sqlcmd_homework.view.Console;
import sqlcmd_homework.view.View;

/**
 * Created by Sims on 12/09/2015.
 */
public class MainController {

    private View view;
    private DatabaseManager manager;

    public MainController(View view, DatabaseManager manager){
        this.view = view;
        this.manager = manager;
    }

    public void run(){
        connectToDb();
    }

    private void connectToDb() {
        view.write("Hi, welcome to the database manager.");
        view.write("Enter 'database|userName|password' to connect to database:");
        while (true) {
            String string = view.read();
            String[] data = string.split("\\|");
            String databaseName = data[0];
            String userName = data[1];
            String password = data[2];
            try {
                manager.connect(databaseName, userName, password);
                break;
            } catch (Exception e) {
                String message = e.getMessage();
                if (e.getCause() != null) {
                    message += " " + e.getCause().getMessage();
                }
                view.write("Something went wrong: " + message);
                view.write("Try again:");
            }
        }
        view.write("Success!");
    }
}

