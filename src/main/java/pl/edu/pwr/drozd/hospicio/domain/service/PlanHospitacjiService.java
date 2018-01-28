package pl.edu.pwr.drozd.hospicio.domain.service;

import pl.edu.pwr.drozd.hospicio.Main;
import pl.edu.pwr.drozd.hospicio.domain.entity.PlanHospitacji;
import pl.edu.pwr.drozd.hospicio.domain.entity.Semestr;

import java.util.List;

public class PlanHospitacjiService {

    public List<PlanHospitacji> findAll() {
        return Main.PLANY_HOSPITACJI;
    }

    /** Sprawdza czy na podany @semestr istnieje zaakceptowany plan hospitacji
     * @param semestr semestr w którym sprawdzamy, czy istnieje zaakceptowany plan hospitacji
     * @return true lub false, zaleznie od tego czy istnieje zaakceptowany plan hospitacji w podanym semestrze
     */
    public boolean istniejeZaakceptowanyPlanHospitacjinaSemestr(Semestr semestr) {
        return semestr != null &&
                findAll().stream()
                        .filter(p -> p.czyZaakceptowany())
                        .filter(p -> p.getSemestr().equals(semestr))
                        .count() > 0;

    }
}
