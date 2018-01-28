package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Protokolhospitacji {
    private int id;
    private Date datautworzenia;
    private int hospitacjaid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datautworzenia")
    public Date getDatautworzenia() {
        return datautworzenia;
    }

    public void setDatautworzenia(Date datautworzenia) {
        this.datautworzenia = datautworzenia;
    }

    @Basic
    @Column(name = "hospitacjaid")
    public int getHospitacjaid() {
        return hospitacjaid;
    }

    public void setHospitacjaid(int hospitacjaid) {
        this.hospitacjaid = hospitacjaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Protokolhospitacji that = (Protokolhospitacji) o;

        if (id != that.id) return false;
        if (hospitacjaid != that.hospitacjaid) return false;
        if (datautworzenia != null ? !datautworzenia.equals(that.datautworzenia) : that.datautworzenia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datautworzenia != null ? datautworzenia.hashCode() : 0);
        result = 31 * result + hospitacjaid;
        return result;
    }
}
