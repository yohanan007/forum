
                                 <main class="container">
                                    
                                     
                                     
                                     
                                     <c:forEach items="${reponses}" var="item" begin="0" end="0">
                                         
                                         <h3>  <c:out value="${item.questtion.question}"></c:out></h3>
                                         <a href="question?id=<c:out value="${item.questtion.categorie.id_categorie}"></c:out>">  revenir au menu des questions  </a>
                                     </c:forEach>
                                         
                                         
                                         
                                         
                                         
                                           <table class="table" style="margin-top: 2em;">
                                                <thead class="thead-dark">
                                                  <tr>
                                                    <th>date de création </th>
                                                    <th>reponse</th>
                                                    <th> id reponse</th>
                                                    <th>utilisateur</th>
                                                    <th>nom categorie</th>
                                                    
                                                  </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${reponses}" var="item"> 
                                                  <tr>
                                                    <td>     <c:out value="${item.date_de_post}"></c:out></td>
                                                    <td>   <c:out escapeXml="false" value="${item.reponse}"></c:out> </td>
                                                    <td>   <c:out value="${item.id_reponse}"></c:out> </td>
                                                    <td><c:out value="${item.utilisateur.username}"></c:out></td>
                                                    <td><a href="question?id=<c:out value="${item.questtion.categorie.id_categorie}"></c:out>&&categorie=${item.questtion.categorie.nom_categorie}"><c:out value="${item.questtion.categorie.nom_categorie}"></c:out></a></td>
                                                   
                                                  </tr>
                                                    </c:forEach>
                                                </tbody>
                                              </table>
                                     
                                         
                                         
                                         <!-- Button to Open the Modal -->
                                         <a href="formulairereponse?id=${sessionScope.idQuestion}" class="btn btn-primary">
                                                      Participer au débat 
                                                    </a>

                                 </main>
 