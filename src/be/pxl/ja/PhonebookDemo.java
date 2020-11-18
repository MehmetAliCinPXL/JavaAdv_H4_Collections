package be.pxl.ja;

import java.util.HashMap;
import java.util.Map;

public class PhonebookDemo {

	public static void main(String[] args) {
		Map<String,String> phoneBook = new HashMap<>();
		phoneBook.put("Ben", "1");
		phoneBook.put("Gerrit", "2");
		phoneBook.put("Rudy", "3");
		phoneBook.put("Heidi", "4");

		System.out.println(phoneBook.get("Ben"));
		System.out.println(phoneBook.containsKey("Els"));
		System.out.println(phoneBook.values());

		phoneBook.forEach((k,v) -> System.out.println("naam: "+k+" nummer:"+v));

		/*HashMap<String, HashMap> selects = new HashMap<String, HashMap>();

		for(Map.Entry<String, String> entry : phoneBook.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("naam: "+key+" nummer:"+value));
			// do what you have to do here
			// In your case, another loop.
		}*/




		//ANTWOORD
		// de order is random en heeft op geen enkele manier een volgorde
	}
}
