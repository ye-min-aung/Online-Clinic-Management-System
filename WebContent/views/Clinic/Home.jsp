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
    <title>Clinic Home</title>
    <style>
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
.textareadiv>.form-control
{
    height: 20px;
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
.outermenu>.right{
  padding-right: 10%;
}
.booking{
 cursor: pointer;
 background-color: rgb(26, 130, 203);
 color: aliceblue;

 border: none;
 padding-left: 25px;
 padding-right: 25px;
 height: 40px;
} 
/*==============Model==============================*/

        .bginput{
        
          border-top: 2px solid rgba(26, 129, 203, 0.281);
          border-right: 2px solid rgba(26, 129, 203, 0.977);
        
        }
      .btn-outline-secondary:first-child{
        background-color:rgb(26, 130, 203);
        color: white;
      }
      .modal-body{
       background-color:white;
      }
        
   /*==============Model==============================*/    
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

.imgtext{
  position: relative;
   top: -365px;
  width: 350px;
  font-family: 'Asar';
 color: rgb(0, 5, 7);

}
/* .imghieht{
  height: 465px;
}  */
.bBorder{
  border-top: none;
}
.menu{
 
  width: 100%;
  background-color:white;
  
  }

   /*==============Herosection==============================*/ 
   
   .hero-section {
      background: url(/ClinicManagementSystem/views/img/slidedoctor.jpg) no-repeat center center;
      background-size: cover;
      height: 450px;
      display: flex;
      align-items: center;
      color: #fff;
    }
    .hero-section>.container{
      width: 500px;
      color: rgba(2, 18, 26, 0.849);
      height: 400px;
      position: relative;
      margin-left: 40px;
      top: 40px; font-family:'Asar' ;
   
    }

   .pwelcome{
    font-size: 15px;
   }
    .hero-section>.container>h2{
      font-weight: bolder;
  } 
 
  .advcard{
    position: relative; 
    font-family: 'Asar';
    top:-70px;
}
/*=========cardadv============*/
   .sinup{
    position: relative;left: 179px;color: rgb(12, 137, 240); width: 100px;font-weight: bold;
   } 
    .hero-section>.container>h2{
     
      font-family:'Asar' ;
      font-weight: bolder;
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
 
  }
  
 
@media screen and (max-width:600px) and (min-width:400px){
  .outermenu>.left{
  padding-left: 5px;
}
/*==========*/
.register_outer{
            width: 70%;
            margin: auto;
            margin-top: 90px; 
          }
/*================*/
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

.sinup{
   left: 145px;
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
.hero-section {
      
      height: 400px;
     
      
    }
.hero-section>.container{
      width: 350px;
      height: 600px;
      position: relative;
      top: 170px;
      margin-left: 10px;
    }
    .pwelcome{
    font-size: 12.5px;
   }
.advcard{
    position: relative; 
  top:0px}

}
    </style>    
</head>
<body id="body">
 
 <div class="menu">
  <div class="nav-bar outermenu d-flex justify-content-between">
    <div class="left">
      <a href="#" style="border-right: 2px solid gainsboro;"><i class="fa-solid fa-location-dot " style="color: rgb(16, 123, 198);"></i>&nbsp;<span class="">Hlaing </span>&nbsp;&nbsp;</a>
      <a href="#" style="border-right: 2px solid gainsboro;"><i class="fa-solid fa-envelope " style="color: rgb(16, 123, 198);"></i>&nbsp;hl12@gmail.com&nbsp;&nbsp;</a>
      <a href="#" ><i class="fa-solid fa-phone-flip" style="color: rgb(16, 123, 198);"></i>&nbsp;+95 422233333</a>
    </div>
   
</div>
</div>
  
    
     <nav class="navbar navbar-expand-lg  navbar-dark bg-white " style="border-bottom: 2px solid rgba(73, 117, 214, 0.505) ;">
      <div class="container-fluid">
      
        <div class="navbar-brand logo_margin " > <img src="${pageContext.request.contextPath}/views/img/HHicon1.jpg" alt="Logo" style="width:60px;height:60px;" class="rounded-pill"> 
          <span class="logotext" >Health Hub</span>
        </div>
        <span class="navbar-toggler " style="background-color: #0d222486;" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon" style="color: black;"></span>
        </span>

        <div class="collapse navbar-collapse justify-content-end menulist bBorder" id="collapsibleNavbar" style="padding-right:130px;font-family: 'Asar';font-size: 17px;">
          <ul class="navbar-nav ">
            <li class="nav-item">
              <a class="nav-link text-dark address" href="/ClinicManagementSystem/views/welcome/All.jsp">HOME</a>
            </li>
            <!--==================DOCTOR=====================-->
            <li class="nav-item">
              <a class="nav-link text-dark address" >
              <div type="button"  data-bs-toggle="modal" data-bs-target="#DoctorLoginModal" class="w-100" >
                  DOCTOR
                </div>
                
                <!-- Modal -->
                
                <div class="modal fade " id="DoctorLoginModal">
                
                  <div class="modal-dialog  ">
                
                    <div class="modal-content">
                
                      <div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                        <img src="/ClinicManagementSystem/views/img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                        <span class=" ms-1 h4" style="position: relative; top: 4px; 
                        color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                        font-size: 22px;">HEALTH HUB</span>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                      </div>
                
                      
                        
                        <div class="modal-body" >
                          <div class="row ">
                            <div class="register_right col-12  p-3">
                            
                              <form class="row g-3 mx-2 my-2" action="/ClinicManagementSystem/doctor/login" method="post" style="font-family: 'Asar';font-size: 17px;">
                                  
                                  <div class="col-12">
                                    <label class="form-label">Doctor Name</label>
                                    <input type="text" class="form-control bginput" name="doctor_name" required pattern="[a-z A-Z]+\.[a-z A-Z]+$" placeholder="Enter Doctor's Name" title="Please enter Dr.Name Or name" >
                                  </div>
                  
                                  <div class="col-12">
                                    <label class="form-label">Password</label>
                                    <input type="password" class="form-control bginput" name="doctor_password" placeholder="**********" required autocomplete="off">
                                  </div>
                                  <% if(request.getAttribute("DloginError") != null){%>
									 <div class="col-12 alert alert-danger">
									 <%= request.getAttribute("DloginError") %>
									 </div>
									 <%} %> 
									 
									

                                  <div class="col-12">
                                    <input type="submit" class="btn btn-outline-secondary "  value="Login">
                                    <input type="reset"  class="btn btn-outline-secondary bg-danger text-white"  value="Cancel">
                                  </div>
                                    

                                  <br>
                                  <p style="text-align: center;">------OR------</p>
                                  <p type="button" class="sinup" data-bs-toggle="modal" data-bs-target="#DoctorRegisterModal" 
                                 >
                                    Sign Up
                                </p>
                                </form>
                             
                              </div>
                           
                            </div>
                          
                        <!--login-->
                      </div>
                
                    </div>
                
                  </div>
                
                </div>
              </a>
            </li>
             <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

      <% if (request.getAttribute("DloginError") != null ) { %>
    <script>
        $(document).ready(function() {
            $('#DoctorLoginModal').modal('show');
        });
    </script>
<% } %>
            
           
            <!-----============Register=============-->

                <div class="modal fade" id="DoctorRegisterModal">
                
                  <div class="modal-dialog modal-lg">
                
                    <div class="modal-content">
                
                      <div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                        <img src="/ClinicManagementSystem/views/img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                        <span class="text-white ms-2 h4" style="position: relative; top: 4px; 
                        color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                        font-size: 22px;">HEALTH HUB</span>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                      </div>
                
                    
                       
                        <div class="modal-body">
                
                          <div class="row " style=" ">
                              
                              <div class="col-12 ">
                                <form action="/ClinicManagementSystem/doctor/register" method="post" enctype="multipart/form-data" style="font-family: 'Asar';font-size: 17px;">
                                     <% if(request.getAttribute("registerError") != null){%>
									 <div class="col-12 alert alert-danger">
									 <%= request.getAttribute("registerError") %>
									 </div>
									 <%} %>
                                    <div class="row ">
                                    
                                    <div class="mb-3 col-12 col-md-6 ">
                                       <label class="form-label">Doctor Name</label>
                                      
                                         <input type="text" class="form-control bginput" name="doctor_name" required  pattern="[a-z A-Z]+\.[a-z A-Z]+" placeholder="Enter Doctor's Name" title="Please enter Dr.Name Or name" >
                                       
                                     </div>
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Gender</label>
                                       
                                         <select class="form-select bginput" name="doctor_gender" required>
                                           <option selected disabled value="">Select gender</option>
                                           <option value="male">Male</option>
                                           <option value="female">Female</option>
                                         </select>
                                       
                                     </div>
                                     
                                      
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Qualification</label>
                                       
                                       <input type="text" name="doctor_qualification" class="form-control bginput"   placeholder="Enter Qualification"  required >
                                     </div>
                                     
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Specialization</label>
                                       
                                          <input type="text" class="form-control bginput" name="doctor_specialization" placeholder="Enter Specialization" required  pattern="[a-zA-Z]+$" title="Please enter alphaband and character">
                                       
                                     </div>
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Email</label>
                                       
    								<input type="email" class="form-control bginput" name="doctor_email" placeholder="Enter Email" required pattern="^[a-zA-Z0-9._%+-]+@gmail\.com$" title="Enter e-mail format and must contain @ and gmail.com">
                                       
                                     </div>
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Contact Number</label>
                                      
                                         <input type="tel" class="form-control bginput" name="doctor_contact_no" placeholder="Enter Contact Number" required pattern="09[0-9]{6,11}" title="Please enter a valid number for Contact">
                                       
                                     </div>
                                     <div class="mb-3 col-12 col-md-6">
                                        <label class="form-label">Password</label>
                                        
                                          <input type="password" class="form-control bginput" name="doctor_password" placeholder="*******" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number, one lowercase letter, one uppercase letter, and at least 8 characters">
                                        
                                      </div>
                                     
                                     
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label ">Year of Experience</label> 
                                       <input type="text" class="form-control bginput" name="year_of_experience"  placeholder="Enter Year of Experience" required pattern="[0-9]+" title="Please enter a valid number for Year of Experience">
                                       
                                     </div>
                                     <div class="mb-3 col-12 col-md-6 textareadiv">
                                       <label class="form-label ">Address</label>
                                       
                                         <textarea class="form-control bginput" name="doctor_address"  placeholder="Enter Address" required></textarea>
                                       
                                     </div>
                                     <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Consultation Fee</label>
                                       
                                         <input type="text" class="form-control bginput" name="consultation_fee" placeholder="Enter Consultation Fee" required pattern="[0-9]+[A-Za-z\s]+$" title="Please enter a valid number for Consultation Fee">
                                       
                                     </div>
                                    <div class="mb-3 col-12 col-md-6">
								        <label class="form-label">Doctor Image</label>
								        <input type="file" class="form-control" name="doctor_image" accept="image/*"> 
   									 </div>
                                     <div class="text-center">
                                       <button type="submit" class="btn btn-success " >Save Changes</button>
                                       <button type="reset" class="btn btn-danger ">Cancel</button>
                                     </div> 
                                   </div>
                                   </form>
                                  
                              </div>
                                
                            
                            </div>
                          
                      
                    
                        
                      </div>
                
                      
                
                    </div>
                
                  </div>
                
                </div></a> 
                <!-----============Register=============-->
            </li>
      

      <% if (request.getAttribute("registerError") != null ) { %>
    <script>
        $(document).ready(function() {
            $('#DoctorRegisterModal').modal('show');
        });
    </script>
<% } %>
<!--=================End Doctor==========-->

           <!--======================RECPPTION==============================-->
           <li class="nav-item">
            <a class="nav-link text-dark address" >
                <div type="button"  data-bs-toggle="modal" data-bs-target="#ReceptionLoginModal" class="w-100" >
                 RECEPTION
                </div>
                
                <!-- Modal -->
                <div class="modal fade " id="ReceptionLoginModal">
                
                  <div class="modal-dialog  ">
                
                    <div class="modal-content">
                
                      <div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                        <img src="/ClinicManagementSystem/views/img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                        <span class=" ms-1 h4" style="position: relative; top: 4px; 
                        color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                        font-size: 22px;">HEALTH HUB</span>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                      </div>
                
                      
                        
                        <div class="modal-body" >
                          <div class="row ">
                            <div class="register_right col-12  p-3">
                              <form class="row g-3 mx-2 my-2" action="/ClinicManagementSystem/Reception/receptionLogin" method="post" style="font-family: 'Asar';font-size: 17px;">
                            
                                  <div class="col-12">
                                    <label class="form-label">Reception Name</label>
                                    <input type="text" class="form-control bginput"  name="reception_name" placeholder="Enter reception's name" required autocomplete="off">
                                  </div>
                  
                                  <div class="col-12">
                                    <label class="form-label">Password</label>
                                    <input type="password" class="form-control bginput"  name="reception_password" placeholder="********" required autocomplete="off">
                                  </div> 
                                          
									<% if (request.getAttribute("rloginError") != null ) { %>
                                <div class="col-12 alert alert-danger">
                                <%= request.getAttribute("rloginError") %>
                                </div>
                 				<%} %>
                 				
                                  <div class="col-12">
                                    <input type="submit"  class="btn btn-outline-secondary "  value="Login">
                                    <input type="reset"  class="btn btn-outline-secondary bg-danger text-white"  value="Cancel">
                                  </div>
                                    

                                  <br>
                                  <p style="text-align: center;">------OR------</p>
                                  <p type="button" class="sinup" data-bs-toggle="modal" data-bs-target="#ReceptionRegisterModal" >
                                    Sign Up
                                </p>
                                </form>
                             
                              </div>
                           
                            </div>
                          
                        <!--login-->
                      </div>
                
                    </div>
                
                  </div>
                
                </div>
              </a>
            </li> 
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
   
   <% if (request.getAttribute("rloginError") != null ) { %>
    <script>
        $(document).ready(function() {
            $('#ReceptionLoginModal').modal('show');
        });
    </script>
<% } %>
            <!-----============Register=============-->

 <div class="modal fade" id="ReceptionRegisterModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
<div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                        <img src="/ClinicManagementSystem/views/img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                        <span class=" ms-1 h4" style="position: relative; top: 4px; 
                        color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                        font-size: 22px;">HEALTH HUB</span>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                      </div>      
       
      <div class="modal-body">
        <div class="row " style=" ">
          <div class="col-12 ">
            <form action="/ClinicManagementSystem/Reception/receptionRegister" method="post" style="font-family: 'Asar';font-size: 17px;">
              <div class="row ">
                <div class="mb-3 col-12 col-md-6 ">
                  <label class="form-label">Reception Name</label>
                  <input type="text" class="form-control bginput" name="reception_name" placeholder="Enter reception's name" required pattern="[A-Za-z\s]+$">
                </div>
                <div class="mb-3 col-12 col-md-6 ">
                  <label class="form-label">Reception Address</label>
                  <input type="text" class="form-control bginput" name="reception_address" placeholder="Enter reception's address" required>
                </div>
                <div class="mb-3 col-12 col-md-6">
                  <label class="form-label">Gender</label>
                  <select class="form-select bginput" name="reception_gender" required>
                    <option selected disabled value="">Select gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                  </select>
                </div>
                <div class="mb-3 col-12 col-md-6 ">
                  <label class="form-label">Date Of Birth</label>
                  <input type="date" class="form-control bginput" name="reception_birth_date" placeholder="Date Of Birth" required>
                </div>
                <div class="mb-3 col-12 col-md-6">
                  <label class="form-label">Reception Password</label>
                  <input type="password" class="form-control bginput" name="reception_password" placeholder="**********" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number, one lowercase letter, one uppercase letter, and at least 8 characters">
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-success " >Register</button>
                  <button type="reset" class="btn btn-danger ">Cancel</button>
                </div> 
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div></a> 
          </li>  

<!--======================RECEPTION==============================-->
           
<!--======================ADMIN==============================-->

                <li class="nav-item">
            <a class="nav-link text-dark address" >
              <div type="button"  data-bs-toggle="modal" data-bs-target="#AdminLoginModal" class="w-100" >
               ADMIN
              </div>
              
              <!-- Modal -->
              <div class="modal fade " id="AdminLoginModal">
              
                <div class="modal-dialog  ">
              
                  <div class="modal-content">
              
                    <div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                      <img src="${pageContext.request.contextPath}/views/img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                      <span class=" ms-1 h4" style="position: relative; top: 4px; 
                      color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                      font-size: 22px;">HEALTH HUB</span>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                    </div>
              
                    
                      
                      <div class="modal-body" >
                        <div class="row ">
                          <div class="register_right col-12  p-3">
                            <form class="row g-3 mx-2 my-2" action="/ClinicManagementSystem/admin/loign" method="post" style="font-family: 'Asar';font-size: 17px;">
                                
                                <div class="col-12">
                                  <label class="form-label">Admin Name</label>
                                  <input type="text" class="form-control bginput"  name="adminName" placeholder="Admin Name" required autocomplete="off">
                                </div>
                
                                <div class="col-12">
                                  <label class="form-label">Password</label>
                                  <input type="password" class="form-control bginput"  name="admin_password" placeholder="**********" required autocomplete="off">
                                </div>
                                <% if (request.getAttribute("loginError") != null ) { %>
                                <div class="col-12 alert alert-danger">
                                <%= request.getAttribute("loginError") %>
                                </div>
                                <%} %>

                                <div class="col-12">
                                  <input type="submit" class="btn btn-outline-secondary "  value="Login">
                                  <input type="reset"  class="btn btn-outline-secondary bg-danger text-white"  value="Cancel">
                                </div>
                                  

                                <br>
                                
                              </form>
                           
                            </div>
                         
                          </div>
                        
                      <!--login-->
                    </div>
              
                  </div>
              
                </div>
              
              </div>
           
         
          <!-----============Register=============-->

         
              
             <div class="modal fade" id="AdminRegisterModal">
              
                <div class="modal-dialog modal-lg">
              
                  <div class="modal-content">
              
                    <div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                      <img src="../img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                      <span class="text-white ms-2 h4" style="position: relative; top: 4px; 
                      color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                      font-size: 22px;">HEALTH HUB</span>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                    </div>
              
                  
                     
                      <div class="modal-body">
              
                        <div class="row " style=" ">
                            
                            <div class="col-12 ">
                              <form action="../Clinic/admin/AdminHome.html" style="font-family: 'Asar';font-size: 17px;">
                                  
                                  <div class="row ">
                                  
                                    <div class="mb-3 row">
                                      <label for="adminName" class="col-sm-5 col-form-label">Enter Name</label>
                                      <div class="col-sm-6">
                                        <input type="text" class="form-control" name="adminName" placeholder="Enter name" required>
                                      </div>
                                    </div> 
                                    <div class="mb-3 row">
                                      <label for="phone" class="col-sm-5 col-form-label">Enter Phone Number</label>
                                      <div class="col-sm-6">
                                        <input type="text" class="form-control" id="phone" placeholder="Enter Phone number" required>
                                      </div>
                                    </div> 
                                    <div class="mb-3 row">
                                      <label for="address" class="col-sm-5 col-form-label">Address</label>
                                      <div class="col-sm-6">
                                        <textarea class="form-control" id="address" rows="3" placeholder="Enter address" required></textarea>
                                      </div>
                                    </div> 
                                    <div class="text-center">
                                      <button type="submit" class="btn btn-success w-25">Save</button>
                                    </div> 
                                 </div>
                                 </form>
                                
                            </div>
                              
                          
                          </div>
                       
                    </div>
              
                    
              
                  </div>
              
                </div>
              
              </div></a> 

              <!-----============Refister=============-->
          </li>
<!--======================ENDADMIN==============================-->



          </ul>
        </div>
      </div>
    </nav>
    
  </div>

  <!--SLIde IMG-->
  <!-- Hero Section -->
  <div class="hero-section">
    <div class="container">
    
      <h1 class="">Welcome to our Clinical System</h1>
          <p class="pt-3 pwelcome" style="">Clinic are an essential part of the health-care syatem and having a complete Clinic Management System is a must today everymoment</p>
         
        </div>
  </div>
 
      <footer class="navbar footernav" style="background-color: rgb(5, 55, 91) ;text-align: center;">
       <p style="width: 100%;margin: auto; font-size: small;">www.healthhub.com</p>
      </footer>
      
     <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

      <% if (request.getAttribute("loginError") != null ) { %>
    <script>
        $(document).ready(function() {
            $('#AdminLoginModal').modal('show');
        });
    </script>
<% } %>
</body>
</html>