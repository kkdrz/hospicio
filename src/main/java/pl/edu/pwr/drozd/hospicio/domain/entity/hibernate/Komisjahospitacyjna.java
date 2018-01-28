package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Komisjahospitacyjna {
    private int id;
    private int pracownikid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pracownikid")
    public int getPracownikid() {
        return pracownikid;
    }

    public void setPracownikid(int pracownikid) {
        this.pracownikid = pracownikid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Komisjahospitacyjna that = (Komisjahospitacyjna) o;

        if (id != that.id) return false;
        if (pracownikid != that.pracownikid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pracownikid;
        return result;
    }
}
