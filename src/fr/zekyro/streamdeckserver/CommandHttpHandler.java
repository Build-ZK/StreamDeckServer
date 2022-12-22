package fr.zekyro.streamdeckserver;

import com.sun.net.httpserver.HttpExchange;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CommandHttpHandler implements com.sun.net.httpserver.HttpHandler {
    private Robot robot;

    public CommandHttpHandler() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(HttpExchange exchange) {
        if ("GET".equals(exchange.getRequestMethod())) {
            String input = exchange.getRequestURI().toString().replaceFirst("/request\\?key=", "");
            exchange.close();
            switch (input) {
                case "start":
                    System.out.println("Start stream");
                    toggleKeys(KeyEvent.VK_S, KeyEvent.VK_T, KeyEvent.VK_A);
                    break;
                case "stop":
                    System.out.println("Stop stream");
                    toggleKeys(KeyEvent.VK_S, KeyEvent.VK_T, KeyEvent.VK_O);
                    break;
                case "micro":
                    System.out.println("Toggle micro");
                    toggleKeys(KeyEvent.VK_M, KeyEvent.VK_I, KeyEvent.VK_C);
                    break;
                case "casque":
                    System.out.println("Toggle casque");
                    toggleKeys(KeyEvent.VK_C, KeyEvent.VK_A, KeyEvent.VK_S);
                    break;
                case "webcam":
                    System.out.println("Toggle webcam");
                    toggleKeys(KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_B);
                    break;
                case "debut":
                    System.out.println("Scene debut");
                    toggleKeys(KeyEvent.VK_D, KeyEvent.VK_E, KeyEvent.VK_B);
                    break;
                case "game":
                    System.out.println("Scene game");
                    toggleKeys(KeyEvent.VK_G, KeyEvent.VK_A, KeyEvent.VK_M);
                    break;
                case "chat":
                    System.out.println("Scene chat");
                    toggleKeys(KeyEvent.VK_C, KeyEvent.VK_H, KeyEvent.VK_A);
                    break;
                case "pause":
                    System.out.println("Scene pause");
                    toggleKeys(KeyEvent.VK_P, KeyEvent.VK_A, KeyEvent.VK_U);
                    break;
                case "fin":
                    System.out.println("Scene fin");
                    toggleKeys(KeyEvent.VK_F, KeyEvent.VK_I, KeyEvent.VK_N);
                    break;
            }
        }
    }

    public void toggleKeys(int... key){
        for (int k : key) {
            robot.keyPress(k);
        }
        for (int j : key) {
            robot.keyRelease(j);
        }
    }
}
