package com.mattiz.factorypattern;

public class FactoryPattern {//create a family of related object types, eg for diff DAO types at runtime

	public static class PersonFactory {

		public static Person getPerson(String name, String gender) {
			Person pp = null;
			if (gender.equals("M")) {
				pp = new Male(name);
			} else if (gender.equals("F")) {
				pp = new Female(name);
			}
			return pp;
		}
	}// end PersonFactory

	static abstract class Person {
		private String name;

		Person() {
		}

		Person(String name) {
			this.name = name;
		}

		abstract String getSalutation();

		String getNameAndSaluation() {
			return getSalutation() + " " + name;
		}
	}// end Person

	static class Male extends Person {

		public Male(String name) {
			super.name = name;
			this.name = name;
		}

		private String name;

		String getSalutation() {
			return "Mr";
		}

	}// Male

	static class Female extends Person {

		public Female(String name) {
			super.name = name;
			this.name = name;
		}

		private String name;

		String getSalutation() {
			return "Mrs";
		}

	}// Female

	public static void main(String[] args) {
		Person p1 = PersonFactory.getPerson("Martha", "F");
		System.out.println(p1.getNameAndSaluation());
		Person p2 = PersonFactory.getPerson("Suresh", "M");
		System.out.println(p2.getNameAndSaluation());

	}
}
