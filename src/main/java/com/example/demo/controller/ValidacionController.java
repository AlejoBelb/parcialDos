package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ValidacionService;

@RestController
@RequestMapping("/validar")
public class ValidacionController {

    @Autowired
    private ValidacionService validacionService;

    @GetMapping("/correo")
    public ResponseEntity<String> validarCorreo(@RequestParam String correo) {
        String resultado = validacionService.validarCorreo(correo);
        return ResponseEntity.ok(resultado);
    }
    
    @GetMapping("/numero")
    public ResponseEntity<String> validarMultiplo(@RequestParam int numero) {
        String resultado = validacionService.validarMultiploDeTres(numero);
        return ResponseEntity.ok(resultado);
    }

}
