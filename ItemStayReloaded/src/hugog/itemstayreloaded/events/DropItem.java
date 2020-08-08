package hugog.itemstayreloaded.events;

import hugog.itemstayreloaded.events.DropItem;
import hugog.itemstayreloaded.others.ConfigAccessor;
import hugog.itemstayreloaded.others.Messages;

import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DropItem implements Listener {
	
  private final JavaPlugin plugin = (JavaPlugin)Bukkit.getServer().getPluginManager().getPlugin("ItemStayReloaded");
  public static boolean shouldItemBeSaved = false;
  
  @EventHandler
  public void onDropItem(PlayerDropItemEvent e) {
	  
    Player p = e.getPlayer();
    Messages messages = new Messages(new ConfigAccessor(plugin, "messages.yml"));
     
    if (shouldItemBeSaved) {
    	
    	e.getItemDrop().setMetadata("isStatic", (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, Boolean.valueOf(true)));
    	shouldItemBeSaved = false;
    	
    	p.sendMessage(messages.getPluginPrefix() + MessageFormat.format(messages.getItemSaved(), ChatColor.GOLD + e.getItemDrop().getType().name() + ChatColor.GRAY));
    	
    }
    
  }
}

