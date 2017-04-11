package fr.afcepf.atod.wine.business.product.test;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.atod.business.product.impl.BuAdress;
import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.product.api.IDaoAdress;
import fr.afcepf.atod.wine.entity.Adress;
import fr.afcepf.atod.wine.entity.City;
import fr.afcepf.atod.wine.entity.Country;
import fr.afcepf.atod.wine.entity.Region;
/**
 * Test de la méthode du business de recherche de produit
 * par une chaine de caractères.
 * @author Metabeen
 *
 */
public class TestBuAdressAddAddress {
	/**
	 * Mock avec EasyMock pour le daoAdress.
	 */
	private static IDaoAdress mock;
	/**
	 * Pour l'execution des tests
	 */
	private static BuAdress business;
	/**
	 * CAS NOMINAL
	 * Le cas d'ajout d'une adresse conforme.
	 */
	private static Adress addressNominal;
	/**
	 * CAS NOMINAL
	 * L'adresse retournée par la méthode d'ajout.
	 */
	private static Adress addressNominalExpected;
	/**
	 * CAS ERREUR
	 * Le cas d'une erreur null.
	 */
	private static Adress addressNull;
	/**
	 * WineException retournée par la méthode.
	 */
	private static WineException exceptionNull;
	/**
	 * Initialisation des variables.
	 * @throws WineException 
	 */
	@BeforeClass
	public static void beforeTests() throws WineException {
		mock = EasyMock.createMock(IDaoAdress.class);
		business = new BuAdress();
		/**
		 * initialisation des variables
		 */
		addressNominal = new Adress(1,"TestStreet","TestNumber",true,new City(1,"Test","Test",new Region(1,"Test",new Country(1,"Test"))));
		addressNominalExpected = new Adress(1,"TestStreet","TestNumber",true,new City(1,"Test","Test",new Region(1,"Test",new Country(1,"Test"))));
		addressNull = null;
		exceptionNull = new WineException(
				WineErrorCode.IMPOSSIBLE_AJOUT_DANS_BASE,
				addressNull + " not referenced in the db");
		EasyMock.expect(mock.insertObj(addressNominal)).andReturn(addressNominalExpected);
		EasyMock.expect(mock.insertObj(addressNull)).andStubThrow(exceptionNull);
		EasyMock.replay(mock);
		//Mise en place du mock dans le business.
		business.setDaoAdress(mock);
	}

	@Test
	public void testAjoutNominal() throws WineException {
		addressNominalExpected = business.addNewAdress(addressNominal);
		Assert.assertNotNull(addressNominalExpected);
		Assert.assertNotNull(addressNominalExpected.getCity());
		Assert.assertEquals(addressNominalExpected.getNumber(), addressNominal.getNumber());
		Assert.assertEquals(addressNominalExpected.getStreet(), addressNominal.getStreet());
	}

	@Test (expected = WineException.class)
	public void testAjoutNull() throws WineException {
		business.addNewAdress(addressNull);
		Assert.assertNull(addressNull);
	}

	@AfterClass
	public static void afterAllTests() {
		EasyMock.verify(mock);
	}

}
