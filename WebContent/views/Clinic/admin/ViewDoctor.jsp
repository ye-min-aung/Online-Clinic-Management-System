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
  <title>Admin(View Doctor)</title>
 <style>
	table {
	       border-collapse: collapse;
	       width: 98%;
	   }
	
	   th, td {
	       border: 1px solid #ddd;
	       padding: 8px;
	       text-align:center;
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
.menu{
  width: 100%;
background-color:white;
position:fixed;
top:0px;
  
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
  .footernav{
   color: white;
  padding-top: 20px;
  padding-bottom: 20px;
 
  }/*==============Herosection==============================*/ 
   
   
  .hero-section {
     margin-top:110px;
     background-size: cover;
     padding-top:30px;
     color: #1f0202;
   	margin-bottom:300px;
  
    }
  .advcard{
    position: relative; 
    font-family: 'Asar';
    top:-70px;
}  
</style>
   
</head>
<body>
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
      
        <div class="navbar-brand logo_margin " > 
        <img src="${pageContext.request.contextPath}/views/img/HHicon1.jpg" alt="Logo" style="width:60px;height:60px;" class="rounded-pill"> 
          <span class="logotext" >Health Hub</span>
        </div>
        <span class="navbar-toggler " style="background-color: #0d222486;" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon" style="color: black;"></span>
        </span>

        <div class="collapse navbar-collapse justify-content-end menulist bBorder" id="collapsibleNavbar" style="padding-right:130px;font-family: 'Asar';">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5"">
            <li class="nav-item">
              <a class="nav-link  text-dark" aria-current="page" href="${pageContext.request.contextPath}/views/Clinic/admin/AdminHome.jsp">HOME</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle text-dark  " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                DOCTOR
              </a>
              <ul class="dropdown-menu text-dark">
                <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/admin/AddDoctor.jsp">Add Doctor</a></li>
               
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle text-dark  " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                RECEPTION
              </a>
              <ul class="dropdown-menu text-dark">
                <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/admin/AddReception.jsp">Add Reception</a></li>
                <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/adminViewReceptionList">View Reception</a></li>
              </ul>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-dark  " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  PATIENT
                </a>
                <ul class="dropdown-menu text-dark">
                  
                  <li><a class="dropdown-item bg-white text-primary" href="/ClinicManagementSystem/patient">View Patient</a></li>
                </ul>
              </li>
            
            <li class="nav-item">
              <a class="nav-link text-dark" href="${pageContext.request.contextPath}/views/Clinic/admin/Income.jsp">INCOME</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle text-dark  " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  <%
    String adminName = (String) session.getAttribute("adminName");
    if (adminName != null) {
        %>
        <%= adminName %>
        <%
    } else {
        response.sendRedirect("/admin/login");
    }
%>
                </a>
              <ul class="dropdown-menu text-dark">
                <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/admin/editProfile.jsp">Update Profile</a></li>
                <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/admin/ChangePw.jsp">Change Password</a></li>
                <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/welcome/All.jsp">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
  </div><br>

          <div class="hero-section">  
 			<center><h3>Doctor Information</h3></center><br>
      <div class="d-flex justify-content-center">
       <form action="/ClinicManagementSystem/adminViewDoctorList" method="post" class="d-flex " style="float:left">
           <input class="form-control me-2" type="search" placeholder="Search Doctors" name="searchName" aria-label="Search" style="width: 300px;">
           <button class="btn btn-success me-3" type="submit">Search</button>
       </form>
        <form action="/ClinicManagementSystem/adminViewDoctorList" method="get" style="float:left" >
           <button class="btn btn-success" type="submit">View All</button>
       </form>
      </div>
  <br>
  <table class="m-3 ">
			<tr class="bg-success text-white">
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Gender</th>
				<th>Qualification</th>
				<th>Specialization</th>
				<th>Contact_No</th>
				<th>Address</th>
				<th>Email</th>
				<th>Experiences</th>
				<th>Fee</th>
				<th>Action</th>
				<th>Confirm_Account</th>
			</tr>

			<%
				HttpSession ss = request.getSession();

				ArrayList<Doctor> doctorInfo = (ArrayList<Doctor>)ss.getAttribute("doctorList");

				 for(Doctor d: doctorInfo){
			%>

			<tr>
				<td> <%=d.getDoctor_id() %> </td>
				<td> <%=d.getDoctor_name() %> </td>
				<td> <%=d.getDoctor_password() %> </td>
				<td> <%=d.getDoctor_gender() %> </td>
				<td> <%=d.getDoctor_qualification() %> </td>
				<td> <%=d.getDoctor_specialization() %> </td>
				<td> <%=d.getDoctor_contact_no() %> </td>
				<td> <%=d.getDoctor_address() %></td>
				<td> <%=d.getDoctor_email() %></td>
				<td> <%=d.getYear_of_experience() %></td>
				<td> <%=d.getConsultation_fee() %></td>
				<td> 
				 <form action="/ClinicManagementSystem/views/Clinic/admin/adminDoctorUpdate.jsp"  style="display: inline;">
                   <input type="hidden" name="doctor_id" value="<%=d.getDoctor_id()%>">
                      <button type="submit" class="btn btn-success btn-sm mb-2" name="doctorUpdate">Update</button>
                    </form>
                    <form action="/ClinicManagementSystem/admin/doctordelete" method="post" style="display: inline;">
                    <input type="hidden" name="doctor_id" value="<%=d.getDoctor_id() %>" >
                      <button type="submit" class="btn btn-danger btn-sm" name="doctorDelete">Delete</button>
                    </form>
                  </td>
				<td>
					<% if (d.getIs_confirmed() == 0) { %>
						<form action="/ClinicManagementSystem/admin/confirmDoctorAccount" method="post" style="display: inline;">
							<input type="hidden" name="doctor_id" value="<%=d.getDoctor_id() %>" >
							<button type="submit" class="btn btn-primary btn-sm" name="confirmAccount">Confirm Account</button>
						</form>
					<% } else { %>
						<span class="badge bg-success">Confirmed</span>
					<% } %>
				</td>
			</tr>
				<%
					}
				%>
			</table>
    </div>

      
      
      <footer class="navbar footernav mt-5" style="background-color: rgb(5, 55, 91) ;text-align: center;">
      <p style="width: 100%;margin: auto; font-size: small;">www.healthhub.com</p>
      </footer>
      </body>
      </html>
      