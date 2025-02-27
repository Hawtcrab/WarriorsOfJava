package game;

import game.characters.Player;
import game.gameactions.ActionConditions;
import game.gameactions.GameAction;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static game.Actions.LoadActions;

public class Main {


    public static GUI gui;
    public static final Player PLAYER = new Player();
    public static Area currentArea = new Area();

    public static ArrayDeque<String> lastTells = new ArrayDeque<>();


    public static void main(String[] args) {
        LoadActions();
        gui = new GUI();
    }




}