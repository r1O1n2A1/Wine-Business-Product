package fr.afcepf.atod.business.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.atod.business.product.api.IBuProduct;
import fr.afcepf.atod.business.product.api.IGetWinesParameters;
import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.product.api.IDaoProduct;
import fr.afcepf.atod.wine.data.product.api.IDaoProductType;
import fr.afcepf.atod.wine.entity.Product;
import fr.afcepf.atod.wine.entity.ProductType;
import fr.afcepf.atod.wine.entity.ProductVarietal;
import fr.afcepf.atod.wine.entity.ProductVintage;
import fr.afcepf.atod.wine.entity.ProductWine;

/**
 *
 * @author ronan
 */
@Service
public class BuProduct implements IBuProduct, IGetWinesParameters {
	/**
	 * Logger de log 4j pour les codes d'erreur.
	 */
	private Logger log = Logger.getLogger(BuAdress.class);
	/**
	 * Gestion de l'injection via Spring par
	 * l'annotation autowired. 
	 */
    @Autowired
    protected IDaoProduct daoProduct;
    /**
	 * Gestion de l'injection via Spring par
	 * l'annotation autowired. 
	 */
    @Autowired
    private IDaoProductType daoProductType;
    /**
     * TODO Ask what it is?
     */
    private static final int MAX_SE = 50;
    /**
     * {@link List} d'objets {@link ProductWine}.
     */
    private List<ProductWine> wines = null;

