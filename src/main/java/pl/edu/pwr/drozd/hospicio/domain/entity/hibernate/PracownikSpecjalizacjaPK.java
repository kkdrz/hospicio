package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Konrad on 28.01.2018.
 */
public class PracownikSpecjalizacjaPK implements Serializable {
    private int specjalizacjaid;
    private int pracownikid;

    @Column(name = "specjalizacjaid")
    @Id
    public int getSpecjalizacjaid() {
        return specjalizacjaid;
    }

    public void setSpecjalizacjaid(int specjalizacjaid) {
        this.specjalizacjaid = specjalizacjaid;
    }

    @Column(name = "pracownikid")
    @Id
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

        PracownikSpecjalizacjaPK that = (PracownikSpecjalizacjaPK) o;

        if (specjalizacjaid != that.specjalizacjaid) return false;
        if (pracownikid != that.pracownikid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specjalizacjaid;
        result = 31 * result + pracownikid;
        return result;
    }
}
