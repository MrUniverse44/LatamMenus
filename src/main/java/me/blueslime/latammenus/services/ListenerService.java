package me.blueslime.latammenus.services;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.latammenus.listener.PlayerCommandListener;

public class ListenerService implements AdvancedModule {
    @Override
    public void initialize() {
        registerAll(new PlayerCommandListener());
    }
}
