package lesson20;

import java.io.Serial;
import java.io.Serializable; // интерфейс маркер
import java.util.Objects;
// point (34, 89): serialVersionUID (12) -> file
// file -> point (34, 89): 12 -> ошибка (в версии идеи)
// point (34, 89)

public class Point implements Serializable {
    @Serial // аннотация доступна, начиная с 14 версии
    private static final long serialVersionUID = 1L;
    private int x;
    private int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
