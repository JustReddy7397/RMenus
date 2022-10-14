package ga.justreddy.wiki.rmenus.exceptions;

public class MenuManagerInitializedException extends RuntimeException {

  public MenuManagerInitializedException() {
    super("The Menu Manager has not been initialized.");
  }

}
