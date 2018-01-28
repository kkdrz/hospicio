package pl.edu.pwr.drozd.hospicio.domain.entity;

import pl.edu.pwr.drozd.hospicio.domain.service.DataProvider;

import java.util.List;

public class Pracownik {

    private int id;

    private String imie;

    private String nazwisko;

    private Rola rola;

    private StopienNaukowy stopienNaukowy;

    private List<Specjalizacja> specjalizacje;

    private int obciazenie = DataProvider.random(1, 4);

    public int getObciazenie() {
        return obciazenie;
    }

    public void setObciazenie(int obciazenie) {
        this.obciazenie = obciazenie;
    }

    public List<Specjalizacja> getSpecjalizacje() {
        return specjalizacje;
    }

    public void setSpecjalizacje(List<Specjalizacja> specjalizacje) {
        this.specjalizacje = specjalizacje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }

    public StopienNaukowy getStopienNaukowy() {
        return stopienNaukowy;
    }

    public void setStopienNaukowy(StopienNaukowy stopienNaukowy) {
        this.stopienNaukowy = stopienNaukowy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pracownik pracownik = (Pracownik) o;

        if (id != pracownik.id) return false;
        if (!imie.equals(pracownik.imie)) return false;
        if (!nazwisko.equals(pracownik.nazwisko)) return false;
        if (rola != null ? !rola.equals(pracownik.rola) : pracownik.rola != null) return false;
        return stopienNaukowy != null ? stopienNaukowy.equals(pracownik.stopienNaukowy) : pracownik.stopienNaukowy == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + imie.hashCode();
        result = 31 * result + nazwisko.hashCode();
        result = 31 * result + (rola != null ? rola.hashCode() : 0);
        result = 31 * result + (stopienNaukowy != null ? stopienNaukowy.hashCode() : 0);
        return result;
    }
}
