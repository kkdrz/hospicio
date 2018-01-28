package pl.edu.pwr.drozd.hospicio.domain.dao;


import pl.edu.pwr.drozd.hospicio.domain.entity.PlanHospitacji;

import java.util.List;
import java.util.stream.Collectors;

public class PlanHospitacjiDao extends BasicDAO<PlanHospitacji> {

    public PlanHospitacjiDao(Class<PlanHospitacji> clazz) {
        super(clazz);
    }

    public List<PlanHospitacji> findAllAccepted() {
        return findAll().stream()
                .filter(PlanHospitacji::czyZaakceptowany)
                .collect(Collectors.toList());
    }

    public List<PlanHospitacji> findAllUnaccepted() {
        return findAll().stream()
                .filter(p -> !p.czyZaakceptowany())
                .collect(Collectors.toList());
    }
}
