package ex03;

import java.util.List;
import java.util.Map;

public class Car {
	String model;
	int cc;
	Engine engine; // Car는 engine에 의존하는 의존 객체
	String[] tires;
	List<Object> cdBox;
	Map<String, Object> options;

	public Car() {
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
		this.engine = engine;
	}

	public String[] getTires() {
		return tires;
	}

	public void setTires(String[] tires) {
		this.tires = tires;
	}

	public List<Object> getCdBox() {
		return cdBox;
	}

	public void setCdBox(List<Object> cdBox) {
		this.cdBox = cdBox;
	}

	public Map<String, Object> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}
	
	
}
