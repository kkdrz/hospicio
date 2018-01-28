package pl.edu.pwr.drozd.hospicio.rest.controller;

import org.glassfish.jersey.server.mvc.Template;
import pl.edu.pwr.drozd.hospicio.Main;
import pl.edu.pwr.drozd.hospicio.domain.entity.*;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Path("/")
public class JSPController {

    @GET
    @Template(name = "/index.jsp")
    public Specjalizacja index() {
        Specjalizacja spec = new Specjalizacja();
        spec.setNazwa("dupa");
        spec.setId(1);
        return spec;
    }

    @GET
    @Path("/prezentacja")
    @Template(name = "/prezentacja.jsp")
    public List<PlanHospitacji> prezentacja() {
        return Main.PLANY_HOSPITACJI.stream()
                .filter(PlanHospitacji::czyZaakceptowany)
                .filter(PlanHospitacji::czyZakonczony)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/generate")
    @Produces("text/plain")
    public Response downloadFile(@QueryParam("hosp1") int hosp1ID,
                                 @QueryParam("hosp2") int hosp2ID) throws IOException {

        PlanHospitacji p1 = znajdzPlanPoId(hosp1ID);
        PlanHospitacji p2 = znajdzPlanPoId(hosp2ID);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("plik.txt").getFile());

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for (PlanHospitacji p : Arrays.asList(p1, p2)) {
            writer.write("Plan hospitacji:  " + p.getKierunek().getNazwa() + "  " + p.getSemestr().toString());
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write("Hospitacje: ");
            writer.newLine();
            writer.newLine();

            for (Hospitacja h : p.getHospitacje()) {
                writer.write("Kurs: " + h.getKurs().getNazwa());
                writer.newLine();
                writer.write("Hospitowany: " + h.getHospitowany().getStopienNaukowy().getNazwa() + " " + h.getHospitowany().getImie() + " " + h.getHospitowany().getNazwisko());
                writer.newLine();
                writer.write("Komisja: ");
                writer.newLine();
                writer.write("     Przewodniczacy: " + h.getKomisja().getPrzewodniczacy().getStopienNaukowy().getNazwa() + " " + h.getKomisja().getPrzewodniczacy().getImie() + " " + h.getKomisja().getPrzewodniczacy().getNazwisko());
                writer.newLine();
                for (Pracownik prac : h.getKomisja().getCzlonkowie()) {
                    writer.write("     Członek: " + prac.getStopienNaukowy().getNazwa() + " " + prac.getImie() + " " + prac.getNazwisko());
                    writer.newLine();
                }
                writer.newLine();
                writer.newLine();
            }
            writer.newLine();
            writer.newLine();
            writer.write("---------------------------------");
            writer.newLine();
        }

        writer.close();

        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=\"prezentacja.txt\"");
        return response.build();
    }

    private PlanHospitacji znajdzPlanPoId(int hosp2ID) {
        List<PlanHospitacji> plany = Main.PLANY_HOSPITACJI.stream()
                .filter(h -> h.getId() == hosp2ID)
                .collect(Collectors.toList());
        return plany.get(0);
    }

    private Hospitacja znajdzHospitacjePoId(int hosp2ID) {
        return Main.PLANY_HOSPITACJI.stream()
                .map(PlanHospitacji::getHospitacje)
                .flatMap(Collection::stream)
                .filter(h -> h.getId() == hosp2ID)
                .collect(Collectors.toList())
                .get(0);
    }

    @GET
    @Path("/plan/{id}")
    @Template(name = "/plan.jsp")
    public PlanHospitacji plan(@PathParam("id") int id) {
        PlanHospitacji toRet = Main.PLANY_HOSPITACJI.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (toRet == null) return Main.PLANY_HOSPITACJI.get(0);

        return toRet;
    }

    @GET
    @Path("/plan/{id}/zatwierdz")
    @Template(name = "/planz.jsp")
    public PlanHospitacji planzatwierdz(@PathParam("id") int id) {
        PlanHospitacji toRet = Main.PLANY_HOSPITACJI.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (toRet == null) return Main.PLANY_HOSPITACJI.get(0);

        if (!istniejeZatwierdzonyPlanNaSemestr(toRet.getSemestr(), toRet.getKierunek())) {
            toRet.setDataAkceptacji(new Date(new java.util.Date().getTime()));
            toRet.setZaakceptowany(true);
        }
        return toRet;
    }

    private boolean istniejeZatwierdzonyPlanNaSemestr(Semestr semestr, Kierunek kierunek) {
        List<Semestr> semestry = Main.PLANY_HOSPITACJI.stream()
                .filter(PlanHospitacji::czyZaakceptowany)
                .filter(p -> p.getKierunek().equals(kierunek))
                .map(PlanHospitacji::getSemestr)
                .collect(Collectors.toList());
        return semestry.contains(semestr);
    }


    @GET
    @Path("/plany")
    @Template(name = "/planyhospitacji.jsp")
    public List<PlanHospitacji> plany(@QueryParam("studies") int studies,
                                      @QueryParam("accepted") int accepted) {
        List<PlanHospitacji> toRet = Main.PLANY_HOSPITACJI;
        switch (studies) {
            case 1:
                toRet = Main.PLANY_HOSPITACJI.stream()
                        .filter(p -> "Informatyka".equals(p.getKierunek().getNazwa()))
                        .collect(Collectors.toList());
                break;
            case 2:
                toRet = Main.PLANY_HOSPITACJI.stream()
                        .filter(p -> "Inżynieria Systemów".equals(p.getKierunek().getNazwa()))
                        .collect(Collectors.toList());
                break;
            case 3:
                toRet = Main.PLANY_HOSPITACJI.stream()
                        .filter(p -> "Zarządzanie".equals(p.getKierunek().getNazwa()))
                        .collect(Collectors.toList());
                break;
        }

        switch (accepted) {
            case 1:
                toRet = toRet.stream()
                        .filter(PlanHospitacji::czyZaakceptowany)
                        .collect(Collectors.toList());
                break;
            case 2:
                toRet = toRet.stream()
                        .filter(p -> !p.czyZaakceptowany())
                        .collect(Collectors.toList());
                break;
        }

        return toRet;
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlanHospitacji> hospitacje2() {
        return Main.PLANY_HOSPITACJI;
    }

}
