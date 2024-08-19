<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    


    <title>Patient of Dr Hla Aung</title>
    <style>
*{
  margin: 0;
  box-sizing: border-box;
}

.outermenu{
  height: 40px;
  border-bottom: 1px solid gainsboro;
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
.outermenu>.right{
  padding-right: 10%;
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
.outermenu>.right{
  padding-right: 10%;
}
.booking{
 cursor: pointer;
 background-color: rgba(36, 94, 209, 0.847);
 color: aliceblue;
 

 border: none;
 padding-left: 25px;
 padding-right: 25px;
 height: 40px;
} 

.logo_margin{ 
  position: relative;
  left:70px;
  bottom: 9px;
  width:150px;
  height:60px;
}
/*==============Booking==============================*/
.bginput,.selectinput{
        
        border-top: 2px solid rgba(30, 145, 227, 0.772);
        border-right: 2px solid rgb(33, 149, 232);
      
      }
      .btn-outline-secondary:first-child{
       
        background-color: rgba(36, 94, 209, 0.847);
      }
      .btn-outline-secondary:last-child{
       
        color: black;
      }
      
      .modal-body{
        background-color:white;
      }
     
       
      
        
   /*==============Booking==============================*/ 
   .menu{
 
  z-index: 1;
  width: 100%;
  background-color:white;
  }
   /*==============Herosection==============================*/ 
   
   
   .hero-section {
      background: url(${pageContext.request.contextPath}/views/Clinic/doctor/doctorImage/profileslide.jpg) no-repeat center center;
      background-size: cover;
     display: flex;
      
       background-size: cover;
   	   padding-top:40px;
       color: #1f0202;
    }
   
    
    .hero-section>.container{
      
      color: rgba(2, 18, 26, 0.849);
      height: 400px;
      position: relative;
     left: 240px;
      font-family:'Asar' ;
   
    }
   .pwelcome{
    font-size: 14px;
   }
    .hero-section>.container>h2{
     
      
      font-weight: bolder;
  } 
 
  .advcard{
    position: relative; 
    font-family: 'Asar';
    top:-70px;
}
.nav-item{
  margin-left: 40px;
}

.imgtext{
  position: relative; top: -365px;
  width: 350px;
  padding-left: 20px;
 color: rgba(36, 94, 209, 0.847);

}
.imghieht{
  height: 465px;
}
.bBorder{
  border-top: none;
}


  .profile{
   position: relative;
   top: 6px;
  }

  .address{
    font-size: 14.5px;
  }
  .address:hover{
    background-color: rgba(43, 187, 240, 0.249);
    border-bottom: 2px solid rgba(11, 95, 173, 0.279);
    transition: 0.1s ease-in-out;
    border-radius:10px;
  }
  .address:hover #App{
    background-color: rgba(43, 187, 240, 0.02);
  }
  #App{
    background-color: white;
   
  }
 
  .footernav{
    color: white;
    padding-top: 20px;
    padding-bottom: 20px;
 
  }
 
