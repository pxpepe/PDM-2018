<?php

if (isset($_GET['nome'])) {

	include('credenciais.php');
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 

	$sql = "update pedido set atendido = 1 where nome = '".$_GET['nome']."';";
	
	$result = $conn->query($sql);
	
	$conn->close();

}
?>