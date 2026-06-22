package com.myapps.server;

import com.myapps.GlidingTooFastMod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

public class ServerTickAction {

    public static double SPEED_THRESHOLD = -0.3;

    public static void execute(MinecraftServer server) {
        for (ServerLevel world : server.getAllLevels()) {
            world.getPlayers(player -> {
                if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == Items.ELYTRA) {
                    if (player.isFallFlying()) {
                        Vec3 velocity = player.getDeltaMovement();
                        if (velocity.y < SPEED_THRESHOLD) {
                            GlidingTooFastMod.LOGGER.warn(
                                "Player {} is falling too fast with elytra! Velocity Y: {}",
                                player.getName().getString(),
                                velocity.y
                            );
                            player.displayClientMessage(
                                    Component.literal("BE CAREFUL!")
                                            .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFFEA00))),
                                    true
                            );
                        }
                    }
                }
                return true;
            });
        }
    }
}
