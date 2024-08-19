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
    <title>Doctor Home</title>
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


.bBorder{
  border-top: none;
}

   
  .menu{
 width: 100%;
background-color:white;
position:fixed;
top:0px;
  
  }

   /*==============Herosection==============================*/ 
   
   
   .hero-section {
   background: url(${pageContext.request.contextPath}/views/Clinic/doctor/doctorImage/profileslide.jpg) no-repeat center center;
      background-size: cover;
      height:450px;
       margin-top:110px;
       background-size: cover;
   	   padding-top:30px;
       color: #1f0202;
    }

   .sinup{
    position: relative;left: 179px;color: rgb(12, 137, 240); width: 100px;font-weight: bold;
   } 
    .hero-section>.container>h2{
     
      font-family:'Asar' ;
    
  } 
/*==========slide Patient /Appoment====*/
  .total_appoment{
    position: relative;
    font-size: 13px;
  }
  .profile{
   position: relative;
   top: 6px;
  }
  /*==========slide Patient /Appoment====*/
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

    .pwelcome{
    font-size: 12.5px;
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
  
    
     <nav class="navbar navbar-expand-lg  navbar-dark bg-white " style="border-bottom: 2px solid rgba(73, 117, 214, 0.505) ;">
      <div class="container-fluid">
      
        <div class="navbar-brand logo_margin " > <img src="${pageContext.request.contextPath}/views/img/HHicon1.jpg" alt="Logo" style="width:60px;height:60px;" class="rounded-pill"> 
          <span class="logotext" >Health Hub</span>
        </div>
        <span class="navbar-toggler " style="background-color: #0d222486;" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon" style="color: black;"></span>
        </span>

        <div class="collapse navbar-collapse justify-content-end menulist bBorder" id="collapsibleNavbar" style="padding-right:130px;font-family: 'Asar';">
          <ul class="navbar-nav ">
            
            <li class="nav-item">
              <a class="nav-link text-dark address" href="${pageContext.request.contextPath}/views/Clinic/doctor/index.jsp">HOME</a>
            </li>
           
            

            <li class="nav-item">
              <a class="nav-link text-dark address" href="${pageContext.request.contextPath}/schedulePatient">SCHEDULE PATIENT</a>
            </li>  
 
            <% String doctorname=(String) session.getAttribute("dname"); %>
            <li class="nav-item" >
              <div class="dropdown ">
                  <a  class=" dropdown-toggle profile mb-sm-5" data-bs-toggle="dropdown" style="text-decoration: none;color: black;">
                    <%= doctorname %>
                  </a>
                  <ul class="dropdown-menu ddrop">
                    
                      <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/doctor/doctorProfile.jsp">Update Profile</a></li>
                      <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/doctor/ChangePw.jsp">Change Password</a></li>
                      <li><a class="dropdown-item bg-white text-primary" href="${pageContext.request.contextPath}/views/Clinic/Home.jsp">Logout</a></li>
                    </ul>
                  
            </li> 
            
          </ul>
        </div>
      </div>
    </nav>
    
  </div>

  <!--SLIde IMG-->
  <!-- Hero Section -->
  <div class="hero-section">
    <div class="container mt-5 col-md-6 col-lg-4 shadow p-5 mb-5 bg-body-tertiary rounded">
     <h2 class="text-center ">Welcome Doctor</h2>
    
   </div>
   </div>
  
      <footer class="navbar footernav" style="background-color: rgb(5, 55, 91) ;text-align: center;">
       <p style="width: 100%;margin: auto; font-size: small;">www.healthhub.com</p>
      </footer>
  
</body>
 
</html>