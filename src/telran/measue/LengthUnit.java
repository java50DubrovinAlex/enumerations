package telran.measue;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), M(1000), KM(1_000_000);

	float value;

	LengthUnit(float value) {
		this.value = value;

	}

	public float getValue() {
		return value;
	}
	
	public Length between(Length length1, Length length2) {
		return new Length (length2.convert(this).getAmount() - length1.convert(this).getAmount(), this);
	}

}
