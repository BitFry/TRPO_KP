/*
 * TRPO_KPApp.java
 */

package trpo_kp;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import trpo_kp.control.OrganisationControl;

/**
 * The main class of the application.
 */
public class TRPO_KPApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        OrganisationControl.initEntityManagerFactory();
        show(new TRPO_KPView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TRPO_KPApp
     */
    public static TRPO_KPApp getApplication() {
        return Application.getInstance(TRPO_KPApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(TRPO_KPApp.class, args);
    }
}
