package com.mattiz.builder;

public class BuilderPattern {// When you need multiple options while creating an object

	static class Coffee {

		private String type;
		private boolean sugar;
		private boolean milk;
		private boolean honey;
		private boolean cardamom;
		private boolean ginger;
		private String size;

		public Coffee() {
		}

		public Coffee(Builder builder) {
			super();
			this.type = builder.type;
			this.sugar = builder.sugar;
			this.milk = builder.milk;
			this.honey = builder.honey;
			this.cardamom = builder.cardamom;
			this.ginger = builder.ginger;
			this.size = builder.size;
		}

		public static class Builder {

			public Builder(String type) {
				super();
				this.type = type;
			}

			private String type;
			private boolean sugar;
			private boolean milk;
			private boolean honey;
			private boolean cardamom;
			private boolean ginger;
			private String size;

			public Builder addSugar(boolean flag) {
				this.sugar = flag;
				return this;
			}

			public Builder addMilk(boolean flag) {
				this.milk = flag;
				return this;

			}

			public Builder addHoney(boolean flag) {
				this.honey = flag;
				return this;
			}

			public Builder addCardamom(boolean flag) {
				this.cardamom = flag;
				return this;
			}

			public Builder addGinger(boolean flag) {
				this.ginger = flag;
				return this;
			}
			
			public Builder makeSize(String size) {
				this.size = size;
				return this;
			}

			public Coffee build() {
				return new Coffee(this);
			}

		}// end of Class Builder

		public static void main(String[] args) {
			Coffee mocha = new Builder("Mocha").addGinger(true).addSugar(true).addCardamom(true).makeSize("small").build();
			System.out.println(mocha.toString());
			Coffee cappuchino = new Builder("Cappcucchino").addCardamom(true).addSugar(true).makeSize("large").build();
			System.out.println(cappuchino.toString());
		}

		@Override
		public String toString() {
			return "type= " + type + ",sugar= " + sugar + ",milk= " + milk + ",honey= " + honey + ",cardamon= "
					+ cardamom + ",ginger= " + ginger + ",size= " + size;
		}

	}// end of Class Coffee

}// end of main class
