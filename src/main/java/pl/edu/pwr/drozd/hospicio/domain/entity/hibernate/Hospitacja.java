package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Hospitacja {
    private int id;
    private int komisjaid;
    private Integer kursid;
    private int planhospitacjiid;
    private int przewodniczacyid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "komisjaid")
    public int getKomisjaid() {
        return komisjaid;
    }

    public void setKomisjaid(int komisjaid) {
        this.komisjaid = komisjaid;
    }

    @Basic
    @Column(name = "kursid")
    public Integer getKursid() {
        return kursid;
    }

    public void setKursid(Integer kursid) {
        this.kursid = kursid;
    }

    @Basic
    @Column(name = "planhospitacjiid")
    public int getPlanhospitacjiid() {
        return planhospitacjiid;
    }

    public void setPlanhospitacjiid(int planhospitacjiid) {
        this.planhospitacjiid = planhospitacjiid;
    }

    @Basic
    @Column(name = "przewodniczacyid")
    public int getPrzewodniczacyid() {
        return przewodniczacyid;
    }

    public void setPrzewodniczacyid(int przewodniczacyid) {
        this.przewodniczacyid = przewodniczacyid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospitacja that = (Hospitacja) o;

        if (id != that.id) return false;
        if (komisjaid != that.komisjaid) return false;
        if (planhospitacjiid != that.planhospitacjiid) return false;
        if (przewodniczacyid != that.przewodniczacyid) return false;
        if (kursid != null ? !kursid.equals(that.kursid) : that.kursid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + komisjaid;
        result = 31 * result + (kursid != null ? kursid.hashCode() : 0);
        result = 31 * result + planhospitacjiid;
        result = 31 * result + przewodniczacyid;
        return result;
    }
}
