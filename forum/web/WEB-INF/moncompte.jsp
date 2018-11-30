
        <main class="container">
                       
                    
              
                  <ul class="list-group list-group-flush">
                      <li class="list-group-item ">
                          <br>
                           <h4>INFORMATION UTILISATEUR</h4>
                           <a href="#">modifié les infos</a>
                      </li>
                    <li class="list-group-item">

                    <div class="card">
                        <div class="card-body"><b> ${sessionScope.user.nom}</b></div>
                      </div>
                      <hr>
                         <div class="card">
                        <div class="card-body"><b> ${sessionScope.user.prenom}</b></div>
                      </div>
                      <hr>
                       <div class="card">
                        <div class="card-body"><b> ${sessionScope.user.username}</b></div>
                      </div>
                      <hr>
                       <div class="card">
                        <div class="card-body"><b> ${sessionScope.user.adresse_email}</b></div>
                      </div>
                      <hr>
                       <div class="card">
                        <div class="card-body"><b> ${sessionScope.user.date_de_naissance}</b></div>
                      </div>
                   
                    </li>
                    <li class="list-group-item">
                        <div class="card">
                        <div class="card-body"><a href="menu" class="btn btn-block btn-success">menu</a></div>
                      </div>
                    </li>
                    <li class="list-group-item">
                          <div class="card">
                        <div class="card-body"><a href="deconnexion" class="btn btn-block btn-danger">deconnexion</a></div>
                      </div>
                    </li>
                  </ul>
                       
                   
                   
                 
        </main>
