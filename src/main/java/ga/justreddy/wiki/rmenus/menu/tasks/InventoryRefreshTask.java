package ga.justreddy.wiki.rmenus.menu.tasks;

import ga.justreddy.wiki.rmenus.MenuManager;
import ga.justreddy.wiki.rmenus.menu.AbstractMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryRefreshTask extends BukkitRunnable {

  @Override
  public void run() {
    for (Map.Entry<UUID, AbstractMenu> entry : MenuManager.getMenuManager().getOpenMenus().entrySet()) {
      if (Bukkit.getPlayer(entry.getKey()) == null) continue;
      final Inventory inventory = entry.getValue().getInventory();
      for (int i = 0; i < inventory.getSize(); i++) {
        ItemStack itemStack = inventory.getItem(i);
        if (itemStack == null) continue;
        if (!itemStack.hasItemMeta()) continue;
        ItemStack clonedItem = itemStack.clone();
        ItemMeta meta = clonedItem.getItemMeta();
        if (itemStack.getItemMeta().hasDisplayName()) meta.setDisplayName(
                ChatColor.translateAlternateColorCodes('&', itemStack.getItemMeta().getDisplayName())
        );
        if (itemStack.getItemMeta().hasLore()) meta.setLore(colorLore(itemStack.getItemMeta().getLore()));
        clonedItem.setItemMeta(meta);
        inventory.setItem(i, clonedItem);
      }
    }
  }

  private List<String> colorLore(List<String> input) {
    List<String> hi = new ArrayList<>();
    for (String i : input) {
      hi.add(ChatColor.translateAlternateColorCodes('&', i));
    }
    return hi;
  }

}
