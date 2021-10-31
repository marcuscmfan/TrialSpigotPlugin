package me.cilantro.trialplugin;

import me.cilantro.trialplugin.commands.TrialCommands;
import org.bukkit.plugin.java.JavaPlugin;
public class Trial extends JavaPlugin {

    TrialCommands trialCommands = new TrialCommands();

    @Override
    public void onEnable() {
        getLogger().info("OYE, it's on!");
        this.getCommand("players").setExecutor(trialCommands);
        this.getCommand("tpall").setExecutor(trialCommands);
        this.getCommand("smite").setExecutor(trialCommands);
    }

    @Override
    public void onDisable() {
        getLogger().info("Peace");
    }
}

