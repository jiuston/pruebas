package com.propio.pruebas.controller;

import com.propio.pruebas.servicios.MiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final MiServicio miServicio;

    public Controller(MiServicio miServicio) {
        this.miServicio = miServicio;
    }

    @GetMapping("/")
    public ResponseEntity saludo(){
        return ResponseEntity.ok(miServicio.helloWorld());
    }

}
