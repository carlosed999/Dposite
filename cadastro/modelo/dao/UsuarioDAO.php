<?php

//pegar as informação JA MASTIGADAS, para manda para o BANCO DE DADOS//
/*//O Dao tem a função de capturar e persistir os dados de um objeto(entidade) que representa 
 * um registro em uma base de dados (uma linha em uma tabela, por exemplo).
 */

include_once (__DIR__ . "/../dto/Usuario.php");

class UsuarioDAO  {
    
    public function login($email, $senha) {
        
        $con = new mysqli("localhost", "root", "", "cadastro", 3306);
        $comando = $con->prepare(
                
                "select * from usuarios where "
                . "email = ? and  senha = md5(?)"
        );
        
        $comando -> bind_param("ss", $email, $senha);
        $comando -> execute();
        $res = $comando->get_result();
        
        if($linha=$res ->fetch_object ()){
            $u = new Usuario();
            $u -> setId($linha->id);
            $u -> setNome($linha->nome);
            $u ->setSobrenome($linha->sobrenome);
            
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

