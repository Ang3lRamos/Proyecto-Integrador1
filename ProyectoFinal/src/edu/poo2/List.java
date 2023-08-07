package edu.poo2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

public class List {
    private JTable table1;
    private JTextField textFieldSearch;
    private JButton openButton;
    private JButton searchButton;
    public JPanel lista;
    private JButton returnButton;

    private TableRowSorter trsFilter;
    String Filter;

    private File file;

    public void filter(){
        Filter = textFieldSearch.getText();
        trsFilter.setRowFilter(RowFilter.regexFilter(textFieldSearch.getText(),0));
    }

    public List() {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login" );
                frame.setSize(800,800);
                frame.setContentPane(new CostumerLogin().pacl);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });
        String[] cols = {"Products","Grammes", "Price"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        table1.setModel(model);


        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Producto, Gramos, Precio;
                String archivo = "C:\\Users\\angel\\ProyectoFinal_PI\\ProyectoFinal\\src\\Productos.txt";
                Scanner linea = null;
                File abrirTxt = new File(archivo);
                try {
                    linea = new Scanner(abrirTxt);
                    while (linea.hasNextLine()) {
                        Producto = linea.nextLine();
                        Gramos = linea.nextLine();
                        Precio = linea.nextLine();
                        model.addRow(new Object[]{Producto, Gramos, Precio});
                    }
                } catch (Exception ez) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldSearch.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        String cadena = textFieldSearch.getText();
                        textFieldSearch.setText(cadena);
                        filter();
                    }
                });

            }
        });
        textFieldSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                trsFilter = new TableRowSorter(table1.getModel());
                table1.setRowSorter(trsFilter);
            }
        });
    }
}
