package com.objis.demoArchiJdbc.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.demoArchiJdbc.domaine.Employe;
import com.objis.demoArchiJdbc.service.ServiceEmploye;

public class LanceurDemoJdbc {

	public static void main(String[] args) {

//		Employe employe = new Employe(1, "Tra", "Jo");
//		ServiceEmploye service = new ServiceEmploye();

//		service.createEmploye(employe);

		// 1. Chargement du conteneur en 4.0.0
		ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("beans.xml");

		// 2. Recupération d'un Bean
//		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societeDevLogiciel");
		ServiceEmploye serviceEmploye = (ServiceEmploye) appContext.getBean("serviceEmploye");
		Employe employe = (Employe) appContext.getBean("employe");

		// 3. Manipulation du bean
		
		serviceEmploye.createEmploye(employe);
		
//		logger.info("Chef Developpeur : " + societe.getChefDeveloppeur().getNom());
//		logger.info("Developpeur : " + societe.getDeveloppeur().getNom());

		// serviceEmploye.createEmploye(employe2);
		// Employe newEmploye = serviceEmploye.createEmploye(employe);
		// System.out.println(newEmploye);
		// serviceEmploye.readAllEmploye();
		// serviceEmploye.readEmployeById(2);
		// serviceEmploye.updateEmploye(employe1, employe2);
		// serviceEmploye.readAllEmploye();
	}

}
