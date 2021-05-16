package com.cg.hsm.entity;

public enum TreatmentStatus {

	COMPLETED {
		@Override
		public String toString() {
			return "Completed";
		}
	},
	INPROGRESS {
		@Override
		public String toString() {
			return "In Process";
		}
	},
	APPOINTED {
		@Override
		public String toString() {
			return "Appointed";
		}
	},
	CANCELLED {
		@Override
		public String toString() {
			return "Cancelled";
		}
	}
}