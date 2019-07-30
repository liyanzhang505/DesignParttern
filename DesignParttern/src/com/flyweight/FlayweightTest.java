package com.flyweight;

import java.util.HashMap;

// 享元模式
public class FlayweightTest {
    public static void main(String[] args) {
        Chess chess1  =  ChessFactory.getChess(Color.WHITE, new Point(0,1));
        Chess chess2  =  ChessFactory.getChess(Color.WHITE, new Point(0,2));
        Chess chess3  =  ChessFactory.getChess(Color.WHITE, new Point(0,3));

        Chess chess4  =  ChessFactory.getChess(Color.BLACK, new Point(1,1));
        Chess chess5  =  ChessFactory.getChess(Color.BLACK, new Point(1,2));
        Chess chess6  =  ChessFactory.getChess(Color.BLACK, new Point(1,3));
        
        if( chess1.equals(chess2) && chess1.equals(chess3)) {
            System.out.println("chess1 与 chess2 chess3 是同一个对象");
        } else {
            System.out.println("chess1 与 chess2 chess3 不是同一个对象");
        }
    }
}

enum Color {
    WHITE("White"),
    BLACK("Black");
   
    private String color;
    Color(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return color;
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return String.format("(x:%d,y:%d)", x, y);
    }
}

// 不允许悔棋，所以不提供set接口
interface Chess {
    public void downChess(Point point);
}

// color 相当于内在元素，point相当于外部元素，实体角色必须提供设置外部元素的接口。
class RealChess implements Chess {
    private Color color;
    private Point point;
    
    RealChess(Color color) {
        this.color = color;
    }

    public void downChess(Point point) {
        this.point = point;
        System.out.println(String.format("color:%s, point:%s", color, point));
    }
}


class ChessFactory {
    private static HashMap chessPool = new HashMap<Color, Chess>();
    
    public static Chess getChess(Color color, Point point) {
        if (color==null || point==null) {
            return null;
        }
        
        Chess chess = null;
        if(chessPool.containsKey(color)) {
            chess = (RealChess) chessPool.get(color);
            chess.downChess(point);
        } else {
            chess = new RealChess(color);
            chess.downChess(point);
            chessPool.put(color, chess);
        }

        return chess;
    }
}
