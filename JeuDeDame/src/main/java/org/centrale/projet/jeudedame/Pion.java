/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.projet.jeudedame;

/**
 *
 * @author Max
 */
public class Pion {
    
    
    public void deplace(int a){
        if (this.couleur=="blanc"){
            if (a==1){
                this.position.sety=this.position.gety-1;
                this.position.setx=this.position.getx+1;    
            }else{
                this.position.sety=this.position.gety+1;
                this.position.setx=this.position.getx+1;
            }
        }else{
            if (a==1){
                this.position.sety=this.position.gety-1;
                this.position.setx=this.position.getx-1;    
            }else{
                this.position.sety=this.position.gety+1;
                this.position.setx=this.position.getx-1;
            }
        }
    }
}
