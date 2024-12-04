package me.blueslime.latammenus.commands;

import me.blueslime.bukkitmeteor.actions.Actions;
import me.blueslime.bukkitmeteor.commands.InjectedCommand;
import me.blueslime.bukkitmeteor.implementation.Implements;
import me.blueslime.bukkitmeteor.libs.utilitiesapi.commands.sender.Sender;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PluginCommand extends InjectedCommand {

    public PluginCommand() {
        super("latammenus");
    }

    @Override
    public void executeCommand(Sender sender, String label, String[] args) {
        if (!sender.hasPermission("latammenus.admin")) {
            return;
        }
        if (args.length == 0) {
            sender.send(
                "&9/latammenus reload &7- &eReload menus",
                "&9/latammenus actions &7- &eSee all action list"
            );
            return;
        }
        String argument = args[0].toLowerCase(Locale.ENGLISH);
        if (argument.equals("reload")) {
            plugin.reload();
            sender.send("&aPlugin reloaded successfully.");
        }
        if (argument.equals("actions")) {
            Actions actions = Implements.fetch(Actions.class);

            List<String> externalPrefixes = new ArrayList<>();
            List<String> internalPrefixes = new ArrayList<>();


            actions.getExternalActions().forEach(
                    action -> externalPrefixes.addAll(action.getPrefixes())
            );

            actions.getActions().forEach(
                    action -> internalPrefixes.addAll(action.getPrefixes())
            );

            sender.send(
                "&9Internal Actions:",
                "&6" + String.join("&e, &6", internalPrefixes),
                "&9External Actions:",
                "&6" + String.join("&e, &6", externalPrefixes)
            );
            return;
        }
    }
}
