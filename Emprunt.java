import java.time.LocalDate;

public class Emprunt {
    private int numCin, numLivre;
    private LocalDate dateEmp;
    private LocalDate dateRetour;
    private int nmbrEmprunt;

    public Emprunt() {
    }

    public int getNumCin() {
        return numCin;
    }

    public void setNumCin(int numCin) {
        this.numCin = numCin;
    }

    public int getNumLivre() {
        return numLivre;
    }

    public void setNumLivre(int numLivre) {
        this.numLivre = numLivre;
    }

    public LocalDate getDateEmp() {
        return dateEmp;
    }

    public void setDateEmp(LocalDate dateEmp) {
        this.dateEmp = dateEmp;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getNmbrEmprunt() {
        return nmbrEmprunt;
    }

    public void setNmbrEmprunt(int nmbrEmprunt) {
        this.nmbrEmprunt = nmbrEmprunt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Emprunt) {
            Emprunt e = (Emprunt) obj;
            if (this.getNumCin() == (e.getNumCin()) && this.getNumLivre() == e.getNumLivre())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Emprunt [numCin= " + numCin + ", numLivre= " + numLivre + "] Date d'emprunte : " + dateEmp
                + " Date de retour : " + dateRetour;
    }

    @Override
    public int hashCode() {

        return getNumCin();
    }

}
