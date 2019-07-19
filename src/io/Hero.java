package io;

import java.io.Serializable;

public class Hero implements Serializable {
    private static final long serialVersionUID = 1L;
    public int hp;

    public Hero(int hp) {
        this.hp = hp;
    }
}
