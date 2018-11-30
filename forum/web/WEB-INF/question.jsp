
                                 <main class="container">
                                     <ul class="list-group" style="padding-top: 2em;">
                                         <li class="list-group-item" style="background-color: #544A80; color: #C0BB95;">
                                             <a href="menu" >retour au menu</a>
                                             <br>
                                             <h3>${categorie}</h3>
                                             <h5>Les différentes questions</h5>
                                         </li>
                                         <li class="list-group-item" >
                                             
                                               <c:forEach items="${questions}" var="item"> 
                                                   
                                                            <div class="card" >
                                                               
                                                                    
                                                               
                                                                <div class="card-body">
                                                                     <div class="d-flex justify-content-between mb-3">
                                                                         <div class="p-2 "><i><c:out value="${item.date_de_creation}"></c:out></i></div>
                                                                         <div class="p-2 "><i><c:out value="${item.categorie.nom_categorie}"></c:out> </i></div>
                                                                         <div class="p-2"><i><c:out value="${item.utilisateur.username}"></c:out></i></div>
  </div>
                                                               
                                                                 <hr>
                                                                 <p style="padding:1em;">  <b><c:out value="${item.question}"></c:out></b></p>
                                                                    <hr>
                                                                     <a href="reponse?id=<c:out value="${item.id_question}"></c:out>">reponses</a> 
                                                                </div>
                                                              
                                                                  
                                                           
                                                            </div>
                                                     <hr>
                                                    </c:forEach>
                                         </li>
                                         
                                
                                                  
                                          
                                     
                                     
                                         <li class="list-group-item">
                                                                                 <a href="formulairequestion?id=${sessionScope.idCategorie}" class="btn btn-primary" >
  Poser une question ! 
</a>
                                         </li>
                                         
                                

       </ul>
                                 </main>
 
 