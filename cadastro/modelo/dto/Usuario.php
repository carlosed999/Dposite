<?php
//(dto) data tranfer, representar a classe do usuario
//90

/*//Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão 
de projetos bastante usado em Java para o transporte de dados entre 
diferentes componentes de um sistema, diferentes instâncias ou 
processos de um sistema distribuído ou diferentes sistemas via serialização.
A ideia consiste basicamente em agrupar um conjunto de atributos numa classe        
simples de forma a otimizar a comunicação./*/

class Usuario{
    
    private $id;
    
    private $nome;
    
    private $email;
    
    private $telefone;
    
    private $sobrenome;
    
    private $senha;
    
    public function getId() {
        return $this->id;
    }

    public function getNome() {
        return $this->nome;
    }

    public function getEmail() {
        return $this->email;
    }

    public function getTelefone() {
        return $this->telefone;
    }

    public function getSobrenome() {
        return $this->sobrenome;
    }

    public function getSenha() {
        return $this->senha;
    }

    public function setId($id): void {
        $this->id = $id;
    }

    public function setNome($nome): void {
        $this->nome = $nome;
    }

    public function setEmail($email): void {
        $this->email = $email;
    }

    public function setTelefone($telefone): void {
        $this->telefone = $telefone;
    }

    public function setSobrenome($sobrenome): void {
        $this->sobrenome = $sobrenome;
    }

    public function setSenha($senha): void {
        $this->senha = $senha;
    }



}




?>



