<?php
include "koneksi.php";
@$nama = $_GET['nama'];
@$alamat = $_GET['alamat'];
@$id = $_GET['id'];
$query_update_biodata = mysqli_query($con, "UPDATE isibiodata SET nama='$nama', alamat='$alamat' WHERE id='$id'");
if ($query_update_biodata) {
echo "Update Data Berhasil";
}
else {
    echo mysqli_error($con);
}