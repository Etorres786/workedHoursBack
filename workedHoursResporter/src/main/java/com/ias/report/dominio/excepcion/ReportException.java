package com.ias.report.dominio.excepcion;

public class ReportException extends RuntimeException {
	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String EL_LIBRO_NO_EXISTE = "El libro no existe";
	public static final String LIBRO_PALINDROMO = "Los libros palindromos solo se pueden utilizar en la biblioteca";
	public static final String INGRESE_ISBN_PARA_EL_PRESTAMO = "Ingrese el ISBN para realizar el prestamo del libro";
	public static final String INGRESE_NOMBRE_USUARIO_PARA_EL_PRESTAMO = "Ingrese el nombre del usuario para poder realizar el prestamo";
	public static final String INGRESE_FECHA_SOLICITUD_PARA_EL_PRESTAMO = "Para el prestamo se necesita fecha de Solicitud";
    private static final long serialVersionUID = 1L;

    public ReportException(String message) {
        super(message);
    }
}
