package Command;

import java.awt.*;

public class DrawCommand implements Command {
    // 그림 그리기 대상
    protected Drawable drawable;
    // 그림 그리기 위치
    private Point position;
    private Color color;
    // 생성자
    public DrawCommand(Drawable drawable, Point position, Color color) {
        this.drawable = drawable;
        this.position = position;
        this.color=color;
    }
    // 실행
    public void execute() {
        drawable.draw(position.x, position.y,color);
    }
}