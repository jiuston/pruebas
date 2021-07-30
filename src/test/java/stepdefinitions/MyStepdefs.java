package stepdefinitions;

import com.propio.pruebas.modelo.Persona;
import io.cucumber.java.en.Given;

import java.util.List;

public class MyStepdefs {


    @Given("tengo estas personas")
    public void tengo_estas_personas(final List<Persona>personas) {
        System.out.println(personas);

    }


}
