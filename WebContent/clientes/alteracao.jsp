<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/js/bootstrap.min.js"></script>
    <link href="../lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/padrao.css" rel="stylesheet" type="text/css">
  </head><body>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; CLIENTES - ALTERAR UM CLIENTE &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" type="submit" onsubmit= "Chama()" name = "form" action = "../Controlador" method = "post">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Informar o CPF:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="cpf" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputNome" class="control-label">Informar o NOME:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputNome" placeholder="Nome">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEMAIL" class="control-label">Informar o EMAIL:</label>
                </div>
                <div class="col-sm-10">
                  <input type=text class="form-control" id="inputEMAIL" required>
                  <input type= "hidden" name="formulario" value = "clialt">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-danger">Alterar</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="/ProjetoWEB/clientes/index.jsp">Voltar</a>
          </div>
        </div>
      </div>
    </div>
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">© ABCTreinamentos - Curso de Java 8 para Web</div>
          </div>
        </div>
      </div>
    </footer>
  

</body></html>