<?php

header("Content-type: text/json");

include_once (__DIR__ . "/../../modelo/dao/UsuarioDAO.php");

$email = $_POST["email"];
$senha = $_POST["senha"];

$dao = new UsuarioDAO();
$u = $dao->login($email, $senha);

if ($u != null) {
    $resposta = [
        "mensagem" => "Usuario autenticado com sucesso",
        "usuario" => [
            "id" => $u->getId(),
            "nome" => $u->getNome()
        ]
    ];

    echo json_encode($resposta);
} else {
    $resposta = [
        "mensagem" => "Usuario ou senha errados",
        "usuario" => null
    ];
     echo json_encode($resposta);
}
?>



