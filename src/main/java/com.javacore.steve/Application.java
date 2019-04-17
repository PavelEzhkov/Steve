package com.javacore.steve;

import com.javacore.steve.common.ConsoleCanvas;
import com.javacore.steve.helpers.CommandParser;
import com.javacore.steve.profile.ProfileController;
import com.javacore.steve.state.ApplicationState;
import com.javacore.steve.state.StateIdle;
import db.DataBase;
import db.Record;
import db.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Application is the main entity will be using to start work with Steve
 *
 * @author Pavel Ezhkov
 * @version 0.0.2
 */

public class Application {
    public static final String APP_NAME = "Steve";
    public static final String AUTHOR = "Pavel Ezhkov";
    public static final String VERSION = "0.0.4";
    private static ApplicationState currentState;

    public static void main(String[] args) {
        List<String[]> records = DataBase.readDataFile("//criminals.tdl");
        Table table = new Table("Criminls", Arrays.asList(new String[]{"id","name","deceased"}));
        for (String[] s: records
             ) {
            Record record = new Record(table);
            record.setValues(s);
            table.insert(record);

        }

        System.out.println("All's ok");

        /**
         * example of sinhronized
         */
        /*
        final DataBase dataBase = new DataBase();
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataBase.select();
                }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                  dataBase.update();

            }
        };
        thread.start();
        (new Thread((runnable))).start();
*/


        /**
         * test DB
         */

        /*
        List<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("firstname");
        columns.add("lastname");
        Table criminalTable = new Table("Criminals", columns);
        List<String> values = new ArrayList<>();
        List<String> values2 = new ArrayList<>();
        List<String> values3 = new ArrayList<>();
        values.add("1");
        values.add("Vladimir");
        values.add("Tramp");
        values2.add("2");
        values2.add("Donald");
        values2.add("Timishenko");
        values3.add("3");
        values3.add("Jon");
        values3.add("Snow");
        criminalTable.insert(new Record(values));
        criminalTable.insert(new Record(values2));
        criminalTable.insert(new Record(values3));
        DataBase dataBase = new DataBase(criminalTable.getName(),criminalTable);
        //dataBase.select("SELECT id, firstName, lastName from Criminals");
        dataBase.select("SELECT id, firstName, lastName from Criminals where id = 3");
        //
        //criminalTable.select();

*/

        /**
         * test Canvas
         */
        //ConsoleCanvas canvas = new ConsoleCanvas(75,75);
        //canvas.setSymbolAt(0,2,'A');
        //canvas.drawSquareAt(2,4,5);
        //canvas.drawCircleAt(37,37,25);
        //canvas.drawTestAt(1,6,"asdfdhgfdhfdghsdfgljksrgehklsergnklgsrdhlkasfghlkfasgjh");
        //canvas.draw();

        // ProfileController profileController = new ProfileController();
        // profileController.showProfile(6);

        /**
         * test Threads
         */

        /*
        Thread thread = new Thread(){
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){}
                }
                System.out.println("done");
            }

        };
        System.out.print("\nLoading");
        thread.start();*/

        /*
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print("-");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }

                }
            }
            };
        Thread thread = new Thread(){
            @Override
            public void run()
            {
                for (int i = 0; i < 100; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(100);
                        System.out.println(this.getState());
                    } catch (InterruptedException e){}
                }
                System.out.println(this.getState());
            }

        };
        System.out.println(thread.getState());
        (new Thread(runnable1)).start();
        thread.start();
*/

        /**
         * test Commands
         */

        /*changeState(new StateIdle(), "idle");
        Scanner scanner = new Scanner(System.in);
        String commandName;

        while (true) {
            String newString = scanner.nextLine();
            commandName = CommandParser.pars(newString.toLowerCase());
            //System.out.println(commandName);
            if (commandName.equals("bye"))
                break;
            currentState.onCommand(commandName);
        }*/
    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        currentState.enter(commandName);
    }

}
