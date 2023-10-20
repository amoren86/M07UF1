package cat.institutmarianao.ejb;

import javax.ejb.Local;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Local
public interface Post2BeanLocal {
	@NotBlank
	@Pattern(regexp = "^(.+)@(.+)$", message = "The e-mail is not valid")
	String getEmail();

	void setEmail(String email);

	@Min(value = 18, message = "You must be older than 18 to write a message")
	int getAge();

	void setAge(String age);

	@NotBlank
	@Size(min = 1, max = 150, message = "<p>The message must have at most 150 characters</p>")
	String getMessage();

	void setMessage(String message);

}