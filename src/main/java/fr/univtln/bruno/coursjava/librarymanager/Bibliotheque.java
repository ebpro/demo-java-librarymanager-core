package fr.univtln.bruno.coursjava.librarymanager;

import fr.univtln.bruno.coursjava.librarymanager.emprunts.Empruntable;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.documents.DocumentInconnuException;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.emprunts.*;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.materiels.MaterielInconnuException;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.personnes.AdherentInconnuException;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.personnes.AuteurInconnuException;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.sauvegarde.RestaurationException;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.sauvegarde.SauvegardeException;
import fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire.Document;
import fr.univtln.bruno.coursjava.librarymanager.fondDocumentaire.Livre;
import fr.univtln.bruno.coursjava.librarymanager.matériel.Matériel;
import fr.univtln.bruno.coursjava.librarymanager.matériel.OrdinateurPortable;
import fr.univtln.bruno.coursjava.librarymanager.personne.Personne;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * La classe Bibliothèque est une facade pour la gestion complète d'une bibliothèque. Elle permet de créer des ressources (Documents, Adhérents, Matériel)
 * et les emprunts.
 */
public class Bibliotheque implements IBibliotheque, Serializable {
    /**
     * Le logger de la classe courante
     */
    private static Logger logger = Logger.getLogger(Bibliotheque.class.getName());
    /**
     * Le nom de la bibliothèque
     */
    private String nom;
    /**
     * L'index des auteurs de la bibliothèque
     */
    private Map<IPersonne.Id, IPersonne> auteurs = new HashMap<IPersonne.Id, IPersonne>();
    /**
     * L'index du matériels de la bibliothèque
     */
    private Map<Integer, Matériel> matériels = new HashMap<Integer, Matériel>();
    /**
     * L'index des documents de la bibliothèque
     */
    private Map<String, Document> documents = new HashMap<String, Document>();
    /**
     * L'index des adhérents de la bibliothèque
     */
    private Map<IPersonne.Id, Adhérent> adherents = new HashMap<IPersonne.Id, Adhérent>();

    /**
     * Constructeur de bibliothèque avec un nom
     *
     * @param nom
     */
    public Bibliotheque(String nom) {
        logger.info("Création de la bibliothèque " + nom);
        this.nom = nom;
    }

    /**
     * Crée une nouvelle instance de Bibliothèque à partir de données serialisée dans un fichier
     *
     * @param filename le nom du fichier
     * @return la nouvelle bibliotheque
     * @throws RestaurationException
     */
    public static IBibliotheque importer(String filename) throws RestaurationException {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            return importer(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RestaurationException(e);
        }
    }

