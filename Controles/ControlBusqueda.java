package controles;
import entidades.Cuenta;
import entidades.Articulo;

public class ControlBusqueda {
   Cuenta c;
   Articulo a;
   
   public ControlBusqueda(){
     c = new Cuenta(); //Asume que la instancia persiste durante la sesion
     a = new Articulo();
   }
   public boolean validarBusqueda(int IDC, int IDA){
       //este metodo revisa si el usuario puede acceder al articulo
       //dependiendo del tipo de cuenta que tenga
       String t = c.getTipo(IDC);
       //las cuentas de juez, admin y editor pueden acceder a cualquier articulo que exista
       if(t.equals("Juez")||t.equals("Admin")||t.equals("Editor")){
           return true;
       }
       boolean p = a.getPublicado(IDA);
       //si es un usuario normal entonces solo puede verlo si esta publicado
       return p;
   }
   public String busqueda(int IDA){
       //se asume previa validacion de la busqueda
       return a.getTexto(IDA);
   }
}