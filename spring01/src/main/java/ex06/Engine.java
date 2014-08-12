package ex06;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

//@Component("engine01")
public class Engine {
	String maker;
	int horsePower;
	
	public String getMaker() {
		return maker;
	}
	
	/*
	 * @Required: property를 필수 입력 항목으로 만듦
	 *            setter 메소드에 선언 가능, 인스턴스 변수에는 불가능
	 */
	@Required
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	@Override
  public String toString() {
	  return "Engine [maker=" + maker + ", horsePower=" + horsePower + "]";
  }
}
