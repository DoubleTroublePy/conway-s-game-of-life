package com.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class HUD {
    private int settings_x = 5;
    private int settings_y = 5;
    private int settings_w = 25;
    private int settings_h = settings_w;
    private Rectangle settingBox = new Rectangle(settings_x, settings_y, settings_w, settings_h);

    private Image settingImg;

    public HUD(){
        try {
            settingImg = ImageIO.read(new File("src/resources/settings.png"));
            int ratio = settingImg.getWidth(null) / settingImg.getWidth(null);
            settings_h = settings_w / ratio;
            settingImg = settingImg.getScaledInstance(settings_w, settings_w * ratio, Image.SCALE_DEFAULT);
            settingBox = new Rectangle(settings_x, settings_y, settings_w, settings_h);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(settings_x, settings_y, settings_w, settings_h);
        if (settingImg != null) {
            g.drawImage(settingImg, settings_x, settings_y, null);
        }
        g.setColor(Color.GREEN);
        g.drawRect(settings_x, settings_y, settings_w, settings_h);
    }

    public Rectangle getSettingBox() {
        return settingBox;
    }
}
