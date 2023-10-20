package cat.institutmarianao.ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

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