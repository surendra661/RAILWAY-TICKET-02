package com.railway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookTicket")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get form data
        String passengerName = request.getParameter("passengerName");
        String trainNumber = request.getParameter("trainNumber");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");
        String coachType = request.getParameter("coachType");
        int numberOfTickets = Integer.parseInt(request.getParameter("numberOfTickets"));
        
        // Calculate fare (simple calculation for demo)
        double baseFare = 500.0;
        if (coachType.equals("AC")) {
            baseFare = 1000.0;
        } else if (coachType.equals("Sleeper")) {
            baseFare = 600.0;
        }
        double totalFare = baseFare * numberOfTickets;
        
        // Create ticket
        Ticket ticket = new Ticket(passengerName, trainNumber, source, destination, 
                                 date, coachType, numberOfTickets, totalFare);
        
        // Save to database
        Database.bookTicket(ticket);
        
        // Set attributes for JSP
        request.setAttribute("ticket", ticket);
        
        // Forward to confirmation page
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // For getting available trains
        request.setAttribute("trains", Database.getAvailableTrains());
        request.getRequestDispatcher("booking.html").forward(request, response);
    }
}