@media screen and (max-width:600px) and (min-width:400px){
  .outermenu>.left{
  padding-left: 5px;
}

.outermenu>.right{
  padding-right: 1%;
}
 
  .bBorder{
    border-top: 1px solid rgb(229, 215, 215);
  }
.nav-item:hover{
  margin-left: 10px;
  
 
}
.logo_margin{
  position: relative;left:-10px;
 
}



.imghieht{
  height: 400px;
}
.address:hover{
background-color: rgba(43, 187, 240, 0.249);
  border-bottom: 2px solid rgba(11, 95, 173, 0.279);
  transition: 0.3s ease-in-out;
  border-radius:10px;
  padding-left: 40px;
}
.booking{
 
 padding-left: 20px;
 padding-right: 20px;
} 
.hero-section{
   position: relative;
  
    }
.hero-section>.container{
      
      
      height:auto;
      top: -80px;
     left: 0px;
   
   
    }
     .pdoctor{
    padding-top:30px;
    }
    

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
       <!--BOOKing-->
      <div class="right">
       
      
        <button type="button" class="booking" data-bs-toggle="modal" data-bs-target="#BookingeModal" >
          Make Booking
        </button>
        
        <!-- Modal -->
        <div class="modal fade" id="BookingeModal" style="padding-top:90px;">
        
          <div class="modal-dialog ">
                
            <div class="modal-content">
        
              <div class="modal-header" style="background-color: rgba(40, 136, 214, 0.82);">
                <img src="${pageContext.request.contextPath}/views/Clinic/patient/img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 50% ; background-color: aliceblue;">
                <span class="  h5" style="position: relative; right: -8px;top:5px;color: white; font-family: 'El Messiri';
                font-size: 22px;">HEALTH HUB</span>
                <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
              </div>
        
              
                 <!--REForm-->
                 <div class="" >
                  <div class="row">
                      
                      <div class="col-12">
                    
                        <form class="row g-3 px-5 pb-3" action="/ClinicManagementSystem/Appoinment" method="post" style="font-family: 'Asar'; font-size: 17px;">
                          <div class="col-12">
                            <label class="form-label">Specialists</label>
                            <select name="doctor_specialization" class="form-select selectinput" aria-label=".form-select-sm example" >
                              <option selected disabled>Select Specialists</option>
                              <option value="1">Heart</option>
                              <option value="2">General</option>
                              <option value="3">Cancer</option>
                              <option value="4">Diabetes</option>
                              <option value="5">Skin</option>
                            </select>
                          </div>
                         
                          <div class="col-12">
                            <label class="form-label">Date</label>
                            <input type="date" class="form-control bginput"  name="appointment_date" placeholder="Enter Appointment"required autocomplete="off">
                          </div>
                          <div class="col-12">
                          	<%
   							 String patientId = (String) session.getAttribute("patientId");
        					%>
        					<input type="hidden" name="patient_id" value="<%= patientId%>">
                          </div>
                          <div class="col-12">
                          	<%
   							 String receptionId = (String) session.getAttribute("receptionId");
        					%>
        					<input type="hidden" name="reception_id" value="<%= receptionId%>">
                          </div>
                          <div class="col-12" >
                            <label >Select Time</label>
                          </div>
                          <div class="" style="border: 1px solid blue;">
                            
                            <input type="radio" class="bginput ms-2" id="dname" name="appointment_time" value="09:00AM-09:30AM" required>
                            <span style=" font-family: 'Asar'; font-size: 13.5px;" class="ms-1 me-5">09:00AM-09:30AM</span>
                            
                            <input type="radio" class="bginput" id="dname" name="appointment_time" value="09:30AM-10:00AM" required>
                            <span style=" font-family: 'Asar'; font-size: 13.5px;" class="mx-1">09:30AM-10:00AM</span>
                            <br>
                            <input type="radio" class="bginput ms-2" id="dname" name="appointment_time" value="10:00AM-10:30AM" required>
                            <span style=" font-family: 'Asar'; font-size: 13.5px;" class="ms-1 me-5">10:00AM-10:30AM</span>
                             
                            <input type="radio" class="bginput" id="dname" name="appointment_time" value="10:30AM-11:00AM" required>
                            <span style=" font-family: 'Asar'; font-size: 13.5px;" class="mx-1">10:30AM-11:00AM</span>
                            <br>
                            <input type="radio" class="bginput ms-2" id="dname" name="appointment_time" value="11:00AM-11:30AM" required>
                            <span style=" font-family: 'Asar'; font-size: 13.5px;" class="mx-1 me-5">11:00AM-11:30AM</span>

                            <input type="radio" class="bginput" id="dname" name="appointment_time" value="11:30AM-12:00AM" required>
                            <span style=" font-family: 'Asar'; font-size: 13.5px;" class="mx-1">11:30AM-12:00AM</span>

                          </div>
                          
                          <br>
          
                          <div class="col-12">
                            <input type="submit" class="btn btn-outline-secondary text-white"  value="Booking"  onclick="alert('DD')">
                            <input type="reset"  class="btn btn-outline-secondary bg-danger text-white"  value="Cancel">
                          </div>
                        </form>
                     </div>
                    </div>
                  
              </div>
                <!--REForm-->
              </div>
         </div>
      </div>
    </div>
  <!--END BOOKing-->
</div>

  
    
<nav class="navbar navbar-expand-lg  navbar-dark bg-white " style="border-bottom: 1px solid rgba(220, 195, 195, 0.505) ;font-family: 'Asar';">
      <div class="container-fluid">
      
        <div class="navbar-brand logo_margin " > <img src="${pageContext.request.contextPath}/views/Clinic/patient/img/HHicon1.jpg" alt="Logo" style="width:60px;height:60px;font-family: 'Asar';" class="rounded-pill"> 
          <span class="logotext" >Health Hub</span>
        </div>
        <button class="navbar-toggler " style="background-color: #0d222486;" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon" style="color: black;"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end menulist bBorder" id="collapsibleNavbar" style="padding-right: 70px;">
          <ul class="navbar-nav ">
            <li class="nav-item ps-1">
              <a class="nav-link text-dark address Active" href="${pageContext.request.contextPath}/views/Clinic/patient/patientHome.jsp">HOME</a>
            </li>
            
             <!--------===================Doctorlist============-->
           <li class="nav-item ps-1">
              <a class="nav-link text-dark address" href="${pageContext.request.contextPath}/views/Clinic/patient/patientDoctorList.jsp">DOCTOR LIST</a>
            </li>
            <!--------===================ENDDoctorlist============-->
            
            <!-- Appoinment Status -->
            
            <li class="nav-item">
            <a class="nav-link text-dark address">
            <form action="/ClinicManagementSystem/Appoinment" method="get">
        		<input type="hidden" name="patient_id" value="<%= patientId%>">
              <button  id="App" type="submit" style="border:none; ">
              	APPOINTMENT
              </button>
            </form>
            </a>
            </li>
            <!-- Appoinment Status -->
 		<!-- medicalINof -->
            <li class="nav-item">
             <a class="nav-link text-dark address">
            <form method="get" action="/ClinicManagementSystem/patientMedicalInfo">
            <input type="hidden" name="patient_id" value="<%= patientId%>">
              <button id="App" style="border:none;">MEDICAL INFO</button>
              </form>
               </a>
            </li>
            <!-- medicalINof -->
             <li class="nav-item ps-1" >
               <div class="dropdown ">
                   <a  class=" dropdown-toggle profile mb-sm-5" data-bs-toggle="dropdown" style="text-decoration: none;color: black;">
                     PROFILE
                   </a>
                   <ul class="dropdown-menu ddrop">
                     <li><a class="dropdown-item" href="${pageContext.request.contextPath}/views/Clinic/patient/patientUpdateProfile.jsp">Update profie</a></li>
                     <li><a class="dropdown-item" href="${pageContext.request.contextPath}/views/Clinic/patient/patientChangePassword.jsp">Change Password</a></li>
                     <li><a class="dropdown-item" href="${pageContext.request.contextPath}/views/welcome/All.jsp">Log out</a></li>
                   </ul>
                 
             </li> <br>
             <li class="nav-item ps-1">
               <a class="nav-link text-dark address" href="${pageContext.request.contextPath}/views/Clinic/patient/about.jsp">ABOUT</a>
             </li>
            
           </ul>
         </div>
       </div>
   </nav>
 </div>
<!--SLIde IMG-->
<div class="hero-section">
    <div class="container mt-5">
        <div class="row mt-5 " >
            <div class="col-12 col-md-3   p-md-2" style="text-align: center;background-color: rgba(255, 255, 255, 0.491);">
               <div class=" " style="background-color: #b9aeae70;"><img src="${pageContext.request.contextPath}/views/Clinic/patient/img/doctor1.jpg" width="210px" height="200px"></div> 
            </div>
            <div class="col-12 col-md-4 border text-dark pdoctor" style="background-color: rgba(255, 255, 255, 0.491);">
            
            <%
            String dQualification=request.getParameter("dQualification");
            String dSpecialization=request.getParameter("dSpecialization");
            String dContactNo=request.getParameter("dContactNo");
            String dConsultation=request.getParameter("dConsultationFee");
            
            %>
          
          <h3 class="text-primary">Dr. Hla Aung</h3>
            <p><strong>-The best doctor at least 5 years on ground experience.</strong></p>
           <p><strong>-Qualification:</strong> ${requestScope.dQualification}</p>
           <p><strong>-Specialization:</strong> ${requestScope.dSpecialization}</p>
           <p><strong>-Contact Number:</strong> ${requestScope.dContactNo}</p>
           <p><strong>-Consultation:</strong> ${requestScope.dConsultationFee}</p>
                
             
                    
                   
                   
                  
            </div>
           </div>
    </div>
  </div>

 
   
 <footer class="navbar footernav" style="background-color: rgb(5, 55, 91) ;text-align: center;">
  <p style="width: 100%;margin: auto; font-size: small;">www.healthhub.com</p>
 </footer>
    
      
    
        

</body>
 
</html>