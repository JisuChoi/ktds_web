package ex07;

public class Engine {
	String maker;
	int horsePower;
	
	public Engine() {
		System.out.println("Engine() 생성됨..");
	}
	
	@Override
  public String toString() {
	  return "Engine [maker=" + maker + ", horsePower=" + horsePower + "]";
  }
	
	public String getMaker() {
		return maker;
	}
	
	public void setMaker(String maker) {
  	System.out.println("Engine:setMaker() 호출됨..");
		this.maker = maker;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		System.out.println("Engine:setHorsePower() 호출됨..");
		this.horsePower = horsePower;
	}
}