package com.capgemini.amazonviewer.model;

import java.util.Date;

/**
 * IVisualizable
 * <p>
 * Es ina una interfaces para implementar metodos
 * 
 * @author JORIVERA
 * @version 1.0
 * @since 2020
 * 
 * */
public interface IVisualizable {
	/**
	 * Este metodo captura el tiempo de inicio de visualizacion
	 * 
	 * @param dateI Este es un objeto {@code Date} con el tiempo exacto de inicio
	 * @return Regresa la fecha y hora de captura
	 * */	
	Date startToSee(Date dateI);
	
	/**
	 * 
	 * Este metodo captura el tiempo de inicio y fin de visualizacion
	 * @param dateI Este es un objeto {@code Date} con el tiempo exacto de inicio
	 * @param dateF Este es un objeto {@code Date} con el tiempo exacto de Fin
	 * */
	void stopToSee(Date dateI, Date dateF);
	
}
