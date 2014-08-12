package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * annotation을 통해 bean 설정
 * - @Component: 스프링 IoC 컨테이너는 이 annotation이 붙은 클래스의 인스턴스를 자동 생성
 * - 클래스를 좀 더 상세히 분류하기 위해 스프링은 다음 annotation을 추가로 제공
 *   (@Controller, @Service, @Repository -> 인스턴스 자동 생성) 
 * - 스프링 설정 파일에 이런 annotation을 처리할 담당자를 지정해야함 
 *   <context:component-scan base-package="탐색 시작 패키지"/>
 *   
 * - @Autowired: 지정된 property와 일치하는 타입의 객체를 찾아서 자동 주입한다.
 *               생성자, setter 메소드, 인스턴스 변수(가능한 public)에 붙일 수 있음 
 *               같은 타입의 객체가 여러 개 있을 경우 오류 발생
 */

//@Component
public class Car01 {
	String model;
	int cc;
	Engine engine; // Car는 engine에 의존하는 의존 객체

	public Car01() {
  }
	
	public Car01(String model, int cc) {
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

	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}
