package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("localeService")
public class LocaleInfoServiceImpl implements ILocaleInfoService {

	@Override
	public Set<String> getAllCountries() {
		Locale locales[] = null;
		Set<String> countriesSet = null;
		//get all locales
		locales = Locale.getAvailableLocales();
		countriesSet = new TreeSet<>();
		//copy all contries to List collection
		for (Locale l : locales) {
			if (!l.getDisplayCountry().equals("")) {
				countriesSet.add(l.getDisplayCountry());
			}
		}
		return countriesSet;
	}

}
