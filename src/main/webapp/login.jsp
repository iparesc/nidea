
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
<jsp:include page="templates/alert.jsp"></jsp:include>


<div  id="login" >  
        
        <form class="form-signin" action="login" method="post">  
            <div class="form-group"> <label for="user">User Name</label> <input type="text" class="form-control" id="user" placeholder="Enter email"> </div>  
            <div class="form-group"> <label for="pwd">Password</label> <input type="password" class="form-control" id="pwd" placeholder="Enter password"> </div>  
             <button type="submit" class="btn btn-primary">Submit</button> </form>  
    </div>
    
    <jsp:include page="templates/footer.jsp"></jsp:include>