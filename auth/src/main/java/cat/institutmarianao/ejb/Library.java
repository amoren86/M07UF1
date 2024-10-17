package cat.institutmarianao.ejb;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;

@DeclareRoles({ "librarian" })
@Stateless
public class Library implements LibraryLocal {

	@RolesAllowed({ "librarian" })
	@Override
	public String catalog(String book) {
		return "Book " + book + " cataloged.";
	}

	@PermitAll
	@Override
	public String checkAvailability(String book) {
		if (book.equals("Java")) {
			return "Book " + book + " available.";
		}
		return "Book " + book + " not available.";
	}

	@DenyAll
	@Override
	public Boolean borrow(String book) {
		return false;
	}
}