/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
/**
 *
 * @author steve
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sframe f=new sframe("Travel Agent System");
        f.setVisible(true);
        int i;
        for(i=2;i<=1575;i+=5)
        {
            f.setLocation((1500/2)-(i/2)+25,(1000/2)-(i*36/100)+25);
            f.setSize(i,i*36/55);
            try
            {
               Thread.sleep(8);
            }
            catch(Exception e)  { }
        }
    }
    
}
