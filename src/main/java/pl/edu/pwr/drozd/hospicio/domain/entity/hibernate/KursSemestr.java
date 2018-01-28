package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.*;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
@Table(name = "kurs_semestr", schema = "hospicio", catalog = "")
@IdClass(KursSemestrPK.class)
public class KursSemestr {
    private int semestrid;
    private int kursid;

    @Id
    @Column(name = "semestrid")
    public int getSemestrid() {
        return semestrid;
    }

    public void setSemestrid(int semestrid) {
        this.semestrid = semestrid;
    }

    @Id
    @Column(name = "kursid")
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

        KursSemestr that = (KursSemestr) o;

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
