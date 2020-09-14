package hugog.itemstayreloaded.others;

import org.bukkit.ChatColor;

public class Messages {
	
  private String pluginHeader;
  private String pluginFooter;
  private String pluginPrefix;
  private String noPermission;
  private String missingArguments;
  private String wrongArguments;
  private String unknownCommand;
  private String unknownError;
  private String reloadConfig;
  private String intentNextItemSaved;
  private String itemSaved;
  private String itemIdNotFound;
  private String itemDeleted;
  private String itemBeingProcessed;
  private String noItemsFound;
  private String pageNotFound;
  
  public Messages(ConfigAccessor messagesConfig) {
    this.pluginHeader = ChatColor.GRAY + "-=-=-=-=-=-=-=-=-= " + ChatColor.GREEN + "ItemStayReloaded" + ChatColor.GRAY + " =-=-=-=-=-=-=-=-=- ";
    this.pluginFooter = ChatColor.GRAY + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-";
    this.pluginPrefix = ChatColor.GREEN + "ISR" + ChatColor.RESET + " > " + ChatColor.GRAY;
    this.noPermission = messagesConfig.getConfig().getString("NoPermission");
    this.missingArguments = messagesConfig.getConfig().getString("MissingArguments");
    this.wrongArguments = messagesConfig.getConfig().getString("WrongArguments");
    this.unknownError = messagesConfig.getConfig().getString("UnknownError");
    this.unknownCommand = messagesConfig.getConfig().getString("UnknownCommand");
    this.reloadConfig = messagesConfig.getConfig().getString("ReloadConfig");
    this.intentNextItemSaved = messagesConfig.getConfig().getString("IntentNextItemSaved");
    this.itemSaved = messagesConfig.getConfig().getString("ItemSaved");
    this.itemIdNotFound = messagesConfig.getConfig().getString("ItemIdNotFound");
    this.itemDeleted = messagesConfig.getConfig().getString("ItemDeleted");
    this.itemBeingProcessed = messagesConfig.getConfig().getString("ItemBeingProcessed");
    this.noItemsFound = messagesConfig.getConfig().getString("NoItemsFound");
    this.pageNotFound = messagesConfig.getConfig().getString("PageNotFound");
  }
  
  public String getPluginHeader() {
    return this.pluginHeader;
  }
  
  public String getPluginFooter() {
    return this.pluginFooter;
  }
  
  public String getNoPermission() {
    return this.noPermission;
  }
  
  public String getPluginPrefix() {
    return this.pluginPrefix;
  }
  
  public String getMissingArguments() {
    return this.missingArguments;
  }
  
  public String getWrongArguments() {
    return this.wrongArguments;
  }
  
  public String getUnknownCommand() {
    return this.unknownCommand;
  }
  
  public String getUnknownError() {
    return this.unknownError;
  }
  
  public String getReloadConfig() {
    return this.reloadConfig;
  }
  
  public String getIntentNextItemSaved() {
    return this.intentNextItemSaved;
  }
  
  public String getItemSaved() {
    return this.itemSaved;
  }

	public String getItemIdNotFound() {
		return itemIdNotFound;
	}
	
	public String getItemDeleted() {
		return itemDeleted;
	}

	public String getItemBeingProcessed() {
		return itemBeingProcessed;
	}

	public String getNoItemsFound() {
		return noItemsFound;
	}

	public String getPageNotFound() {
		return pageNotFound;
	}
	
}
