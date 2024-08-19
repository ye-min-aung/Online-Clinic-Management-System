<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.*" %>
<%@page import="Controller.*" %>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

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
    <title>Login</title>
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
      background: url(${pageContext.request.contextPath}/views/Clinic/patient/img/slidedoctor.jpg) no-repeat center center;
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
    <div class="right">
      <!--END BOOKing-->
    
      <button type="button" class="booking" data-bs-toggle="modal" data-bs-target="#LoginModal">
        Make Booking
      </button>
      
      
<!--END BOOKing-->
</div>
</div>
  
    
     <nav class="navbar navbar-expand-lg  navbar-dark bg-white " style="border-bottom: 2px solid rgba(73, 117, 214, 0.505) ;">
      <div class="container-fluid">
      
        <div class="navbar-brand logo_margin " > <img src="${pageContext.request.contextPath}/views/Clinic/patient/img/HHicon1.jpg" alt="Logo" style="width:60px;height:60px;" class="rounded-pill"> 
          <span class="logotext" >Health Hub</span>
        </div>
        <span class="navbar-toggler " style="background-color: #0d222486;" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon" style="color: black;"></span>
        </span>

        <div class="collapse navbar-collapse justify-content-end menulist bBorder" id="collapsibleNavbar" style="padding-right:130px;font-family: 'Asar';font-size: 17px;">
          <ul class="navbar-nav ">
            <li class="nav-item">
              <a class="nav-link text-dark address" href="${pageContext.request.contextPath}/views/welcome/All.jsp">HOME</a>
            </li>
            <!--==================login Modal-->
            <li class="nav-item">
              <a class="nav-link text-dark address" >
                <div type="button"  data-bs-toggle="modal" data-bs-target="#LoginModal" class="w-100" >
                  LOGIN
                </div>
                
                <!-- Modal -->
                <div class="modal fade " id="LoginModal">
                
                  <div class="modal-dialog  ">
                
                    <div class="modal-content">
                
                      <div class="modal-header" style="background-color: rgba(31, 125, 202, 0.845);">
                        <img src="../img/HHicon1.jpg" width="50px" height="50px" style="border-radius: 30px;">
                        <span class=" ms-1 h4" style="position: relative; top: 4px; 
                        color: rgb(253, 244, 244);position: relative; right: -8px;top:5px; font-family: 'El Messiri';
                        font-size: 22px;">HEALTH HUB</span>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" ></button>
                      </div>
                
                      
                        
                        <div class="modal-body" >
                          <div class="row ">
                            <div class="register_right col-12  p-3">
                              <form class="row g-3 mx-2 my-2" action="home.jsp" style="font-family: 'Asar';font-size: 17px;">
                                  
                                  <div class="col-12">
                                    <label class="form-label">Patient Name</label>
                                    <input type="text" class="form-control" name="patient_name" placeholder="Enter Patient Name" required autocomplete="off">
                                  </div>
                  
                                  <div class="col-12">
                                    <label class="form-label">Password</label>
                                    <input type="password" class="form-control" name="patient_password" placeholder="**********" required autocomplete="off">
                                  </div>
              


                                  <div class="col-12">
                                    <input type="submit" class="btn btn-outline-secondary "  value="Login">
                                    <input type="reset"  class="btn btn-outline-secondary bg-danger text-white"  value="Cancel">
                                  </div>
                                    

                                  <br>
                                  <p style="text-align: center;">------OR------</p>
                                  <p type="button" class="sinup" data-bs-toggle="modal" data-bs-target="#RegisterModal" 
                                 >
                                    Sing Up
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

 <!-----============Register=============-->
            <li class="nav-item">
              <a class="nav-link text-dark address" >
                <div type="button"  data-bs-toggle="modal" data-bs-target="#RegisterModal" class="w-100" >
                  REGISTER
                </div>
                
                
                <div class="modal fade" id="RegisterModal">
                
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
                              
                            
                                <form class="row g-lg-2 g-1 mx-2 my-2" action="home.jsp"    style="font-family: 'Asar';font-size: 17px;"  >                             <form class="row g-3 mx-2 my-2" action="home.html" style="font-family: 'Asar';font-size: 17px;">
                                  
                                  <div class="col-md-6">
                                    <label class="form-label" >Patient Name</label>
                                    <input type="text" class="form-control bginput" name="patient_name" placeholder="Enter Patient Name" required autocomplete="off">
                                  </div>

                                 

                                  <div class="col-md-6">
                                    <label class="form-label">Patient Age</label>
                                    <input type="text" class="form-control bginput" name="patient_age" placeholder="Enter Patient Age" required autocomplete="off">
                                  </div>


                                  <div class="col-md-6">
                                    <label class="form-label">Date Of Birth</label>
                                    <input type="date" class="form-control bginput" name="patient_birth_date" placeholder="01/2/2024" required autocomplete="off">
                                  </div>

                                  <div class="col-md-6">
                                    <label class="form-label">Password</label>
                                    <input type="password" class="form-control bginput" name="patient_password" placeholder="Enter Password">
                                  </div>


                                  <div class="col-12">
                                    <label class="form-label">Address</label>
                                    <input type="text" class="form-control bginput" name="patient_address" placeholder="Enter Patient's Address"required autocomplete="off">
                                  </div>
                  
                                  <div class=" col-12 col-md-6">
                                    <label class="form-label">Gender</label>
                                    
                                      <select class="form-select bginput" name="patient_gender" required>
                                        <option selected disabled value="">Select gender</option>
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                      </select>
                                    
                                  </div>
                                 
                                  <div class="col-md-6">
                                    <label class="form-label">Contact Number</label>
                                    <input type="text" class="form-control bginput" name="patient_contant_no" placeholder="094556578" required autocomplete="off">
                                  </div>
                               <br>
                                  <div class="col-12">
                                    <input type="submit" class="btn btn-outline-secondary"  value="Register">
                                    <input type="reset"  class="btn btn-outline-secondary bg-danger text-white"  value="Cancel">
                                   
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
            <li class="nav-item">
              <a class="nav-link text-dark address" href="about.html">ABOUT</a>
            </li>
           
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
          <button type="button" class="booking" data-bs-toggle="modal" data-bs-target="#LoginModal">
            Make Booking
          </button>
          
        </div>
  </div>
 
  
   
      <footer class="navbar footernav" style="background-color: rgb(5, 55, 91) ;text-align: center;">
       <p style="width: 100%;margin: auto; font-size: small;">www.healthhub.com</p>
      </footer>
  
</body>
 
</html>