package pl.edu.pwr.drozd.hospicio.domain.service;

import org.junit.Before;
import org.junit.Test;
import pl.edu.pwr.drozd.hospicio.Main;
import pl.edu.pwr.drozd.hospicio.domain.entity.Pracownik;
import pl.edu.pwr.drozd.hospicio.domain.entity.Semestr;

import static org.junit.Assert.*;


public class PracownikServiceTest {

    PracownikService pracownikService;
    SemestrService semestrService;

    @Before
    public void setUp() {
        Main.PLANY_HOSPITACJI = DataProvider.generatePlanyHospitacji();
        pracownikService = new PracownikService();
        semestrService = new SemestrService();
    }

    @Test
    public void obliczObciazenie_nonExistingPracownik_ExpectMinusOne() throws Exception {
        Pracownik pracownik = null;
        Semestr semestr = semestrService.findAll().get(0);

        int obciazenie = pracownikService.obliczObciazenie(pracownik, semestr);

        assertEquals("Obciazenie dla nie istniejacego pracownika powinno byc rowne -1", -1, obciazenie);
    }

    @Test
    public void obliczObciazenie_nonExistingSemestr_ExpectMinusOne() throws Exception {
        Pracownik pracownik = pracownikService.findAll().get(0);
        Semestr semestr = null;

        int obciazenie = pracownikService.obliczObciazenie(pracownik, semestr);

        assertEquals("Obciazenie dla istniejacego pracownika, nie istniejącego semestru powinno byc rowne -1", -1, obciazenie);
    }

    @Test
    public void obliczObciazenie_Existing_ExpectNonMinus() throws Exception {
        Pracownik pracownik = pracownikService.findAll().get(0);
        Semestr semestr = semestrService.findAll().get(0);

        int obciazenie = pracownikService.obliczObciazenie(pracownik, semestr);

        assertTrue("Obciazenie dla istniejacego pracownika powinno byc wieksze/rowne 0", obciazenie >= 0);
    }
}
