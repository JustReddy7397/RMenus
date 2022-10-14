package ga.justreddy.wiki.rmenus.menu;

import ga.justreddy.wiki.rmenus.exceptions.MenuSizeException;
import ga.justreddy.wiki.rmenus.xseries.XMaterial;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class AbstractPaginatedMenu extends AbstractMenu {

  protected int page = 0;

  protected int index = 0;

  protected int maxItemsPerPage = 0;

  public void addMenuBorder() {

    final ItemStack left = XMaterial.LIME_DYE.parseItem();
    final ItemMeta meta = left.getItemMeta();
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aLeft"));
    left.setItemMeta(meta);
    final ItemStack right = XMaterial.LIME_DYE.parseItem();
    final ItemMeta meta1 = right.getItemMeta();
    meta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aRight"));
    right.setItemMeta(meta1);
    final ItemStack back = XMaterial.BARRIER.parseItem();
    final ItemMeta meta2 = back.getItemMeta();
    meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cBack"));
    back.setItemMeta(meta2);

    switch (getSize()) {
      case $9:
        throw new MenuSizeException();
      case $18:
        setItem(0, FILLER_GLASS);
        setItem(8, FILLER_GLASS);
        maxItemsPerPage = 7;
        setItem(12, left);
        setItem(14, right);
        setItem(13, back);
        for (int i = 9; i < 18; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        break;
      case $27:
        // Seven because the row above the middle one will get glassed too!
        maxItemsPerPage = 7;
        setItem(17, FILLER_GLASS);
        setItem(9, FILLER_GLASS);
        setItem(21, left);
        setItem(22, back);
        setItem(23, right);
        for (int i = 0; i < 9; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        for (int i = 18; i < 27; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        break;
      case $36:
        maxItemsPerPage = 14;
        setItem(9, FILLER_GLASS);
        setItem(18, FILLER_GLASS);
        setItem(17, FILLER_GLASS);
        setItem(26, FILLER_GLASS);
        setItem(30, left);
        setItem(31, back);
        setItem(32, right);
        for (int i = 0; i < 9; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        for (int i = 27; i < 35; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        break;
      case $45:
        maxItemsPerPage = 21;
        setItem(9, FILLER_GLASS);
        setItem(18, FILLER_GLASS);
        setItem(27, FILLER_GLASS);
        setItem(17, FILLER_GLASS);
        setItem(26, FILLER_GLASS);
        setItem(35, FILLER_GLASS);
        setItem(39, left);
        setItem(40, back);
        setItem(41, right);
        for (int i = 0; i < 9; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        for (int i = 36; i < 45; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        break;
      case $54:
        maxItemsPerPage = 28;
        setItem(17, FILLER_GLASS);
        setItem(18, FILLER_GLASS);
        setItem(26, FILLER_GLASS);
        setItem(27, FILLER_GLASS);
        setItem(35, FILLER_GLASS);
        setItem(36, FILLER_GLASS);
        setItem(48, left);
        setItem(49, back);
        setItem(50, right);
        for (int i = 0; i < 10; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, FILLER_GLASS);
          }
        }
        for (int i = 44; i < 54; i++) {
          if (inventory.getItem(i) == null) {
            setItem(i, super.FILLER_GLASS);
          }
        }
    }
  }

}
