package pl.edu.pwr.drozd.hospicio.domain.service;

import org.junit.Before;
import org.junit.Test;
import pl.edu.pwr.drozd.hospicio.Main;
import pl.edu.pwr.drozd.hospicio.domain.entity.*;

import static org.junit.Assert.*;


public class HospitacjaServiceTest {

    HospitacjaService hospitacjaService;

    @Before
    public void setUp() throws Exception {
        Main.PLANY_HOSPITACJI = DataProvider.generatePlanyHospitacji();
        hospitacjaService = new HospitacjaService();
    }

    @Test
    public void czyKompletna_NonExistingHospitacja_ExpectFalse() throws Exception {
        Hospitacja hospitacja = null;

        boolean actual = hospitacjaService.czyKompletna(hospitacja);

        assertFalse(actual);
    }

    @Test
    public void czyKompletna_ExistingHospitacjaNoProtokol_ExpectFalse() throws Exception {
        Hospitacja hospitacja = new Hospitacja();
        hospitacja.setKomisja(new KomisjaHospitacyjna());
        hospitacja.setHospitowany(new Pracownik());
        hospitacja.setKurs(new Kurs());

        boolean actual = hospitacjaService.czyKompletna(hospitacja);

        assertFalse(actual);
    }

    @Test
    public void czyKompletna_ExistingHospitacjaNoKurs_ExpectFalse() throws Exception {
        Hospitacja hospitacja = new Hospitacja();
        hospitacja.setKomisja(new KomisjaHospitacyjna());
        hospitacja.setHospitowany(new Pracownik());
        hospitacja.setProtokol(new ProtokolHospitacji());

        boolean actual = hospitacjaService.czyKompletna(hospitacja);

        assertFalse(actual);
    }

    @Test
    public void czyKompletna_ExistingHospitacjaNoHospitowany_ExpectFalse() throws Exception {
        Hospitacja hospitacja = new Hospitacja();
        hospitacja.setKomisja(new KomisjaHospitacyjna());
        hospitacja.setKurs(new Kurs());
        hospitacja.setProtokol(new ProtokolHospitacji());

        boolean actual = hospitacjaService.czyKompletna(hospitacja);

        assertFalse(actual);
    }

    @Test
    public void czyKompletna_ExistingHospitacjaNoKomisja_ExpectFalse() throws Exception {
        Hospitacja hospitacja = new Hospitacja();
        hospitacja.setKurs(new Kurs());
        hospitacja.setHospitowany(new Pracownik());
        hospitacja.setProtokol(new ProtokolHospitacji());

        boolean actual = hospitacjaService.czyKompletna(hospitacja);

        assertFalse(actual);
    }

    @Test
    public void czyKompletna_Kompletna_ExpectTrue() throws Exception {
        Hospitacja hospitacja = new Hospitacja();
        hospitacja.setKurs(new Kurs());
        hospitacja.setKomisja(new KomisjaHospitacyjna());
        hospitacja.setHospitowany(new Pracownik());
        hospitacja.setProtokol(new ProtokolHospitacji());

        boolean actual = hospitacjaService.czyKompletna(hospitacja);

        assertFalse(actual);
    }
}