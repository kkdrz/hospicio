package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.*;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
@Table(name = "komisjahospitacyjna_pracownik", schema = "hospicio", catalog = "")
@IdClass(KomisjahospitacyjnaPracownikPK.class)
public class KomisjahospitacyjnaPracownik {
    private int pracownikid;
    private int komisjahospitacyjnaid;

    @Id
    @Column(name = "pracownikid")
    public int getPracownikid() {
        return pracownikid;
    }

    public void setPracownikid(int pracownikid) {
        this.pracownikid = pracownikid;
    }

    @Id
    @Column(name = "komisjahospitacyjnaid")
    public int getKomisjahospitacyjnaid() {
        return komisjahospitacyjnaid;
    }

    public void setKomisjahospitacyjnaid(int komisjahospitacyjnaid) {
        this.komisjahospitacyjnaid = komisjahospitacyjnaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KomisjahospitacyjnaPracownik that = (KomisjahospitacyjnaPracownik) o;

        if (pracownikid != that.pracownikid) return false;
        if (komisjahospitacyjnaid != that.komisjahospitacyjnaid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pracownikid;
        result = 31 * result + komisjahospitacyjnaid;
        return result;
    }
}
