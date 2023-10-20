package cat.institutmarianao.ejb;

public interface LibraryLocal {

	String catalog(String book);

	String checkAvailability(String book);

	Boolean borrow(String book);

}