package exceptions;

public class FileFormatException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public FileFormatException() {
		System.out.println("Wrong file format. File should be in .properties format");
	}
}
