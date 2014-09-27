package fr.univtln.bruno.exemple.bibliotheque;

import fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire.Document;
import fr.univtln.bruno.exemple.bibliotheque.fondDocumentaire.Livre;
import fr.univtln.bruno.exemple.bibliotheque.matériel.OrdinateurPortable;
import fr.univtln.bruno.exemple.bibliotheque.personne.Personne;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliothequeTest {
    private Bibliotheque bibliothèque;
    Personne personne1 = new Personne("marie.durand@test.fr", "marie", "durand");
    Personne personne2 = new Personne("jean.martin@test.fr", "jean", "martin");

    @Before
    public void setUp() throws Exception {
        bibliothèque = new Bibliotheque("Ma Bibliothèque")
                .addAuteur(personne1)
                .addAuteur(personne2)
                .addAdhérent("pierre.dupond@test.fr", "pierre", "dupond", Bibliotheque.Adhérent.Statut.ENSEIGNANT)
                .addAdhérent("marc.durand@test.fr", "marc", "durand", Bibliotheque.Adhérent.Statut.ETUDIANT)
                .addOrdinateurPortable("Vaio", OrdinateurPortable.Os.LINUX)
                .addOrdinateurPortable("Dell", OrdinateurPortable.Os.WINDOWS)
                .addOrdinateurPortable("Macbook Pro", OrdinateurPortable.Os.MACOS)
                .addLivre("123-XY", "Mon livre 1", "marie.durand@test.fr")
                .addLivre("A", "Mon livre 1", "marie.durand@test.fr")
                .addLivre("B", "Mon livre B", "marie.durand@test.fr")
                .addLivre("C", "Mon livre C", "jean.martin@test.fr")
                .addLivre("D", "Mon livre D", "marie.durand@test.fr");
    }

    /**
     * Ajout simple d'auteurs.
     *
     * @throws Exception
     */
    @Test
    public void testAddAuteur() throws Exception {
        Bibliotheque bibliotheque = new Bibliotheque("Test");
        bibliotheque.addAuteur(new Personne("prenom1.nom1@ici.fr", "prenom1", "nom1"));
        assertEquals(bibliotheque.getAuteursIds().size(), 1);

        bibliotheque.addAuteur(new Personne("prenom2.nom2@ici.fr", "prenom2", "nom2"));
        assertEquals(bibliotheque.getAuteursIds().size(), 2);

        bibliotheque.addAuteur(new Personne("prenom3.nom3@ici.fr", "prenom3", "nom3"));
        assertEquals(bibliotheque.getAuteursIds().size(), 3);
    }

    /**
     * Récupération simple d'un auteur via un ID
     *
     * @throws Exception
     */
    @Test
    public void testGetAuteur() throws Exception {
        assertEquals(bibliothèque.getAuteur(personne1.ID), personne1);
        assertEquals(bibliothèque.getAuteur(personne2.ID), personne2);
    }

    /**
     * Récupération simple d'un auteur via un email en String
     *
     * @throws Exception
     */
    @Test
    public void testGetAuteur1() throws Exception {
        assertEquals(bibliothèque.getAuteur(personne1.ID.EMAIL), personne1);
        assertEquals(bibliothèque.getAuteur(personne2.ID.EMAIL), personne2);
    }

    /**
     * Ajout d'un Matériel
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        Bibliotheque bibliothèque = new Bibliotheque("Ma Bibliothèque")
                .addOrdinateurPortable("Vaio", OrdinateurPortable.Os.LINUX);
        assertEquals(bibliothèque.getMaterielIds().size(), 1);
        bibliothèque.addOrdinateurPortable("Dell", OrdinateurPortable.Os.WINDOWS);
        assertEquals(bibliothèque.getMaterielIds().size(), 2);
        bibliothèque.addOrdinateurPortable("Macbook Pro", OrdinateurPortable.Os.MACOS);
        assertEquals(bibliothèque.getMaterielIds().size(), 3);
    }

    /**
     * Suppression d'un matériel
     *
     * @throws Exception
     */
    @Test
    public void testRemove() throws Exception {

    }

    /**
     * Ajout d'un document
     *
     * @throws Exception
     */
    @Test
    public void testAdd1() throws Exception {
        String docId;
        String docTitle;
        String auteurId;
        Livre livre;
        Bibliotheque bibliothèque = new Bibliotheque("Ma Bibliothèque")
                .addAuteur(personne1)
                .addAuteur(personne2)
                .addLivre(docId = "123-XY", docTitle = "Mon livre 1", auteurId = "marie.durand@test.fr");
        assertNotNull(livre = (Livre) bibliothèque.getDocument(docId));
        assertEquals(livre.ISBN, docId);
        assertEquals(livre.getTitre(), docTitle);
        assertEquals(livre.getAuteur(), bibliothèque.getAuteur(auteurId));

        bibliothèque.addLivre(docId = "A", docTitle = "Mon livre 1", auteurId = "marie.durand@test.fr");
        assertNotNull(livre = (Livre) bibliothèque.getDocument(docId));
        assertEquals(livre.ISBN, docId);
        assertEquals(livre.getTitre(), docTitle);
        assertEquals(livre.getAuteur(), bibliothèque.getAuteur(auteurId));

        bibliothèque.addLivre(docId = "B", docTitle = "Mon livre B", auteurId = "marie.durand@test.fr");
        assertNotNull(livre = (Livre) bibliothèque.getDocument(docId));
        assertEquals(livre.ISBN, docId);
        assertEquals(livre.getTitre(), docTitle);
        assertEquals(livre.getAuteur(), bibliothèque.getAuteur(auteurId));

        bibliothèque.addLivre(docId = "C", docTitle = "Mon livre C", auteurId = "jean.martin@test.fr");
        assertNotNull(livre = (Livre) bibliothèque.getDocument(docId));
        assertEquals(livre.ISBN, docId);
        assertEquals(livre.getTitre(), docTitle);
        assertEquals(livre.getAuteur(), bibliothèque.getAuteur(auteurId));

        bibliothèque.addLivre(docId = "D", docTitle = "Mon livre D", auteurId = "marie.durand@test.fr");
        assertNotNull(livre = (Livre) bibliothèque.getDocument(docId));
        assertEquals(livre.ISBN, docId);
        assertEquals(livre.getTitre(), docTitle);
        assertEquals(livre.getAuteur(), bibliothèque.getAuteur(auteurId));
    }

    /**
     * Suppression d'un document
     *
     * @throws Exception
     */
    @Test
    public void testRemove1() throws Exception {

    }

    @Test
    public void testAdd2() throws Exception {

    }

    @Test
    public void testRemove2() throws Exception {

    }

    @Test
    public void testGetNom() throws Exception {

    }

    @Test
    public void testAddAdhérent() throws Exception {

    }

    @Test
    public void testAddOrdinateurPortable() throws Exception {

    }

    @Test
    public void testAddLivre() throws Exception {

    }

    @Test
    public void testAddLivre1() throws Exception {

    }

    @Test
    public void testGetDocument() throws Exception {

    }

    @Test
    public void testGetMatériel() throws Exception {

    }

    @Test
    public void testGetAdhérent() throws Exception {

    }

    @Test
    public void testGetAdhérent1() throws Exception {

    }

    @Test
    public void testRendreOrdinateur() throws Exception {

    }

    @Test
    public void testRendreLivre() throws Exception {

    }

    @Test
    public void testRendre() throws Exception {

    }

    @Test
    public void testEmprunterOrdinateur() throws Exception {

    }

    @Test
    public void testEmprunterLivre() throws Exception {

    }

    @Test
    public void testEmprunter() throws Exception {

    }

    @Test
    public void testGetMaterielIds() throws Exception {

    }

    @Test
    public void testGetAdherentsIds() throws Exception {

    }

    @Test
    public void testGetAuteursIds() throws Exception {

    }
}