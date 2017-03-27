package fr.afcepf.atod.business.product.api;

import java.util.List;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.City;
/**
 * Interface pour les règles de gestion
 * associées aux villes dans l'application.
 * @author Metabeen
 *
 */
@FunctionalInterface
public interface IBuCity {
	/**
	 * Méthode pour la récupération de toutes les villes
	 * présentes dans l'unité de persistence.
	 * @return une {@link List} d'objets {@link City}.
	 * @throws WineException
	 */
	List<City> findAllCities() throws WineException;
}
