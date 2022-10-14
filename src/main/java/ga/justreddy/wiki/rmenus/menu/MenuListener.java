package ga.justreddy.wiki.rmenus.menu;

import ga.justreddy.wiki.rmenus.MenuManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

  @EventHandler
  public void onMenuClick(InventoryClickEvent e){
    final InventoryHolder holder = e.getInventory().getHolder();
    if(holder instanceof AbstractMenu) {
      e.setCancelled(true);
      if(e.getCurrentItem() == null) return;
      ((AbstractMenu) holder).onClick(e);
    }
  }

  @EventHandler
  public void onInventoryClose(InventoryCloseEvent e) {
    MenuManager.getMenuManager().getOpenMenus().remove(e.getPlayer().getUniqueId());
  }

}
