<%@ page import="com.airline.models.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="com.airline.models.Pilot" %>
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
    <%--<link rel="stylesheet" href="../../resources/jpaStyle.css">--%>
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
    <title>Flights List</title>
</head>
<body>
<h1>List Of Flights</h1>
<table>
    <tr>
        <th>Id</th>
        <th>From</th>
        <th>To</th>
        <th>Time</th>
        <th>Price</th>
        <th>Airplane</th>
        <th>Seating</th>
        <th>NumberOfPilots</th>
        <th>PilotNames</th>

    </tr>
    <%
        List<Flight> flights = (List<Flight>) request.getAttribute("flight_list");
        for (Integer i = 0; i < flights.size(); i++) {
    %>
    <tr>
        <td><%=flights.get(i).getId()%>
        </td>
        <td><%=flights.get(i).getFlightOrigins()%>
        </td>
        <td><%=flights.get(i).getFlightDestination()%>
        </td>
        <td><%=flights.get(i).getFlightTime()%>
        </td>
        <td><%=flights.get(i).getPrice()%>
        </td>
        <td><%=flights.get(i).getAirplaneDetails().getPlaneMake() + " "+flights.get(i).getAirplaneDetails().getModelName()%>
        </td>
        <td><%=flights.get(i).getAirplaneDetails().getSeatingCapacity()%>
        </td>
        <td>
            <%
                if (flights.get(i).getPilots() != null) {
            %>
            <%=flights.get(i).getPilots().size()%> pilots
            <%
            } else {
            %>
            No pilots Yet
            <%
                }
            %>
        </td>
        <td>
            <%
                if (flights.get(i).getPilots() != null) {
                    List<Pilot> pilots = flights.get(i).getPilots();
                    for (Integer j=0; j < pilots.size(); j++) {


            %>
            <%=
            (j + 1) + ")" + pilots.get(j).getFirstName() + " " + pilots.get(j).getLastName() + "(" + pilots.get(i).getPilotRank() + ")" + "<br/>"
            %>
            <%
                    }
                }
            %>
        </td>
    </tr>
    <tr>
        <td colspan="9">No Passengers On This Flight Yet !</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
