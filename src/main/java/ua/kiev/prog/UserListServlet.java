package ua.kiev.prog;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/usersList")
public class UserListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.setContentType("application/json");
        OutputStream os = response.getOutputStream();
        byte[] buf = UsersBase.getAllUsersName().getBytes(StandardCharsets.UTF_8);
        os.write(buf);
    }
}
