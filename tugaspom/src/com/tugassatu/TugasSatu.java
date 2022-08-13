package com.tugassatu;

import java.util.TreeMap;
import java.util.TreeSet;

public class TugasSatu {

	public static void main(String[] args) {
		//Tugas 1: Buat TreeSet & TreeMap
		
		//TreeSet
		TreeSet<String> listBatch10 = new TreeSet<>();
		listBatch10.add("Arif");
		listBatch10.add("Silvi");
		listBatch10.add("Devi");
		
		for (String item : listBatch10) {
			System.out.println(item);
		}
		
		//TreeMap
		TreeMap<Integer, String> listNumberBatch10 = new TreeMap<>();
		listNumberBatch10.put(11, "John");
		listNumberBatch10.put(3, "Sri");
		listNumberBatch10.put(5, "Andin");
		
		for (Integer key : listNumberBatch10.keySet()) {
			System.out.println(key + " " + listNumberBatch10.get(key));
		}

	}

}

