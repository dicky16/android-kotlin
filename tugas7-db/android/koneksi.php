<?php 
$server = "localhost";
$username = "root";
$password = "";
$database = "tabelbiodata";

$con = mysqli_connect($server, $username, $password) or die("<h1>Koneksi Mysqli Error : </h1>" .   mysqli_connect_error());
mysqli_select_db($con, $database) or die("<h1>Koneksi Kedatabase Error : </h1>" . mysqli_error($con)); ?>