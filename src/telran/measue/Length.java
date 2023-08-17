package telran.measue;

import java.util.Objects;

public class Length implements Comparable<Length> {
	
	private final float amount;
	private final LengthUnit unit;
	
	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	
	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

	
	public Length convert(LengthUnit unit) {
		
		return new Length(amount * this.unit.getValue() / unit.getValue(), unit);
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(unit);
	}


	@Override
	public boolean equals(Object obj) {
		
		return this.compareTo((Length) obj) == 0;
	}

	@Override
	public int compareTo(Length o) {
		if(this.unit.getValue() == o.unit.getValue()) {
			return Float.compare(this.amount, o.amount);
		}else {
			Length convertValue = this.convert(o.unit);
			return Float.compare(convertValue.amount, o.amount);
		}
		
	}

	@Override
	public String toString() {
		return amount + "" + unit;
	}

	



	
	
}
