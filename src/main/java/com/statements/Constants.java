package com.statements;

public class Constants {
	public static enum MaritalStatus {
		MARRIED(1), SINGLE(2);

		int value;

		MaritalStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	public static enum Education {
		GRAD_SCHOOL(1), UNIVERSITY(2), HIGH_SCHOOL(3), OTHER(4);

		int value;

		Education(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}
}
