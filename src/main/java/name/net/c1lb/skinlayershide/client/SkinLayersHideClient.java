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
                "option.skin-key-all",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.all.category"));
        // All no cape
        KeyBinding skin_key_all_no_cape = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-all-no-cape",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.all.category"));
        //Hat
        KeyBinding skin_key_hat = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-hat",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));
        //Body
        KeyBinding skin_key_jacket = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-jacket",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));
        //Right hand
        KeyBinding skin_key_right_sleeve = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-right-sleeve",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));
        //Left hand
        KeyBinding skin_key_left_sleeve = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-left-sleeve",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));
        //Right leg
        KeyBinding skin_key_right_pains_leg = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-right-pains-leg",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));
        //Left leg
        KeyBinding skin_key_left_pains_leg = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-left-pains-leg",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));
        //Cape
        KeyBinding skin_key_cape = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-cape",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-layers-hide.parts.category"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Grups

            // On/off all layers
            while (skin_key_all_no_cape.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.JACKET, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_SLEEVE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.HAT, SkinLayersHideAll[0]);
                SkinLayersHideAll[0] = !SkinLayersHideAll[0];
            }
            //all
            while (skin_key_all.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.CAPE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.JACKET, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_SLEEVE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinLayersHideAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.HAT, SkinLayersHideAll[0]);
                SkinLayersHideAll[0] = !SkinLayersHideAll[0];
            }

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
