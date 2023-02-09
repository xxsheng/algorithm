package program;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import program.threadpool.DefaultThreadPool;
import program.threadpool.ThreadPool;

public class HttpServer {
    ThreadPool<HttpServerHandler> threadPool = new DefaultThreadPool<>(1);
    ServerSocket serverSocket;
    String baseUrl;

    int port;

    public void setPort(int port) {
        if (port > 0) {
            this.port = port;
        } else {
            throw new IllegalArgumentException("无效的端口");
        }
    }

    public void setBaseUrl(String url) {
        if (url != null && new File(url).exists() && new File(url).isDirectory()) {
            this.baseUrl = url;
        } else {
            throw new IllegalArgumentException("无效的文件地址");
        }
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            threadPool.execute(new HttpServerHandler(socket, this.baseUrl));
        }
    }

    public static class HttpServerHandler implements Runnable {

        Socket socket;
        String baseUrl;

        public HttpServerHandler(Socket socket, String baseUrl) {
            this.socket = socket;
            this.baseUrl = baseUrl;
        }

        @Override
        public void run() {
            InputStream inputStream;
            BufferedReader bufferedReader;
            BufferedOutputStream bufferedOutputStream;
            try {
                inputStream = socket.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String readLine = bufferedReader.readLine();
                String filePath = this.baseUrl + readLine.split(" ")[1];
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    FileInputStream fileInputStream = new FileInputStream(new File(filePath));
                }
            } catch (Exception e) {

            } finally {

            }
        }
    }
}
