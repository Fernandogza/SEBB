package controles;
import entidades.Cuenta;
import entidades.Suscripcion;

public class ControlCancelacion {
   Cuenta c;
   Suscripcion s;

   public ControlCancelacion(){
     c = new Cuenta(); //Asume que la instancia persiste durante la sesion
     s = new Suscripcion();
   }  
   //Valida si la cuenta existe en la base de datos
   public boolean validarCuenta(String nombre){            
      return(c.validar(nombre));
   }
   public void cancelarSuscripcion(int IDC) {
      s.cancelar(s.getSuscripcion(IDC));
   }
   public void cancelarCuenta(String nombre, int ncuenta) {
     if(s.validar(ncuenta)) {
       s.cancelar(s.getSuscripcion(ncuenta));
       c.cancelar(nombre);
     } else {
       c.cancelar(nombre);
     }
   }
}
