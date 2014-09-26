package fr.univtln.bruno.exemple.bibliotheque.matériel;

import fr.univtln.bruno.exemple.bibliotheque.Bibliotheque;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.ComportementEmpruntable;
import fr.univtln.bruno.exemple.bibliotheque.emprunts.Empruntable;

/**
 * Created by bruno on 26/09/14.
 */
public class OrdinateurPortable extends Matériel
        implements Empruntable {

    public enum Os {WINDOWS, LINUX, MACOS}

    private String modèle;
    private Os os;

    public static OrdinateurPortable getInstance(Bibliotheque bibliotheque, String modèle, Os os) {
        OrdinateurPortable ordinateurPortable = new OrdinateurPortable(bibliotheque, modèle, os);
        bibliotheque.add(ordinateurPortable);
        return ordinateurPortable;
    }

    private OrdinateurPortable(Bibliotheque bibliotheque, String modèle, Os os) {
        super(bibliotheque);
        this.modèle = modèle;
        this.os = os;
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

    private ComportementEmpruntable comportementEmpruntable = new ComportementEmpruntable();

    @Override
    public boolean isDisponible() {
        return comportementEmpruntable.isDisponible();
    }

    @Override
    public void estEmprunte(Bibliotheque.Adhérent emprunteur) {
        comportementEmpruntable.estEmprunte(this, emprunteur);
    }

    @Override
    public void estRendu() {
        comportementEmpruntable.estRendu(this);
    }
}
