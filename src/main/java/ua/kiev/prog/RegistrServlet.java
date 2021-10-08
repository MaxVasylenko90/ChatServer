package ua.kiev.prog;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/registration")
public class RegistrServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte [] buf = RequestToByteArray.convert(request);
        String bufStr = new String(buf, StandardCharsets.UTF_8);
        User user = User.fromJSON(bufStr);
        if(UsersBase.add(user)) {
            response.getOutputStream().write("[SERVER] Registration is complete!".getBytes(StandardCharsets.UTF_8));
            response.setStatus(200);
        } else {
            response.getOutputStream().write("[SERVER] Wrong login! Try another name.".getBytes(StandardCharsets.UTF_8));
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }



    }







}
