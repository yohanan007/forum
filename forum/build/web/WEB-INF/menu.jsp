
        <main class="container">
        <div class="list-group" style="margin-top: 2em;">
            <p>bienvenue ${sessionScope.user.username} </p>
            
            
            <!-- liste de toutes les categorie -->
  <li class="list-group-item active">LISTE DES CATEGORIE</li>
   <c:forEach items="${categorieList}" var="categorie">
            
        <a href="question?id=<c:out value="${categorie.id_categorie}"></c:out>&&categorie=<c:out value="${categorie.nom_categorie}"></c:out>" class="list-group-item list-group-item-action"><c:out value="${categorie.nom_categorie}"></c:out> </a>
            
        </c:forEach>
        </div>
        </main>



    
        
  