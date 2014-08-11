package kt.c.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// annotation 정의
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	String value();
}