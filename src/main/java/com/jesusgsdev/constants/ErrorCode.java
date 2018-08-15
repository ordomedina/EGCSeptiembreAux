package com.jesusgsdev.constants;

public enum ErrorCode {

    PREGUNTA_NO_ENCONTRADA("0001", "Pregunta no encontrada"),

    VOTACION_NO_ENCONTRADA("1001", "Votacion no encontrada"),

    RESPUESTA_NO_ENCONTRADA("1002", "Respuesta no encontrada")

   ;

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + " - " + message;
    }
}
