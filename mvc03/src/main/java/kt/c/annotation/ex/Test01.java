package kt.c.annotation.ex;

import java.lang.annotation.Annotation;

import kt.c.annotation.Component;

// annotation 추출
public class Test01 {
	public static void main(String[] args) {
	  Car car = new Car();	  
	  
	  Class clazz = car.getClass(); // 어떤 class의 instance인지 리턴
	  Annotation[] annos = clazz.getAnnotations();
	  
	  for(Annotation anno : annos){
	  	System.out.println(anno.toString());
	  }
	  
	  Component comp = (Component)clazz.getAnnotation(Component.class); // Component는 class 정보를 갖고 있는 인스턴스 변수(파일명 ㄴㄴ)
	  System.out.println("->" + comp.value());
  }
}
