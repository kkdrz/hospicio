package pl.edu.pwr.drozd.hospicio;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("")
public class Main extends ResourceConfig {

    public Main() {
        packages("pl.edu.pwr.drozd.hospicio");
        register(Controller.class);
    }

}

