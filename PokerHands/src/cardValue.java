public enum CardValue {
	Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), T(
			10), J(11), Q(12), K(13), A(14), fail(15);

	int value;

	CardValue(int v) {
		value = v;
	}

	int getValue() {
		return value;
	}
}
