package fr.univtln.bruno.coursjava.librarymanager.matériel;


import fr.univtln.bruno.coursjava.librarymanager.IBibliotheque;
import fr.univtln.bruno.coursjava.librarymanager.emprunts.ComportementEmpruntable;
import fr.univtln.bruno.coursjava.librarymanager.emprunts.Empruntable;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.sauvegarde.RestaurationException;
import fr.univtln.bruno.coursjava.librarymanager.exceptions.sauvegarde.SauvegardeException;

import java.io.*;
import java.util.Collection;

/**
 * Created by bruno on 26/09/14.
 */
public class OrdinateurPortable extends Matériel
        implements Empruntable, Serializable {

    private String modèle;
    private Os os;
    private ComportementEmpruntable comportementEmpruntable = new ComportementEmpruntable();

    private OrdinateurPortable(IBibliotheque bibliotheque, String modèle, Os os) {
        super(bibliotheque);
        this.modèle = modèle;
        this.os = os;
    }

    public static OrdinateurPortable getInstance(IBibliotheque bibliotheque, String modèle, Os os) {
        OrdinateurPortable ordinateurPortable = new OrdinateurPortable(bibliotheque, modèle, os);
        bibliotheque.add(ordinateurPortable);
        return ordinateurPortable;
    }

    public static void exporter(Collection<OrdinateurPortable> ordinateurPortables, String filename) throws SauvegardeException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            new SauvegardeException(e);
        }
        exporter(ordinateurPortables, fileOutputStream);
    }

    public static void exporter(Collection<OrdinateurPortable> ordinateurPortables, OutputStream outputStream) throws SauvegardeException {
        for (OrdinateurPortable o : ordinateurPortables)
            o.exporter(outputStream);
    }

    public static void importer(IBibliotheque bibliotheque, String filename) throws RestaurationException {
        OrdinateurPortable ordinateurPortable = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            importer(bibliotheque, fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RestaurationException(e);
        }
    }

    public static void importer(IBibliotheque bibliotheque, InputStream inputStream) throws RestaurationException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String modèle;
        Os os;
        try {
            try {
                while (true) {
                    modèle = dataInputStream.readUTF();
                    os = Os.values()[dataInputStream.readInt()];
                    bibliotheque.addOrdinateurPortable(modèle, os);
                }
            } catch (EOFException e) {
            }
        } catch (IOException e) {
            throw new RestaurationException(e);
        }
    }

    public String getModèle() {
        return modèle;
    }

    public void setModèle(String modèle) {
        this.modèle = modèle;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "OrdinateurPortable{" +
                "ID=" + ID +
                ", modèle='" + modèle + '\'' +
                ", os=" + os +
                ", " + comportementEmpruntable +
                '}';
    }

    @Override
    public boolean isDisponible() {
        return comportementEmpruntable.isDisponible();
    }

    @Override
    public void estEmprunte(IBibliotheque.Adhérent emprunteur) {
        comportementEmpruntable.estEmprunte(this, emprunteur);
    }

    @Override
    public void estRendu() {
        comportementEmpruntable.estRendu(this);
    }


    public void exporter(String filename) throws SauvegardeException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            throw new SauvegardeException(e);
        }
        exporter(fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            throw new SauvegardeException(e);
        }
    }

    public void exporter(OutputStream outputStream) throws SauvegardeException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try {
            dataOutputStream.writeUTF(modèle);
            //L'enum Os est enregistré sous forme de valeur ordinale
            dataOutputStream.writeInt(os.ordinal());
        } catch (IOException e) {
            throw new SauvegardeException(e);
        }
    }

    public enum Os {WINDOWS, LINUX, MACOS}
}
