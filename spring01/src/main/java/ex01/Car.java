package ex01;

public class Car {
	String model;
	int cc;

	public Car() {
		System.out.println("Car() 호출됨...");
  }
	
	public Car(String model, int cc) {
		System.out.println("Car(model, cc) 호출됨...");
	  this.model = model;
	  this.cc = cc;
  }

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
}
