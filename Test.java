import java.util.Scanner;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    private static Bibliotheque b1 = new Bibliotheque();

    public static void main(String args[]) {
        app();
    }

    /*************************************************************************************************************************/
    public static void app() {

        new AffichageMenuPrincipale();
        firstStep(choixMenuPrincipale());

    }

    public static void firstStep(int choix1) {

        if (choix1 == 0) {
            new AffichageMenuPrincipale();
            firstStep(choixMenuPrincipale());
        }
        if (choix1 == 1) {
            new AffichageMenuAdherent();
            gestionAdherent(choixMenuAdherent());

        } else if (choix1 == 2) {
            new AffichageMenuBibliotheque();
            gestionBibliotheque(choixMenuBibliotheque());
        } else if (choix1 == 3)
            return;

    }

    public static void gestionAdherent(int choix2) {
        if (choix2 == 1) {
            b1.afficherLivresBibliotheque();
            firstStep(1);
        } else if (choix2 == 2) {
            b1.ajouterEmpruntBibliotheque();
            firstStep(1);
        } else if (choix2 == 3) {
            b1.supprimerEmpruntBibliotheque();
            firstStep(1);
        } else if (choix2 == 4) {
            b1.afficherEmpruntAdherent();
            firstStep(1);
        } else if (choix2 == 5)
            firstStep(0);
    }

    public static void gestionBibliotheque(int choix3) {
        if (choix3 == 1) {
            b1.ajouterLivre();
            firstStep(2);
        } else if (choix3 == 2) {
            b1.supprimerLivre();
            firstStep(2);
        } else if (choix3 == 3) {
            b1.afficherNbrExemplaire();
            firstStep(2);
        } else if (choix3 == 4) {
            b1.empruntDateRetour();
            firstStep(2);
        } else if (choix3 == 5) {
            b1.supprimerEnsembleEmprunt();
            firstStep(2);
        } else if (choix3 == 6) {
            b1.LivresPlusEmpruntes();
            firstStep(2);
        } else if (choix3 == 7) {
            b1.emprunteurFidele();
            firstStep(2);
        } else if (choix3 == 8) {
            firstStep(0);
        }
    }

    public static int choixMenuPrincipale() {
        int choix = 0;
        choix = sc.nextInt();
        while (choix != 1 && choix != 2 && choix != 3) {
            System.out.println("Saisie incorrecte");
            choix = sc.nextInt();
        }
        return choix;
    }

    public static int choixMenuAdherent() {
        int choix = 0;
        choix = sc.nextInt();
        while (choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5) {
            System.out.println("Saisie incorrecte");
            choix = sc.nextInt();
        }
        return choix;
    }

    public static int choixMenuBibliotheque() {
        int choix = 0;
        choix = sc.nextInt();
        while (choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 && choix != 6 && choix != 7
                && choix != 8) {
            System.out.println("Saisie incorrecte");
            choix = sc.nextInt();
        }
        return choix;
    }
}
