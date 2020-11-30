package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    private int edellinen;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, sovelluslogiikka);
    }

    @Override
    public void suorita() {
        edellinen = sovelluslogiikka.tulos();
        sovelluslogiikka.nollaa();
        tuloskentta.setText(Integer.toString(sovelluslogiikka.tulos()));
        syotekentta.setText(Integer.toString(sovelluslogiikka.tulos()));

        nollaa.setDisable(true);
        undo.setDisable(false);
    }

    @Override
    public void peru() {
        sovelluslogiikka.setTulos(edellinen);
        tuloskentta.setText(Integer.toString(sovelluslogiikka.tulos()));

        undo.setDisable(true);
        nollaa.setDisable(false);
    }
    
}
