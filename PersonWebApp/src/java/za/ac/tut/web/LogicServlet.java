package za.ac.tut.web;

import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import za.ac.tut.entities.*;

@WebServlet("/upload")
@MultipartConfig
public class LogicServlet extends HttpServlet {

    @EJB
    PersonFacadeLocal logic;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        String url = "";

        if (op.equalsIgnoreCase("add")) {

            String name = request.getParameter("name");
            String nickname = request.getParameter("nickname");
            String address = request.getParameter("address");
            int id = Integer.parseInt(request.getParameter("id"));
            Part img = request.getPart("file");

            logic.create(createPerson(id, name, nickname, address, getBytes(img)));

            url = "add_outcome.jsp";
            request.setAttribute("name", name);
            request.setAttribute("picture", getBytes(img));
            request.setAttribute("nickname", nickname);
            request.setAttribute("address", address);
            request.setAttribute("id", id);
        } else if ("list".equalsIgnoreCase(op)) {
            List<Person> list = logic.findAll();
             request.setAttribute("list", list);
             url = "list_outcome.jsp";
        } 
        
 
        
        else if (op.equalsIgnoreCase("edit")) {
            
            
            
            String name = request.getParameter("name");
            String nickname = request.getParameter("nickname");
            String address = request.getParameter("address");
            int id = Integer.parseInt(request.getParameter("id"));
            Part img = request.getPart("file");
            
            //Person p = logic.find(id);
            //logic.remove(p);

            logic.edit(createPerson(id, name, nickname, address, getBytes(img)));
            
            url = "edit_outcome.jsp";
            
        }
        
        

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }

    public Person createPerson(Integer id, String name, String nickname, String address, byte[] picture) {
        return new Person(id, name, nickname, address, picture);
    }

    public byte[] getBytes(Part img) throws IOException {
        InputStream inputStream = img.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int size = 0;

        while ((size = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, size);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
