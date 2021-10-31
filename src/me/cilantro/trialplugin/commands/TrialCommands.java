package me.cilantro.trialplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TrialCommands implements CommandExecutor {

    ArrayList<String> onlinePlayerNames = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)){return true;}

        Player p = (Player) sender;
        double playerX = p.getPlayer().getLocation().getX();
        double playerY = p.getPlayer().getLocation().getY();
        double playerZ = p.getPlayer().getLocation().getZ();

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

        if (cmd.getName().equalsIgnoreCase("tpall")){
            for (Player ops : Bukkit.getOnlinePlayers()) {
                ops.getPlayer().teleport(new Location(Bukkit.getWorld("world"), playerX, playerY, playerZ));
            }
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("smite")){
            for (Player ops : Bukkit.getOnlinePlayers()) {
                double smiteX = ops.getPlayer().getLocation().getX();
                double smiteY = ops.getPlayer().getLocation().getY();
                double smiteZ = ops.getPlayer().getLocation().getZ();
                Bukkit.getWorld("world").strikeLightning(new Location(Bukkit.getWorld("world"), smiteX, smiteY, smiteZ));
            }
            return true;
        }


        return true;
    }
}
