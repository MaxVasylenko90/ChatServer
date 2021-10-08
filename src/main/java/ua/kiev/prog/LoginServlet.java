package ua.kiev.prog;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] buf = RequestToByteArray.convert(request);
        String req = new String(buf, StandardCharsets.UTF_8);
        User user = User.fromJSON(req);
        if ( UsersBase.getUsers().containsKey(user.getLogin()) & UsersBase.getUsers().containsValue(user.getPass()))
            response.setStatus(200);
        else response.setStatus(500);
    }
}
