/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.business.product.designpattern.visitor;

import fr.afcepf.atod.wine.entity.Product;
import fr.afcepf.atod.wine.entity.ProductType;

/**
 * Class pour la diff�rentiation des types de produits.
 * @author ronan - Metabeen
 */
public class ProductBase {
	/**
	 * Objet pour le type d'un {@link Product}.
	 */
	private ProductType type;
	private Integer     firstRow;
	private Integer     rowsPerPage;

	public ProductBase(ProductType type, 
			Integer firstRow, Integer rowsPerPage) {
		this.type        = type;
		this.firstRow    = firstRow;
		this.rowsPerPage = rowsPerPage;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public Integer getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(Integer firstRow) {
		this.firstRow = firstRow;
	}

	public Integer getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}    
}
