package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OracleFunctionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
	public String validarCorreo(String correo) {
        return jdbcTemplate.queryForObject("SELECT validar_correo(?) FROM DUAL", new Object[]{correo}, String.class);
    }
    
    @SuppressWarnings("deprecation")
	public String validarMultiploDeTres(int numero) {
        return jdbcTemplate.queryForObject("SELECT es_multiplo_de_tres(?) FROM DUAL", new Object[]{numero}, String.class);
    }

}
