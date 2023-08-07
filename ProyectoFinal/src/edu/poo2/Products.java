package edu.poo2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Products {
    public JPanel productos;
    private JTable table1;
    private JTextField textFieldproducto;
    private JTextField textFieldpeso;
    private JTextField textFieldprecio;
    private JButton buttonabrir;
    private JButton saveButton;
    private JButton modifyButton;
    private JButton searchButton;
    private JButton deleteButton1;
    private JButton addButton;
    private JButton buttonvolver;

    private TableRowSorter trsFiltro;
    String Filtro;

    public void limpiar() {
        textFieldproducto.setText("");
        textFieldpeso.setText("");
        textFieldprecio.setText("");
    }
    public void filtro(){
        Filtro = textFieldproducto.getText();
        trsFiltro.setRowFilter(RowFilter.regexFilter(textFieldproducto.getText(),0));
    }


    public Products() {

        buttonvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame framePrin = new JFrame("Login" );
                framePrin.setSize(800,800);
                framePrin.setContentPane(new Inicioman().Login);
                framePrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framePrin.setVisible(true);
            }
        });

        String[] cols = {"Products", "Grammes", "Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        table1.setModel(model);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] data = {textFieldproducto.getText(), textFieldpeso.getText(), textFieldprecio.getText()};
                    model.addRow(data);
                } catch (Exception ex) {
                    System.out.println("Error");
                }
                limpiar();

            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter salvar = new FileWriter("C:\\Users\\angel\\ProyectoFinal_PI\\ProyectoFinal\\src\\Productos.txt");
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        salvar.write(model.getValueAt(i, 0).toString() + ("\n"));
                        salvar.write(model.getValueAt(i, 1).toString() + ("\n"));
                        salvar.write(model.getValueAt(i, 2).toString() + ("\n"));
                    }
                    salvar.close();
                    JOptionPane.showMessageDialog(null, "Datos guardados.");
                } catch (Exception ex) {
                    System.out.println("Error");
                }

            }
        });

        buttonabrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Products, Grammes, Price;
                String archivo = "C:\\Users\\angel\\ProyectoFinal_PI\\ProyectoFinal\\src\\Productos.txt";
                Scanner linea = null;
                File abrirTxt = new File(archivo);
                try {
                    linea = new Scanner(abrirTxt);
                    while (linea.hasNextLine()) {
                        Products = linea.nextLine();
                        Grammes = linea.nextLine();
                        Price = linea.nextLine();
                        model.addRow(new Object[]{Products, Grammes, Price});
                    }
                } catch (Exception ez) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaSelecccionada = table1.getSelectedRow();
                if(FilaSelecccionada >= 0){
                    textFieldproducto.setText(table1.getValueAt(FilaSelecccionada,0).toString());
                    textFieldpeso.setText(table1.getValueAt(FilaSelecccionada,1).toString());
                    textFieldprecio.setText(table1.getValueAt(FilaSelecccionada,2).toString());
                    model.removeRow(FilaSelecccionada);
                }else{
                    JOptionPane.showMessageDialog(null,"Seleccione la fila.");
                }

            }
        });

        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FilaSeleccionada = table1.getSelectedRow();
                if(FilaSeleccionada >=0){
                    model.removeRow(FilaSeleccionada);
                }else{
                    JOptionPane.showMessageDialog(null,"Selecciones una fila.");
                }

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldproducto.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        String cadena = textFieldproducto.getText();
                        textFieldproducto.setText(cadena);
                        filtro();
                    }
                });

            }
        });

        textFieldproducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                trsFiltro = new TableRowSorter(table1.getModel());
                table1.setRowSorter(trsFiltro);
            }
        });
    }
}
