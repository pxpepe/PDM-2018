<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1" >
<title>Lista de espera</title>
</head>

<body>
<?php
include('credenciais.php');
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT * FROM pedido where atendido = 0";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo $row["instante"] . '  --  ' . $row["nome"].'  --  ' . $row["descricao"]. "<br>";
    }
} else {
    echo "0 results";
}
$conn->close();
?>
</body>

</html>