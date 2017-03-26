package fr.afcepf.atod.business.product.api;

import java.util.List;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.City;
/**
 * Interface pour les r�gles de gestion
 * associ�es aux villes dans l'application.
 * @author Metabeen
 *
 */
@FunctionalInterface
public interface IBuCity {
	/**
	 * M�thode pour la r�cup�ration de toutes les villes
	 * pr�sentes dans l'unit� de persistence.
	 * @return une {@link List} d'objets {@link City}.
	 * @throws WineException
	 */
	List<City> findAllCities() throws WineException;
}
