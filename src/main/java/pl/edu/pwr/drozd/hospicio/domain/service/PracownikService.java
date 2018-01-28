package pl.edu.pwr.drozd.hospicio.domain.service;


import pl.edu.pwr.drozd.hospicio.domain.entity.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PracownikService {

    PlanHospitacjiService planHospitacjiService = new PlanHospitacjiService();

    /**
     * Liczy obciazenie danego pracownika, czyli ile hospitacji ma przydzielonych w podanym semestrze
     * @param pracownik pracownik dla którego liczone jest obciazenie
     * @param semestr semestr w ktorym liczone jest obciazenie
     * @return liczba całkowita oznaczająca w ilu hospitacjach w danym semestrze bierze udział pracownik
     */
    public int obliczObciazenie(Pracownik pracownik, Semestr semestr) {
        if (pracownik == null || semestr == null)
            return -1;

        int obciazenie = planHospitacjiService.findAll().stream()
                .filter(p -> p.getSemestr().equals(semestr))
                .map(PlanHospitacji::getHospitacje)
                .flatMap(Collection::stream)
                .filter(h -> h.getKomisja().getCzlonkowie().contains(pracownik))
                .collect(Collectors.toList()).size();

        if (obciazenie < 0) return -1;

        return obciazenie;
    }


    public List<Pracownik> findAll() {
        return planHospitacjiService.findAll()
                .stream()
                .map(PlanHospitacji::getHospitacje)
                .flatMap(Collection::stream)
                .map(h->h.getKomisja().getCzlonkowie())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
