package com.hsm.healthservicemanagement.entity;

public enum TreatmentStatus {

	// enum value 0 in sql
	COMPLETED {
		@Override
		public String toString() {
			return "Completed";
		}
	},
	// enum value 1 in sql
	INPROGRESS {
		@Override
		public String toString() {
			return "In Process";
		}
	},
	// enum value 2 in sql
	APPOINTED {
		@Override
		public String toString() {
			return "Appointed";
		}
	},
	// enum value 3 in sql
	CANCELLED {
		@Override
		public String toString() {
			return "Cancelled";
		}
	}
}