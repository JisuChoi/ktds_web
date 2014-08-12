package ex07;

public class Car {
	String model;
	int cc;
	Engine engine;
	
	public Car() {
		System.out.println("Car() 생성됨...");
		
	} 
	
	public Car(String model, int cc) {
		this.model = model;
		this.cc = cc;
	}
	
	@Override
  public String toString() {
	  return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine + "]";
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
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		System.out.println("setEngine() 호출됨...");
		this.engine = engine;
	}
}
