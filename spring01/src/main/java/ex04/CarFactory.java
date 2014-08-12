package ex04;

/*
 * Factory Method 패턴
 * : 객체 생성 과정이 복잡한 경우, 객체 생성 로직을 메소드로 감춘다.
 */
public class CarFactory {
	public static Car createCar(String model){
		Car car = new Car();
		
		if(model.equals("tico")){
			car.setModel("티코");
			car.setCc(800);
			
			Engine e = new Engine();
			e.setMaker("대우자동차");
			e.setHorsePower(120);
			car.setEngine(e);
			return car;
			
		} else if(model.equals("sonata")) {
			car.setModel("소나타");
			car.setCc(1998);
			
			Engine e = new Engine();
			e.setMaker("현대자동차");
			e.setHorsePower(275);
			car.setEngine(e);
			return car;
			
		} else {
			return null;
		}
	}
}
