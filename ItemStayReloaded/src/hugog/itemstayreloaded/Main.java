package hugog.itemstayreloaded;

import hugog.itemstayreloaded.Main;
import hugog.itemstayreloaded.commands.CmdImplementer;
import hugog.itemstayreloaded.events.DropItem;
import hugog.itemstayreloaded.events.PickItem;
import hugog.itemstayreloaded.others.ConfigAccessor;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
  public void onEnable() {
	  
    registerCommands();
    configureMessages();
    registerEvents();
    System.out.println("[ItemStay] Plugin successfully enabled.");
    
  }
  
  public void onDisable() {
    System.out.println("[ItemStay] Plugin successfully disabled.");
  }
  
  private void registerCommands() {
    getCommand("isr").setExecutor((CommandExecutor)new CmdImplementer(this));
  }
  
  private void registerEvents() {
    Bukkit.getServer().getPluginManager().registerEvents((Listener)new DropItem(), (Plugin)this);
    Bukkit.getServer().getPluginManager().registerEvents((Listener)new PickItem(), (Plugin)this);
  }
  
  private void configureMessages() {
	  
    ConfigAccessor messagesConfig = new ConfigAccessor(this, "messages.yml");
    
    if (!(new File(getDataFolder(), "messages.yml")).exists()) {
    	messagesConfig.saveDefaultConfig(); 
    }
    
    messagesConfig.getConfig().options().copyDefaults(true);
    
    messagesConfig.getConfig().addDefault("NoPermission", "You don't have enough permissions.");
    messagesConfig.getConfig().addDefault("UnknownCommand", "Unknown command.");
    messagesConfig.getConfig().addDefault("UnknownError", "Unknown Error.");
    messagesConfig.getConfig().addDefault("MissingArguments", "There are missing arguments.");
    messagesConfig.getConfig().addDefault("WrongArguments", "There are wrong arguments.");
    messagesConfig.getConfig().addDefault("ReloadConfig", "Config was successfully reloaded.");
    messagesConfig.getConfig().addDefault("PlayerJob", "{0} is a {1}.");
    messagesConfig.getConfig().addDefault("PlayerNotFound", "{0} was not found.");
    messagesConfig.getConfig().addDefault("NoMoney", "You don't have enough money.");
    messagesConfig.getConfig().addDefault("MustBeUnemployed", "You must be unemployed to do that.");
    messagesConfig.getConfig().addDefault("GangCreated", "You successfully created the gang {0}.");
    messagesConfig.getConfig().addDefault("NoGang", "You do not belong to any gang.");
    messagesConfig.getConfig().addDefault("LeftGang", "You left your gang.");
    messagesConfig.getConfig().addDefault("InvitationSent", "You sent an invitation to {0}.");
    messagesConfig.getConfig().addDefault("InvitationReceived", "You received an invitation from {0}.");
    messagesConfig.getConfig().addDefault("ImpossibleToSendInvitation", "You can not invite that player.");
    messagesConfig.getConfig().addDefault("ImpossibleToAcceptInvitation", "You can not accept the invitation.");
    messagesConfig.getConfig().addDefault("NoInvitation", "You have not any invitation.");
    messagesConfig.getConfig().addDefault("InvitationReceivedAccepted", "You accepted the invitation from {0}.");
    messagesConfig.getConfig().addDefault("InvitationSentAccepted", "{0} accepted your invitation.");
    messagesConfig.getConfig().addDefault("ImpossibleKick", "You can not kick out {0}.");
    messagesConfig.getConfig().addDefault("PlayerKicked", "You kicked {0} from your gang.");
    messagesConfig.getConfig().addDefault("GotKicked", "You were kicked from your gang.");
    messagesConfig.getConfig().addDefault("NotInGang", "{0} is not in your gang.");
    messagesConfig.getConfig().addDefault("PlayerMustBeOnline", "{0} must be online to perform that action.");
    messagesConfig.getConfig().addDefault("ImpossiblePromotion", "You can not promote that player.");
    messagesConfig.getConfig().addDefault("PlayerPromoted", "You promoted {0} to {1}.");
    messagesConfig.getConfig().addDefault("ImpossibleDemotion", "You can not demote that player.");
    messagesConfig.getConfig().addDefault("PlayerDemoted", "You demoted {0} to {1}.");
    messagesConfig.getConfig().addDefault("GotDemoted", "You were demoted to {0}.");
    messagesConfig.getConfig().addDefault("GotPromoted", "You were promoted to {0}.");
    messagesConfig.getConfig().addDefault("LevelUpped", "Your gang is now level {0}.");
    messagesConfig.getConfig().addDefault("ImpossibleLevelUp", "Your gang already is in maximum level.");
    messagesConfig.getConfig().addDefault("GangNoMoney", "Your gang does not have {0} coins.");
    messagesConfig.getConfig().addDefault("GotKit", "You received a Gang Kit.");
    messagesConfig.getConfig().addDefault("RobberyInProgress", "The gang {0} started a robbery.");
    messagesConfig.getConfig().addDefault("RobberyFinished", "The robbery from {0} just finished.");
    messagesConfig.getConfig().addDefault("CooldownMsg", "Please wait {0} seconds and try again.");
    messagesConfig.getConfig().addDefault("AnotherRobberyInProgress", "Another robbery is in progress. Try again later.");
    messagesConfig.getConfig().addDefault("ItemsSold", "You sold {0} for {1} coins.");
    messagesConfig.getConfig().addDefault("PlayerNewGangChief", "Congratulations! You are the new Chief of the gang {0}.");
    messagesConfig.getConfig().addDefault("RoleSalaryChanged", "You changed the salary of {0} to {1} coins");
    messagesConfig.getConfig().addDefault("IntentNextItemSaved", "The next dropped item will be saved.");
    messagesConfig.getConfig().addDefault("ItemSaved", "{0} was successfully saved.");
    
    messagesConfig.saveConfig();
    
  }
}
