<?php
// Recebimento dos dados do cadastro (usuário)

include_once (__DIR__ . "/../../modelo/dao/UsuarioDAO.php");
include_once (__DIR__ . "/../../modelo/dto/Usuario.php");

$email = $_POST['email'];
$nome = $_POST['nome'];
$sobrenome = $_POST['sobrenome'];
$senha = $_POST['senha'];
$telefone = $_POST['telefone'];

$dao = new UsuarioDAO();
$usuario = new Usuario();
$usuario->setEmail($email);
$usuario->setSenha($senha);
$usuario->setNome($nome);
$usuario->setSobrenome($sobrenome);
$usuario->setTelefone($telefone);

$dao->inserir($usuario);

// Criação da resposta em formato JSON
$resposta = array(
    'status' => 'sucesso',
    'mensagem' => 'Salvo com sucesso!',
    'usuario' => array(
        'email' => $usuario->getEmail(),
        'nome' => $usuario->getNome(),
        'sobrenome' => $usuario->getSobrenome(),
        'telefone' => $usuario->getTelefone()
    )
);

// Definindo o cabeçalho para indicar que a resposta é em JSON
header('Content-Type: application/json');

// Retorna a resposta em JSON
echo json_encode($resposta);
?>
