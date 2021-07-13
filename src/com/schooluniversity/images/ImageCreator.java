package com.schooluniversity.images;

//import java.awt.Image;

import javax.swing.ImageIcon;

import com.schooluniversity.variables.ConstantVariables;

import java.util.HashMap;
import java.util.Map;

public class ImageCreator {

    public static ImageIcon createImg(Images img) {

        ImageIcon imageIcon = null;

        switch (img) {
            case ENEMY:
                //imageIcon = new ImageIcon(ConstantVariables.ENEMY_IMAGE);
                imageIcon = getRandomImage(img);
                break;
            case BULLET:
                imageIcon = new ImageIcon(ConstantVariables.BULLET_IMAGE);
                break;
            case BOMB:
                imageIcon = new ImageIcon(ConstantVariables.BOMB_IMAGE2);
                break;
            case BACKGROUND:
                imageIcon = new ImageIcon(ConstantVariables.BACKGROUND_IMAGE3);
                //imageIcon = getRandomImage(img);
                break;
            case MENUBACKGROUND:
                imageIcon = new ImageIcon(ConstantVariables.BACKGROUND_IMAGE);
                break;
            case MENUHELP:
                imageIcon = new ImageIcon(ConstantVariables.BACKGROUND_HELP);
                break;
            case PLAYERSHIP:
                //imageIcon = new ImageIcon(ConstantVariables.PLAYERSHIP_IMAGE);
                imageIcon = new ImageIcon(ConstantVariables.PLAYERSHIP_IMAGE2);

                break;

            default:
                return null;
        }

        return imageIcon;
    }


    public static ImageIcon getRandomImage(Images myImage) {

        ImageIcon imageIcon = null;
        //int random = (int) (Math.random() * 4);
        int random = getRandom();
        Map<Integer, String> enemyMap = new HashMap<Integer, String>();
        enemyMap.put(0, ConstantVariables.ENEMY_IMAGE);
        enemyMap.put(1, ConstantVariables.ENEMY_IMAGE2);
        enemyMap.put(2, ConstantVariables.ENEMY_IMAGE3);
        enemyMap.put(3, ConstantVariables.ENEMY_IMAGE4);
        enemyMap.put(4, ConstantVariables.ENEMY_IMAGE5);
        enemyMap.put(5, ConstantVariables.ENEMY_IMAGE6);
        enemyMap.put(6, ConstantVariables.ENEMY_IMAGE7);

        int rand = (int) (Math.random() * 7);

        Map<Integer, String> bkMap = new HashMap<Integer, String>();
        bkMap.put(0, ConstantVariables.BACKGROUND_IMAGE);
        bkMap.put(1, ConstantVariables.BACKGROUND_IMAGE2);
        bkMap.put(2, ConstantVariables.BACKGROUND_IMAGE3);
        bkMap.put(3, ConstantVariables.BACKGROUND_IMAGE4);
       // bkMap.put(4, ConstantVariables.BACKGROUND_IMAGE5);
      //  bkMap.put(5, ConstantVariables.BACKGROUND_IMAGE6);
       // bkMap.put(6, ConstantVariables.BACKGROUND_IMAGE7);


        switch (myImage) {
            case ENEMY:
                imageIcon = new ImageIcon(enemyMap.get(random));
                break;
            case BACKGROUND:
                imageIcon = new ImageIcon(bkMap.get(rand));
                break;
        }
        return imageIcon;
    }

    public static int getRandom() {
        int rand = (int) (Math.random() * 4);
        return rand;
    }

}
