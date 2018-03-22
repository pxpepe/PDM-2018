<?php

if (isset($_GET['nome'])
	&& $_GET['nome']!='Selecionar...') {

	include('credenciais.php');
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 

	$sql = "insert into pedido (nome,descricao, atendido) values ('".$_GET['nome']."','".$_GET['desc']."',0)";
	
	$result = $conn->query($sql);
	
	$conn->close();

}
?>