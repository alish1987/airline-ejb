<%--
  Created by IntelliJ IDEA.
  User: Alish
  Date: 2/9/2019
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 14px;
        }
    </style>
</head>
<body>
<h1 style="text-decoration:underline;">Fansy Forms</h1>
<hr>
Add Flight And Airplane
</br>
<form method="post" action="/AddFlight">
    <select id="form_destination" name="form_destination">
        <option value="San_Francisco">San Francisco</option>
        <option value="Los_Angeles">Los Angeles</option>
        <option value="New_York">New York</option>
        <option value="London">London</option>
        <option value="Paris">Paris</option>
        <option value="Rome">Rome</option>
        <option value="Amesterdom">Amesterdom</option>
    </select>
    </br></br>
    To :
    <select id="to_destination" name="to_destination">
        <option value="San_Francisco">San Francisco</option>
        <option value="Los_Angeles">Los Angeles</option>
        <option value="New_York">New York</option>
        <option value="London">London</option>
        <option value="Paris">Paris</option>
        <option value="Rome">Rome</option>
        <option value="Amesterdom">Amesterdom</option>
    </select>
    <h4>Time Of Flight:</h4>
    </hr>
    Year :
    <select id="year" name="year">
        <option value="2015">2015</option>
        <option value="2016">2016</option>
        <option value="2017">2017</option>
        <option value="2018">2018</option>
        <option value="2019">2019</option>
        <option value="2020">2020</option>
    </select>
    </br></br>
    Month :
    <select id="month" name="month">
        <option value="0">January</option>
        <option value="1">February</option>
        <option value="2">March</option>
        <option value="3">April</option>
        <option value="4">May</option>
        <option value="5">Jun</option>
        <option value="6">July</option>
        <option value="7">August</option>
        <option value="8">September</option>
        <option value="9">October</option>
        <option value="10">November</option>
        <option value="11">December</option>
    </select>
    </br></br>
    Day Of Month :
    <input name="day" type="text"/>
    </br></br>
    Hour Of Day (0 - 23) :
    <input name="hour" type="text"/>
    </br></br>
    Minute (0 - 59) :
    <input name="minute" type="text"/>
    </br></br>
    Price :
    <input name="price" type="text"/>
    </hr>
    <h4>Airplane :</h4>
    Plane Make :
    <input name="airPlane_make" type="text"/>
    </br></br>
    Model Name :
    <input name="model_name" type="text"/>
    </br></br>
    Seating :
    <input name="seating" type="text"/>
    </hr>
    <button type="submit"> Add Flight and Airplane</button>
    </hr>
</form>
<h1>Add Pilot to Flight</h1>
<form method="post" action="">
    First Name :
    <input name="first_name" type="text"/>
    </br></br>
    Last Name :
    <input name="last_name" type="text"/>
    </br></br>
    License :
    <input name="license" type="text"/>
    </br></br>
    Pilot Rank:
    <select name="pilot_rank">
        <option value="Captain">Captain</option>
        <option value="First_Officer">First Officer</option>
        <option value="Junior_Officer">Junior Officer</option>
    </select>
    </br></br>
    Flight Id :
    <input name="fId" type="text"/>
    </hr>
    <button type="submit">Add Pilot to Flight</button>
    </hr>
</form>
<h1>Add Passenger</h1>
<form method="post" action="">
    First Name :
    <input name="first_name" type="text"/>
    </br></br>
    Last Name :
    <input name="last_name" type="text"/>
    </br></br>
    Day Of Birth :
    <input name="dob" type="text"/>
    </br></br>
    Gender :
    <select name="gender">
        <option value="Female">Female</option>
        <option value="Male">Male</option>
    </select>
    </hr>
    <button type="submit">Add Passenger</button>
    </hr>
</form>
<h1>Add Passenger to Flight</h1>
<form method="post" action="">
    Add Passenger With an Id of
    <input name="pid" type="text"/>
    to a Flight With an Id of
    <input name="fid" type="text"/>
    </hr>

    <button type="submit">Add Passenger to Flight</button>
    </hr>
</form>
<h1>Add Flight to Passenger <span style="font-size: 16px;vertical-align: middle;">(Give a Passenger Another Flight Ticket to his\her Collection of flight tickets)</span>
</h1>
<form method="post" action="">
    Add a ticket for a flight with an Id of
    <input name="fid" type="text"/>
    to a Passenger With an Id of
    <input name="pid" type="text"/>
    </br></br>
    <span style="font-weight:bold;">(In Real Word Terms - Add the Flight Ticket to Passenger's Collection of Flight Tickets)</span>
    </hr>
    <button type="submit">Add Flight (Ticket) to Passenger's Flight Tickets</button>
    </hr>
</form>

</body>
</html>
