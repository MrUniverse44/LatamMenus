package me.blueslime.latammenus;

import me.blueslime.bukkitmeteor.BukkitMeteorPlugin;
import me.blueslime.latammenus.commands.PluginCommand;
import me.blueslime.latammenus.services.ListenerService;
import me.blueslime.latammenus.services.MenuCommandService;
import me.blueslime.latammenus.utils.Metrics;

public final class LatamMenus extends BukkitMeteorPlugin {

    @Override
    public void onEnable() {
        initialize(this, false, true);
        new Metrics(this, 24072);
    }

    @Override
    public void registerModules() {
        registerModule(
            MenuCommandService.class,
            ListenerService.class
        ).finish();

        new PluginCommand().register();
    }
}
