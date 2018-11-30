



        <!-- page permettant de poser une question sur le forum -->
        <main class="container">
            <ul class="list-group" style="margin-top:5em;">
                <li class="list-group-item active">formulaire question</li>
                <form action="formulairequestion?id=${sessionScope.idCategorie}" method="post">
                    <li class="list-group-item"> <div class="form-group">
                        <label for="comment">votre question:</label>
                        <textarea name="comment" class="form-control"  id="comment" required></textarea>
                      </div> 
                    </li>
                    <li class="list-group-item">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </li>
                </form>
          </ul> 
        </main>
 