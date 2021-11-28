package studio.auradevelopment.mongo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoCatch {

    public MongoCatch(){
        this.catchError();
    }

    private void catchError(){

        System.setProperty("DEBUG.GO", "true");
        System.setProperty("DB.TRACE", "true");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.WARNING);
    }
}
