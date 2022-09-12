package eu.asangarin.figurahook;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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

	public static void sendCustomEvent(Player player, String id) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF(id);
		} catch (IOException ignored) {
		}

		player.sendPluginMessage(FiguraHook.getPlugin(), CUSTOM_EVENT_IDENTIFIER, b.toByteArray());
	}
}
