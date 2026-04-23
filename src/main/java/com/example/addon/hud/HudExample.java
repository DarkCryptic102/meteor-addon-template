package com.example.addon.hud;

import com.example.addon.AddonTemplate;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class HudExample extends HudElement {

    public static final HudElementInfo<HudExample> INFO =
        new HudElementInfo<>(AddonTemplate.HUD_GROUP, "dyselexia", "HUD element.", HudExample::new);

    public HudExample() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        String text = "D Y S E L E X I A";

        double scale = 2.0;

        double width = renderer.textWidth(text, true) * scale;
        double height = renderer.textHeight(true) * scale;

        double xPos = x;
        double yPos = y;

        // Blue background (client style bar)
        renderer.quad(
            xPos - 4,
            yPos - 4,
            width + 8,
            height + 8,
            new Color(0, 90, 255, 180)
        );

        // White "Impact-style" text (bold feel via scale + spacing)
        renderer.text(
            text,
            xPos,
            yPos,
            new Color(255, 255, 255, 255),
            true,
            scale
        );

        setSize(width, height);
    }
}
