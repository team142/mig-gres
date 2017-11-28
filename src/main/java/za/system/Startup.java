/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.system;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author just1689
 */
public class Startup {
    
    
    public static final AtomicBoolean STARTED = new AtomicBoolean(false);
    private static final String MIG_GRES_PATH_KEY = "MIG_GRES_PATH";
    
    public static synchronized void startup() {
        
        Repository.MIG_GRES_PATH = System.getenv(MIG_GRES_PATH_KEY);
        if (Repository.MIG_GRES_PATH == null || Repository.MIG_GRES_PATH.isEmpty()) {
            System.err.println("Could not find anything in " + MIG_GRES_PATH_KEY + " environment variable");
            System.exit(1);
            return;
        }
        STARTED.set(true);
        
    }
    
}
