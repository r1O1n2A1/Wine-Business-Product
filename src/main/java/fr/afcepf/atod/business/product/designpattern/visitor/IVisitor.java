/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.business.product.designpattern.visitor;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.Customer;

/**
 * Design Pattern Visitor
 * permet d'externaliser et de centraliser
 * des actions Ã  effectuer sur des objets 
 * qui n'ont pas forcÃ©ment de liens entre eux.
 * @author ronan - Metabeen
 */
public interface IVisitor {
    /**
     * Méthode pour l'accessibilité aux {@link Customer}.
     * * TODO implement or delete
     * @param visitable interface pour la visite {@link IVisitable}.
     * <ul>
     * <li></li>
     * </ul>
     */
    void visit(IVisitable visitable);
    /**
     * Méthode pour l'accessibilité aux {@link Customer}
     * en fonction du critère {@link ProductTypeMoney}.
     * TODO implement or delete
     * @param typeAndMoney un objet {@link ProductTypeMoney}.
     * @throws WineException 
     * <ul>
     * <li></li>
     * </ul>
     */
    void visit(ProductTypeMoney typeAndMoney) throws WineException;
    /**
     * Méthode pour l'accessibilité aux {@link Customer} en fonction
     * du critère {@link ProductTypeVintage}.
     * @param typeAndVintage un objet {@link ProductTypeVintage}.
     * @throws WineException 
     * <ul>
     * <li></li>
     * </ul>
     */
    void visit(ProductTypeVintage typeAndVintage) throws WineException;
}
