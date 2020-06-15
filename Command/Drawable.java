package Command;

import java.awt.*;

public interface Drawable {
    public abstract void init();
    public abstract void draw(int x, int y,Color color);
    public abstract void setColor(Color color);
}