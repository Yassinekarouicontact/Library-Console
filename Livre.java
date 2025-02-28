public class Livre {
    private int numero;
    private String titre;
    private int nmbrExemplaire;
    private int nmbrEmpruntLivre;

    public Livre() {
    }

    public Livre(int numero) {
        this.numero = numero;
    }

    public Livre(int numero, String titre, int nmbrExemplaire) {
        this.numero = numero;
        this.titre = titre;
        this.nmbrExemplaire = nmbrExemplaire;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNmbrExemplaire() {
        return nmbrExemplaire;
    }

    public void setNmbrExemplaire(int nmbrExemplaire) {
        this.nmbrExemplaire = nmbrExemplaire;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Livre) {
            Livre liv = (Livre) obj;
            if (this.getNumero() == liv.getNumero())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Livre [numero= " + numero + ", titre=" + titre + ", Nombre exemplaires existants= " + nmbrExemplaire
                + "]";
    }

    public int getNmbrEmpruntLivre() {
        return nmbrEmpruntLivre;
    }

    public void setNmbrEmpruntLivre(int nmbrEmpruntLivre) {
        this.nmbrEmpruntLivre = nmbrEmpruntLivre;
    }

}
