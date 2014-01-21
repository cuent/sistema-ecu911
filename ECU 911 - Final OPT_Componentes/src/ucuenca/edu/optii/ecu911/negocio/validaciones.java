/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.negocio;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidaTextoExcepcion;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidacionCamposTextoExcepcion;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidacionCedulaExcepcion;

/**
 *
 * @author May
 */
public class validaciones {
    public boolean validaCedula(String cedula)throws ValidacionCedulaExcepcion{
    int suma=0;
    if(cedula.length()<=9){
      ValidacionCedulaExcepcion e=new ValidacionCedulaExcepcion("ERROR! Ingrese su cedula de 10 digitos");
      return false;
    }else{
      int a[]=new int [cedula.length()/2];
      int b[]=new int [(cedula.length()/2)];
      int c=0;
      int d=1;
      for (int i = 0; i < cedula.length()/2; i++) {
        a[i]=Integer.parseInt(String.valueOf(cedula.charAt(c)));
        c=c+2;
        if (i < (cedula.length()/2)-1) {
          b[i]=Integer.parseInt(String.valueOf(cedula.charAt(d)));
          d=d+2;
        }
      }
   
      for (int i = 0; i < a.length; i++) {
        a[i]=a[i]*2;
        if (a[i] >9){
          a[i]=a[i]-9;
        }
        suma=suma+a[i]+b[i];
      } 
      int aux=suma/10;
      int dec=(aux+1)*10;
      if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length()-1)))) {
            return true;
        }
      else
        if(suma%10==0 && cedula.charAt(cedula.length()-1)=='0'){
          return true;
           
        }else{
           ValidacionCedulaExcepcion e=new ValidacionCedulaExcepcion("SU CEDULA ES INVALIDA");
         return false;        
        }
      }
     
   }
    
    public void validaTexto(KeyEvent evt, JTextField txt){
        int k = (int) evt.getKeyChar();
        if (k>47 && k<58) {
        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
         throw new ValidaTextoExcepcion( "NO SE PUEDE INGRESAR NÚMEROS!") ;
        }
        if (k==10) {
        txt.transferFocus();
        }
    }
}
