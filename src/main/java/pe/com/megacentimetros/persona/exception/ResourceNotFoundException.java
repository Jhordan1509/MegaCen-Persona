package pe.com.megacentimetros.persona.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}
}
