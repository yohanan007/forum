
        <!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
        <!-- page permettant de poser une question sur le forum -->
        <main class="container">
            <ul class="list-group" style="margin-top:5em;">
                <li class="list-group-item active">formulaire reponse</li>
                <form action="formulairereponse?id=${id}" method="post">
                    <li class="list-group-item"> <div class="form-group">
                        <label for="comment">votre question:</label>
                        <textarea name="comment" class="form-control" rows="8" id="comment" required></textarea>
                      </div> 
                    </li>
                    <li class="list-group-item">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </li>
                </form>
          </ul> 
                <c:if test="${erreur != null}">
                    <br>
                    
  <div class="card bg-danger text-white">
      <div class="card-body"><h4>${erreur}</h4></div>
  </div>
  </c:if>
        </main>
                   <script>
$(document).ready(function() {
  $('#comment').summernote();
});</script>