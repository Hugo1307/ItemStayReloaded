package hugog.itemstayreloaded.commands;

import hugog.itemstayreloaded.Main;
import hugog.itemstayreloaded.commands.DropItemCmd;
import hugog.itemstayreloaded.events.DropItem;
import hugog.itemstayreloaded.others.ConfigAccessor;
import hugog.itemstayreloaded.others.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DropItemCmd {
  private Main main;
  
  private CommandSender sender;
  
  public DropItemCmd(Main main, CommandSender sender) {
    this.main = main;
    this.sender = sender;
  }
  
  void runDropItemCmd() {
	  
    Player p = (Player)this.sender;   
    Messages messages = new Messages(new ConfigAccessor((JavaPlugin)this.main, "messages.yml"));
    
    if (p.hasPermission("isr.commands.drop")) {
      
    	DropItem.shouldItemBeSaved = true;
      
    	p.sendMessage(messages.getPluginPrefix() + messages.getIntentNextItemSaved());
      
    } else {
      p.sendMessage(String.valueOf(messages.getPluginPrefix()) + messages.getNoPermission());
    } 
    
  }
  
}

