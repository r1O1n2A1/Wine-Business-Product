package fr.afcepf.atod.business.product.api;

import fr.afcepf.atod.wine.entity.Adress;
/**
 * Interface pour les règles de gestion associées
 * à l'adresse dans l'application.
 * @author Metabeen
 * 
 */
@FunctionalInterface
public interface IBuAdress {
	/**
	 * Méthode d'ajout d'une nouvelle adresse dans la base.
	 * @param adr l'objet {@link Adress} pour l'ajout.
	 * @return un objet {@link Adress}.
	 */
	Adress addNewAdress(Adress adr);

}
