package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Konrad on 28.01.2018.
 */
public class KursSemestrPK implements Serializable {
    private int semestrid;
    private int kursid;

    @Column(name = "semestrid")
    @Id
    public int getSemestrid() {
        return semestrid;
    }

    public void setSemestrid(int semestrid) {
        this.semestrid = semestrid;
    }

    @Column(name = "kursid")
    @Id
    public int getKursid() {
        return kursid;
    }

    public void setKursid(int kursid) {
        this.kursid = kursid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KursSemestrPK that = (KursSemestrPK) o;

        if (semestrid != that.semestrid) return false;
        if (kursid != that.kursid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semestrid;
        result = 31 * result + kursid;
        return result;
    }
}
