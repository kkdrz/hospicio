package pl.edu.pwr.drozd.hospicio.domain.service;

import org.junit.Before;
import org.junit.Test;
import pl.edu.pwr.drozd.hospicio.Main;
import pl.edu.pwr.drozd.hospicio.domain.entity.PlanHospitacji;
import pl.edu.pwr.drozd.hospicio.domain.entity.Semestr;

import static org.junit.Assert.*;


public class PlanHospitacjiServiceTest {

    PlanHospitacjiService planHospitacjiService;
    SemestrService semestrService;

    @Before
    public void setUp() throws Exception {
        Main.PLANY_HOSPITACJI = DataProvider.generatePlanyHospitacji();
        planHospitacjiService = new PlanHospitacjiService();
        semestrService = new SemestrService();
    }

    @Test
    public void istniejeZaakceptowanyPlanHospitacjinaSemestr_nonExisitingSemestr_expectFalse() throws Exception {
        Semestr semestr = null;

        boolean actual = planHospitacjiService.istniejeZaakceptowanyPlanHospitacjinaSemestr(semestr);

        assertFalse("Nie moze istniec zaakceptowany plan hospitacji na nieistniejący semestr",actual);
    }


    @Test
    public void istniejeZaakceptowanyPlanHospitacjinaSemestr_ExisitingSemestr_expectTrue() throws Exception {
        Semestr semestr = semestrService.findAll().get(0);
        PlanHospitacji planHospitacji = planHospitacjiService.findAll().get(0);
        planHospitacji.setZaakceptowany(true);
        planHospitacji.setSemestr(semestr);

        boolean actual = planHospitacjiService.istniejeZaakceptowanyPlanHospitacjinaSemestr(semestr);

        assertTrue("Jezeli w danym semestrze jest zaakceptowany plan hospitacji, powinno zwrócic true", actual);
    }

}