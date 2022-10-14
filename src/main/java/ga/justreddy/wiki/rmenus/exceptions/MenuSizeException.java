package ga.justreddy.wiki.rmenus.exceptions;

public class MenuSizeException extends RuntimeException {

  public MenuSizeException() {
    super("A Paginated Menu can not have a size of '9', minimum is 18.");
  }

}
