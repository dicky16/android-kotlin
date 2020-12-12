<?php
include "koneksi.php";

@$id = $_GET['id'];
$query_tampil_biodata = mysqli_query($con, "SELECT * FROM isibiodata WHERE id='$id'") or die (mysqli_error($con));
$data_array = array();
$data_array = mysqli_fetch_assoc($query_tampil_biodata);
echo "[" . json_encode ($data_array) . "]";
?>