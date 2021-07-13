package com.schooluniversity.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.schooluniversity.events.GameListener;
import com.schooluniversity.images.ImageCreator;
import com.schooluniversity.images.Images;
import com.schooluniversity.objects.Bomb;
import com.schooluniversity.objects.Bullet;
import com.schooluniversity.objects.EnemyShip;
import com.schooluniversity.objects.PlayerShip;
import com.schooluniversity.sounds.SoundCreator;
import com.schooluniversity.variables.ConstantVariables;

public class GameMainPanel extends JPanel {

    private ImageIcon backGroundImage;
    private SoundCreator sounds;
    private Timer timer;// javax.swing timer not java.util
    private PlayerShip playerShip;
    private boolean inGame = true;
    private Bullet bullet;
    private int direction = 1;
    private List<EnemyShip> enemies;
    private List<Bomb> enemyBombs;
    private Random gen;
    private String message;
    private int enemyDeaths;
    private int score;
    private int life = 3;
    private int health = 150;
    //**************CHANGES*********************
    private State gameState;
    private Menu menu;
    private boolean onPause;
    private int ammo = 40;
    //*****************************************
    private int imgY = 0;
    private int relY;



    public GameMainPanel() {

        initVar();
        //if(gameState == State.GAME)
        init();
        initGame();

    }


    private void initGame() {
        for (int i = 0; i < ConstantVariables.ENEMYSHIPS_ROW; i++) {
            for (int j = 0; j < ConstantVariables.ENEMYSHIPS_COLUMN; j++) {

                EnemyShip enemy = new EnemyShip(ConstantVariables.ENEMYSHIP_INIT_X + 50 * j,
                        ConstantVariables.ENEMYSHIP_INIT_Y + 50 * i);
                // enemies.add(new EnemyShip(x, y))
                this.enemies.add(enemy);
            }
        }

    }

    private void initVar() {
        this.menu = new Menu(this);//latest change
        this.gameState = State.MENU;
        this.onPause = true;
        //this.addMouseListener(menu);
        //************************************
        this.sounds = new SoundCreator();
        this.gen = new Random();
        this.enemyBombs = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.backGroundImage = ImageCreator.createImg(Images.BACKGROUND);
        this.playerShip = new PlayerShip();
        this.bullet = new Bullet();
        this.timer = new Timer(ConstantVariables.GAMESPEED, new GameCore(this));
        this.timer.start();

    }

    private void init() {
        this.addMouseListener(menu);
        addKeyListener(new GameListener(this));
        setFocusable(true);
        setPreferredSize(new Dimension(ConstantVariables.BOARD_WIDTH, ConstantVariables.BOARD_HEIGHT));

    }

    // Drawing*****************************************************************************************
    private void drawPlayerShip(Graphics g) {
        g.drawImage(playerShip.getImage(), playerShip.getX(), playerShip.getY(), null);
    }

    private void drawBullet(Graphics g) {
        if (!bullet.isDead()) {
            g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
        }
    }

