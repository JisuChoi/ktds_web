package kt.c.annotation.ex;

public class Test02 {
	public static void main(String[] args) {
	  Car2 c = new Car2();
	  
	  Class clazz = c.getClass();
	  SearchInfo p = (SearchInfo)clazz.getAnnotation(SearchInfo.class);
	  System.out.println(p.value());
	  System.out.println(p.level());
	  
	  String[] authors = p.author();
	  
	  for(String a : authors){
	  	System.out.println("=>" + a);
	  }
  }
}
