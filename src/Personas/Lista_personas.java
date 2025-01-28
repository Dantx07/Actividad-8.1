package Personas;
import java.util.*;

public class Lista_personas {
    Vector Lista_personas;

    public Lista_personas() {
        Lista_personas = new Vector();
    }

    public void Añadir_persona(Persona p)   {
        Lista_personas.add(p);
    }

    public void Eliminar_persona(int i) {
        if (i >= 0 && i < Lista_personas.size()){
            Lista_personas.removeElementAt(i);
        }
    }

    public void Eliminar_lista_personas()   {
        Lista_personas.removeAllElements();
    }
}
