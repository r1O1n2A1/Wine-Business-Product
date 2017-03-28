/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.business.product.api;

import java.util.List;
import java.util.Map;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.Product;
import fr.afcepf.atod.wine.entity.ProductType;
import fr.afcepf.atod.wine.entity.ProductVarietal;
import fr.afcepf.atod.wine.entity.ProductVintage;
import fr.afcepf.atod.wine.entity.ProductWine;

/**
 * Interface pour les règles de gestion associées
 *  aux {@link Product} dans l'application.
 * @author ronan - Metabeen
 */
public interface IBuProduct {
	/**
	 * Méthode pour la récupération d'un {@link Product}
	 * dans l'unité de persistence en utilisant comme
	 * argument un String nom.
	 * @param name Le String nom du vin.
	 * @return le premier objet {@link Product} poss�dant le nom
	 * correspondant � l'argument de la m�thode.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit ne correspond � ce nom,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul>
	 */
	List<Product> findByName(String name) throws WineException;
	/**
	 * Méthode pour la récupération d'un {@link Product}
	 * dans l'unité de persistence en utilisant comme argument
	 * un Integer identifiant.
	 * @param id Identifiant correspondant au produit
	 * dans l'unité de persistence.
	 * @return un objet {@link Product} possédant l'indentifiant
	 * correspondant à l'argument de la méthode.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit ne correspond à cet identifiant,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	Product findById(Integer id) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link List}
	 * d'objets {@link Product} en promotion ayant une date
	 * d'expiration proche.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit n'approche suffisamment de la date
	 * d'expiration,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	List<Product> getPromotedProductsSelection() throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link List}
	 * d'objets {@link Product} selon le critère d'un montant minimum.
	 * @param min Le montant minimum correspondant au prix d'un produit
	 * Règle : prix du produit > min.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException    
	 * <ul>
	 * <li>Aucun produit n'approche suffisamment de la date
	 * d'expiration,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul>
	 */
	List<Product> findExpensive(double min) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link List} de
	 * {@link ProductType}.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit n'approche suffisamment de la date
	 * d'expiration,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul>
	 */
	List<ProductType> getWineTypes() throws WineException;
	/**
	 * Méthode pour la récupération d'une {@link List} 
	 * {@link Product} dans l'unité de persistence en utilisant 
	 * comme argument un String nom.
	 * @param name Le String nom des {@link Product}.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à ce nom,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul>
	 */
	List<Product> findProductsByName(String name) throws WineException;
	/**
	 * Méthode pour la récupération d'une {@link List} 
	 * {@link Product} dans l'unité de persistence en utilisant 
	 * comme argument un String nom.
	 * @param appelation Le String appelation des {@link Product}.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à cette appelation,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul>
	 */
	List<Product> findProductsByAppelation(String appelation) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link List} de {@link ProductVintage}
	 * selon de millesime.
	 * @param vintage Millesime d'un {@link ProductVintage}.
	 * @return une {@link List} d'objets {@link ProductVintage}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à ce millesime,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	List<ProductVintage> findProductsByVintage(Integer vintage) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link List} de {@link ProductVarietal}
	 * selon le ceppage.
	 * @param varietal Ceppage d'un {@link ProductVarietal}.
	 * @return une {@link List} d'objets {@link ProductVarietal}.
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à ce ceppage,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	List<ProductVarietal> findProductsBy(String varietal) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link List} de {@link ProductType}
	 * associée au type d'un vin.
	 * @param wineType Type de vin sous forme de String.
	 * @return une {@link List} d'objets {@link ProductType}.
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à ce type de vin,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	List<ProductType> findProductsType(String wineType) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link Map} ayant pour clé
	 * le {@link ProductType} et comme valeurs une {@link List} de String 
	 * correspondant à l'appelation.
	 * @param wineTypes une {@link List} de {@link ProductType}.
	 * @return une {@link Map} ayant pour clé {@link ProductType} 
	 * et comme valeurs une {@link List} de String appelation.
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à ce type de vin,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	Map<ProductType, List<String>> getAppellationsByType(List<ProductType> wineTypes) throws WineException;
	/**
	 * Méthode permettant la récupération d'une {@link Map} ayant pour clé
	 * le {@link ProductType} et comme valeurs une {@link List} de {@link ProductVarietal}.
	 * @param wineTypes une {@link List} de {@link ProductType}.
	 * @return une {@link Map} ayant pour clé {@link ProductVarietal} 
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond à ces types de vin,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	Map<ProductType, List<ProductVarietal>> getVarietalsByType(List<ProductType> wineTypes) throws WineException;
	/**
	 * Méthode de filtre permettant la récupération de {@link ProductWine}
	 * selon la catégorie.
	 * @param type {@link ProductType} de la {@link List} de {@link ProductWine} à afficher.
	 * @param o Type générique {@link Object} pour la détermination du type.
	 * @return Une {@link List} de {@link ProductWine}.
	 * @throws WineException 
	 * <ul>
	 * <li>Les paramètres saisis ne permettent pas d'afficher une liste de produits,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul> 
	 */
	List<ProductWine> categoryAccordingToObjectType(ProductType type, Object o,Integer firstRow,Integer rowsPerPage) throws WineException;
	/**
	 * Méthode permettant l'ébauche de la gestion des stocks.
	 * @param type {@link ProductType} pour le décompte.
	 * @param o {@link Object} pour la discrimination.
	 * @return un {@link Integer} du d�compte de bouteilles correspondant à ce {@link ProductType}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucune bouteilles disponible en stock,</li>
	 * <li>impossible d'accéder à l'unité de persistence.</li>
	 * </ul>
	 */
	Integer countCategoryAccordingToObjectType(ProductType type, Object o) throws WineException;
	/**
	 * Méthode permettant la répartition d'une {@link List} de {@link ProductType}
	 * selon des critères de prix.
	 * @param wineTypes une {@link List} de {@link ProductType}.
	 * @return une {@link Map} ayant pour clé un {@link ProductType} et pour valeurs
	 * une {@link Map} ayant pour clé un range de prix sous forme d'un {@link Integer} 
	 * minimum et d'un {@link Integer} maximum.
	 * @throws WineException
	 * <ul>
	 * <li>Une erreur générique,</li>
	 * </ul>
	 */
	Map<ProductType,Map<Integer, Integer>> getPricesRepartitionByType(List<ProductType> wineTypes) throws WineException;
}
