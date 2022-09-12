package eu.asangarin.figurahook;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class FiguraHook extends JavaPlugin {
	@Getter
	private static FiguraHook plugin;
	public static final String CUSTOM_EVENT_IDENTIFIER = "figura:custom_event";

	@Override
	public void onLoad() {
		plugin = this;
	}

	@Override
	public void onEnable() {
		getServer().getMessenger().registerOutgoingPluginChannel(this, CUSTOM_EVENT_IDENTIFIER);
	}

	public static void sendCustomEvent(Player player) {
		player.sendPluginMessage(FiguraHook.getPlugin(), CUSTOM_EVENT_IDENTIFIER, new byte[0]);
	}
}