    @Override
    public List<Product> findByName(String name) throws WineException {
        List<Product> products = null;
        WineException wineException;
        try {
            if (!name.equalsIgnoreCase("")) {
                products = daoProduct.findByName(name);
                if (products.get(0) != null) {
                    return products;
                } else {
                    throw new WineException(
                            WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                            name + " not referenced in the db");
                }
            } else {
                throw new WineException(
                        WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                        name + " not referenced in the db");
            }
        } catch (Exception e) {
            wineException = new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    name + " not referenced in the db");
            log.debug(e);
        }
        if (wineException != null) {
            throw wineException;
        }
        return products;
    }

    @Override
    public List<Product> findExpensive(double min) 
    		throws WineException {
        List<Product> expensiveProds;
        if (min >= 0) {
            expensiveProds = daoProduct.findExpensiveProducts(min);
            if (expensiveProds.isEmpty()) {
                throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                        "expensive products not found in the database");
            }
        } else {
            throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "criteria has to be defined...");
        }
        return expensiveProds;
    }

    @Override
    public List<Product> getPromotedProductsSelection() 
    		throws WineException {
        List<Product> list = null;
        try {
            list = daoProduct.getPromotedProductsSortedByEndDate(MAX_SE/5);
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");  
        }
        return list;
    }

    @Override
    public List<ProductType> getWineTypes() throws WineException {
        List<ProductType> list = null;
        try {
            list = daoProductType.findAllObj();
        } catch (Exception e) {
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "the persistence unit doesn't have ProductType");
        }
        return list;
    }

    @Override
    public List<Product> findProductsByName(String name) 
    		throws WineException {
        List<Product> list = null;
        try {
            list = daoProduct.findByNotCompleteName(name);
        } catch (Exception e) {
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");
        }
        return list;
    }

    @Override
    public List<Product> findProductsByAppelation(String appelation) 
    		throws WineException {
        List<Product> list = null;
        try {
            list = daoProduct.findByAppelation(appelation);
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");
        }
        return list;
    }

    @Override
    public List<ProductVintage> findProductsByVintage(Integer vintage) 
    		throws WineException {
        List<ProductVintage> list = null;
        try {
            list = daoProduct.findByVintage(vintage);
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");
        }
        return list;
    }

    @Override
    public List<ProductVarietal> findProductsBy(String variatal) 
    		throws WineException {
        List<ProductVarietal> list = null;
        try {
            list = daoProduct.findByVarietal(variatal);
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");
        }
        return list;
    }

    @Override
    public List<ProductType> findProductsType(String wineType) 
    		throws WineException {
        List<ProductType> list = null;
        try {
            list = daoProduct.findByType(wineType);
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "cannot find any associated ProductType to this wineType");
        }
        return list;
    }

    @Override
    public Map<ProductType, List<String>> getAppellationsByType(List<ProductType> wineTypes) 
    		throws WineException {
        Map<ProductType, List<String>> map = new HashMap<>();
        try {
            for (ProductType productType : wineTypes) {
                map.put(productType, daoProduct.getAppellationsByWineType(productType));
            }
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");
        }
        return map;
    }

    @Override
    public Map<ProductType, List<ProductVarietal>> getVarietalsByType(List<ProductType> wineTypes)
            throws WineException {
        Map<ProductType, List<ProductVarietal>> map = new HashMap<>();
        try {
            for (ProductType productType : wineTypes) {
                map.put(productType, daoProduct.getVarietalsByWineType(productType));
            }
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "no promoted item referenced in db");
        }
        return map;
    }

    @Override
    public Product findById(Integer id) throws WineException {
        Product prod = null;
        try {
            prod = daoProduct.findObj(id);
        } catch (Exception e) {
        	log.debug(e);
            throw new WineException(
                    WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "not referenced in db");
        }
        return prod;
    }

    @Override
    public List<ProductWine> categoryAccordingToObjectType(ProductType type, Object o,
    		Integer firstRow,Integer rowsPerPage) throws WineException {
    	wines = new ArrayList<>();
        if (!type.getType().equalsIgnoreCase("")) {
            wines = getWinesParameters(type, o,firstRow,rowsPerPage);
            if (wines != null && wines.isEmpty()) {
                throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                        "Pas de produits trouves selon les parametres: "
                        + type.getType());
            }
        } else {
            throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "Pas de produits trouves selon les parametres: "
                    + type.getType());
        }
        return wines;
    }

    @Override
    public List<ProductWine> getWinesParameters(ProductType type, Object o,
    		Integer firstRow,Integer rowsPerPage) throws WineException {
    	wines = new ArrayList<>();
        if (o instanceof ProductVarietal) {
            ProductVarietal varietal = (ProductVarietal) o;
            wines = getWinesParameters(type, varietal,firstRow,rowsPerPage);
        } else if (o instanceof ProductVintage) {
            ProductVintage vintage = (ProductVintage) o;
            wines = getWinesParameters(type, vintage,firstRow,rowsPerPage);
        } else if(o instanceof String){    
                wines = getWinesParameters(type, (String)o,firstRow,rowsPerPage);
        } else if(o instanceof Integer){    
                Integer i = Integer.valueOf(o.toString());
                wines = getWinesParameters(type, i,firstRow,rowsPerPage);
        } else if (o==null){
        	 wines = getWinesParameters(type,firstRow,rowsPerPage);
        } else {
            throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                    "Pas de bouteille de type : " + type.getType());
        }
        return wines;
    }
    
    public List<ProductWine> getWinesParameters(ProductType type, Integer firstRow,Integer rowsPerPage)
            throws WineException {
        wines = new ArrayList<>();
        wines = daoProduct.findByType(type,firstRow,rowsPerPage);
        return wines;
    }

    public List<ProductWine> getWinesParameters(ProductType type, ProductVarietal varietal, Integer firstRow,Integer rowsPerPage)
            throws WineException {
        wines = new ArrayList<>();
        wines = daoProduct.findByVarietalAndType(type, varietal,firstRow,rowsPerPage);
        return wines;
    }
    
    public List<ProductWine> getWinesParameters(ProductType type, String appellation ,Integer firstRow,Integer rowsPerPage)
            throws WineException {
        wines = new ArrayList<>();
        wines = daoProduct.findByAppelationAndType(type, appellation,firstRow,rowsPerPage);
        return wines;
    }
    

    public List<ProductWine> getWinesParameters(ProductType type, ProductVintage vintage ,Integer firstRow,Integer rowsPerPage)
            throws WineException {
        wines = new ArrayList<>();
        wines = daoProduct.findByVintageAndType(type, vintage,firstRow,rowsPerPage);
        return wines;
    }

    public List<ProductWine> getWinesParameters(ProductType type, Integer integ, 
            Integer firstRow, Integer rowsPerPage)
            throws WineException {
        wines = new ArrayList<>();
        switch (integ) {
            case 0:
                wines = daoProduct.findByMoneyAndType(type, integ, integ + MAX_SE,firstRow,rowsPerPage);
                break;
            case MAX_SE:
                wines = daoProduct.findByMoneyAndType(type, integ,
                        integ + MAX_SE,firstRow,rowsPerPage);
                break;
            case 2*MAX_SE:
                wines = daoProduct.findByMoneyAndType(type, integ,firstRow,rowsPerPage);
                break;
            default:
                break;
                
        }
        return wines;
    }

	@Override
	public Integer countCategoryAccordingToObjectType(ProductType type, Object o) 
                    throws WineException {
		Integer count = 0;
		if (o instanceof ProductVarietal) {
			ProductVarietal varietal = (ProductVarietal) o;
			count = daoProduct.countByVarietalAndType(type, varietal);
		} else if (o instanceof ProductVintage) {
			ProductVintage vintage = (ProductVintage) o;
			count = daoProduct.countByVintageAndType(type, vintage);
		} else if (o instanceof String) {
			count = daoProduct.countByAppellationAndType(type, (String) o);
		} else if (o instanceof Integer) {
			Integer i = Integer.valueOf(o.toString());
			if (i == 2 * MAX_SE)
				count = daoProduct.countByMoneyAndType(type, i);
			else
				count = daoProduct.countByMoneyAndType(type, i, i + MAX_SE);
		} else if (o == null) {
			count = daoProduct.countByType(type);
		} else {
			throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
					"Pas de bouteille de type : " + type.getType());
		}
		return count;
	}

	@Override
	public Map<ProductType, Map<Integer, Integer>> getPricesRepartitionByType(List<ProductType> wineTypes)
			throws WineException {
		Map<ProductType, Map<Integer, Integer>> map = new HashMap<>();
        try {
            for (ProductType productType : wineTypes) {
            	Map<Integer, Integer> pricemap = new HashMap<Integer, Integer>();
            	pricemap.put(0, daoProduct.countByMoneyAndType(productType, 0,50));
            	pricemap.put(50, daoProduct.countByMoneyAndType(productType, 50,100));
            	pricemap.put(100, daoProduct.countByMoneyAndType(productType, 100));
                map.put(productType, pricemap);
            }
        } catch (Exception e) {
            log.debug(e);
        }
        return map;
	}
      
}
