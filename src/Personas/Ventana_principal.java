package Personas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana_principal extends JFrame implements ActionListener {

   private Lista_personas Lista;
    private Container Contenedor;
    private JLabel Nombre, Apellido, Telefono, Direccion;
    private JTextField Campo_Nombre, Campo_Apellido, Campo_Telefono, Campo_Direccion;
    private JButton Añadir, Eliminar, Eliminar_lista;
    private JList Lista_nombres;
    private DefaultListModel Modelo;
    private JScrollPane Scroll_lista;

    public Ventana_principal()  {
        Lista = new Lista_personas();
        Inicio();
        setTitle("Lista de personas");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void Inicio()   {
        Contenedor = getContentPane();
        Contenedor.setLayout(null);
        Nombre = new JLabel();
        Nombre.setText("Nombre");
        Nombre.setBounds(20, 120, 135, 23);
        Campo_Nombre = new JTextField();
        Campo_Nombre.setBounds(105, 120, 135, 23);
        Apellido = new JLabel();
        Apellido.setText("Apellidos");
        Apellido.setBounds(20, 150, 135, 23);
        Campo_Apellido = new JTextField();
        Campo_Apellido.setBounds(105, 150, 135, 23);
        Telefono = new JLabel();
        Telefono.setText("Telefono");
        Telefono.setBounds(20, 180, 135, 23);
        Campo_Telefono = new JTextField();
        Campo_Telefono.setBounds(105, 180, 135, 23);
        Direccion = new JLabel();
        Direccion.setText("Direccion");
        Direccion.setBounds(20, 210, 135, 23);
        Campo_Direccion = new JTextField();
        Campo_Direccion.setBounds(105, 210, 135, 23);
        Añadir = new JButton();
        Añadir.setText("Añadir");
        Añadir.setBounds(105, 240, 135, 23);
        Añadir.addActionListener(this);
        Eliminar = new JButton();
        Eliminar.setText("Eliminar");
        Eliminar.setBounds(105, 270, 135, 23);
        Eliminar.addActionListener(this);
        Eliminar_lista = new JButton();
        Eliminar_lista.setText("Eliminar lista");
        Eliminar_lista.setBounds(105, 300, 135, 23);
        Eliminar_lista.addActionListener(this);
        Modelo = new DefaultListModel();
        Lista_nombres = new JList();
        Lista_nombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Scroll_lista = new JScrollPane(Lista_nombres);
        Scroll_lista.setBounds(20, 20, 220, 80);
        Scroll_lista.setViewportView(Lista_nombres);
        Contenedor.add(Nombre);
        Contenedor.add(Campo_Nombre);
        Contenedor.add(Apellido);
        Contenedor.add(Campo_Apellido);
        Contenedor.add(Telefono);
        Contenedor.add(Campo_Telefono);
        Contenedor.add(Direccion);
        Contenedor.add(Campo_Direccion);
        Contenedor.add(Añadir);
        Contenedor.add(Eliminar);
        Contenedor.add(Eliminar_lista);
        Contenedor.add(Scroll_lista);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == Añadir)   {
            Añadir_persona();
        }
        if (evento.getSource() == Eliminar) {
            Eliminar_persona(Lista_nombres.getSelectedIndex());
        }
        if (evento.getSource() == Eliminar_lista)   {
            Eliminar_lista_personas();
        }
    }

    private void Añadir_persona()   {
        if (Campo_Nombre.getText().trim().isEmpty() || Campo_Apellido.getText().trim().isEmpty() || Campo_Telefono.getText().trim().isEmpty() || Campo_Direccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
        }   else {
            Persona pers = new Persona(Campo_Nombre.getText(), Campo_Apellido.getText(), Campo_Telefono.getText(), Campo_Direccion.getText());
            String Elemento = Campo_Nombre.getText() + "-" + Campo_Apellido.getText() + "-" + Campo_Telefono.getText() + "-" + Campo_Direccion.getText();
            Modelo.addElement(Elemento);
            Lista_nombres.setModel(Modelo);
            Campo_Nombre.setText("");
            Campo_Apellido.setText("");
            Campo_Telefono.setText("");
            Campo_Direccion.setText("");
            Contenedor.revalidate();
            Contenedor.repaint();
        }
    }

    private void Eliminar_persona(int indice) {
        if (indice >= 0)    {
            Modelo.removeElementAt(indice);
            Lista.Eliminar_persona(indice);
            Contenedor.revalidate();
            Contenedor.repaint();
        }   else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Eliminar_lista_personas()  {
        Lista.Eliminar_lista_personas();
        Modelo.clear();
        Contenedor.revalidate();
        Contenedor.repaint();
    }
}