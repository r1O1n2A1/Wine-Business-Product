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

import java.util.List;

/**
 * Interface pour les r�gles de gestion associ�es
 *  aux {@link Product} dans l'application.
 * @author ronan - Metabeen
 */
public interface IBuProduct {
	/**
	 * M�thode pour la r�cup�ration d'un {@link Product}
	 * dans l'unit� de persistence en utilisant comme
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
	Product findByName(String name) throws WineException;
	/**
	 * M�thode pour la r�cup�ration d'un {@link Product}
	 * dans l'unit� de persistence en utilisant comme argument
	 * un Integer identifiant.
	 * @param id Identifiant correspondant au produit
	 * dans l'unit� de persistence.
	 * @return un objet {@link Product} poss�dant l'indentifiant
	 * correspondant � l'argument de la m�thode.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit ne correspond � cet identifiant,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	Product findById(Integer id) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link List}
	 * d'objets {@link Product} en promotion ayant une date
	 * d'expiration proche.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit n'approche suffisamment de la date
	 * d'expiration,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	List<Product> getPromotedProductsSelection() throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link List}
	 * d'objets {@link Product} selon le crit�re d'un montant minimum.
	 * @param min Le montant minimum correspondant au prix d'un produit
	 * R�gle : prix du produit > min.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException    
	 * <ul>
	 * <li>Aucun produit n'approche suffisamment de la date
	 * d'expiration,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul>
	 */
	List<Product> findExpensive(double min) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link List} de
	 * {@link ProductType}.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit n'approche suffisamment de la date
	 * d'expiration,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul>
	 */
	List<ProductType> getWineTypes() throws WineException;
	/**
	 * M�thode pour la r�cup�ration d'une {@link List} 
	 * {@link Product} dans l'unit� de persistence en utilisant 
	 * comme argument un String nom.
	 * @param name Le String nom des {@link Product}.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � ce nom,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul>
	 */
	List<Product> findProductsByName(String name) throws WineException;
	/**
	 * M�thode pour la r�cup�ration d'une {@link List} 
	 * {@link Product} dans l'unit� de persistence en utilisant 
	 * comme argument un String nom.
	 * @param appelation Le String appelation des {@link Product}.
	 * @return une {@link List} d'objets {@link Product}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � cette appelation,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul>
	 */
	List<Product> findProductsByAppelation(String appelation) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link List} de {@link ProductVintage}
	 * selon de millesime.
	 * @param vintage Millesime d'un {@link ProductVintage}.
	 * @return une {@link List} d'objets {@link ProductVintage}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � ce millesime,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	List<ProductVintage> findProductsByVintage(Integer vintage) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link List} de {@link ProductVarietal}
	 * selon le ceppage.
	 * @param varietal Ceppage d'un {@link ProductVarietal}.
	 * @return une {@link List} d'objets {@link ProductVarietal}.
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � ce ceppage,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	List<ProductVarietal> findProductsBy(String varietal) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link List} de {@link ProductType}
	 * ass�oci� au type d'un vin.
	 * @param wineType Type de vin sous forme de String.
	 * @return une {@link List} d'objets {@link ProductType}.
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � ce type de vin,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	List<ProductType> findProductsType(String wineType) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link Map} ayant pour cl�
	 * le {@link ProductType} et comme valeurs une {@link List} de String 
	 * correspondant � l'appelation.
	 * @param wineTypes une {@link List} de {@link ProductType}.
	 * @return une {@link Map} ayant pour cl� {@link ProductType} 
	 * et comme valeurs une {@link List} de String appelation.
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � ce type de vin,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	Map<ProductType, List<String>> getAppellationsByType(List<ProductType> wineTypes) throws WineException;
	/**
	 * M�thode permettant la r�cup�ration d'une {@link Map} ayant pour cl�
	 * le {@link ProductType} et comme valeurs une {@link List} de {@link ProductVarietal}.
	 * @param wineTypes une {@link List} de {@link ProductType}.
	 * @return une {@link Map} ayant pour cl� {@link ProductVarietal} 
	 * @throws WineException 
	 * <ul>
	 * <li>Aucun produit(s) ne correspond � ces types de vin,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	Map<ProductType, List<ProductVarietal>> getVarietalsByType(List<ProductType> wineTypes) throws WineException;
	/**
	 * M�thode de filtre permettant la r�cup�ration de {@link ProductWine}
	 * selon la cat�gorie.
	 * @param type {@link ProductType} de la {@link List} de {@link ProductWine} � afficher.
	 * @param o Type g�n�ric {@link Object} pour la d�termination du type.
	 * @return Une {@link List} de {@link ProductWine}.
	 * @throws WineException 
	 * <ul>
	 * <li>Les param�tres saisis ne permettent pas d'afficher une liste de produits,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul> 
	 */
	List<ProductWine> categoryAccordingToObjectType(ProductType type, Object o,Integer firstRow,Integer rowsPerPage) throws WineException;
	/**
	 * M�thode permettant l'�bauche de la gestion des stocks.
	 * @param type {@link ProductType} pour le d�compte.
	 * @param o {@link Object} pour la discrimination.
	 * @return un {@link Integer} du d�compte de bouteilles correspondant � ce {@link ProductType}.
	 * @throws WineException
	 * <ul>
	 * <li>Aucune bouteilles disponible en stock,</li>
	 * <li>impossible d'acc�der � l'unit� de persistence.</li>
	 * </ul>
	 */
	Integer countCategoryAccordingToObjectType(ProductType type, Object o) throws WineException;
	/**
	 * M�thode permettant la r�partition d'une {@link List} de {@link ProductType}
	 * selon des crit�res de prix.
	 * @param wineTypes une {@link List} de {@link ProductType}.
	 * @return une {@link Map} ayant pour cl� un {@link ProductType} et pour valeurs
	 * une {@link Map} ayant pour cl� un range de prix sous forme d'un {@link Integer} 
	 * minimum et d'un {@link Integer} maximum.
	 * @throws WineException
	 * <ul>
	 * <li>Une erreur g�n�rique,</li>
	 * </ul>
	 */
	Map<ProductType,Map<Integer, Integer>> getPricesRepartitionByType(List<ProductType> wineTypes) throws WineException;
}
