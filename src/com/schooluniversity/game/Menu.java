package com.schooluniversity.game;

import com.schooluniversity.images.ImageCreator;
import com.schooluniversity.images.Images;
import com.schooluniversity.variables.ConstantVariables;

import java.awt.*;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {

    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 60;
    private static final String PLAY = "PLAY";
    private static final String HELP = "HELP";
    private static final String QUIT = "QUIT";
    private static final String MENU = "MENU";
    private static final String BACK = "BACK";
    private Font font;
    private Font fontMenu;
    private GameMainPanel game;
    //private State state;


   public Menu(GameMainPanel game){

       this.game = game;
       initVar();
   }

    private void initVar() {
       this.font = new Font("Gotham", Font.BOLD, 30);
       this.fontMenu = new Font("Gotham", Font.BOLD, 50);

    }


    public void mousePressed(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        //boolean mousePressed = mouseOver(mouseX,mouseY,ConstantVariables.BOARD_WIDTH/2 -100,200,BUTTON_WIDTH,BUTTON_HEIGHT);

        //PLAY Button
        if(mouseOver(mouseX,mouseY,ConstantVariables.BOARD_WIDTH/2 -100,200,BUTTON_WIDTH,BUTTON_HEIGHT)) {
            this.game.setGameState(State.GAME);
           // game.gameState = State.GAME;
            System.out.println(game.getGameState());
            //this.setState(State.GAME);
        }
        //HELP Button
        if(mouseOver(mouseX,mouseY,ConstantVariables.BOARD_WIDTH/2 -100,300,BUTTON_WIDTH,BUTTON_HEIGHT)){
            this.game.setGameState(State.HELP);
            System.out.println(game.getGameState());
        }
        //BACK Button
        if(game.getGameState() == State.HELP){
            if(mouseOver(mouseX,mouseY,100,ConstantVariables.BOARD_HEIGHT-100,100,40)){
                this.game.setGameState(State.MENU);
                System.out.println("Back Button Pressed");
                System.out.println(game.getGameState());
                return;
            }
        }

        if(game.getGameState() == State.HELP){
            if(mouseOver(mouseX, mouseY,ConstantVariables.BOARD_WIDTH -200,ConstantVariables.BOARD_HEIGHT -100,100,40 )){
                this.game.setGameState(State.GAME);
                System.out.println("Help/Play Button Pressed");
            }
        }
        //QUIT Button
        if(mouseOver(mouseX,mouseY,ConstantVariables.BOARD_WIDTH/2 -100,400,BUTTON_WIDTH,BUTTON_HEIGHT)){
            System.exit(1);
        }

    }


    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my,int x, int y, int width, int height ){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }


    public void render(Graphics g){

       if(game.getGameState() == State.MENU){
          // Font font = new Font("Gotham", Font.BOLD, 30);
           FontMetrics fontMetrics = g.getFontMetrics(font);
          // Font fontMenu = new Font("Gotham", Font.BOLD, 50);
           FontMetrics fontMenuMetrics = g.getFontMetrics(fontMenu);

           //The BackGroundMenu
           g.setColor(Color.BLACK);
           g.fillRect(0,0,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12);
           g.drawImage(ImageCreator.createImg(Images.MENUBACKGROUND).getImage(),0,0,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12,null);

           //The Menu
           g.setFont(fontMenu);
           g.setColor(Color.YELLOW);
           g.drawString(MENU, ConstantVariables.BOARD_WIDTH / 2 - fontMenuMetrics.stringWidth(MENU) /2,135 );

           //The Play Button
           g.setColor(Color.white);
           g.drawRect(ConstantVariables.BOARD_WIDTH/2 -100,200,BUTTON_WIDTH,BUTTON_HEIGHT);
           g.setColor(Color.BLUE);
           g.fillRect(ConstantVariables.BOARD_WIDTH/2 -97,202,BUTTON_WIDTH-6,BUTTON_HEIGHT-5);
           g.setFont(font);
           g.setColor(Color.YELLOW);
           g.drawString(PLAY, ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(PLAY) /2,240 );

           //The Help Button
           g.setColor(Color.white);
           g.drawRect(ConstantVariables.BOARD_WIDTH/2 -100,300,BUTTON_WIDTH,BUTTON_HEIGHT);
           g.setColor(Color.BLUE);
           g.fillRect(ConstantVariables.BOARD_WIDTH/2 -97,302,BUTTON_WIDTH-6,BUTTON_HEIGHT-5);
           g.setColor(Color.YELLOW);
           g.drawString(HELP,ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(HELP) /2,340 );

           //The Quit Button
           g.setColor(Color.white);
           g.drawRect(ConstantVariables.BOARD_WIDTH/2 -100,400,BUTTON_WIDTH,BUTTON_HEIGHT);
           g.setColor(Color.BLUE);
           g.fillRect(ConstantVariables.BOARD_WIDTH/2 -97,402,BUTTON_WIDTH-6,BUTTON_HEIGHT-5);
           g.setColor(Color.YELLOW);
           g.drawString(QUIT,ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(QUIT) /2,440 );
           game.repaint();
       }
       else if(game.getGameState() == State.HELP){

           Font font = new Font("Gotham", Font.BOLD, 30);
           FontMetrics fontMetrics = g.getFontMetrics(font);
           Font fontMenu = new Font("Gotham", Font.BOLD, 50);
           FontMetrics fontMenuMetrics = g.getFontMetrics(fontMenu);
           //The entire board
           g.setColor(Color.BLACK);
           g.fillRect(0,0,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12);
           g.drawImage(ImageCreator.createImg(Images.MENUHELP).getImage(),0,0,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12,null);

//           g.setFont(fontMenu);
//           g.setColor(Color.YELLOW);
//           g.drawString(HELP, ConstantVariables.BOARD_WIDTH / 2 - fontMenuMetrics.stringWidth(HELP) /2,135 );

           g.setColor(Color.white);
           g.drawRect(100,ConstantVariables.BOARD_HEIGHT -100,100,40);
           g.setColor(Color.BLUE);
           g.fillRect(102,ConstantVariables.BOARD_HEIGHT -98,98,38);
           g.setColor(Color.YELLOW);
           g.setFont(font);
           g.drawString(BACK,108,ConstantVariables.BOARD_HEIGHT-70);
           g.setColor(Color.white);
           g.drawRect(ConstantVariables.BOARD_WIDTH -200,ConstantVariables.BOARD_HEIGHT -100,100,40);
           g.setColor(Color.BLUE);
           g.fillRect(ConstantVariables.BOARD_WIDTH -198,ConstantVariables.BOARD_HEIGHT -98,98,38);
           g.setFont(font);
           g.setColor(Color.YELLOW);
           g.drawString(PLAY,ConstantVariables.BOARD_WIDTH -190,ConstantVariables.BOARD_HEIGHT-70);
           game.repaint();
       }



    }


}
