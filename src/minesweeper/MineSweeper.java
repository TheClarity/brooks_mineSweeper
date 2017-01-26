/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.*;

/**
 *
 * @author Clarity
 */
public class MineSweeper {

    static Node a0, a1, a2, a3, a4, a5, a6, a7, a8;
    static Node b0, b1, b2, b3, b4, b5, b6, b7, b8;
    static Node c0, c1, c2, c3, c4, c5, c6, c7, c8;
    static Node d0, d1, d2, d3, d4, d5, d6, d7, d8;
    static Node e0, e1, e2, e3, e4, e5, e6, e7, e8;
    static Node f0, f1, f2, f3, f4, f5, f6, f7, f8;
    static Node g0, g1, g2, g3, g4, g5, g6, g7, g8;
    static Node h0, h1, h2, h3, h4, h5, h6, h7, h8;
    static Node i0, i1, i2, i3, i4, i5, i6, i7, i8;
    public static int player;

    static Node[][] board = {
        {a0, a1, a2, a3, a4, a5, a6, a7, a8},
        {b0, b1, b2, b3, b4, b5, b6, b7, b8},
        {c0, c1, c2, c3, c4, c5, c6, c7, c8},
        {d0, d1, d2, d3, d4, d5, d6, d7, d8},
        {e0, e1, e2, e3, e4, e5, e6, e7, e8},
        {f0, f1, f2, f3, f4, f5, f6, f7, f8},
        {g0, g1, g2, g3, g4, g5, g6, g7, g8},
        {h0, h1, h2, h3, h4, h5, h6, h7, h8},
        {i0, i1, i2, i3, i4, i5, i6, i7, i8}
    };
    public static final int h = 9;
    public static final int w = 9;

    public static void main(String[] args) {
        // TODO code application logic here
        init();
        mines();

        print();
    }

    public static void init() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = new Node();
            }
        }
        for (int i = 0; i < h; i++) {//height
            for (int j = 0; j < w; j++) {//width
                boolean up = false, down = false, left = false, right = false;
                if (i < h - 1) {//if not bottom
                    down = true;
                    board[i][j].setD(board[i + 1][j]);
                }
                if (j < w - 1) {//if not right
                    right = true;
                    board[i][j].setR(board[i][j + 1]);

                }
                if (i != 0) {//if not top
                    up = true;
                    board[i][j].setU(board[i - 1][j]);

                }
                if (j != 0) {//if not left
                    left = true;
                    board[i][j].setL(board[i][j - 1]);
                }

                if (up && left) {
                    board[i][j].setUl(board[i - 1][j - 1]);
                }
                if (up && right) {
                    board[i][j].setUr(board[i - 1][j + 1]);
                }
                if (down && left) {
                    board[i][j].setDl(board[i + 1][j - 1]);
                }
                if (down && right) {
                    board[i][j].setDr(board[i + 1][j + 1]);
                }

            }
        }
    }

    public static void mines() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int tempX = rand.nextInt(w - 1) + 1;
            int tempY = rand.nextInt(h - 1) + 1;
            board[tempY][tempX].v = 10;
            numbers(tempX, tempY);
        }
    }

    public static void numbers(int x, int y) {
        if (board[y][x].u != null && board[y][x].u.v != 10) {
            board[y][x].u.v++;
        }
        if (board[y][x].d != null && board[y][x].d.v != 10) {
            board[y][x].d.v++;
        }
        if (board[y][x].l != null && board[y][x].l.v != 10) {
            board[y][x].l.v++;
        }
        if (board[y][x].r != null && board[y][x].r.v != 10) {
            board[y][x].r.v++;
        }
        if (board[y][x].ul != null && board[y][x].ul.v != 10) {
            board[y][x].ul.v++;
        }
        if (board[y][x].ur != null && board[y][x].ur.v != 10) {
            board[y][x].ur.v++;
        }
        if (board[y][x].dr != null && board[y][x].dr.v != 10) {
            board[y][x].dr.v++;
        }
        if (board[y][x].dl != null && board[y][x].dl.v != 10) {
            board[y][x].dl.v++;
        }

    }

    public static void print() {
        System.out.print(" A  B  C  D  E  F  G  H  I");
        System.out.println("");
        for (int i = 0; i < h; i++) {
            System.out.print(i); 
            for (int j = 0; j < w; j++) {
                if(!board[i][j].hidden){
                if (board[i][j].v == 10) {
                    System.out.print("m ");
                } else {
                    System.out.print(board[i][j].v + " ");
                }
                }
                else{
                    System.out.print("██ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
