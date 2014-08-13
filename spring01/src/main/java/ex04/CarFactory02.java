package ex04;

/*
 * Factory Method 패턴
 * : 팩토리 메서드가 인스턴스 메서드인 경우
 */
public class CarFactory02 {
	public Car createCar(String model){
		
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
