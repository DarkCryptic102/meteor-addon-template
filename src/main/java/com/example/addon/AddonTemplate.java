package com.example.addon;

import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import org.slf4j.Logger;

public class AddonTemplate extends MeteorAddon {

    public static final Logger LOG = LogUtils.getLogger();

    public static final Category CATEGORY = new Category("Dyselexia");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Dyselexia Addon");
    }

    @Override
    public void onRegisterCategories() {
        meteordevelopment.meteorclient.systems.modules.Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("YOUR_GITHUB_USERNAME", "YOUR_REPO_NAME");
    }
}
