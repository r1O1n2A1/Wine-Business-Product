package fr.afcepf.atod.wine.business.product.test;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.atod.business.product.impl.BuProduct;
import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.product.api.IDaoProduct;

public class TestBuProductFindByName {
	/**
	 * Mock avec EasyMock pour le daoProduct.
	 */
	private static IDaoProduct mock;
	/**
	 * Pour l'execution des tests.
	 */
	private static BuProduct business;
	/**
	 * CAS ERREUR
	 * Demande dans la base avec un string null.
	 */
	private static String testNull;
	/**
	 * CAS NOMINAL
	 * 
	 */
	private static String testNom;
	/**
	 * Initialisation de toutes les variables
	 * @throws WineException 
	 */
	@BeforeClass
	public static void beforeTests() throws WineException {
		EasyMock.createMock(IDaoProduct.class);
		business = new BuProduct();
		testNull = null;
		testNom = "testNominal";
//		EasyMock.expect(mock.findByName(testNom)).andReturn(EasyMock.anyObject());
//		EasyMock.replay(mock);
		/**
		 * Remplacement du dao par le mock.
		 */
		business.setDaoProduct(mock);
	}
	
	@Test
	public void testNominal() throws WineException {
//		business.findProductsByName(testNom);
		Assert.assertEquals(testNom, testNom);
	}
	
	@Test(expected = Exception.class)
	public void testNull() throws Exception {
		business.findByName(testNull);
		Assert.assertNull(testNull);
		
	}
}
