package net.faceless.project.commands;

import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {

            CraftPlayer craftPlayer = (CraftPlayer) player;
             ServerPlayer serverPlayer = craftPlayer.getHandle();

            ServerGamePacketListenerImpl listener = serverPlayer.connection;

            ClientboundGameEventPacket packet = new ClientboundGameEventPacket(ClientboundGameEventPacket.STOP_RAINING, 0.0F);

            listener.send(packet);
            player.sendMessage(packet.toString());



        }
        return true;
    }
}
