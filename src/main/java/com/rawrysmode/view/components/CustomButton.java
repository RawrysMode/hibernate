package com.rawrysmode.view.components;

import com.rawrysmode.assets.colors.CustomColors;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CustomButton extends JButton implements ChangeListener {

    private final Color BUTTON_ROLLOVER_COLOR = new Color(0x4c5052);
    private final Color BUTTON_PRESSED_BUTTON = new Color(0x5c6164);

    public CustomButton(String text, String font) {
        super(text);
        setFont(new Font(font, Font.PLAIN, 12));
        initializeModel();
    }

    public CustomButton(String text, String font, int width, int height, boolean zeroMargin) {
        this(text, font);
        if (zeroMargin) setMargin(new Insets(0, 0, 0, 0));
        setPreferredSize(new Dimension(width, height));
        getModel().addChangeListener(this);
    }

    private void initializeModel() {
        setForeground(CustomColors.LIGHT_GREY_COLOR);
        setBackground(CustomColors.GREY_COLOR);

        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel buttonModel = getModel();
        if (buttonModel.isPressed()) {
            setBackground(BUTTON_PRESSED_BUTTON);
        } else if (buttonModel.isRollover()) {
            setBackground(BUTTON_ROLLOVER_COLOR);
        } else {
            setBackground(CustomColors.GREY_COLOR);
        }
    }

}
