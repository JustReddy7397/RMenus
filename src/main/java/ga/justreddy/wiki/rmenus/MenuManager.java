package ga.justreddy.wiki.rmenus;

import ga.justreddy.wiki.rmenus.exceptions.MenuManagerInitializedException;
import ga.justreddy.wiki.rmenus.menu.AbstractMenu;
import ga.justreddy.wiki.rmenus.menu.MenuListener;
import ga.justreddy.wiki.rmenus.menu.tasks.InventoryRefreshTask;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuManager {

  private static MenuManager menuManager = null;

  private static Map<UUID, AbstractMenu> openMenus;

  private MenuManager() {}

  public static void setMenuManager(JavaPlugin plugin) {
    if (MenuManager.menuManager != null) return;
    MenuManager.menuManager = new MenuManager();
    MenuManager.openMenus = new HashMap<>();
    Bukkit.getPluginManager().registerEvents(new MenuListener(), plugin);
    new InventoryRefreshTask().runTaskTimerAsynchronously(plugin, 0, 20L);
  }

  public static MenuManager getMenuManager()  {
    if (menuManager == null) throw new MenuManagerInitializedException();
    return menuManager;
  }

  /**
   * This should never be accessed.
   * @return A map of the UUID of the viewer and the object of the menu.
   */
  public Map<UUID, AbstractMenu> getOpenMenus() {
    return openMenus;
  }

}
