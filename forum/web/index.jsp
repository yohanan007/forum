
       
            <main class="container d-flex justify-content-center" style=" height:90%; border:none;">
                
                    <div class="p-2 align-self-center" style="width:50%; ">
                     <div class="card" style="width:100%;">
                        <div class="card-body">
                      <ul class="list-group"
                          style="background-color: transparent; text-align:center;">
                          
                          <!-- on test si l'utilisateur est connecté -->
                          <c:choose>
                              
                              <c:when test="${sessionScope.user != null}">
                                  <!-- si l'utilisateur est connecté -->
                                  <li class="list-group-item" 
                                                     style="background-color: transparent; border-style:none;">
                                      <h3>GARDE A VOUS ${sessionScope.user.username} ! </h3></li>
						  <li class="list-group-item"
                                                      style="background-color: transparent;  border-style:none;">
                                                      <a href="menu" class="btn btn-primary btn-block">menu</a></li>
						  <li class="list-group-item"
                                                      style="background-color: transparent;  border-style:none;">
                                                      <a href="moncompte" class="btn btn-primary btn-block">ton compte</a></li>
                                  
                              </c:when>
                              <c:otherwise>
                                  <!-- l'utilisateur n'est pas connecté -->
						 <li class="list-group-item" 
                                                     style="background-color: transparent; border-style:none;">
                                                     <h3>BIENVENUE SUR LE FORUM MILITAIRE</h3></li>
						  <li class="list-group-item"
                                                      style="background-color: transparent;  border-style:none;">
                                                      <a href="connexion" class="btn btn-primary btn-block">connexion</a></li>
						  <li class="list-group-item"
                                                      style="background-color: transparent;  border-style:none;">
                                                      <a href="inscription" class="btn btn-primary btn-block">inscription</a></li>
                             </c:otherwise>
                        </c:choose>
						  <li class="list-group-item"
                                                      style="background-color: transparent; border-style:none;">
                                                      <a href="#">régle d'utilisation du forum </a></li>
						</ul>
                        </div> 
                        <div class="card-footer">Une mesure exacte vaut l'avis d'un millier d'experts.</div>
                      </div>
                    </div>
                  
            </main>
            
         
        
           <c:if test="${reussi != null}">
                <p style="background-color: peru;"><c:out value="${reussi}"></c:out></p>
            </c:if>
  