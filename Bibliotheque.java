import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Bibliotheque {
    List<Livre> tabLivre;
    Set<Emprunt> tabEmprunt;
    List<Emprunt> tabDelete;
    List<Emprunt> tabEmprunteurs;
    private Scanner scNumeroLivre;
    private Scanner scTitre;
    private Scanner scNbrExemplaire;
    private Scanner scCIN;
    private Scanner scNbrJour;
    private Scanner scJ;
    private Scanner scM;
    private Scanner scA;
    private Scanner scJJ;
    private Scanner scMM;
    private Scanner scAA;

    public Bibliotheque() {
        tabLivre = new ArrayList<>();
        tabEmprunt = new HashSet<>();
        tabDelete = new ArrayList<>();
        tabEmprunteurs = new ArrayList<>();
    }

    /*
     * oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
     */
    /*
     * oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
     */
    public boolean rechercherLivre(Livre l) {
        for (Livre liv : tabLivre) {
            if (liv.equals(l)) {
                return true;
            }
        }
        return false;
    }

    public void ajouterLivre(Livre l) {
        if (rechercherLivre(l)) {
            for (Livre liv : tabLivre) {
                if (liv.equals(l)) {
                    liv.setNmbrExemplaire(liv.getNmbrExemplaire() + 1);
                    return;
                }
            }
        } else {
            tabLivre.add(l);
        }
    }

    public void ajouterLivre() {
        System.out.println(
                "--------------------------------------------Creation du livre--------------------------------------------");

        Livre l = new Livre();
        System.out.println("Numero du livre : ");
        scNumeroLivre = new Scanner(System.in);

        l.setNumero(scNumeroLivre.nextInt());

        if (rechercherLivre(l)) {
            System.out.println("Combien d'exemplaire voulez vous ajouter?");
            scNbrExemplaire = new Scanner(System.in);

            for (Livre liv : tabLivre) {
                if (liv.equals(l)) {
                    liv.setNmbrExemplaire(liv.getNmbrExemplaire() + scNbrExemplaire.nextInt());
                    return;
                }
            }
        }

        else {
            System.out.println("Nom du livre : ");
            scTitre = new Scanner(System.in);
            l.setTitre(scTitre.next());
            System.out.println("Nombre d'exemplaire du livre : ");
            scNbrExemplaire = new Scanner(System.in);
            l.setNmbrExemplaire(scNbrExemplaire.nextInt());
            tabLivre.add(l);
        }
    }

    public void supprimerLivre() {
        if (tabLivre.size() != 0) {
            Livre l = new Livre();
            System.out.println("Numero du livre a supprimer : ");
            scNumeroLivre = new Scanner(System.in);
            l.setNumero(scNumeroLivre.nextInt());

            if (tabLivre.remove(l))
                System.out.println("le livre a ete supprimer avec succes");
            else
                System.out.println("le livre n existe pas");
        } else
            System.out.println("Notre bibliotheque ne contient aucun livre.");
    }

    public void afficherLivresBibliotheque() {

        if (tabLivre.size() != 0) {
            for (Livre liv : tabLivre)
                System.out.println(liv);
        } else
            System.out.println("La bibliotheque ne contient aucun livre");
    }

    public void afficherNbrExemplaire() {
        if (tabLivre.size() != 0) {
            Livre l = new Livre();
            System.out.println("Numero du livre : ");
            scNumeroLivre = new Scanner(System.in);
            l.setNumero(scNumeroLivre.nextInt());
            for (Livre liv : tabLivre) {
                if (liv.equals(l)) {
                    System.out.println("Nombre d'exemplaire pour ce livre = " + liv.getNmbrExemplaire());
                    return;
                }

            }
            System.out.println("Le livre n'existe pas");
        } else
            System.out.println("La bibliotheque ne contient aucun livre");

    }

    /*
     * oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
     */
    /*
     * oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
     */
    public boolean rechercherAdherent(int cin) {
        for (Emprunt emp : tabEmprunt) {
            if (emp.getNumCin() == cin)
                return true;
        }
        return false;
    }

    public boolean rechercherEmprunt(Emprunt e) {
        for (Emprunt emp : tabEmprunt) {
            if (e.equals(emp))
                return true;
        }
        return false;
    }

    public void ajouterEmpruntBibliotheque() {
        if (tabLivre.size() != 0) {
            Emprunt e = new Emprunt();
            System.out.println("Num de Cin : ");
            scCIN = new Scanner(System.in);
            e.setNumCin(scCIN.nextInt());
            if (!testNbrEmprunt(e.getNumCin())) {
                System.out.println("Num de livre : ");
                scNumeroLivre = new Scanner(System.in);
                e.setNumLivre(scNumeroLivre.nextInt());
                Livre l = new Livre();
                l.setNumero(e.getNumLivre());
                if (rechercherLivre(l) && (!rechercherEmprunt(e))) {

                    for (Livre livre : tabLivre) {
                        if (livre.getNumero() == l.getNumero())
                            l.setNmbrExemplaire(livre.getNmbrExemplaire());
                    }
                    if (l.getNmbrExemplaire() != 0) {
                        for (Livre liv : tabLivre) {
                            if (liv.getNumero() == l.getNumero()) {
                                liv.setNmbrExemplaire(liv.getNmbrExemplaire() - 1);
                            }
                        }
                        e.setDateEmp(LocalDate.now());
                        System.out.println(
                                "Pour combien de jour voulez vous emprunter ce livre : \n Vous avez une duree de maximum 1 mois");
                        int nbrJour;
                        do {

                            scNbrJour = new Scanner(System.in);
                            nbrJour = scNbrJour.nextInt();

                        } while (nbrJour < 1 || nbrJour > 30);
                        e.setDateRetour(e.getDateEmp().plusDays(nbrJour));
                        tabEmprunt.add(e);
                        System.out.println("La date de retour : " + e.getDateRetour());

                    } else {
                        if (tabEmprunt.size() == 0) {
                            System.out.println("Ce livre n'est pas disponible");
                            return;
                        }

                        for (Emprunt emp : tabEmprunt) {
                            if (emp.getNumLivre() == e.getNumLivre())
                                System.out.println("Ce livre sera disponible le " + emp.getDateRetour());

                        }

                    }
                } else if (!rechercherLivre(l))
                    System.out.println("Le livre n'existe pas ");
                else if (rechercherEmprunt(e))
                    System.out.println("Emprunt deja existant.");
            } else
                System.out.println("Vous avez atteint le maximum d'emprunt possible.");
        } else
            System.out.println("Pas de Livre a emprunter.");
    }

    public void supprimerEmpruntBibliotheque() {
        if (tabEmprunt.size() != 0) {
            Emprunt e = new Emprunt();
            System.out.println("Num de Cin : ");
            scCIN = new Scanner(System.in);
            e.setNumCin(scCIN.nextInt());
            if (rechercherAdherent(e.getNumCin())) {
                System.out.println("Num de livre : ");
                scNumeroLivre = new Scanner(System.in);
                e.setNumLivre(scNumeroLivre.nextInt());
                for (Emprunt emp : tabEmprunt)
                    if (emp.equals(e)) {
                        for (Livre liv : tabLivre) {
                            if (liv.getNumero() == e.getNumLivre())
                                liv.setNmbrExemplaire(liv.getNmbrExemplaire() + 1);
                        }
                        tabEmprunt.remove(emp);
                        return;
                    }
                System.out.println("Emprunt pas existant.");
            } else
                System.out.println("Pas d'emprunt correspondant a ce numero de Cin.");

        } else
            System.out.println("Notre bibliotheque ne contient aucun emprunt.");

    }

    public boolean testNbrEmprunt(int cin) {
        int compteur = 0;
        for (Emprunt e : tabEmprunt) {
            if (e.getNumCin() == cin) {
                compteur++;
            }
        }
        if (compteur > 5)
            return true;
        return false;
    }

    public void afficherEmpruntAdherent() {
        if (tabEmprunt.size() != 0) {
            int test = 0;
            Emprunt e = new Emprunt();
            System.out.println("Num de Cin : ");
            scCIN = new Scanner(System.in);
            e.setNumCin(scCIN.nextInt());
            for (Emprunt emp : tabEmprunt) {
                if (emp.getNumCin() == e.getNumCin()) {
                    System.out.println(emp);
                    test = 1;
                }

            }
            if (test == 0)
                System.out.println("Cet adherent n'a pas d'emprunt.");
        } else
            System.out.println("Notre bibliotheque ne contient aucun emprunt.");

    }

    public void empruntDateRetour() {
        if (tabEmprunt.size() != 0) {
            int test = 0;
            Emprunt e = new Emprunt();

            System.out.println("Date de retour : \n Entrez l'annee \n Entrez le mois \n Entrez le jour");
            scJ = new Scanner(System.in);
            scM = new Scanner(System.in);
            scA = new Scanner(System.in);
            e.setDateRetour(LocalDate.of(scA.nextInt(), scM.nextInt(), scJ.nextInt()));

            for (Emprunt emp : tabEmprunt) {
                if (emp.getDateRetour().equals(e.getDateRetour())) {
                    System.out.println(emp);
                    test = 1;
                }

            }
            if (test == 0)
                System.out.println("Pas d'emprunt relatif a cette date.");
        } else
            System.out.println("Notre bibliotheque ne contient aucun emprunt.");

    }

    public void supprimerEnsembleEmprunt() {
        int jour = 0, mois = 0, annee = 0;
        int jourr = 0, moiss = 0, anneee = 0;
        if (tabEmprunt.size() != 0) {
            int test = 0;
            Emprunt e = new Emprunt();
            System.out.println("Date de debut de periode : \n");
            System.out.println("Jour : ");
            scJ = new Scanner(System.in);
            jour = scJ.nextInt();
            System.out.println("Mois : ");
            scM = new Scanner(System.in);
            mois = scM.nextInt();
            System.out.println("Annee : ");
            scA = new Scanner(System.in);
            annee = scA.nextInt();
            e.setDateEmp(LocalDate.of(annee, mois, jour));

            System.out.println("Date de fin de periode : \n");
            System.out.println("Jour : ");
            scJJ = new Scanner(System.in);
            jourr = scJJ.nextInt();
            System.out.println("Mois : ");
            scMM = new Scanner(System.in);
            moiss = scMM.nextInt();
            System.out.println("Annee : ");
            scAA = new Scanner(System.in);
            anneee = scAA.nextInt();
            e.setDateRetour(LocalDate.of(anneee, moiss, jourr));

            for (Emprunt emp : tabEmprunt) {
                if (((emp.getDateEmp().isAfter(e.getDateEmp())) && (emp.getDateEmp().isBefore(e.getDateRetour())))
                        || ((emp.getDateRetour().isAfter(e.getDateEmp()))
                                && (emp.getDateRetour().isBefore(e.getDateRetour())))) {

                    tabDelete.add(emp);
                    test = 1;
                }

            }
            for (Emprunt emprunt : tabDelete) {
                for (Livre livre : tabLivre) {
                    if (emprunt.getNumLivre() == livre.getNumero())
                        livre.setNmbrExemplaire(livre.getNmbrExemplaire() + 1);
                }
            }
            tabEmprunt.removeAll(tabDelete);

            if (test == 0)
                System.out.println("Pas d'emprunt dans cette periode.");
        } else
            System.out.println("Notre bibliotheque ne contient aucun emprunt.");

    }

    public void LivresPlusEmpruntes() {
        int jour = 0, mois = 0, annee = 0;
        int jourr = 0, moiss = 0, anneee = 0;
        if (tabEmprunt.size() != 0) {
            if (tabLivre.size() != 0) {

                Emprunt e = new Emprunt();
                System.out.println("Date de debut de periode : \n");
                System.out.println("Jour : ");
                scJ = new Scanner(System.in);
                jour = scJ.nextInt();
                System.out.println("Mois : ");
                scM = new Scanner(System.in);
                mois = scM.nextInt();
                System.out.println("Annee : ");
                scA = new Scanner(System.in);
                annee = scA.nextInt();
                e.setDateEmp(LocalDate.of(annee, mois, jour));

                System.out.println("Date de fin de periode : \n");
                System.out.println("Jour : ");
                scJJ = new Scanner(System.in);
                jourr = scJJ.nextInt();
                System.out.println("Mois : ");
                scMM = new Scanner(System.in);
                moiss = scMM.nextInt();
                System.out.println("Annee : ");
                scAA = new Scanner(System.in);
                anneee = scAA.nextInt();
                e.setDateRetour(LocalDate.of(anneee, moiss, jourr));

                for (Emprunt emp : tabEmprunt) {
                    if (((emp.getDateEmp().isAfter(e.getDateEmp())) && (emp.getDateEmp().isBefore(e.getDateRetour())))
                            || ((emp.getDateRetour().isAfter(e.getDateEmp()))
                                    && (emp.getDateRetour().isBefore(e.getDateRetour())))) {
                        for (Livre liv : tabLivre) {
                            if (liv.getNumero() == emp.getNumLivre()) {
                                liv.setNmbrEmpruntLivre(liv.getNmbrEmpruntLivre() + 1);
                            }

                        }
                    }
                }
                int max = 0;
                for (Livre livre : tabLivre) {
                    if (livre.getNmbrEmpruntLivre() > max)
                        max = livre.getNmbrEmpruntLivre();
                }
                for (Livre livr : tabLivre) {
                    if (livr.getNmbrEmpruntLivre() == max)
                        System.out.println("Le livre le plus emprunter : " + livr + "Nombre de fois emprunte : "
                                + livr.getNmbrEmpruntLivre());
                }
            } else
                System.out.println("Notre bibliotheque ne contient aucun emprunt.");
        } else
            System.out.println("Notre bibliotheque ne contient aucun emprunt.");
        for (Livre li : tabLivre) {
            li.setNmbrEmpruntLivre(0);
        }

    }

    public void emprunteurFidele() {

        for (Emprunt emp : tabEmprunt) {
            if (tabEmprunteurs.size() != 0) {
                for (Emprunt emprunt : tabEmprunteurs) {
                    if (emp.getNumCin() == emprunt.getNumCin()) {
                        emprunt.setNmbrEmprunt(emprunt.getNmbrEmprunt() + 1);
                        System.out.println("bonjour if");
                    }

                }

                tabEmprunteurs.add(emp);
                emp.setNmbrEmprunt(emp.getNmbrEmprunt() + 1);

            } else {
                tabEmprunteurs.add(emp);
                emp.setNmbrEmprunt(emp.getNmbrEmprunt() + 1);

            }

        }
        int max = 0;
        for (Emprunt empr : tabEmprunteurs) {
            if (empr.getNmbrEmprunt() > max)
                max = empr.getNmbrEmprunt();
        }
        for (Emprunt emprunteur : tabEmprunteurs) {
            if (emprunteur.getNmbrEmprunt() == max)
                System.out.println(emprunteur + "Nombre d'emprunt : " + emprunteur.getNmbrEmprunt());
        }
        tabEmprunteurs.removeAll(tabEmprunt);
        for (Emprunt emprr : tabEmprunt) {
            emprr.setNmbrEmprunt(0);
        }
    }

}