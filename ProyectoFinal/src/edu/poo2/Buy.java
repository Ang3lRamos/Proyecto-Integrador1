package edu.poo2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buy {
    private JTable table1;
    private JTextField textFieldprice;
    private JTextField textFieldunite;
    private JTextField textFieldName;
    private JButton buyButton;
    private JTextField textFieldStal;
    private JTextField textFieldtotal;
    private JTextField textFieldtax;
    private JButton registerPurchaseButton;
    public JPanel buy;
    private JButton returnButton;
    private JButton openButton;
    private JTable tblCompras;
    private JScrollPane tblProductos;
    private File file;

    public Object total() {
        double valorU = Double.parseDouble(textFieldprice.getText());
        double cantidad = Double.parseDouble(textFieldunite.getText());
        double total = (valorU * cantidad);
        return total;
    }
    private void compraTotal(){
        float suma = 0;
        for(int i= 0;i < tblCompras.getRowCount();i++){
            float renglon;
            renglon = Float.parseFloat(tblCompras.getValueAt(i,3).toString());
            suma += renglon;
        }
        textFieldStal.setText(String.valueOf(suma));
        textFieldtax.setText(String.valueOf(suma*0.19));
        textFieldtotal.setText(String.valueOf(suma*1.19));
    }
    public void limpiar(){
        textFieldName.setText("");
        textFieldprice.setText("");
        textFieldunite.setText("");}
    private List<Buy> Buy = new ArrayList<Buy>();
    private void guardarTxt(){
        try{
            FileWriter fw = new FileWriter("C:\\Users\\angel\\ProyectoFinal_PI\\ProyectoFinal\\src\\Factura.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("Product: "+ textFieldName.getText()+"-");
            pw.print("Price: " + textFieldprice.getText()+"-");
            pw.print("Units: " + textFieldunite.getText()+"\n");
            pw.print("=======================================\n");
            pw.print("Purchase value: " + textFieldStal.getText()+"\n");
            pw.print("Tax: "+ textFieldtax.getText()+"\n");
            pw.print("TOTAL TO PAY: " + textFieldtotal.getText()+"\n");
            pw.print("========================================\n");
            pw.print("\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Buy() {
        String[] cols1 = {"Product", "Price", "Units", "Total"};
        DefaultTableModel model1 = new DefaultTableModel(cols1, 0);
        tblCompras.setModel(model1);
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

        registerPurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] data = {textFieldName.getText(), textFieldprice.getText(), textFieldunite.getText(), total()};
                    model1.addRow(data);}catch (Exception ex){
                    System.out.println("Error");
                }
                compraTotal();
                guardarTxt();
                limpiar();
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String url ="C:\\Users\\angel\\ProyectoFinal_PI\\ProyectoFinal\\src\\Factura.txt";
                    ProcessBuilder p = new ProcessBuilder();
                    p.command("cmd.exe","/C",url);
                    try {
                        p.start();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                JTable table = (JTable) e.getSource();
                Point point = e.getPoint();
                int row = table.rowAtPoint(point);
                if(e.getClickCount()== 1){
                    textFieldName.setText(table1.getValueAt(table1.getSelectedRow(),0).toString());
                    textFieldprice.setText(table1.getValueAt(table1.getSelectedRow(),2).toString());
                }
            }
        });
        String[] cols = {"Name Product","Grams", "Unit Price"};
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
                        model.addRow(new Object[]{Producto, Gramos, Precio,});
                    }
                } catch (Exception ez) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }
}
