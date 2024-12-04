package me.blueslime.latammenus.listener;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.bukkitmeteor.logs.MeteorLogger;
import me.blueslime.bukkitmeteor.menus.Menus;
import me.blueslime.bukkitmeteor.menus.list.PersonalMenu;
import me.blueslime.latammenus.services.MenuCommandService;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Locale;
import java.util.Map;

public class PlayerCommandListener implements Listener, AdvancedModule {

    @EventHandler
    public void on(PlayerCommandPreprocessEvent event) {
        Map<String, String> map = fetch(MenuCommandService.class).getCommandMap();

        String[] split = event.getMessage().split(" ");
        String keySet = split[0].toLowerCase(Locale.ENGLISH);

        if (map.containsKey(keySet)) {
            event.setCancelled(true);
            PersonalMenu menu = fetch(Menus.class).getSpecifiedMenu(map.get(keySet), event.getPlayer());
            if (menu != null) {
                menu.open(event.getPlayer());
            } else {
                fetch(MeteorLogger.class).info(event.getPlayer().getName() + " tried to open menu id: " + map.get(keySet) + " with command: " + keySet + " but this menu doesn't exist more, please reload the plugin.");
            }
        }
    }
}
