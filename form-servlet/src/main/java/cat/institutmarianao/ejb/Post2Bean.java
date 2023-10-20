package cat.institutmarianao.ejb;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class Post2Bean
 */
@Stateful
public class Post2Bean implements Post2BeanLocal {

	private String email;
	private int age;
	private String message;

	public Post2Bean() {
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(String age) {
		if (!"".equals(age)) {
			this.age = Integer.parseInt(age);
		} else {
			this.age = 0;
		}
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}