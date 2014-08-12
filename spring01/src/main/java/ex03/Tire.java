package ex03;

public class Tire {
	String diameter;

	public Tire() {
	  super();
	  // TODO Auto-generated constructor stub
  }

	public Tire(String diameter) {
	  super();
	  this.diameter = diameter;
  }

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	@Override
  public String toString() {
	  return "Tire [diameter=" + diameter + "]";
  }

}
