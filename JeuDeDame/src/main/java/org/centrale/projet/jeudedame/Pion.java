/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.projet.jeudedame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Max
 */
public class Pion {

    Point2D pos;
    String couleur;
    Plateau plateau;

    public List<Pion> doitManger() {
        List<Pion> maListePion = new ArrayList<>();
        List<Point2D> maListePionPos = new ArrayList<>();
        List<Pion> maListePionTotal;

        if ("Blanc".equals(couleur)) {
            maListePionTotal = plateau.getMaListePionNoir();
        } else if ("Noir".equals(couleur)) {
            maListePionTotal = plateau.getMaListePionBlanc();
        } else {
            return maListePion; // couleur inconnue
        }

        // 2) Cases adjacentes diagonales autour de CE pion
        maListePionPos.add(new Point2D(this.pos.getX() + 1, this.pos.getY() + 1));
        maListePionPos.add(new Point2D(this.pos.getX() - 1, this.pos.getY() + 1));
        maListePionPos.add(new Point2D(this.pos.getX() + 1, this.pos.getY() - 1));
        maListePionPos.add(new Point2D(this.pos.getX() - 1, this.pos.getY() - 1));

        // 3) Parcourir TOUS les pions adverses
        for (Pion pionAdv : maListePionTotal) {
            if (maListePionPos.contains(pionAdv.getPos())) {

                if (peutSauterParDessus(pionAdv)) {
                    maListePion.add(pionAdv);
                }

            }
        }

        return maListePion;
    }

    private boolean peutSauterParDessus(Pion pionAdv) {
        int dx = pionAdv.getPos().getX() - this.pos.getX();
        int dy = pionAdv.getPos().getY() - this.pos.getY();

        // Case derrière le pion adverse
        int xDerriere = pionAdv.getPos().getX() + dx;
        int yDerriere = pionAdv.getPos().getY() + dy;

        // À adapter à ta représentation du plateau :
        return plateau.estDansLePlateau(xDerriere, yDerriere)
                && plateau.caseVide(xDerriere, yDerriere);
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

}
