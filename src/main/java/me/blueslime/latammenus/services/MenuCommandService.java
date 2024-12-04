package me.blueslime.latammenus.services;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.bukkitmeteor.logs.MeteorLogger;
import me.blueslime.bukkitmeteor.menus.Menus;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MenuCommandService implements AdvancedModule {

    private final Map<String, String> commandMap = new ConcurrentHashMap<>();

    @Override
    public void initialize() {
        MeteorLogger logs = fetch(MeteorLogger.class);
        for (Map.Entry<String, ConfigurationSection> entry : fetch(Menus.class).getMenuStorageSettings().toMap().entrySet()) {
            List<String> commands = entry.getValue().getStringList("settings.open-commands");
            commands.forEach(command -> commandMap.put(command.toLowerCase(Locale.ENGLISH), entry.getKey()));
            logs.info(
                "Registered commands for menu '" +
                entry.getKey() + "': " + String.join(",", commands)
            );
        }
    }

    @Override
    public void shutdown() {
        commandMap.clear();
    }

    @Override
    public void reload() {
        shutdown();
        initialize();
    }

    public Map<String, String> getCommandMap() {
        return commandMap;
    }
}
