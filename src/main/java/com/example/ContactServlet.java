package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = safe(request.getParameter("name"));
        String email = safe(request.getParameter("email"));
        String message = safe(request.getParameter("message"));

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html><html lang='en'><head><meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<title>Message received</title><link rel='stylesheet' href='css/style.css'></head><body>");
            out.println("<main class='result-card'><div class='eyebrow'>CONTACT FORM</div>");
            out.println("<h1>Thanks, " + name + "!</h1>");
            out.println("<p>Your demo message was received by the Java servlet.</p>");
            out.println("<div class='submitted'><strong>Email</strong><p>" + email + "</p>");
            out.println("<strong>Message</strong><p>" + message + "</p></div>");
            out.println("<a class='button' href='index.html'>Back to home</a>");
            out.println("<p class='note'>Practice demo only: messages are not saved to a database.</p></main></body></html>");
        }
    }

    private String safe(String value) {
        if (value == null || value.trim().isEmpty()) return "(not provided)";
        return value.replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
