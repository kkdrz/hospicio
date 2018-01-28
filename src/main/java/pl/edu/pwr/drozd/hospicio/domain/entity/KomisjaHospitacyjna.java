package pl.edu.pwr.drozd.hospicio.domain.entity;

import javax.persistence.*;
import java.util.List;


public class KomisjaHospitacyjna {

    private int id;

    private Pracownik przewodniczacy;

    private List<Pracownik> czlonkowie;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pracownik getPrzewodniczacy() {
        return przewodniczacy;
    }

    public void setPrzewodniczacy(Pracownik przewodniczacy) {
        this.przewodniczacy = przewodniczacy;
    }

    public List<Pracownik> getCzlonkowie() {
        return czlonkowie;
    }

    public void setCzlonkowie(List<Pracownik> czlonkowie) {
        this.czlonkowie = czlonkowie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KomisjaHospitacyjna that = (KomisjaHospitacyjna) o;

        if (id != that.id) return false;
        if (przewodniczacy != null ? !przewodniczacy.equals(that.przewodniczacy) : that.przewodniczacy != null)
            return false;
        return czlonkowie != null ? czlonkowie.equals(that.czlonkowie) : that.czlonkowie == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (przewodniczacy != null ? przewodniczacy.hashCode() : 0);
        result = 31 * result + (czlonkowie != null ? czlonkowie.hashCode() : 0);
        return result;
    }
}
