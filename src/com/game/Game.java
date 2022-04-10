package com.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    public static final int tileFieldWidth = 10, tileFieldHeight = 10;

    private Thread thread;
    private boolean running = false;

    private final Handler handler;
    private final Field field;

    double interpolation = 0;
    final int TICKS_PER_SECOND = 1;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    public Game() {
        handler = new Handler();

        field = new Field(0, 0, tileFieldWidth, tileFieldHeight, handler);

        int magic = WIDTH / tileFieldWidth;
        MyMouseListener mml = new MyMouseListener(field);
        MyKeyListener mkl = new MyKeyListener(field);

        new Window(magic * tileFieldWidth, (HEIGHT / magic) * magic, "game", this);
        this.addMouseListener(mml);
        this.addKeyListener(mkl);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        gameLoop2();
    }

    public void gameLoop1(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            while (delta >= 1){
                tick();
                delta --;
            }
            if (running)
                render();
            frames ++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("fps: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public void gameLoop2() {
        double next_game_tick = System.currentTimeMillis();
        int loops;

        while (running) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick
                    && loops < MAX_FRAMESKIP) {

                tick();

                next_game_tick += SKIP_TICKS;
                loops++;
            }

            interpolation = (System.currentTimeMillis() + SKIP_TICKS - next_game_tick
                    / (double) SKIP_TICKS);
            render();
        }
    }

    private void tick(){
        handler.tick();
        field.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        field.render(g);

        g.dispose();
        bs.show();

    }

    public static float clamp(float var, float min, float max){
        if (var >= max)
            return max;
        else if (var <= min)
            return min ;
        else
            return var;
    }

    public static void main(String[] args) {
        new Game();

    }
}
