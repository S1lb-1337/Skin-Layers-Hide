package name.net.c1lb.skinlayershide.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class SkinLayersHideClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        final boolean[] SkinLayersHideAll = {false};
        final boolean[] SkinLayersHideTop = {false};
        final boolean[] SkinLayersHideLegs = {false};
        // All
        KeyBinding skin_key_all = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "All layer on/off [Everything disappears except the cape]",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "All layer on/off"));
        //Hat
        KeyBinding skin_key_hat = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Hat on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));
        //Body
        KeyBinding skin_key_jacket = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Jacket on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));
        //Right hand
        KeyBinding skin_key_right_sleeve = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Right sleeve on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));
        //Left hand
        KeyBinding skin_key_left_sleeve = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Left sleeve on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));
        //Right leg
        KeyBinding skin_key_right_pains_leg = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Right pains leg on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));
        //Left leg
        KeyBinding skin_key_left_pains_leg = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Left pains leg on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));
        //Cape
        KeyBinding skin_key_cape = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Cape on/off",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "Skin layers hide - Parts"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Grups

            // On/off all layers
            while (skin_key_all.wasPressed()) {
                //MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.CAPE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.JACKET, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_SLEEVE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.HAT, SkinLayersHideAll[0]);
                SkinLayersHideAll[0] = !SkinLayersHideAll[0];
            }


            // On/off hat
            /*while (skin_key_hat.wasPressed()) {
                mc.togglePlayerModelPart(PlayerModelPart.HAT,
                !mc.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                );
                System.out.println(skin_key_hat.wasPressed()
                );
                System.out.println(skin_key_jacket.wasPressed()
                );
                System.out.println(skin_key_right_sleeve.wasPressed()
                );
            }*/
            while (skin_key_hat.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.HAT, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT));
                if (skin_key_hat.equals(skin_key_jacket)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.JACKET,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                    );
                }
                if (skin_key_hat.equals(skin_key_right_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE)
                    );
                }
                if (skin_key_hat.equals(skin_key_left_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                    );
                }
                if (skin_key_hat.equals(skin_key_right_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                    );
                }
                if (skin_key_hat.equals(skin_key_left_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                    );
                }
                if (skin_key_hat.equals(skin_key_cape)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.CAPE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                    );
                }
            }
            while (skin_key_jacket.wasPressed()) {
                if (skin_key_jacket.equals(skin_key_hat)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.HAT,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                    );
                }
                MinecraftClient.getInstance().options.togglePlayerModelPart(
                        PlayerModelPart.JACKET,
                        !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                );
                if (skin_key_jacket.equals(skin_key_right_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE)
                    );
                }
                if (skin_key_jacket.equals(skin_key_left_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                    );
                }
                if (skin_key_jacket.equals(skin_key_right_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                    );
                }
                if (skin_key_jacket.equals(skin_key_left_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                    );
                }
                if (skin_key_jacket.equals(skin_key_cape)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.CAPE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                    );
                }
            }
            // On/off body
            /*while (skin_key_jacket.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(
                PlayerModelPart.JACKET,
                !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(
                PlayerModelPart.JACKET)
                );
            }*/
            // On/off Right hand
            while (skin_key_right_sleeve.wasPressed()) {
                if (skin_key_right_sleeve.equals(skin_key_hat)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.HAT,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                    );
                }
                if (skin_key_right_sleeve.equals(skin_key_jacket)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.JACKET,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                    );
                }
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
                if (skin_key_right_sleeve.equals(skin_key_left_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                    );
                }
                if (skin_key_right_sleeve.equals(skin_key_right_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                    );
                }
                if (skin_key_right_sleeve.equals(skin_key_left_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                    );
                }
                if (skin_key_right_sleeve.equals(skin_key_cape)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.CAPE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                    );
                }
            }
            // On/off left hand
            while (skin_key_left_sleeve.wasPressed()) {
                if (skin_key_left_sleeve.equals(skin_key_hat)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.HAT,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                    );
                }
                if (skin_key_left_sleeve.equals(skin_key_jacket)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.JACKET,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                    );
                }
                if (skin_key_left_sleeve.equals(skin_key_right_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE)
                    );
                }
                MinecraftClient.getInstance().options.togglePlayerModelPart(
                        PlayerModelPart.LEFT_SLEEVE,
                        !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                );
                if (skin_key_left_sleeve.equals(skin_key_right_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                    );
                }
                if (skin_key_left_sleeve.equals(skin_key_left_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                    );
                }
                if (skin_key_left_sleeve.equals(skin_key_cape)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.CAPE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                    );
                }
            }
            // On/off Right leg
            while (skin_key_right_pains_leg.wasPressed()) {
                if (skin_key_right_pains_leg.equals(skin_key_hat)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.HAT,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                    );
                }
                if (skin_key_right_pains_leg.equals(skin_key_jacket)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.JACKET,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                    );
                }
                if (skin_key_right_pains_leg.equals(skin_key_right_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE)
                    );
                }
                if (skin_key_right_pains_leg.equals(skin_key_left_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                    );
                }
                MinecraftClient.getInstance().options.togglePlayerModelPart(
                        PlayerModelPart.RIGHT_PANTS_LEG,
                        !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                );
                if (skin_key_right_pains_leg.equals(skin_key_left_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                    );
                }
                if (skin_key_right_pains_leg.equals(skin_key_cape)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.CAPE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                    );
                }
            }
            // On/off left leg
            while (skin_key_left_pains_leg.wasPressed()) {
                if (skin_key_left_pains_leg.equals(skin_key_hat)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.HAT,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                    );
                }
                if (skin_key_left_pains_leg.equals(skin_key_jacket)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.JACKET,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                    );
                }
                if (skin_key_left_pains_leg.equals(skin_key_right_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE)
                    );
                }
                if (skin_key_left_pains_leg.equals(skin_key_left_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                    );
                }
                if (skin_key_left_pains_leg.equals(skin_key_right_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                    );
                }
                MinecraftClient.getInstance().options.togglePlayerModelPart(
                        PlayerModelPart.LEFT_PANTS_LEG,
                        !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                );
                if (skin_key_left_pains_leg.equals(skin_key_cape)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.CAPE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                    );
                }
            }
            // On/off cape
            while (skin_key_cape.wasPressed()) {
                if (skin_key_cape.equals(skin_key_hat)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.HAT,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT)
                    );
                }
                if (skin_key_cape.equals(skin_key_jacket)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.JACKET,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET)
                    );

                }
                if (skin_key_cape.equals(skin_key_right_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE)
                    );
                }
                if (skin_key_cape.equals(skin_key_left_sleeve)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_SLEEVE,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE)
                    );
                }
                if (skin_key_cape.equals(skin_key_right_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.RIGHT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG)
                    );
                }
                if (skin_key_cape.equals(skin_key_left_pains_leg)) {
                    MinecraftClient.getInstance().options.togglePlayerModelPart(
                            PlayerModelPart.LEFT_PANTS_LEG,
                            !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG)
                    );
                }
                MinecraftClient.getInstance().options.togglePlayerModelPart(
                        PlayerModelPart.CAPE,
                        !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)
                );
            }
        });
    }
}
