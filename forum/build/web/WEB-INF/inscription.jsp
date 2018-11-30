
<c:if test="${sessionScope.user != null}"><c:redirect url="moncompte"></c:redirect></c:if>        
<div class="container " >
            <ul class="list-group" style="padding-top:2em;">
                <li class="list-group-item" style="background-color: #544A80; color: #C0BB95;">
              <h1>PAGE D'INSCRIPTION</h1>
              </li>
              <li class="list-group-item">
        <form method="post" action="inscription">
                    <div class="form-group">
                      <label for="username">username :</label>
                      <input type="text" name="username" class="form-control" id="username" required>
                    </div>
                    <div class="form-group">
                      <label for="email">email :</label>
                      <input type="text" name="email" class="form-control" id="email" required>
                    </div>
                    <div class="form-group">
                      <label for="nom">nom : </label>
                      <input type="text" name="nom" class="form-control" id="nom" required>
                    </div>
                     <div class="form-group">
                      <label for="prenom">prenom : </label>
                      <input type="text" name="prenom" class="form-control" id="prenom" required>
                    </div>
                    <div class="form-group">
                      <label for="dateDeNaissance">nom : </label>
                      <input type="date" name="dateDeNaissance" class="form-control" id="dateDeNaissance" required>
                    </div>
                    <div class="form-group">
                      <label for="pwd">mot de passe:</label>
                      <input type="password" name="pwd" class="form-control" id="pwd" required>
                    </div>
                    <div class="form-group">
                      <label for="pwd2">repeter votre mot de passe:</label>
                      <input type="password" name="pwd2" class="form-control" id="pwd2" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
            
        </form>
                  </li>
              <c:if test="${erreurSql != null}">
                  <li class="list-group-item">
                                        <div class="card bg-danger text-white">
                                            <div class="card-body"><h4><c:out value="${erreurSql}"></c:out></h4></div>
                      </div>
                  </li>
              </c:if>
              <c:if test="${erreurMdp != null}">
                  <li class="list-group-item">
                  
                                        <div class="card bg-danger text-white">
                                            <div class="card-body"><h4><c:out value="${erreurMdp}"></c:out></h4></div>
                      </div>
                  </li>
              </c:if>
              <c:if test="${erreurVide != null}">
                  <li class="list-group-item">
                      <div class="card bg-danger text-white">
                          <div class="card-body"><h4><c:out value="${erreurVide}"></c:out></h4></div>
                      </div>
                  </li>
              </c:if>
                  
            </ul>
        </div>
