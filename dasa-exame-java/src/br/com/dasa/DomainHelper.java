package br.com.dasa;

/*
* Licensed Materials - Property of IBM
* 5725-B69 5655-Y17 5724-Y00 5724-Y17 5655-V84
* Copyright IBM Corp. 1987, 2017. All Rights Reserved.
*
* Note to U.S. Government Users Restricted Rights: 
* Use, duplication or disclosure restricted by GSA ADP Schedule 
* Contract with IBM Corp.
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * A static function provides a helper for a dedicated fully-qualified class, which is
 * responsible for providing the values.
 */
public class DomainHelper {

	// Hashmap storing configurations for a specific class
	// Key = fully-qualified name of the domain class
	private static HashMap<String,DomainHelper> classdomains = new HashMap<String,DomainHelper> ();

	/**
	 *  Representation of a static reference: name, verbalization, and translation (b2x).
	 *  Instances of this class are stored in each database domain helper.
	 */
	public static class Item {
		private String name;
		private String verbalization;
		private String code;

		public Item(String name, String verbalization, String code) {
			this.name = name;
			this.verbalization = verbalization;
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public String getVerbalization() {
			// Default text is same as the name
			if (verbalization == null) return name;
			return verbalization;
		}

		public String getTranslation() {
			// Default translation is item between double quotes
			if (code == null) return "\"" + name + "\"";
			return code;
		}

	}

	// An instance of the helper is attached to each domain class
	private String className;
	// Store the domain items in a list
	private List<Item> domainItems = new ArrayList<Item>();

	/**
	 * Private constructor, use the factory to get such an instance.
	 * @param fullyQualifiedName The name of the class.
	 */
	private DomainHelper(String fullyQualifiedName){
		this.className = fullyQualifiedName;
	}

	/**
	 * Initialize values for the class name given the attributes.
	 */
	public void initValues() {
		domainItems.clear();
		if (this.className.equals("br.com.dasa.PerguntaTipo")) {
			domainItems.add(new Item("Pergunta 1","Pergunta 1","return \"Pergunta 1\";"));
			domainItems.add(new Item("Pergunta 2","Pergunta 2","return \"Pergunta 2\";"));
			domainItems.add(new Item("Pergunta 3","Pergunta 3","return \"Pergunta 3\";"));
			domainItems.add(new Item("Pergunta 4","Pergunta 4","return \"Pergunta 4\";"));
		} else if (this.className.equals("br.com.dasa.ExameTipo")) {
			domainItems.add(new Item("URINA TIPO I","URINA TIPO I","return \"URINA TIPO I\";"));
			domainItems.add(new Item("GLICOSE","GLICOSE","return \"GLICOSE\";"));
			domainItems.add(new Item("TRIGLICERIDEOS","TRIGLICERIDEOS","return \"TRIGLICERIDEOS\";"));
			domainItems.add(new Item("CREATININA","CREATININA","return \"CREATININA\";"));
			domainItems.add(new Item("RESSON�NCIA","RESSON�NCIA","return \"RESSON�NCIA\";"));
		} else if (this.className.equals("br.com.dasa.UnidadeTipo")) {
			domainItems.add(new Item("Mega Unidade Tatuape","Mega Unidade Tatuape","return \"Mega Unidade Tatuape\";"));
			domainItems.add(new Item("Unidade Augusta","Unidade Augusta","return \"Unidade Augusta\";"));
			domainItems.add(new Item("NPE","NPE","return \"NPE\";"));
		} else if (this.className.equals("br.com.dasa.GrupoTipo")) {
			domainItems.add(new Item("Deficiente Visual","Definiciente Visual","return \"Definiciente Visual\";"));
			domainItems.add(new Item("Deficiente F�sico","Deficiente F�sico","return \"Deficiente F�sico\";"));
			domainItems.add(new Item("Deficiente Auditivo","Deficiente Auditivo","return \"Deficiente Auditivo\";"));
			domainItems.add(new Item("Deficiente Mental","Deficiente Mental","return \"Deficiente Mental\";"));
		}
	}

	/**
	 * @return The list of names for the items of the current helper.
	 */
	public Collection<String> getItemNames() {
		ArrayList<String> names = new ArrayList<String>();
		Iterator<Item> it = domainItems.iterator();
		while (it.hasNext()) {
			Item element = (Item) it.next();
			names.add(element.getName());
		}
		return names;
	}

	/**
	 * Gets the verbalization for a given domain item name.
	 * @param valueName The name of the static reference attribute.
	 * @return The verbalization string.
	 */
	public String getVerbalization(String valueName) {
		Iterator<Item> it = domainItems.iterator();
		while (it.hasNext()) {
			Item element = (Item) it.next();
			if (valueName.equalsIgnoreCase(element.getName()))
				return element.getVerbalization();
		}
		// Should never happen
		return null;
	}

	/**
	 * @param valueName The name of the value.
	 */
	public String getTranslation(String valueName) {
		Iterator<Item> it = domainItems.iterator();
		while (it.hasNext()) {
			Item element =   it.next();
			if (valueName.equalsIgnoreCase(element.getName()))
				return element.getTranslation();
		}
		// Should never happen
		return null;
	}

	/**
	 * The main entry point for the <code>DomainHelper</code> class.
	 * Looks for an existing domain helper of a given class, and creates it
	 * if it does not exist.
	 *
	 * @param className The fully-qualified name of the static reference domain.
	 * @return A helper class dedicated to the domain in the argument.
	 */
	public static DomainHelper getDomainHelper(String className){
		DomainHelper helper = classdomains.get(className);
		if (helper == null) {
			helper = new DomainHelper(className);
			classdomains.put(className, helper);
		}
		return helper;
	}

}

