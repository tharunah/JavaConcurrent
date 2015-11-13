package com.mypractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Sort an array of strings by the length of the string in Java
 * 
 * @author THanumanthaiah
 * 
 */

public class StringSortByLength {

	private Map<String, Integer> findLength(String[] stringList) {
		Map<String, Integer> stringMap = new HashMap<String, Integer>();

		for (String string : stringList) {
			stringMap.put(string, string.length());
		}
		return stringMap;
	}

	public List<Map.Entry<String, Integer>> sortStringLength(String[] stringList) {
		findLength(stringList);
		Map<String, Integer> map = findLength(stringList);
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				set);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {

				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		return list;
	}

	public void pringListMapEntryValue(List<Map.Entry<String, Integer>> stringEntry) {

		for (Map.Entry<String, Integer> entry : stringEntry) {
			System.out.println(entry.getKey());
		}

	}

	public static void main(String... arg) {

		String[] list = { "test", "Tharuna", "ravi", "hcl", "india", "america","AmeRica" };

		StringSortByLength s = new StringSortByLength();

		s.pringListMapEntryValue(s.sortStringLength(list));

	}

}
