package com.javacore.steve;

import com.javacore.steve.dbservice.DBApplication;
import com.javacore.steve.dbservice.server.DBServer;
import com.javacore.steve.state.ApplicationState;
import com.javacore.steve.webservice.WebClientApplication;

/**
 * Application is the main entity will be using to start work with Steve
 *
 * @author Pavel Ezhkov
 * @version 0.0.5
 */

public class Application {
    public static final String APP_NAME = "Steve";
    public static final String AUTHOR = "Pavel Ezhkov";
    public static final String VERSION = "0.0.6";

    private static ApplicationState currentState;

    //private static DataBase dataBase;


    public static void main(String[] args) throws Exception {

        WebClientApplication.INSTANCE.start();
        /*
        DBApplication.INSTANCE.start();

        String query = "SELECT * FROM Criminals WHERE id = 3";

        String xml = DBApplication.INSTANCE.selectXML(query);
        System.out.println(xml);

        DBServer.INSTANCE.showSelect(xml);
*/


       // MainDataEncryptor encryptor = new MainDataEncryptor();
       // String test = encryptor.encrypt("A10");
       // System.out.println(test);
       // initDataBase();
        //dataBase.selectAndPrint("SELECT id, name FROM CriminalsFamilies");

       /* ProfileModel profileModel = new ProfileModel(1,"TestName","TestLastName", "Nick",1,new GregorianCalendar(1900,11,1),true,
                new GregorianCalendar(1925,6,11),10);
        ProfileView profileView = new ProfileView(profileModel);
        profileView.init();
        profileView.draw(new ConsoleCanvas(80,200));
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
/*
    private static void initDataBase(){
        Table criminals = DataBase.readTable("Criminals","tables/Criminals.tbl");
        Table crimeFamilies = DataBase.readTable("CriminalsFamilies","tables/CrimeFamily.tbl");
        dataBase = new DataBase();
        dataBase.setTables(criminals.getName(), criminals);
        dataBase.setTables(crimeFamilies.getName(), crimeFamilies);
    }*/
}
// три части client, appserver, DB. в первой принять запрос и отправить на 2. бд просто хранит данные.