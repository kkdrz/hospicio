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
public class Planhospitacji {
    private int id;
    private boolean czyzaakceptowany;
    private Date dataakceptacji;
    private Date datautworzenia;
    private int kierunekid;
    private String nazwa;
    private Integer semestrid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "czyzaakceptowany")
    public boolean isCzyzaakceptowany() {
        return czyzaakceptowany;
    }

    public void setCzyzaakceptowany(boolean czyzaakceptowany) {
        this.czyzaakceptowany = czyzaakceptowany;
    }

    @Basic
    @Column(name = "dataakceptacji")
    public Date getDataakceptacji() {
        return dataakceptacji;
    }

    public void setDataakceptacji(Date dataakceptacji) {
        this.dataakceptacji = dataakceptacji;
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
    @Column(name = "kierunekid")
    public int getKierunekid() {
        return kierunekid;
    }

    public void setKierunekid(int kierunekid) {
        this.kierunekid = kierunekid;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "semestrid")
    public Integer getSemestrid() {
        return semestrid;
    }

    public void setSemestrid(Integer semestrid) {
        this.semestrid = semestrid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planhospitacji that = (Planhospitacji) o;

        if (id != that.id) return false;
        if (czyzaakceptowany != that.czyzaakceptowany) return false;
        if (kierunekid != that.kierunekid) return false;
        if (dataakceptacji != null ? !dataakceptacji.equals(that.dataakceptacji) : that.dataakceptacji != null)
            return false;
        if (datautworzenia != null ? !datautworzenia.equals(that.datautworzenia) : that.datautworzenia != null)
            return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (semestrid != null ? !semestrid.equals(that.semestrid) : that.semestrid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (czyzaakceptowany ? 1 : 0);
        result = 31 * result + (dataakceptacji != null ? dataakceptacji.hashCode() : 0);
        result = 31 * result + (datautworzenia != null ? datautworzenia.hashCode() : 0);
        result = 31 * result + kierunekid;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (semestrid != null ? semestrid.hashCode() : 0);
        return result;
    }
}
