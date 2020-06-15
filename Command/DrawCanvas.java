package Command;

import javafx.util.Pair;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawCanvas extends Canvas implements Drawable {
    // 그림 그리는 색
    private Color color;
    // 그림 그리는 점의 반경
    private int radius;
    // 이력
    private MacroCommand history;
    private MacroCommand undoHistoryForRedo = new MacroCommand() ;
    // 생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }
    // 이력 전체를 다시 그리기
    public void paint(Graphics g) {
        history.execute();
    }
    //undo
    public void undo(){
        if(history.size()!=0){
            undoHistoryForRedo.append((Command)history.undo());
            this.repaint();
        }
    }
    public void redo() {
        if (undoHistoryForRedo.size() != 0) {
            Command cmd = (Command) undoHistoryForRedo.undo();
            history.append(cmd);
            this.repaint();
        }
    }
    public void clear(){
        undoHistoryForRedo.clear();
    }
    // 그림 그리기
    public void draw(int x, int y,Color color) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    public void init() {
        color = Color.red;
        radius = 6;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
}