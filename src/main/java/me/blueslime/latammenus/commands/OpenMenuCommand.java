package me.blueslime.latammenus.commands;

import me.blueslime.bukkitmeteor.BukkitMeteorPlugin;
import me.blueslime.bukkitmeteor.commands.InjectedCommand;
import me.blueslime.bukkitmeteor.implementation.Implements;
import me.blueslime.bukkitmeteor.libs.utilitiesapi.commands.sender.Sender;
import me.blueslime.bukkitmeteor.menus.Menus;
import me.blueslime.bukkitmeteor.menus.list.PersonalMenu;
import org.bukkit.entity.Player;

import java.util.Locale;

public class OpenMenuCommand extends InjectedCommand {

    public OpenMenuCommand() {
        super("openlatammenu");
    }

    public void executeCommand(Sender sender, String command, String[] arguments) {
        if (arguments.length != 0) {
            String filename = arguments[0].toLowerCase(Locale.ENGLISH);
            String playerName = arguments.length < 2 || !sender.hasPermission("latammenus.admin") && !sender.isConsole() ? null : arguments[1];
            Menus menus = Implements.fetch(Menus.class);
            if (playerName == null) {
                if (!sender.isPlayer()) {
                    return;
                }

                PersonalMenu menuX = menus.getSpecifiedMenu(filename, sender.toPlayer());
                if (menuX != null) {
                    menuX.open(sender.toPlayer());
                }
            } else {
                Player targetPlayer = (Implements.fetch(BukkitMeteorPlugin.class)).getServer().getPlayer(playerName);
                if (targetPlayer == null) {
                    return;
                }

                PersonalMenu menu = menus.getSpecifiedMenu(filename, targetPlayer);
                if (menu != null) {
                    menu.open(targetPlayer);
                }
            }

        }
    }
}
