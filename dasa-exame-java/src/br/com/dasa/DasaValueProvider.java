package br.com.dasa;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import ilog.rules.bom.IlrClass;
import ilog.rules.shared.bom.IlrBOMDomainValueProvider;

public class DasaValueProvider implements IlrBOMDomainValueProvider {

	// Temporary reference of the fully-qualified name of the BOM is set in <code>getValues</code>.
		private String className = null;

		/**
		 * @return A collection of String instances used to name the domain items.
		 */
		public Collection<String> getValues(IlrClass clazz) {
			this.className = clazz.getFullyQualifiedName();
			DomainHelper helper = DomainHelper.getDomainHelper(className);
			helper.initValues();
			return helper.getItemNames();
		}

		/**
		 * @return The verbalization for the static reference item <code>valueName</code>, in the given locale.
		 */
		public String getDisplayText(String valueName, Locale locale) {
			DomainHelper helper = DomainHelper.getDomainHelper(className);
			String verbalization = helper.getVerbalization(valueName);
			return verbalization;
		}

		/**
		 * @return Null in this implementation (translation property is deprecated as of JRules 6.0).
		 */
		public String getTranslation(String valueName) {
			return null;
		}

		/**
		 * @return Null since no specific properties are found in the database domain.
		 */
		public Map<?, ?> getProperties(String valueName) {
			return null;
		}

		/**
		 * @return Null since no specific documentation is found in the database domain.
		 */
		public String getDocumentation(String valueName, Locale locale) {
			return null;
		}

		public void dispose() {
		}

		/**
		 * @return The BOM2XOM mapping for the given named item.
		 */
		public String getBOM2XOMMapping(String valueName) {
			DomainHelper helper = DomainHelper.getDomainHelper(className);
			String translation = helper.getTranslation(valueName);
			return translation;
		}

}
