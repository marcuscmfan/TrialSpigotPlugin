package me.cilantro.trialplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TrialCommands implements CommandExecutor {

    ArrayList<String> onlinePlayerNames = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!(sender instanceof Player)){return true;}

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("players")) {
            String name = "";
            for (Player ops : Bukkit.getOnlinePlayers()){
                name = ops.getName();
                onlinePlayerNames.add(name);
            }
            if (onlinePlayerNames.size() == 1) {
                p.sendMessage("Only you are online");
            }else {
                p.sendMessage("You and "+onlinePlayerNames.size()+" others are online");
                p.sendMessage(ChatColor.RED + "PLAYERS:");
                for (int i = 0; i < onlinePlayerNames.size(); i++) {
                    p.sendMessage(onlinePlayerNames.get(i));
                }
            }
            return true;
        }


        return true;
    }
}
