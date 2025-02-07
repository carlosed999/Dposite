<?php
 
// recebimento dos dados do cadastro//

include_once (__DIR__ . "/../../modelo/dao/UsuarioDAO.php");
include_once (__DIR__ . "/../../modelo/dto/Usuario.php");

    $email = $_POST['email'];
    $nome = $_POST['nome'];
    $sobrenome = $_POST['sobrenome'];
    $senha  = $_POST['senha'];
    $telefone = $_POST['telefone'];
    

    $dao = new UsuarioDAO();
    $usuario = new Usuario();
    $usuario->setEmail($email);
    $usuario->setSenha($senha);
    $usuario->setNome($nome);
    $usuario->setSobrenome($sobrenome);
    $usuario->setTelefone($telefone);
    
    $dao->inserir($usuario);
    
    echo 'Salvo com sucesso!';
    
    
?>

