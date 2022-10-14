package ga.justreddy.wiki.rmenus.menu.tasks;

import ga.justreddy.wiki.rmenus.MenuManager;
import ga.justreddy.wiki.rmenus.menu.AbstractMenu;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryRefreshTask extends BukkitRunnable {

  @Override
  public void run() {
    for (Map.Entry<UUID, AbstractMenu> entry : MenuManager.getMenuManager().getOpenMenus().entrySet()) {
      if (Bukkit.getPlayer(entry.getKey()) == null) continue;
      entry.getValue().setMenuItems(Bukkit.getPlayer(entry.getKey()));
    }
  }
}
