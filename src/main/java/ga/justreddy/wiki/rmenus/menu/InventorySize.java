package ga.justreddy.wiki.rmenus.menu;

public enum InventorySize {

  $9(9),
  $18(18),
  $27(27),
  $36(36),
  $45(45),
  $54(54);

  private final int size;

  InventorySize(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}
