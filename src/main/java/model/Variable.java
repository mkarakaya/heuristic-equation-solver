package model;

public class Variable {

	private int value;
	private final String name;
	private final int multiplier;
	
	
	public Variable(String name,int multiplier, int value){
		this.value=value;
		this.name=name;
		this.multiplier=multiplier;
	}
	
	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
