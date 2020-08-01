package com.mattiz.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {// way of notifying a change to multiple classes

	static class SachinCenturyNotifier {
		static List<SachinObserver> observers = new ArrayList<SachinObserver>();

		public static void registerObserver(SachinObserver zac) {
			observers.add(zac);
		}

		public static void notifySachinScoredACentury() {
			for (SachinObserver zac : observers) {
				zac.messageOut();
			}
		}
	}

	static class SachinObserver {
		private String name;

		public SachinObserver() {
		}

		public SachinObserver(String name) {
			super();
			this.name = name;
		}

		public void messageOut() {
			System.out.println(name + " says Sachin Scored A century!!");
		}

	}

	public static void main(String args[]) {
		SachinObserver sachinObserver = new SachinObserver("Q");
		SachinCenturyNotifier.registerObserver(sachinObserver);
		sachinObserver = new SachinObserver("P");
		SachinCenturyNotifier.registerObserver(sachinObserver);
		sachinObserver = new SachinObserver("A");
		SachinCenturyNotifier.registerObserver(sachinObserver);
		sachinObserver = new SachinObserver("B");
		SachinCenturyNotifier.registerObserver(sachinObserver);
		sachinObserver = new SachinObserver("C");
		SachinCenturyNotifier.registerObserver(sachinObserver);
		SachinCenturyNotifier.notifySachinScoredACentury();
	}
}
