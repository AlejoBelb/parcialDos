CREATE OR REPLACE FUNCTION validar_correo(correo IN VARCHAR2) 
RETURN VARCHAR2 
IS
    -- Variables para las partes del correo
    nombre_usuario VARCHAR2(30);
    dominio VARCHAR2(30);
    extension VARCHAR2(30);
    extension_final VARCHAR2(30);
    
    -- Índices de validación
    at_index INTEGER;
    dot_com_index INTEGER;
    dot_co_index INTEGER;
    
BEGIN
    -- Validar la longitud
    IF LENGTH(correo) < 10 OR LENGTH(correo) > 30 THEN
        RETURN 'Correo inválido: longitud fuera del rango permitido';
    END IF;
    
    -- Validar la estructura del correo
    at_index := INSTR(correo, '@');
    dot_com_index := INSTR(correo, '.com');
    dot_co_index := INSTR(correo, '.co', dot_com_index + 4);
    
    IF at_index = 0 OR dot_com_index = 0 OR dot_co_index = 0 THEN
        RETURN 'Correo inválido: estructura incorrecta';
    END IF;
    
    -- Validar la primera parte (nombre de usuario)
    nombre_usuario := SUBSTR(correo, 1, at_index - 1);
    IF NOT REGEXP_LIKE(nombre_usuario, '^[a-zA-Z0-9]+$') THEN
        RETURN 'Correo inválido: nombre de usuario contiene caracteres no permitidos';
    END IF;
    
    -- Validar la segunda parte (el signo @ ya está comprobado)
    dominio := SUBSTR(correo, at_index + 1, dot_com_index - at_index - 1);
    IF dominio IS NULL OR dominio = '' THEN
        RETURN 'Correo inválido: dominio vacío';
    END IF;
    
    -- Validar la tercera parte (.com)
    extension := SUBSTR(correo, dot_com_index, 4);
    IF extension != '.com' THEN
        RETURN 'Correo inválido: falta ".com"';
    END IF;
    
    -- Validar la última parte (.co)
    extension_final := SUBSTR(correo, dot_co_index, 3);
    IF extension_final != '.co' THEN
        RETURN 'Correo inválido: falta ".co"';
    END IF;
    
    RETURN 'Correo válido';
END validar_correo;
/

CREATE OR REPLACE FUNCTION es_multiplo_de_tres(numero IN NUMBER) 
RETURN VARCHAR2 
IS
BEGIN
    IF MOD(numero, 3) = 0 THEN
        RETURN 'El número es múltiplo de 3';
    ELSE
        RETURN 'El número no es múltiplo de 3';
    END IF;
END es_multiplo_de_tres;
/
