package com.example.addon.hud;

import com.example.addon.AddonTemplate;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class HudExample extends HudElement {
    public static final HudElementInfo<HudExample> INFO =
        new HudElementInfo<>(AddonTemplate.HUD_GROUP, "example", "HUD element example.", HudExample::new);

    private double tick = 0;

    public HudExample() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        String text = "Dyselexia";

        // Animation (smooth up-down movement)
        tick += 0.05;
        double offsetY = Math.sin(tick) * 5; // bounce effect

        double textWidth = renderer.textWidth(text, true);
        double textHeight = renderer.textHeight(true);

        // Center of screen
        double centerX = mc.getWindow().getScaledWidth() / 2.0;
        double centerY = mc.getWindow().getScaledHeight() / 2.0;

        double drawX = centerX - textWidth / 2;
        double drawY = centerY - textHeight / 2 + offsetY;

        setSize(textWidth, textHeight);

        // Blue color (RGB)
        Color blue = new Color(0, 120, 255, 255);

        // Optional subtle background
        renderer.quad(drawX - 2, drawY - 2, textWidth + 4, textHeight + 4, new Color(0, 0, 0, 80));

        // Draw animated text
        renderer.text(text, drawX, drawY, blue, true);
    }
}
