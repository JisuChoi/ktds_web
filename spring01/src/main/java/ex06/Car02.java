package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * annotation을 통해 bean 설정
 * - @Autowired: 지정된 property와 일치하는 타입의 객체를 찾아서 자동 주입한다.
 *               생성자, setter 메소드, 인스턴스 변수(가능한 public)에 붙일 수 있음 
 *               같은 타입의 객체가 여러 개 있을 경우 오류 발생
 */

//@Component
public class Car02 {
	String model;
	int cc;
	
	/*
	 * 인스턴스 변수에 annotation 설정
	 * - 기본(@Autowired)은 필수 입력 항목
	 * - 선택 입력 항목으로 변경: required 속성을 false로 지정
	 */
	@Autowired(required=false) // 선택항목이기 때문에 없으면 무시
	Engine engine;

	public Car02() {
  }
	
	public Car02(String model, int cc) {
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
	
}
