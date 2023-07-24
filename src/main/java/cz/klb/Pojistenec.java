package cz.klb;

public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefonniCislo;

    public Pojistenec(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    @Override
    public String toString() {
        return jmeno + "\t" + prijmeni + "\t" + vek + "\t" + telefonniCislo;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(int telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getVek() {
        return vek;
    }
}
