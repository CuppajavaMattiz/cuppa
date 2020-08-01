package com.mattiz.singleton;

public enum SampleSingleton {//work on this??

	INSTANCE;// this is the singleton instance??

	private SampleSingleton() {

	}

	public Something getSomething() {
		return new Something();
	}

	public static void main(String[] args) {// usage??
		SampleSingleton.INSTANCE.getSomething();
	}
}
