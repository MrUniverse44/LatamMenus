package me.blueslime.latammenus.commands;

import me.blueslime.bukkitmeteor.commands.InjectedCommand;
import me.blueslime.bukkitmeteor.libs.utilitiesapi.commands.sender.Sender;

import java.util.Locale;

public class ReloadCommand extends InjectedCommand {

    public ReloadCommand() {
        super("latammenus");
    }

    @Override
    public void executeCommand(Sender sender, String label, String[] args) {
        if (!sender.hasPermission("latammenus.admin")) {
            return;
        }
        if (args.length == 0) {
            sender.send("&9/latammenus reload &7- &eReload menus");
            return;
        }
        String argument = args[0].toLowerCase(Locale.ENGLISH);
        if (argument.equals("reload")) {
            plugin.reload();
            sender.send("&aPlugin reloaded successfully.");
        }
    }
}
