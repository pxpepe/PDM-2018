<?php

$servername = "localhost";
$username = "nome_utilizaor";
$password = "palavra chave";
$dbname = "nome base de dados";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysql_set_charset('utf8',$conn);

?>