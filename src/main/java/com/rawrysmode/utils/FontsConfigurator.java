package com.rawrysmode.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FontsConfigurator {

    public FontsConfigurator() {
        final GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final ArrayList<String> AVAILABLE_FONT_FAMILY_NAMES = new ArrayList<>(Arrays.asList(GE.getAvailableFontFamilyNames()));

        try {
            final ArrayList<File> list = new ArrayList<>(Arrays.asList(
                    new File("src/main/java/com/rawrysmode/assets/fonts/JetBrainsMono-Bold.ttf"),
                    new File("src/main/java/com/rawrysmode/assets/fonts/JetBrainsMono-ExtraBold.ttf"),
                    new File("src/main/java/com/rawrysmode/assets/fonts/JetBrainsMono-ExtraLight.ttf"),
                    new File("src/main/java/com/rawrysmode/assets/fonts/JetBrainsMono-Light.ttf"),
                    new File("src/main/java/com/rawrysmode/assets/fonts/JetBrainsMono-Medium.ttf"),
                    new File("src/main/java/com/rawrysmode/assets/fonts/JetBrainsMono-Thin.ttf")
            ));

            for (File item : list) {
                if (item.exists()) {
                    Font FONT = Font.createFont(Font.TRUETYPE_FONT, item);
                    if (!AVAILABLE_FONT_FAMILY_NAMES.contains(FONT.getFontName())) {
                        GE.registerFont(FONT);
                    }
                }
            }
        } catch (FontFormatException | IOException exception) {
            exception.printStackTrace();
        }
    }

}
