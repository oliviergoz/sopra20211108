package formation.sopra.formationSpringBoot.exceptions;

public class ClientException extends RuntimeException {
	public ClientException() {

	}

	public ClientException(String message) {
		super(message);
	}
}
