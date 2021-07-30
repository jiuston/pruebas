package com.propio.pruebas.servicios;

import org.springframework.stereotype.Component;

@Component
public class MiServicio {

    public String helloWorld() {
        return"Hola Mundo";
    }

}
