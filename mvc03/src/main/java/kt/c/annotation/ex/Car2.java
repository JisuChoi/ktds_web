package kt.c.annotation.ex;
/*
@SearchInfo(value="tico")
*/

/*
 * value 속성의 값만 설정할 때는 속성 이름 생략 가능
 * 단, value 속성 이외에 다른 속성을 설정할 때는 value 이름을 생략할 수 없음
 * @SearchInfo("tico")
 * @SearchInfo(value="tico", level=2)
 */

/*
 * default가 선언되지 않은 프로퍼티는 값을 반드시 입력해야함
 * @SearchInfo(level=2) // value 속성 값을 입력하지 않아서 error
 */

/*
 * 문자열 배열 넣기 중괄호{} 사용
 * @SearchInfo(value="tico", level=2, author={"임꺽정", "홍길동"})
 */

/*
 * 배열 값이 한 개일 경우 중괄호 붙이지 않아도 된다
 * @SearchInfo(value="tico", level=2, author="임꺽정")
 */

@SearchInfo(value="tico", level=2, author={"임꺽정", "홍길동"})
public class Car2 {
	
}
