package kt.c.annotation.ex;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SearchInfo {
	String value(); // 필수 입력
	int level() default 1; // property 설정하지 않아도 됌, default 설정 되었으므로 생략 가능
	String[] author() default {""}; 
}
