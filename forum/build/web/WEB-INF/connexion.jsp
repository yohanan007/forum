<c:if test="${sessionScope.user != null}"><c:redirect url="moncompte"></c:redirect></c:if>
        <div class=" d-flex container justify-content-center" style=" height:90%;">
            <ul class="list-group  p-2 align-self-center" style="width:50%;" >
                <li class="list-group-item" style="background-color:#544A80; color: #C0BB95; text-align: center;"><h4>FORMULAIRE DE CONNEXION</h4></li>
                <li class="list-group-item">
                    
                    
            <form method="post" action="connexion" >
                <div class="form-group">
                      <label for="email">username :</label>
                                <div class="input-group mb-3">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text"><i style='font-size:24px' class='fas'>&#xf007;</i></span>
                                  </div>
                                  <input type="text" class="form-control" placeholder="Username" id="email" name="username" required>
                                </div>
                </div>
                 <div class="form-group">
                      <label for="pwd">mot de passe:</label>
                                    <div class="input-group mb-3">
                                   <div class="input-group-prepend">
                                     <span class="input-group-text"><i style='font-size:24px' class='fas'>&#xf21b;</i></span>
                                   </div>
                                   <input type="password" class="form-control" placeholder="Password" id="pwd" name="pwd" required>
                                 </div>
                 </div>
                   <br>
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                  
                  </form> 
                    </li>
                    <li class="list-group-item">    
            
            <a href="inscription">Pour vous inscrire</a>
                    </li>
                    <c:if test="${erreur != null}">
                        <li class="list-group-item list-group-item-alert">
                <p> <c:out value="${erreur}"></c:out></p>
                        </li>
            </c:if>
            </ul>
          

        </div>
             
        
        
   