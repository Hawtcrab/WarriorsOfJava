package game;

import game.characters.Player;
import game.gameactions.ActionConditions;
import game.gameactions.GameAction;
import game.location.Station;
import game.location.Stationen;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static game.Actions.LoadActions;

public class Main {


    public static GUI gui;
    public static final Player PLAYER = new Player();
    public static Station currentArea = Stationen.ESSENHBF;

    public static ArrayDeque<String> lastTells = new ArrayDeque<>();


    public static void main(String[] args) {
        LoadActions();
        gui = new GUI();
    }




}