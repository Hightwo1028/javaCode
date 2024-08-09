import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class downloadPracticeClient {

	public static void main(String[] args) {
        String serverAddress = "10.0.100.101";
        int port = 8888;
        String fileName = "usage.jpg";

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
             FileOutputStream fileOut = new FileOutputStream("downloaded_" + fileName);
             BufferedOutputStream bout = new BufferedOutputStream(fileOut)) {

            out.println(fileName);
            System.out.println("Requested file: " + fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                bout.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
            bout.flush();
            System.out.println("File downloaded successfully as: downloaded_" + fileName);
            System.out.println("Total bytes downloaded: " + totalBytesRead);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
