package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Semestr {
    private int id;
    private int rodzajsemestruid;
    private int rok1;
    private int rok2;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rodzajsemestruid")
    public int getRodzajsemestruid() {
        return rodzajsemestruid;
    }

    public void setRodzajsemestruid(int rodzajsemestruid) {
        this.rodzajsemestruid = rodzajsemestruid;
    }

    @Basic
    @Column(name = "rok1")
    public int getRok1() {
        return rok1;
    }

    public void setRok1(int rok1) {
        this.rok1 = rok1;
    }

    @Basic
    @Column(name = "rok2")
    public int getRok2() {
        return rok2;
    }

    public void setRok2(int rok2) {
        this.rok2 = rok2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestr semestr = (Semestr) o;

        if (id != semestr.id) return false;
        if (rodzajsemestruid != semestr.rodzajsemestruid) return false;
        if (rok1 != semestr.rok1) return false;
        if (rok2 != semestr.rok2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + rodzajsemestruid;
        result = 31 * result + rok1;
        result = 31 * result + rok2;
        return result;
    }
}
