package cat.institutmarianao.ejb;

import jakarta.ejb.Local;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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