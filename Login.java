package latihankuis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private static final String USERNAME = "123230148";
    private static final String PASSWORD = "123";

    public Login() {
        setTitle("Login");
        setSize(600, 300); // Memperbesar tampilan
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel utama dengan padding dan layout grid
        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15)); // Spasi antar elemen lebih besar
        panel.setBorder(new EmptyBorder(20, 40, 20, 40)); // Padding lebih besar

        // Komponen Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Memperbesar font
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(usernameField);

        // Komponen Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(passwordField);

        // Tombol Login
        loginButton = new JButton("Masuk");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(new JLabel()); // Spacer agar tombol ke tengah
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);

        // Event Handling
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                    dispose(); // Tutup Login Window
                    new HitungSiku();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password salah", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLocationRelativeTo(null); // Menampilkan di tengah layar
        setVisible(true);
    }
}
