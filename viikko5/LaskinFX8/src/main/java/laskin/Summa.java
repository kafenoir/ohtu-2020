package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    private int edellinen;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, sovelluslogiikka);
    }

    @Override
    public void suorita() {

        edellinen = sovelluslogiikka.tulos();
        int syote = Integer.parseInt(syotekentta.getText());
        sovelluslogiikka.plus(syote);
        tuloskentta.setText(Integer.toString(sovelluslogiikka.tulos()));

        nollausPoisPaaltaJosTulosNolla();
        undo.setDisable(false);
        

    }

    @Override
    public void peru() {
        sovelluslogiikka.setTulos(edellinen);
        tuloskentta.setText(Integer.toString(sovelluslogiikka.tulos()));

        nollausPoisPaaltaJosTulosNolla();
        undo.setDisable(true);
    }

    private void nollausPoisPaaltaJosTulosNolla() {
        
        if (sovelluslogiikka.tulos() == 0) {
            nollaa.setDisable(true);
        } else {
            nollaa.setDisable(false);
        }
    }

}
