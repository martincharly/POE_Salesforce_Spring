package fr.dawan.spring.main;

import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dawan.spring.beans.Catalogue;
import fr.dawan.spring.beans.Contact;
import fr.dawan.spring.beans.Formation;
import fr.dawan.spring.beans.Stagiaire;
import fr.dawan.spring.utils.RandomNumberGenerator;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		
		
		// TODO : 2 - On r�cup�re l'objet cr�� dans notre beans.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		
		// TODO : 3 - Cr�ation d'une nouvelle formation
		System.out.println("Appel du getBean");
		Formation formation = (Formation) context.getBean("springmvc"); // Le "(Formation)" est g�n�r� par un "Add to Cast"
		System.out.println(formation);
		
		
		
		
		// TODO : 4 - Autre m�thode pour cr�er une formation via le constructeur (on apelle le bean avec l'id "springmvc")
		Formation formation2 = context.getBean("springmvc", Formation.class);
		System.out.println(formation2);
		
		
		
		
		// TODO : 5 - On modifie une donn�e de notre objet.
		formation.setPrix(1599); // on modifie formation1 et affiche formation2 > on constate que formation 2 a �t� modifi�
		System.out.println(formation2);
		
		
		
		
		// TODO : 7 - Cr�ation d'une nouvelle formation via le contructeur (on appelle le bean avec l'id "jpa")
		Formation formation3 = context.getBean("jpa", Formation.class);
		System.out.println(formation3);
		
		
		
		
		// TODO : 8.2 - Cr�ation des 2 nouvelles formations pour la comparaison et l'int�r�t de l'ordre
		Formation formation4 = context.getBean("jseinit", Formation.class);
		System.out.println(formation4);

		Formation formation5 = context.getBean("jseappro", Formation.class);
		System.out.println(formation5);
		
		
		
		
		// TODO : 9.2 - Cr�ation d'une nouvelle formation avec un ordre diff�rent que le constructeur
		Formation formation6 = context.getBean("uml", Formation.class);
		System.out.println(formation6);
		
		
		
		
		// TODO : 10 - Cr�ation d'une nouvelle formation avec l'init m�thode
		Formation formation7 = context.getBean("git", Formation.class);
		System.out.println(formation7);
		
		Contact contact1 = context.getBean("contact1", Contact.class);
		System.out.println(contact1);
	
		
		
		
		// TODO : 11 - Cr�ation d'un stagiaire pour utiliser "l'h�ritage" des beans
		Stagiaire stagiaire1 = context.getBean("stagiaire1", Stagiaire.class);
		System.out.println(stagiaire1);
		
		Stagiaire stagiaire2 = context.getBean("stagiaire2", Stagiaire.class);
		System.out.println(stagiaire2);
		
		
		
		
		// TODO : 12.2 - Cr�ation d'un RandomNumberGenerator avec r�cup�ration du code Stagiaire de type DW-XXX-123456
		System.out.println("\n Cr�ation du RandomNumberGenerator : ");
		
		RandomNumberGenerator random = new RandomNumberGenerator();
		String code = random.computeNumber(stagiaire1);
		System.out.println(code);
		
		// TODO : 12.3 - R�cup�ration du stagiaire 3 et 4 et affichage des codeStagiaire avec le RandomGenerator de type DW-NOMCOMPLET-1000
		
			// R�cup�ration & affichage du stagiaire 3
			Stagiaire stagiaire3 = context.getBean("stagiaire3", Stagiaire.class);
			System.out.println(stagiaire3);
			
			
			// R�cup�ration & affichage du stagiaire 4
			Stagiaire stagiaire4 = context.getBean("stagiaire4", Stagiaire.class);
			System.out.println(stagiaire4);
		
		
		
		
		// TODO : 13.2 - R�cup�ration du catalogue de formations
		System.out.println("\n R�cup�ration du catalogue : ");
		
		Catalogue cat = context.getBean("catalogue1", Catalogue.class);
		for (Formation formationItem : cat.getListeFormation()) {
			System.out.println(formationItem);
		}
		
		
		
		
		// TODO : 14.1 - R�cup�ration du catalogue de formations n�2
		System.out.println("\n R�cup�ration du catalogue n�2 : ");
		
		Catalogue cat2 = context.getBean("catalogue2", Catalogue.class);
		for (Formation formationItem : cat2.getListeFormation()) {
			System.out.println(formationItem);
		}
		
		
		
		// TODO : 15.2 - R�cup�ration d'une liste d'adresses
		System.out.println("\n R�cup�ration de la liste d'adresses du contact2 : ");
		
		Contact contact2 = context.getBean("contact2", Contact.class);
		for (String adresse : contact2.getListeAdresse()) {
			System.out.println(adresse);
		}
		
		
		
		// TODO : 16.2 - R�cup�ration du catalogue de formations n�3
		System.out.println("\n R�cup�ration du catalogue n�3 : ");
		
		Catalogue cat3 = context.getBean("catalogue3", Catalogue.class);
		for (Entry<Integer, String> entree : cat3.getFormations().entrySet()) {
			System.out.println(entree.getValue());
		}
		
		
		
		// TODO : 17.1 - R�cup�ration de la liste d'adresses fusionn�es du contact 3 ("Astrid Morgan")
		System.out.println("\n R�cup�ration de la liste d'adresses du contact3 : ");
		
		Stagiaire stagiaireFormateur = context.getBean("stagiaireFormateur", Stagiaire.class);
		for (String adresse : stagiaireFormateur.getListeAdresse()) {
			System.out.println(adresse);
		}
		
		
		
		
		
		
	}
}
