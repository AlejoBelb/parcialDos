package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.OracleFunctionRepository;

@Service
public class ValidacionService {

    @Autowired
    private OracleFunctionRepository oracleFunctionRepository;

    public String validarCorreo(String correo) {
        return oracleFunctionRepository.validarCorreo(correo);
    }
    
    public String validarMultiploDeTres(int numero) {
        return oracleFunctionRepository.validarMultiploDeTres(numero);
    }

}
