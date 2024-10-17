package cat.institutmarianao.ejb;

import jakarta.ejb.Local;

@Local
public interface PostBeanLocal {
	Boolean isValidEmail(String email);

	Boolean isValidAge(String age);

	Boolean isValidPost(String message);
}