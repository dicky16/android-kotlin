<?php
include "koneksi.php";
@$nama = $_GET['nama'];
@$alamat = $_GET['alamat'];
$query_insert_data = mysqli_query($con, "INSERT INTO isibiodata (nama,alamat)   VALUES('$nama','$alamat')");
if ($query_insert_data) {
echo "Data Berhasil Disimpan";
}
else {
echo "Maaf Insert Ke Dalam Database Error" . mysqli_error($con);
}
?>