package com.mypractice;

import java.util.LinkedList;

public class MiddleEleLinkedList {

	public LinkedList<String> list = new LinkedList<String>();

	public void addListValues(String... strings) {
		for (String value : strings)
			list.add(value);
	}

	public void addListValue(String s) {
		list.add(s);
	}

	public String removeString() {
		return list.remove();
	}

	public String findMiddleValueOnList() {
		if (list.size() != 0)
			return list.get(list.size() / 2);
		else
			throw new ArrayIndexOutOfBoundsException();
	}

}