    private void drawEnemies(Graphics g) {

        for (EnemyShip enemy : this.enemies) {
            if (enemy.isVisible()) {
                g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), null);
            }

        }
    }

    private void drawBombs(Graphics g) {
        // TODO Auto-generated method stub
        for (Bomb bomb : this.enemyBombs) {
            if (!bomb.isDead()) {
                g.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
            }
        }
    }

    private void drawGameOverStats(Graphics g) {
       // g.drawImage(backGroundImage.getImage(), 0, 0, null);
        g.drawImage(ImageCreator.createImg(Images.MENUBACKGROUND).getImage(),0,0,912,762,null);
        g.setColor(Color.BLUE);
        g.fillRect(50,200,800,300);
        Font font = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fontMetrics = this.getFontMetrics(font);//
        g.setColor(Color.YELLOW);
        g.setFont(font);
        g.drawString(message, ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(message) / 2, ConstantVariables.BOARD_HEIGHT / 2 - 100);
        Font fontScore = new Font("Helvetica ", Font.BOLD, 20);
        FontMetrics fontScoreMetrics = this.getFontMetrics(fontScore);
        //g.setColor(Color.GREEN);
        String yourScore = "Score : " + score;
        g.drawString(yourScore, ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(yourScore) / 2, ConstantVariables.BOARD_HEIGHT / 2 - 50);
        String ammoLeft = "Bullets left : "+ammo;
        g.drawString(ammoLeft, ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(ammoLeft) / 2, ConstantVariables.BOARD_HEIGHT / 2 );
        String stats = "Enemies killed : " + this.enemyDeaths + " out of " + this.enemies.size();
        g.drawString(stats, ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(stats) / 2, ConstantVariables.BOARD_HEIGHT / 2+50);
        String playAgain = "Press Enter to play again!";
        g.drawString(playAgain, ConstantVariables.BOARD_WIDTH / 2 - fontMetrics.stringWidth(playAgain) / 2, ConstantVariables.BOARD_HEIGHT / 2 +100);


    }

    private void drawScore(Graphics g) {

        Font font = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fontMetrics = this.getFontMetrics(font);
        g.setColor(Color.BLUE);
        g.fillRect(40,20,850,40);
        g.setColor(Color.YELLOW);
        g.setFont(font);
        g.drawString("life : " , 50, 50);
        g.setColor(Color.gray);
        g.fillRect(150, 30, 150, 20);
//        g.setColor(Color.GREEN);
//        g.fillRect(150, 30, this.health, 20);
        if(this.health > 50){
            g.setColor(Color.GREEN);
            g.fillRect(150, 30, this.health, 20);
        }else if(this.health <= 50){
            g.setColor(Color.RED);
            g.fillRect(150, 30, this.health, 20);
        }

        g.setColor(Color.YELLOW);
        g.drawString("Ammo :",350,50);
        g.setColor(Color.gray);
        g.fillRect(450, 30, 150, 20);
        if(this.ammo > 35){
            g.setColor(Color.GREEN);
            g.fillRect(450, 30, 110 + ammo, 20);
        }else if(this.ammo <= 35 && this.ammo >= 10){
            g.setColor(Color.YELLOW);
            g.fillRect(450, 30, 110 + ammo, 20);
        }else if(this.ammo <= 10) {
            g.setColor(Color.RED);
            g.fillRect(450, 30, 110 + ammo, 20);
        }
        g.setColor(Color.YELLOW);
        g.drawString("Score : " + score, ConstantVariables.BOARD_WIDTH - 150, 50);
        g.setColor(Color.BLUE);
        g.fillRect(40,ConstantVariables.BOARD_HEIGHT -65,fontMetrics.stringWidth("Press ESC to pause ")+20,40);
        g.setColor(Color.YELLOW);
        if(this.onPause){
            g.drawString("Press ESC to play ",50, ConstantVariables.BOARD_HEIGHT -40);
        }else if(!this.onPause){
            g.drawString("Press ESC to pause ",50, ConstantVariables.BOARD_HEIGHT -40);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(backGroundImage.getImage(), 0, 0,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12, null);
        g.drawImage(backGroundImage.getImage(), 0, this.relY-ConstantVariables.BOARD_HEIGHT,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12, null);
        if(relY < ConstantVariables.BOARD_HEIGHT){
            g.drawImage(backGroundImage.getImage(), 0, this.relY,ConstantVariables.BOARD_WIDTH+12,ConstantVariables.BOARD_HEIGHT+12, null);
            //System.out.println(backGroundImage.getDescription());
        }
        // System.out.println("Repainting");
        drawEverything(g);
        drawMenu(g);
        //System.out.println(this.getGameState());
    }

    private void drawMenu(Graphics g) {
        if (this.gameState == State.MENU || this.gameState == State.HELP) {
            this.menu.render(g);
        }
    }

    private void drawEverything(Graphics g) {
        // doDrawing
        if (inGame) {
            drawScore(g);
            drawPlayerShip(g);
            drawBullet(g);
            drawEnemies(g);
            drawBombs(g);
        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
            drawGameOverStats(g);
            Toolkit.getDefaultToolkit().sync();
        }

    }


    public void render() {
        // doOneLoop
        if (gameState == State.GAME || gameState == State.HELP) {
            //Aici a fost ceva , stai cu ochii pe gameState
            if(!onPause) {
                update();
            }
            repaint();
        }
    }

    private void update() {

       //Scrolling BackGround*****************************
        this.relY = imgY % ConstantVariables.BOARD_HEIGHT;
        imgY += 1;
       //*************************************************

        if (playerShip.isDead()) {
            inGame = false;
            message = ConstantVariables.GAMEOVER;
        }

        if (enemyDeaths == enemies.size()) {
            inGame = false;
            message = ConstantVariables.GAMEWON;
        }

        if(ammo <= 0){
            inGame = false;
            message = ConstantVariables.GAMELOST;
        }

        this.playerShip.move();

        if (!bullet.isDead()) {
            //bullet coordinates
            int bulletX = bullet.getX();
            int bulletY = bullet.getY();

            for (EnemyShip enemyUfo : enemies) {
                //enemy coordinates
                int ufoX = enemyUfo.getX();
                int ufoY = enemyUfo.getY();
                if (!enemyUfo.isVisible()) continue;
                // to check collision detection with the rectangle class
                if (bulletX >= (ufoX) && bulletX <= (ufoX + ConstantVariables.ENEMYSHIP_WIDTH) && bulletY >= (ufoY)
                        && bulletY <= (ufoY + ConstantVariables.ENEMYSHIP_HEIGHT)) {
                    enemyUfo.setVisible(false);
                    bullet.kill();
                    enemyDeaths++;
                    //sounds.explosion();
                    score += 10;
                }
            }


            this.bullet.move();
            if(bullet.getY() < 0 || bullet.isDead()){
                this.ammo -= 1;
                System.out.println("Ammo : "+ammo);
            }
        }

        for (EnemyShip enemy : this.enemies) {
            if (enemy.isVisible()) {
                if (enemy.getX() >= ConstantVariables.BOARD_WIDTH - 2 * ConstantVariables.BORDERPADDING && direction != -1 ||
                        enemy.getX() <= 0 + ConstantVariables.BORDERPADDING && direction != 1) {
                    direction *= -1;
                    Iterator<EnemyShip> alienIterator = enemies.iterator();
                    while (alienIterator.hasNext()) {
                        EnemyShip alien = alienIterator.next();
                        alien.setY(alien.getY() + ConstantVariables.DOWN);
                    }
                    //direction = -1;
                }
//				if (enemy.getX() <= 0 +ConstantVariables.BORDERPADDING && direction != 1) {
//					direction = 1;
//				}
                enemy.move(direction);
                if (enemy.getY() > ConstantVariables.BOARD_HEIGHT - 100) {
                    playerShip.kill();
                }
            }
        }
        for (EnemyShip alienShip : this.enemies) {
            if (alienShip.isVisible() && gen.nextDouble() < ConstantVariables.BOMBPROB) {
                Bomb bmb = new Bomb(alienShip.getX(), alienShip.getY());
                this.enemyBombs.add(bmb);
//				if(!bmb.isDead()) {
//					bmb.move();
//				}
            }
        }

        for (Bomb bomb : this.enemyBombs) {

            int bombX = bomb.getX();
            int bombY = bomb.getY();

            int playerX = playerShip.getX();
            int playerY = playerShip.getY();

            if (!bomb.isDead() && !playerShip.isDead()) {

                if (bombX >= (playerX) && bombX <= (playerX + ConstantVariables.PLAYERSHIP_WIDTH) && bombY >= (playerY)
                        && bombY <= (playerY + ConstantVariables.PLAYERSHIP_HEIGHT)) {
                    bomb.kill();
                    life--;
                    health -= 50;
                    if (life <= 0)
                        playerShip.kill();
                }

            }
            bomb.move();
        }
        // System.out.println("Updateing");
        // can init a new method here , such as initEnenemyMovement instead of this mess
    }

    //*********************Key Adapter**************************************
    public void keyPressed(KeyEvent e) {

        this.playerShip.keyPressed(e);

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            int buletX = this.playerShip.getX();
            int bulletY = this.playerShip.getY();
            if (inGame && bullet.isDead()) {
                //sounds.bullet();
                bullet = new Bullet(buletX, bulletY);
            }
        }
        if(key == KeyEvent.VK_ENTER){
            this.setGameState(State.MENU);
            System.out.println("gamestate:"+this.getGameState());

//            this.inGame = true;
//            this.life = 3;
//            this.ammo = 45;
//            this.enemies.clear();
//            this.enemyBombs.clear();
//            this.score = 0;
//            initVar();
//            init();
//            initGame();
//            update();
            repaint();


        }

        if(onPause){
            if(key == KeyEvent.VK_ESCAPE) onPause = false;
        }else if(!onPause){
            if(key == KeyEvent.VK_ESCAPE) onPause = true;
        }
    }

    public void keyReleased(KeyEvent e) {

        this.playerShip.keyReleased(e);
    }
// Getters and Setters

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    public State getGameState() {return gameState; }

}
