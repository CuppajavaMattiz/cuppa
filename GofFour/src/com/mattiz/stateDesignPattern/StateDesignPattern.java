package com.mattiz.stateDesignPattern;

public class StateDesignPattern {//The previous state defines the next state of the object

	static class FanControl {

		private SpeedLevel current;

		public FanControl() {
			current = new Off();
		}

		public FanControl(SpeedLevel current) {
			super();
			this.current = current;
		}

		public void setState(SpeedLevel speedLevel) {
			this.current = speedLevel;
		}

		public void rotate() {
			current.rotate(this);
		}

		@Override
		public String toString() {
			return "FanControl [current=" + current.toString() + "]";
		}

	}

	public interface SpeedLevel {
		public void rotate(FanControl fanControl);

		@Override
		public String toString();
	}

	static class Off implements SpeedLevel {

		@Override
		public void rotate(FanControl fanControl) {
			SpeedLevelOne speedLevelOne = new SpeedLevelOne();
			fanControl.setState(speedLevelOne);

		}

		@Override
		public String toString() {
			return "0";
		}

	}

	static class SpeedLevelOne implements SpeedLevel {
		@Override
		public void rotate(FanControl fanControl) {
			SpeedLevelTwo speedLevelTwo = new SpeedLevelTwo();
			fanControl.setState(speedLevelTwo);

		}

		@Override
		public String toString() {
			return "1";
		}

	}

	static class SpeedLevelTwo implements SpeedLevel {
		@Override
		public void rotate(FanControl fanControl) {
			SpeedLevelThree speedLevelThree = new SpeedLevelThree();
			fanControl.setState(speedLevelThree);
		}

		@Override
		public String toString() {
			return "2";
		}
	}

	static class SpeedLevelThree implements SpeedLevel {
		@Override
		public void rotate(FanControl fanControl) {
			Off off = new Off();
			fanControl.setState(off);
		}

		@Override
		public String toString() {
			return "3";
		}
	}

	public static void main(String[] args) {
		FanControl fanControl = new FanControl();
		System.out.println(fanControl.toString());
		fanControl.rotate();
		System.out.println(fanControl.toString());
		fanControl.rotate();
		System.out.println(fanControl.toString());
		fanControl.rotate();
		System.out.println(fanControl.toString());
		fanControl.rotate();
		System.out.println(fanControl.toString());
		fanControl.rotate();
		System.out.println(fanControl.toString());
		fanControl.rotate();
		System.out.println(fanControl.toString());

	}
}
