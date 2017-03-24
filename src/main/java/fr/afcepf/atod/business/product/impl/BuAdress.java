package fr.afcepf.atod.business.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.atod.business.product.api.IBuAdress;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.product.api.IDaoAdress;
import fr.afcepf.atod.wine.entity.Adress;
import java.io.Serializable;

@Service
public class BuAdress implements IBuAdress {
	
	@Autowired
	private IDaoAdress daoAdress;

	@Override
	public Adress addNewAdress(Adress adr) {
		Adress adress =null;
		try {
			adress = daoAdress.insertObj(adr);
		} catch (WineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adress;
	}

}
