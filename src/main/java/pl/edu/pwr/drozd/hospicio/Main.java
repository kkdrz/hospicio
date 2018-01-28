package pl.edu.pwr.drozd.hospicio;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import pl.edu.pwr.drozd.hospicio.domain.entity.PlanHospitacji;
import pl.edu.pwr.drozd.hospicio.domain.service.DataProvider;
import pl.edu.pwr.drozd.hospicio.rest.controller.JSPController;

import javax.ws.rs.ApplicationPath;
import java.util.List;

@ApplicationPath("")
public class Main extends ResourceConfig {

    public static List<PlanHospitacji> PLANY_HOSPITACJI;

    public Main() {
        packages("pl.edu.pwr.drozd.hospicio");
        register(JSPController.class);
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");

        PLANY_HOSPITACJI = DataProvider.generatePlanyHospitacji();
    }

}

