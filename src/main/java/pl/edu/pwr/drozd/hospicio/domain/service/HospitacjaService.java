package pl.edu.pwr.drozd.hospicio.domain.service;

import pl.edu.pwr.drozd.hospicio.domain.entity.Hospitacja;
import pl.edu.pwr.drozd.hospicio.domain.entity.PlanHospitacji;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class HospitacjaService {

    PlanHospitacjiService planHospitacjiService = new PlanHospitacjiService();

    public List<Hospitacja> findAll() {
        return planHospitacjiService.findAll()
                .stream()
                .map(PlanHospitacji::getHospitacje)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Sprawdza, czy Hospitacja jest kompletna, czyli, czy zawiera wszystkie dane.
     * @param hospitacja która ma być sprawdzona
     * @return true albo false, zaleznie od tego czy podana hospitacja jest kompletna
     */
    public boolean czyKompletna(Hospitacja hospitacja) {
        return hospitacja != null &&
                hospitacja.getProtokol() != null &&
                hospitacja.getKomisja() != null &&
                hospitacja.getKomisja().getPrzewodniczacy() != null &&
                hospitacja.getKomisja().getCzlonkowie().size() > 1 &&
                hospitacja.getHospitowany() != null &&
                hospitacja.getKurs() != null;
    }
}
