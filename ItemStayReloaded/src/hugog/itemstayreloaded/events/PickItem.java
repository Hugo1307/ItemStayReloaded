package hugog.itemstayreloaded.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PickItem implements Listener {
  private final JavaPlugin plugin = (JavaPlugin)Bukkit.getServer().getPluginManager().getPlugin("ItemStayReloaded");
  
  @EventHandler
  public void onPickItem(EntityPickupItemEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player)e.getEntity();
    } else {
      return;
    } 
    if (e.getItem().hasMetadata("isStatic"))
      e.setCancelled(true); 
  }
}
