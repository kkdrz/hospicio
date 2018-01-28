package pl.edu.pwr.drozd.hospicio.domain.service;

import pl.edu.pwr.drozd.hospicio.domain.entity.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataProvider {

    /**
     * @return generuje losowe dane potrzebne do działania aplikacji w trybie demo
     */
    public static List<PlanHospitacji> generatePlanyHospitacji() {

        List<String> s_imiona = Arrays.asList(
                "Jan", "Marek", "Piotr", "Konrad", "Michał", "Kazimierz", "Marcel");
        List<String> s_nazwiska = Arrays.asList(
                "Nowak", "Kowalski", "Koszyk", "Jelitko", "Pękała", "Zaróbka");
        List<String> s_role = Arrays.asList(
                "P. wewnętrzny", "P. zewnętrzny", "Doktorant");
        List<String> s_stopnie = Arrays.asList(
                "Dr", "Prof.", "Mgr", "Dr hab.");
        List<String> s_kursy = Arrays.asList(
                "Programowanie sys. web", "Podstawy proj. baz danych", "Programowanie aplikacji mult.", "Wspom. zarz. proj. informatycznym",
                "Podstawy zarzadzania", "Podstawy programowania", "Zarzadzanie", "Systemy sterowane", "Systemy webowe");
        List<String> s_specjalizacje = Arrays.asList(
                "Programowanie obiektowe", "Programowanie funkcjonalne", "Projektowanie oprogramowania", "Bazy danych");
        List<String> s_kierunki = Arrays.asList(
                "Informatyka", "Inżynieria Systemów", "Zarządzanie");
        List<String> s_rodzajeSem = Arrays.asList(
                "Letni", "Zimowy");

        List<ProtokolHospitacji> protokoly = generateProtokolyHospitacji();
        List<RodzajSemestru> rodzajeSem = generateRodzajeSemestrow(s_rodzajeSem);
        List<Semestr> semestry = generateSemestry(rodzajeSem);
        List<Specjalizacja> specjalizacje = generateSpecjalizacje(s_specjalizacje);
        List<Kierunek> kierunki = generateKierunki(s_kierunki);
        List<Kurs> kursy = generateKursy(s_kursy, specjalizacje, kierunki);
        List<StopienNaukowy> stopnie = generateStopnieNaukowe(s_stopnie);
        List<Rola> role = generateRole(s_role);
        List<Pracownik> hospitowani = generatePracownicyHospitowani(s_imiona, s_nazwiska, specjalizacje, stopnie, role);
        List<Pracownik> przewodniczacy = generatePracownicyPrzewodniczacy(s_imiona, s_nazwiska, specjalizacje, stopnie, role);
        List<Pracownik> pracownicy = generatePracownicy(s_imiona, s_nazwiska, specjalizacje, stopnie, role);
        List<KomisjaHospitacyjna> komisje = generateKomisje(przewodniczacy, pracownicy);
        List<Hospitacja> hospitacje = generateHospitacje(kursy, hospitowani, komisje);

        for (Hospitacja h : hospitacje) {
            ProtokolHospitacji p = protokoly.get(random(0, protokoly.size() - 1));
            h.setProtokol(p);
            p.setHospitacja(h);
        }

        List<PlanHospitacji> plany = generatePlanyHospitacji(semestry, kierunki, hospitacje);

        return plany;
    }

    private static List<PlanHospitacji> generatePlanyHospitacji(List<Semestr> semestry, List<Kierunek> kierunki, List<Hospitacja> hospitacje) {
        List<PlanHospitacji> plany = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            PlanHospitacji p = new PlanHospitacji();
            p.setZaakceptowany(new Random().nextBoolean());
            p.setDataUtworzenia(new Date(1322866800000l + 1000000 * random(36748, 50 * 36748)));
            p.setDataAkceptacji(new Date(p.getDataUtworzenia().getTime() + 5074800000l));
            List<Hospitacja> hosp = new ArrayList<>();
            hosp.add(hospitacje.get(random(0, hospitacje.size() - 1)));
            hosp.add(hospitacje.get(random(0, hospitacje.size() - 1)));
            hosp.add(hospitacje.get(random(0, hospitacje.size() - 1)));
            p.setHospitacje(hosp);
            p.setId(i);
            p.setSemestr(semestry.get(random(0, semestry.size() - 1)));
            p.setKierunek(kierunki.get(random(0, kierunki.size() - 1)));
            p.setNazwa(p.getKierunek().getNazwa() + " | " + p.getSemestr().toString());
            plany.add(p);
        }
        return plany;
    }

    private static List<Hospitacja> generateHospitacje(List<Kurs> kursy, List<Pracownik> hospitowani, List<KomisjaHospitacyjna> komisje) {
        List<Hospitacja> hospitacje = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            Hospitacja h = new Hospitacja();
            h.setId(i);
            h.setKomisja(komisje.get(random(0, komisje.size() - 1)));
            h.setKurs(kursy.get(random(0, kursy.size() - 1)));
            h.setHospitowany(hospitowani.get(random(0, hospitowani.size() - 1)));
            hospitacje.add(h);
        }
        return hospitacje;
    }

    private static List<KomisjaHospitacyjna> generateKomisje(List<Pracownik> przewodniczacy, List<Pracownik> pracownicy) {
        List<KomisjaHospitacyjna> komisje = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            KomisjaHospitacyjna km = new KomisjaHospitacyjna();
            km.setId(i);
            km.setCzlonkowie(Arrays.asList(pracownicy.get(random(0, pracownicy.size() - 1))));
            km.setPrzewodniczacy(przewodniczacy.get(random(0, przewodniczacy.size() - 1)));
            komisje.add(km);
        }
        return komisje;
    }

    private static List<Pracownik> generatePracownicy(List<String> s_imiona, List<String> s_nazwiska, List<Specjalizacja> specjalizacje, List<StopienNaukowy> stopnie, List<Rola> role) {
        List<Pracownik> pracownicy = new ArrayList<>(15);
        for (int i = 0; i < s_imiona.size(); i++) {
            Pracownik p = new Pracownik();
            p.setId(i);
            p.setImie(s_imiona.get(random(0, s_imiona.size() - 1)));
            p.setNazwisko(s_nazwiska.get(random(0, s_nazwiska.size() - 1)));
            p.setRola(role.get(random(0, role.size() - 1)));
            p.setStopienNaukowy(stopnie.get(random(0, stopnie.size() - 1)));
            List<Specjalizacja> specs = new ArrayList<>();
            specs.add(specjalizacje.get(random(0, specjalizacje.size() - 1)));
            specs.add(specjalizacje.get(random(0, specjalizacje.size() - 1)));
            p.setSpecjalizacje(specs);
            pracownicy.add(p);
        }
        return pracownicy;
    }

    private static List<Pracownik> generatePracownicyPrzewodniczacy(List<String> s_imiona, List<String> s_nazwiska, List<Specjalizacja> specjalizacje, List<StopienNaukowy> stopnie, List<Rola> role) {
        List<Pracownik> przewodniczacy = generatePracownicy(s_imiona, s_nazwiska, specjalizacje, stopnie, role);
        return przewodniczacy;
    }

    private static List<Pracownik> generatePracownicyHospitowani(List<String> s_imiona, List<String> s_nazwiska, List<Specjalizacja> specjalizacje, List<StopienNaukowy> stopnie, List<Rola> role) {
        List<Pracownik> hospitowani = generatePracownicyPrzewodniczacy(s_imiona, s_nazwiska, specjalizacje, stopnie, role);
        return hospitowani;
    }

    private static List<Rola> generateRole(List<String> s_role) {
        List<Rola> role = new ArrayList<>(3);
        for (int i = 0; i < s_role.size(); i++) {
            Rola r = new Rola();
            r.setId(i);
            r.setNazwa(s_role.get(i));
            role.add(r);
        }
        return role;
    }

    private static List<StopienNaukowy> generateStopnieNaukowe(List<String> s_stopnie) {
        List<StopienNaukowy> stopnie = new ArrayList<>(4);
        for (int i = 0; i < s_stopnie.size(); i++) {
            StopienNaukowy s = new StopienNaukowy();
            s.setId(i);
            s.setNazwa(s_stopnie.get(i));
            stopnie.add(s);
        }
        return stopnie;
    }

    private static List<Kurs> generateKursy(List<String> s_kursy, List<Specjalizacja> specjalizacje, List<Kierunek> kierunki) {
        List<Kurs> kursy = new ArrayList<>();
        for (int i = 0; i < s_kursy.size(); i++) {
            Kurs k = new Kurs();
            k.setId(i);
            k.setDziedzina(specjalizacje.get(random(0, specjalizacje.size() - 1)));
            k.setKierunek(kierunki.get(random(0, kierunki.size() - 1)));
            k.setKod("ZRP" + Integer.toString((i * 4) + 1000));
            k.setNazwa(s_kursy.get(random(0, s_kursy.size() - 1)));
            kursy.add(k);
        }
        return kursy;
    }

    private static List<Specjalizacja> generateSpecjalizacje(List<String> s_specjalizacje) {
        List<Specjalizacja> specjalizacje = new ArrayList<>();
        for (int i = 0; i < s_specjalizacje.size(); i++) {
            Specjalizacja s = new Specjalizacja();
            s.setId(i);
            s.setNazwa(s_specjalizacje.get(random(0, s_specjalizacje.size() - 1)));
            specjalizacje.add(s);
        }
        return specjalizacje;
    }

    private static List<Kierunek> generateKierunki(List<String> s_kierunki) {
        List<Kierunek> kierunki = new ArrayList<>();
        for (int i = 0; i < s_kierunki.size(); i++) {
            Kierunek k = new Kierunek();
            k.setId(i);
            k.setNazwa(s_kierunki.get(random(0, s_kierunki.size() - 1)));
            kierunki.add(k);
        }
        return kierunki;
    }

    private static List<Semestr> generateSemestry(List<RodzajSemestru> rodzajeSem) {
        List<Semestr> semestry = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Semestr s = new Semestr();
            s.setId(i);
            s.setRodzajSemestru(rodzajeSem.get(random(0, rodzajeSem.size() - 1)));
            s.setRok1(2010 + i);
            s.setRok2(s.getRok1() + 1);
            semestry.add(s);
        }
        return semestry;
    }

    private static List<RodzajSemestru> generateRodzajeSemestrow(List<String> s_rodzajeSem) {
        List<RodzajSemestru> rodzajeSem = new ArrayList<>();
        for (int i = 0; i < s_rodzajeSem.size(); i++) {
            RodzajSemestru r = new RodzajSemestru();
            r.setId(i);
            r.setNazwa(s_rodzajeSem.get(random(0, s_rodzajeSem.size() - 1)));
            rodzajeSem.add(r);
        }
        return rodzajeSem;
    }

    private static List<ProtokolHospitacji> generateProtokolyHospitacji() {
        List<ProtokolHospitacji> protokoly = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ProtokolHospitacji p = new ProtokolHospitacji();
            p.setId(i);
            p.setKomentarz("Przykładowy komentarz do hospitacji");
            p.setDataUtworzenia(new Date(1322866800000l + 1000000 * random(36748, 50 * 36748)));
            p.setOceny(Arrays.asList(random(3, 9), random(3, 9), random(6, 9)));
            protokoly.add(p);
        }
        return protokoly;
    }

    public static int random(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
