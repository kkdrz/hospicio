package pl.edu.pwr.drozd.hospicio.domain.service;


import pl.edu.pwr.drozd.hospicio.Main;
import pl.edu.pwr.drozd.hospicio.domain.entity.PlanHospitacji;
import pl.edu.pwr.drozd.hospicio.domain.entity.Semestr;

import java.util.List;
import java.util.stream.Collectors;


public class SemestrService {

    public List<Semestr> findAll() {
        return Main.PLANY_HOSPITACJI.stream()
                .map(PlanHospitacji::getSemestr)
                .distinct()
                .collect(Collectors.toList());
    }
}
