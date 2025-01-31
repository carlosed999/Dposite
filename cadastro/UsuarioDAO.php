<?php


include_once ("Usuario.php");

class UsuarioDAO  {
    
    public function login($email, $senha) {
        
        $con = new mysqli("localhost", "root", "", "cadastro", 3306);
        $comando = $con->prepare(
                
                "select id, nome from usuarios where "
                . "email = ? and  senha = md5(?)"
        );
        
        $comando -> bind_param("ss", $email, $senha);
        $comando -> execute();
        $comando -> bind_param($id, $sobrenome);
        
        if($comando -> fetch ()){
            $u = new Usuario();
            $u -> setId($id);
            $u -> setNome($nome);
            $u -> setSobrenome($sobrenome);
            $u -> setSenha($senha);
            
        }else{
            
            $u = null;
        }
        
        $con -> close();
        
        return $u;
    }
    
    public function inserir($usuarios) {
        $con = new mysqli("localhost", "root", "", "cadastro", 3306);
        
        $comando = $con->prepare(
                
                "insert into usuarios(email, senha, nome, sobrenome, telefone) "
                . "values (?, md5(?), ?, ?, ?)"
        );
        
        $email = $usuarios -> getEmail();
        $senha = $usuarios -> getSenha();      
        $nome = $usuarios -> getNome();
        $sobrenome = $usuarios -> getSobrenome();
        $telefone = $usuarios -> getTelefone();
        
        $comando -> bind_param("sssss", $email,$senha, $nome, $sobrenome, $telefone );
        
        $comando -> execute();
        
        $con -> close();
     
        
    }
}

?>