    /**
     * Crée une nouvelle instance de Bibliothèque à partir de données serialisée sur un flux.
     *
     * @param inputStream le flux source des données.
     * @return la nouvelle bibliotheque
     * @throws RestaurationException
     */
    public static IBibliotheque importer(InputStream inputStream) throws RestaurationException {
        IBibliotheque bibliotheque = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            bibliotheque = (IBibliotheque) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RestaurationException(e);
        } catch (ClassNotFoundException e) {
            throw new RestaurationException(e);
        }
        return bibliotheque;
    }

    /**
     * retourne la collection des matériels de la bibliothèque
     *
     * @return
     */
    public Collection<Matériel> getMatériels() {
        return matériels.values();
    }

    /**
     * retourne la collection des adhérents de la bibliothèque
     *
     * @return
     */
    public Collection<Adhérent> getAdhérents() {
        return adherents.values();
    }

    /**
     * retourne la liste des documents de la bibliothèque
     *
     * @return
     */
    public Collection<Document> getDocuments() {
        return documents.values();
    }

    /**
     * Ajoute une personne aux auteurs.
     *
     * @param auteur
     * @return
     */
    public IBibliotheque addAuteur(IPersonne auteur) {
        logger.finest("Ajout de l'auteur " + auteur);
        auteurs.put(auteur.getId(), auteur);
        return this;
    }

    /**
     * Retourne un auteur correspondant à un id.
     *
     * @param auteurId
     * @return
     * @throws AuteurInconnuException
     */
    public IPersonne getAuteur(String auteurId) throws AuteurInconnuException {
        return getAuteur(new Personne.Id(auteurId));
    }

    /**
     * Retourne un auteur correspondant à un id sous forme de String.
     *
     * @param auteurId
     * @return
     * @throws AuteurInconnuException
     */
    public IPersonne getAuteur(IPersonne.Id auteurId) throws AuteurInconnuException {
        IPersonne auteur = auteurs.get(auteurId);
        if (auteur == null) throw new AuteurInconnuException(auteurId);
        return auteur;
    }

    /**
     * Ajoute un nouveau matériel à la bibliothèque
     *
     * @param matériel
     * @return
     */
    public IBibliotheque add(Matériel matériel) {
        logger.finest("Ajout du matériel " + matériel);
        matériels.put(matériel.ID, matériel);
        return this;
    }

    /**
     * Supprime un matériel de la bibliothèque
     *
     * @param matériel
     * @return
     */
    public IBibliotheque remove(Matériel matériel) {
        logger.finest("Suppression du matériel " + matériel);
        matériels.remove(matériel.ID);
        return this;
    }

    /**
     * Ajoute un Document à la bibliothèque
     *
     * @param document
     * @return
     */
    public IBibliotheque add(Document document) {
        logger.finest("Ajout du document " + document);
        documents.put(document.ISBN, document);
        return this;
    }

    /**
     * Supprime un document de la bibliothèque
     *
     * @param document
     * @return
     */
    public IBibliotheque remove(Document document) {
        logger.finest("Suppression du document " + document);
        documents.remove(document.ISBN);
        return this;
    }

    /**
     * Ajoute un adhérent à la bibliothèque
     *
     * @param adhérent
     * @return
     */
    public IBibliotheque add(Adhérent adhérent) {
        adherents.put(adhérent.getId(), adhérent);
        return this;
    }

    /**
     * Supprime un adhérent de la bibliothèque
     *
     * @param adhérent
     * @return
     */
    public IBibliotheque remove(Adhérent adhérent) {
        logger.finest("Suppression de l'adhérent " + adhérent);
        adherents.remove(adhérent);
        return this;
    }

    /**
     * Retourne le nom de la bibliothèque
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return "Bibliothèque {" + newLine +
                " Nom = '" + nom + '\'' + newLine +
                " Matériels = " + matériels + newLine +
                " Auteurs = " + auteurs + newLine +
                " Documents = " + documents + newLine +
                " Adhérents = " + adherents + newLine +
                '}';
    }

    /**
     * Créée un adhérent et l'ajoute à la bibliothèque. C'est une facade de Adhérent.
     *
     * @param email
     * @param prenom
     * @param nom
     * @param statut
     * @return
     */
    public IBibliotheque addAdhérent(String email, String prenom, String nom, Adhérent.Statut statut) {
        AdhérentEnMemoire.getInstance(this, email, prenom, nom, statut);
        return this;
    }

    /**
     * Créée un ordinateur portable et l'ajoute à la bibliothèque. C'est une facade de Ordinateur portable.
     *
     * @param marque
     * @param os
     * @return
     */
    public IBibliotheque addOrdinateurPortable(String marque, OrdinateurPortable.Os os) {
        OrdinateurPortable.getInstance(this, marque, os);
        return this;
    }

    /**
     * Créée un Livre et l'ajoute à la bibliothèque. C'est une facade de Livre.
     *
     * @param isbn
     * @param titre
     * @param auteur
     * @return
     */
    public IBibliotheque addLivre(String isbn, String titre, String auteur) throws AuteurInconnuException {
        Livre.getInstance(this, isbn, titre, getAuteur(auteur));
        return this;
    }

    /**
     * Créée un Livre et l'ajoute à la bibliothèque. C'est une facade de Livre.
     *
     * @param isbn
     * @param titre
     * @param auteur
     * @return
     */
    public IBibliotheque addLivre(String isbn, String titre, IPersonne auteur) {
        Livre.getInstance(this, isbn, titre, auteur);
        return this;
    }

    /**
     * retourne un document correspondant à un ISBN.
     *
     * @param isbn
     * @return
     * @throws DocumentInconnuException
     */
    public Document getDocument(String isbn) throws DocumentInconnuException {
        Document document = documents.get(isbn);
        if (document == null) throw new DocumentInconnuException(isbn);
        return document;
    }

    /**
     * Retourne un matériel correspondant à un id.
     *
     * @param id
     * @return
     * @throws MaterielInconnuException
     */
    public Matériel getMatériel(int id) throws MaterielInconnuException {
        Matériel matériel = matériels.get(id);
        if (matériel == null) throw new MaterielInconnuException(id);
        return matériel;
    }

    /**
     * Retourne un matériel correspondant à un id de personne.
     *
     * @param id
     * @return
     * @throws AdherentInconnuException
     */
    public Adhérent getAdhérent(IPersonne.Id id) throws AdherentInconnuException {
        Adhérent adhérent = adherents.get(id);
        if (adhérent == null) throw new AdherentInconnuException(id);
        return adhérent;
    }

    /**
     * Retourne un matériel correspondant à un id sous forme de string.
     *
     * @param email
     * @return
     * @throws AdherentInconnuException
     */
    public Adhérent getAdhérent(String email) throws AdherentInconnuException {
        return getAdhérent(new Personne.Id(email));
    }

    public IBibliotheque rendreOrdinateur(int id) throws MaterielInconnuException, NonEmpruntableException {
        try {
            ((Empruntable) getMatériel(id)).estRendu();
        } catch (ClassCastException e) {
            throw new NonEmpruntableException();
        }
        return this;
    }

    public IBibliotheque rendreLivre(String isbn) throws DocumentInconnuException, NonEmpruntableException {
        try {
            ((Empruntable) getDocument(isbn)).estRendu();
        } catch (ClassCastException e) {
            throw new NonEmpruntableException();
        }
        return this;
    }

    public IBibliotheque rendre(Empruntable empruntable) {
        empruntable.estRendu();
        return this;
    }

    public IBibliotheque emprunterOrdinateur(String emprunteur, int id) throws MaterielInconnuException, NonEmpruntableException, AdherentInconnuException, EmpruntImpossibleException, DocumentInconnuException {
        try {
            emprunter(getAdhérent(emprunteur), (Empruntable) getMatériel(id));
        } catch (ClassCastException e) {
            throw new NonEmpruntableException();
        }
        return this;
    }

    public IBibliotheque emprunterLivre(String emprunteur, String isbn) throws MaterielInconnuException, NonEmpruntableException, AdherentInconnuException, EmpruntImpossibleException, DocumentInconnuException {
        try {
            emprunter(getAdhérent(emprunteur), (Empruntable) getDocument(isbn));
        } catch (ClassCastException e) {
            throw new NonEmpruntableException();
        }
        return this;
    }

    public IBibliotheque emprunter(Adhérent emprunteur, Empruntable empruntable) throws MaterielInconnuException,
            AdherentInconnuException, NonEmpruntableException, EmpruntImpossibleException {
        //On vérifie qu'il s'agit bien d'un adhérent de cette bibliothèque.
        if (adherents.containsValue(emprunteur))
            emprunteur.emprunter(empruntable);
        else
            throw new EmpruntImpossibleException(emprunteur, empruntable);
        return this;
    }

    /**
     * @return L'ensemble des Id des matériels.
     */
    public Set<Integer> getMaterielIds() {
        return matériels.keySet();
    }

    /**
     * @return L'ensemble des Ids des adhérents
     */
    public Set<IPersonne.Id> getAdherentsIds() {
        return adherents.keySet();
    }

    /**
     * @return L'ensemble des Ids des auteurs.
     */
    public Set<IPersonne.Id> getAuteursIds() {
        return auteurs.keySet();
    }

    @Override
    public IBibliotheque setNom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * Serialise la bibliotheque dans un fichier.
     *
     * @param filename Le nom du fichier dans lequel sera serialisée la bibliotheque
     * @throws SauvegardeException
     */
    public void exporter(String filename) throws SauvegardeException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            exporter(fileOutputStream);
        } catch (FileNotFoundException e) {
            throw new SauvegardeException(e);
        }
    }

    /**
     * Serialise la bibliotheque dans un flux.
     *
     * @param outputStream le flux de destination
     * @throws SauvegardeException
     */
    public void exporter(OutputStream outputStream) throws SauvegardeException {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            throw new SauvegardeException(e);
        }
    }

    public static final class AdhérentEnMemoire extends Personne implements Adhérent, Serializable {
        private static final Logger logger = Logger.getLogger(AdhérentEnMemoire.class.getName());
        private static final int NB_EMPRUNTS_MAX = 5;
        private final Set<Empruntable> emprunts = new HashSet<Empruntable>(NB_EMPRUNTS_MAX);
        private Adhérent.Statut statut;
        private int nbOrdinateursEmpruntés = 0;
        private int nbEmprunts = 0;

        private AdhérentEnMemoire(IPersonne.Id ID, String nom, String prenom, Adhérent.Statut statut) {
            super(ID, nom, prenom);
            this.statut = statut;
            logger.info("Ajout de l'adhérent " + this.ID);
        }

        private static Adhérent getInstance(IBibliotheque bibliotheques, IPersonne.Id id, String nom, String prenom, Adhérent.Statut statut) {
            AdhérentEnMemoire adherent = new AdhérentEnMemoire(id, nom, prenom, statut);
            bibliotheques.add(adherent);
            return adherent;
        }

        private static Adhérent getInstance(IBibliotheque bibliotheques, String id, String nom, String prenom, Adhérent.Statut statut) {
            return getInstance(bibliotheques, new Personne.Id(id)
                    , nom, prenom, statut);
        }

        public Adhérent emprunter(Empruntable empruntable) throws EmpruntImpossibleException {
            logger.info(this.ID + " emprunte " + empruntable);
            //On vérifie les contraintes d'emprunts
            //est-ce disponible ?
            if (!empruntable.isDisponible())
                throw new EmpruntableIndisponibleException(this, empruntable);
                //Si c'est un PC, est-ce bien le 1er ?
            else if (empruntable instanceof OrdinateurPortable)
                if (nbOrdinateursEmpruntés > 0)
                    throw new OrdinateurDejaEmprunteException(this, empruntable);
                    //Dans tout les cas, le nb d'emprunts est-il atteint ?
                else if (nbEmprunts > NB_EMPRUNTS_MAX)
                    throw new NombreMaximumEmpruntsException(this, empruntable);

            //On effectue l'emprunt
            if (empruntable instanceof OrdinateurPortable) nbOrdinateursEmpruntés++;
            nbEmprunts++;
            emprunts.add(empruntable);
            empruntable.estEmprunte(this);

            return this;
        }

        public AdhérentEnMemoire rendre(Empruntable empruntable) throws RestitutionException {
            logger.info(this.ID + " rend " + empruntable);
            //On vérifie que c'est bien cet adhérent qui a fait cet emprunt.
            if (!emprunts.contains(empruntable)) throw new RestitutionException();

            //On effectue la restitution
            emprunts.remove(empruntable);
            empruntable.estRendu();

            //On met à jour les contraintes
            if (empruntable instanceof OrdinateurPortable) nbOrdinateursEmpruntés--;
            nbEmprunts--;
            return this;
        }

        public Set<Empruntable> getEmprunts() {
            return emprunts;
        }

        @Override
        public String toString() {
            String newLine = System.getProperty("line.separator");
            return "Adhérent{" + newLine +
                    "Personne = " + super.toString() + "," + newLine +
                    " statut = " + statut + "," + newLine +
                    " emprunts = " + emprunts + "," + newLine +
                    '}';
        }

        public enum Statut {ETUDIANT, ENSEIGNANT}
    }

}
