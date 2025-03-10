package latihankuis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HitungSiku extends JFrame {
    private JTextField alasField, tinggiField;
    private JButton hitungButton;
    private JLabel hasilLabel;

    public HitungSiku() {
        setTitle("Hitung Sisi Miring Segitiga");
        setSize(400, 250); // Memperbesar ukuran agar lebih proporsional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Menggunakan GridBagLayout untuk fleksibilitas
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Memberikan jarak antar elemen

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Masukkan Alas:"), gbc);
        
        gbc.gridx = 1;
        alasField = new JTextField(10);
        add(alasField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Masukkan Tinggi:"), gbc);
        
        gbc.gridx = 1;
        tinggiField = new JTextField(10);
        add(tinggiField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        hitungButton = new JButton("Hitung");
        add(hitungButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        hasilLabel = new JLabel("Hasil: "); // Inisialisasi label hasil
        add(hasilLabel, gbc);
        
        // Event Handling
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double alas = Double.parseDouble(alasField.getText());
                    double tinggi = Double.parseDouble(tinggiField.getText());
                    if (alas <= 0 || tinggi <= 0) throw new IllegalArgumentException("Nilai harus lebih dari 0");
                    double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
                    
                    hasilLabel.setText("Hasil: " + String.format("%.2f", sisiMiring)); // Menampilkan hasil di bawah inputan
                    saveToFile(alas, tinggi, sisiMiring);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal menyimpan ke file!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveToFile(double alas, double tinggi, double sisiMiring) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("hasil_perhitungan.txt", true))) {
            writer.printf("Alas: %.2f, Tinggi: %.2f, Sisi Miring: %.2f%n", alas, tinggi, sisiMiring);
        }
    }
}