<%@ page import="com.airline.models.Passenger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.airline.models.Flight" %>
<%--
  Created by IntelliJ IDEA.
  User: Alish
  Date: 2/9/2019
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link rel="stylesheet" href="../resources/jpaStyle.css">--%>
    <style>
        h1 {
            font-size: 36px;
            color: red;
        }

        table {
            border: 5px solid rgb(104, 20, 249);
            border-collapse: collapse;
            font-family: Arial, sans-serif;
        }

        th, td {
            padding: 10px;
            border: 2px solid rgb(28, 39, 228);
            font-size: 18px;
            font-weight: bold;
        }

        th {
            font-size: 28px;
        }
    </style>
    <title>Passengers List</title>
</head>
<body>
<h1>List Of Passengers</h1>
<table>
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>DateOfBirth</th>
        <th>Gender</th>


    </tr>
    <%
        List<Passenger> passengers = (List<Passenger>) request.getAttribute("passenger_list");
        for (Integer i = 0; i < passengers.size(); i++) {
    %>
    <tr>
        <td><%=passengers.get(i).getId()%>
        </td>
        <td><%=passengers.get(i).getFirstName()%>
        </td>
        <td><%=passengers.get(i).getLastName()%>
        </td>
        <td><%=passengers.get(i).getDob()%>
        </td>
        <td><%=passengers.get(i).getGender()%>
        </td>
    </tr>
    <tr>
        <td colspan="5">
            <%
                if (passengers.get(i).getFlights().size() > 0) {
                    List<Flight> flights = passengers.get(i).getFlights();
                    for (Integer k = 0; k < flights.size(); k++) {
            %>
            <%=k + 1%>  ) <%=flights.get(k).getFlightOrigins()%> to <%=flights.get(k).getFlightDestination()%> @ <%=flights.get(k).getFlightTime()%> <br/>

            <%
                    }
                } else {
            %>
                No Flights ticket yet !!!
            <%
                }
            %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
