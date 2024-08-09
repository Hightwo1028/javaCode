package tw.hightwo.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class downloadPractice {

	public static void main(String[] args) {
        int port = 8888;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for clients to connect...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    // 讀取客戶端請求的檔案名稱
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String requestedFile = in.readLine();
                    System.out.println("Client requested file: " + requestedFile);

                    // 檢查檔案名稱是否安全
                    if (requestedFile == null || requestedFile.contains("..") || requestedFile.contains("/")) {
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        out.println("Invalid file request");
                        System.out.println("Invalid file request from client.");
                        continue;
                    }

                    // 確保檔案位於 dir1 資料夾內
                    File file = new File("dir1/" + requestedFile);
                    if (file.exists() && !file.isDirectory()) {
                        try (BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file));
                             BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream())) {

                            long fileSize = file.length();
                            System.out.println("File size: " + fileSize);

                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            long totalBytesRead = 0;
                            while ((bytesRead = fileIn.read(buffer)) != -1) {
                                out.write(buffer, 0, bytesRead);
                                totalBytesRead += bytesRead;
                            }
                            out.flush();
                            System.out.println("File sent to client. Total bytes sent: " + totalBytesRead);
                        }
                    } else {
                        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                            out.println("File not found");
                            System.out.println("Requested file not found.");
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

}
