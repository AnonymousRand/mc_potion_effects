package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.loading.FMLCommonLaunchHandler;
import org.lwjgl.system.CallbackI;

import java.util.List;

@Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ChatHandler {
    @SubscribeEvent
    public static void messageSent(ClientChatEvent event) {
        String input = event.getMessage();
        int inp;
        try {
            inp = Integer.parseInt(input);
        } catch (Exception e) {
            inp = 0;
        }

        List<AbstractClientPlayerEntity> l;

        try {
            l = ((ClientWorld)(Minecraft.getInstance().world.getWorld())).getPlayers();
            switch (inp) {
                case 1:
                    for (PlayerEntity player : l) {
                        player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20000000, 7));
                    }
                    break;
                case 3:
                    for (PlayerEntity player : l) {
                        player.addPotionEffect(new EffectInstance(Effects.HASTE, 20000000, 3));
                    }
                    break;
                case 6:
                    for (PlayerEntity player : l) {
                        player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20000000, 1));
                    }
                    break;
                case 8:
                    for (PlayerEntity player : l) {
                        player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 20000000, 5));
                    }
                    break;
                case 9:
                    for (PlayerEntity player : l) {
                        player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 20000000, 0));
                    }
                    break;
                default:
            }
        } catch (NullPointerException e) {}
    }
}
