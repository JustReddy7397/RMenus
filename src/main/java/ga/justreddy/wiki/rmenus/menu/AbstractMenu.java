package ga.justreddy.wiki.rmenus.menu;

import ga.justreddy.wiki.rmenus.MenuManager;
import ga.justreddy.wiki.rmenus.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractMenu implements InventoryHolder {

  protected Inventory inventory;

  protected ItemStack FILLER_GLASS = XMaterial.BLACK_STAINED_GLASS_PANE.parseItem();

  public abstract String getName();

  public abstract InventorySize getSize();

  public abstract void onClick(InventoryClickEvent e);

  public abstract void setMenuItems(Player player);

  public void open(Player player) {
    MenuManager.getMenuManager().getOpenMenus().putIfAbsent(player.getUniqueId(), this);
    inventory = Bukkit.createInventory(
        this,
        getSize().getSize(),
        ChatColor.translateAlternateColorCodes('&', getName())
    );

    player.openInventory(inventory);

    setMenuItems(player);

  }

  public void setFillerGlass() {
    for (int i = 0; i < getSize().getSize(); i++) {
      if(inventory.getItem(i) == null) inventory.setItem(i, FILLER_GLASS);
    }
  }

  public void setItem(int index, ItemStack itemStack) {
    inventory.setItem(index, itemStack);
  }

  public void addItem(ItemStack... itemStack) {
    inventory.addItem(itemStack);
  }

  @Override
  public Inventory getInventory() {
    return inventory;
  }
}
