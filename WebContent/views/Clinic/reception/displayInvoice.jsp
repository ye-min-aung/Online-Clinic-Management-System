<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.*" %>
<%@page import="Controller.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=El Messiri "> 
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family= Baumans"> 
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family= Asar"> 
  <title>Reception  Invoice</title>
<style>
	body {
  font-family: Arial, sans-serif;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: center;
}

th {
  background-color: #f0f0f0;
}

td {
  background-color: #fff;
}
        
        *{
  margin: 0;
  box-sizing: border-box;
}
.outermenu{
 
  height: 40px;
  border-bottom: 1px solid rgba(73, 117, 214, 0.505) ;
  box-sizing: 15px 12px;
 line-height: 40px;
  
}
.outermenu>.left{
  padding-left: 9%;
}
.outermenu>.left>a{
  text-decoration: none;
  color: black;
  font-size: 12.6px;
  
}
.logotext{
  color: black;
  position: relative;
  top: 5px;
  left: 2px;
   font-family: 'El Messiri';
   font-size: 22px;
   font-weight: bold;
   background-image: linear-gradient(to right,rgb(25, 90, 137),rgb(26, 136, 214),rgb(53, 137, 4),rgb(16, 133, 216),rgb(65, 96, 3));
   -webkit-background-clip: text;
   -webkit-text-fill-color: transparent;
   display: inline;
}
.logo_margin{
  position: relative;
  left:70px;
  bottom: 9px;
  width:150px;
  height:60px;
}

.nav-item{
  margin-left: 40px;
}


.bBorder{
  border-top: none;
}

  .address{
    font-size: 14.5px;
  }
  .address:hover{
    background-color: rgba(43, 187, 240, 0.249);
  border-bottom: 2px solid rgba(23, 25, 26, 0.279);
  transition: 0.1s ease-in-out;
  border-radius:10px;
  }
 

  .outer_icon_div{
    border: 1px solid wheat;
    border-radius: 50%;
    line-height: 70px;
    width: 70px;
    height: 70px;
    background-color: rgba(147, 192, 251, 0.847);
    
  }
  .serviceicon{
    font-size: 30px;
  }
  .menu{
 width: 100%;
background-color:white;
position:fixed;
top:0px;
  
  }

   /*==============Herosection==============================*/ 
   
   
   .hero-section {
       margin-top:110px;
       background-size: cover;
   	   padding-top:30px;
       color: #1f0202;
       padding-bottom:300px;
    }
   
    .footernav{
    color: white;
  	padding-top: 20px;
  	padding-bottom: 20px;
 	
  }
 
  .advcard{
    position: relative; 
    font-family: 'Asar';
    top:-70px;
}  
</style>
</head>
<body>
  <!--  -->
  <div class="menu">
    <div class="nav-bar outermenu d-flex justify-content-between">
      <div class="left">
        <a href="#" style="border-right: 2px solid gainsboro;"><i class="fa-solid fa-location-dot " style="color: rgb(16, 123, 198);"></i>&nbsp;<span class="">Hlaing </span>&nbsp;&nbsp;</a>
        <a href="#" style="border-right: 2px solid gainsboro;"><i class="fa-solid fa-envelope " style="color: rgb(16, 123, 198);"></i>&nbsp;hl12@gmail.com&nbsp;&nbsp;</a>
        <a href="#" ><i class="fa-solid fa-phone-flip" style="color: rgb(16, 123, 198);"></i>&nbsp;+95 422233333</a>
      </div>
     
  </div>
    
      
       <nav class="navbar navbar-expand-lg  navbar-dark bg-white " style="border-bottom: 2px solid rgba(73, 117, 214, 0.505) ;">
        <div class="container-fluid">
        
         <div class="navbar-brand logo_margin " > <img src="/ClinicManagementSystem/views/img/HHicon1.jpg" alt="Logo" style="width:60px;height:60px;" class="rounded-pill"> 
            <span class="logotext" >Health Hub</span>
          </div>
          <span class="navbar-toggler " style="background-color: #0d222486;" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon" style="color: black;"></span>
          </span>
  
          <div class="collapse navbar-collapse justify-content-end menulist bBorder" id="collapsibleNavbar" style="padding-right:130px;font-family: 'Asar';">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
              <li class="nav-item address">
                <a class="nav-link  text-dark" aria-current="page" href="/ClinicManagementSystem/views/Clinic/reception/receptionIndex.jsp">HOME</a>
              </li>
              <li class="nav-item address">
                <a class="nav-link text-dark" href="/ClinicManagementSystem/Reception/viewPatientList">PATIENT INFO</a>
              </li>
              <li class="nav-item address">
                <a class="nav-link text-dark" href="/ClinicManagementSystem/Appointment/scheduleAppointment">SCHEDULE APPOINTMENT</a>
              </li>
              <li class="nav-item address">
                <a class="nav-link text-dark" href="/ClinicManagementSystem//Reception/viewInvoiceList">VIEW INVOICE</a>
              </li>
              <% String receptionname=(String) session.getAttribute("receptionName"); %>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-dark" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                 <%=receptionname %>
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item bg-white text-primary" href="/ClinicManagementSystem/views/Clinic/reception/receptionUpdateProfile.jsp">Update Profile</a></li>
                  <li><a class="dropdown-item bg-white text-primary" href="/ClinicManagementSystem/views/Clinic/reception/receptionChangePassword.jsp">Change Password</a></li>
                  <li><a class="dropdown-item bg-white text-primary" href="/ClinicManagementSystem/views/Clinic/Home.jsp">Logout</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      
    </div><br>
  <div class="hero-section">
  
 <center><h3>Invoice Lists</h3></center><br>
 <div class="d-flex justify-content-center">  
 	<form action="/ClinicManagementSystem/Reception/viewInvoiceList" method="post" class="d-flex " style="float:left">
           <input class="form-control me-2" type="search" placeholder="Search" name="searchName" aria-label="Search" style="width: 300px;">
           <button class="btn-success me-3" type="submit">Search</button>
       </form>
       <form action="/ClinicManagementSystem/Reception/viewInvoiceList" method="get" style="float:left">
           <button class="btn btn-success" type="submit">View All</button>
       </form>
   </div><br><br>
	<table style="width:95%;"class="ms-4">
	<tr >
            <th class="bg-success text-white">Patient Name</th>
            <th class="bg-success text-white">Doctor Name</th>
            <th class="bg-success text-white">Date</th>
            <th class="bg-success text-white">Consultation Fee</th>
            <th class="bg-success text-white">Total Cost</th>
        </tr>
       
        <% ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices"); %>
        <% for (Invoice i : invoices) { %>
        
        <tr>
            <td><%= i.getPatient_name() %></td>
            <td><%= i.getDoctor_name() %></td>
            <td><%= i.getPrescription_date() %></td>
            <td><%= i.getConsultation_fee() %></td>
            <td><%= i.getTotal_cost() %></td>
        </tr>
        <% } %>
        
    </table>
  </div>
     
        <footer class="navbar footernav" style="background-color: rgb(5, 55, 91) ;text-align: center;">
         <p style="width: 100%;margin: auto; font-size: small;">www.healthhub.com</p>
        </footer>
</body>
</html>