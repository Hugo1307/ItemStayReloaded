package hugog.itemstayreloaded.commands;

import hugog.itemstayreloaded.Main;
import hugog.itemstayreloaded.commands.CmdImplementer;
import hugog.itemstayreloaded.commands.DropItemCmd;
import hugog.itemstayreloaded.others.ConfigAccessor;
import hugog.itemstayreloaded.others.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdImplementer implements CommandExecutor {
  private Main main;
  
  public CmdImplementer(Main main) {
    this.main = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      sender.sendMessage("[ItemStayReloaded] Player command only."); 
    if (args.length != 0)
      if (args[0].equalsIgnoreCase("drop")) {
        DropItemCmd dropItemCmd = new DropItemCmd(this.main, sender);
        dropItemCmd.runDropItemCmd();
      } else {
        Messages messages = new Messages(new ConfigAccessor((JavaPlugin)this.main, "messages.yml"));
        sender.sendMessage(String.valueOf(messages.getPluginPrefix()) + messages.getUnknownCommand());
      }  
    return false;
  }
}

