//your package

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MemberAccountNeedModifyPath extends JFrame {

    private Scanner scanner;  

    public MemberAccountNeedModifyPath() {
        scanner = new Scanner(System.in);  

        JButton registerButton = new JButton("Create Account For Your Dessert");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAccount();
            }
        });

        JPanel panel = new JPanel();
        panel.add(registerButton);
        panel.add(loginButton);

        add(panel);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createAccount() {
        System.out.println("Account");
        String account = scanner.next();

        if (isAccountExists(account)) {
            System.out.println("帳號已存在，請重新輸入你欲創立的帳號。");
            createAccount();
        } else {
            System.out.println("Password");
            String password = scanner.next();
            System.out.println("Email");
            String email = scanner.next();
            String acCreateTime = LocalDateTime.now().toString();

            String url = "jdbc:mysql://localhost:3306/Hightwo";
            Properties prop = new Properties();
            prop.put("user", "root");
            prop.put("password", "root");

            outputToDatabase(url, prop, account, password, email, acCreateTime);
        }
    }

    private void LoginAccount() {
        String url = "jdbc:mysql://localhost:3306/Hightwo";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");

        try {
            System.out.println("Account:");
            String account = scanner.next();

            if (isAccountExists(account)) {
                System.out.println("Password:");
                String password = scanner.next();

                if (checkPassword(account, password, url, prop)) {
                    System.out.println("登入成功");
                } else {
                    System.out.println("錯誤的密碼，請確認輸入是否有誤");
                }
            } else {
                System.out.println("帳號不存在，請確認輸入是否有誤");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new MemberAccountNeedModifyPath();
    }

    private static void outputToDatabase(String url, Properties prop, String account, String password, String email, String acCreateTime) {
        try (Connection conn = DriverManager.getConnection(url, prop)) {
            String sql = "INSERT INTO memberaccount (account, password, email, acCreateTime) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, acCreateTime);
            if (pstmt.executeUpdate() > 0) {
                System.out.println("Create Success");
            } else {
                System.out.println("Create Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean isAccountExists(String account) {
        String url = "jdbc:mysql://localhost:3306/Hightwo";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");

        try (Connection conn = DriverManager.getConnection(url, prop)) {
            String checkSql = "SELECT COUNT(1) FROM memberaccount WHERE account = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, account);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            return false;
        }
    }

    private boolean checkPassword(String account, String password, String url, Properties prop) {
        try (Connection conn = DriverManager.getConnection(url, prop);
             PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM memberaccount WHERE account = ?")) {

            pstmt.setString(1, account);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    return password.equals(storedPassword);
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}