package kt.c.vo;

import java.io.Serializable;

public class LoginVO implements Serializable {
	// id 값을 통해 직렬화/역직렬화 시 송수신 간의 버전 확인
	// 클래스 정보 수정 시 버전 값 변경
  private static final long serialVersionUID = 1L;
  
	private String id;
	private String password;
	private String type;	// ����('S'), �����('U') ����
	
	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginVO(String id, String password, String type) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public LoginVO setId(String id) {
		this.id = id;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public LoginVO setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getType() {
		return type;
	}

	public LoginVO setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + ", type="
				+ type + "]";
	}
}
