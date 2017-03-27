/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.business.product.api;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.ProductType;
import fr.afcepf.atod.wine.entity.ProductVarietal;
import fr.afcepf.atod.wine.entity.ProductVintage;
import fr.afcepf.atod.wine.entity.ProductWine;
import java.util.List;

/**
 * Interface pour la récupération
 * des paramètres associé à un {@link ProductType}.
 * @author ronan - Metabeen
 */
public interface IGetWinesParameters {
    /**
     * Méthode permettant la récupération d'une {@link List}
     * de {@link ProductWine}.
     * @param type un {@link ProductType}.
     * @param o {@link Object} générique pour la discrimination.
     * @return une {@link List} de {@link ProductWine}.
     * @throws WineException 
     * <ul>
     * <li>Absence d'articles dans l'unité de persistence.</li>
     * </ul>
     */
     List<ProductWine> getWinesParameters(ProductType type, Object o,Integer firstRow,Integer rowsPerPage)
            throws WineException;
    /**
     * Méthode permettant la récupération d'une {@link List}
     * de {@link ProductWine}.
     * @param type un {@link ProductType}.
     * @param varietal un {@link ProductVarietal}.
     * @param firstRow début de l'indexation sous forme d'{@link Integer}.
     * @param rowsPerPage nombre d'articles par Page sous forme d'{@link Integer}.
     * @return une {@link List} de {@link ProductWine}.
     * @throws WineException
     * <ul>
     * <li>Absence d'articles dans l'unité de persistence.</li>
     * </ul> 
     */
    List<ProductWine> getWinesParameters(ProductType type, ProductVarietal varietal,Integer firstRow,Integer rowsPerPage)
            throws WineException;
    /**
     * Méthode permettant la récupération d'une {@link List}
     * de {@link ProductWine}.
     * @param type un {@link ProductType}.
     * @param vintage un {@link ProductVintage}.
     * @param firstRow début de l'indexation sous forme d'{@link Integer}.
     * @param rowsPerPage nombre d'articles par Page sous forme d'{@link Integer}.
     * @return une {@link List} de {@link ProductWine}.
     * @throws WineException
     * <ul>
     * <li>Absence d'articles dans l'unité de persistence.</li>
     * </ul> 
     */
    List<ProductWine> getWinesParameters(ProductType type, ProductVintage vintage,Integer firstRow,Integer rowsPerPage)
            throws WineException;
    /**
     * Méthode permettant la récupération d'une {@link List}
     * de {@link ProductWine}.
     * @param type un {@link ProductType}.
     * @param integ {@link Integer}.
     * @return une {@link List} de {@link ProductWine}.
     * @throws WineException 
     * <ul>
     * <li>Absence d'articles dans l'unité de persistence.</li>
     * </ul> 
     */
    List<ProductWine> getWinesParameters(ProductType type, Integer integ,Integer firstRow,Integer rowsPerPage) 
            throws WineException;
            
}
