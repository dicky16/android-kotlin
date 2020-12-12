<?php
include "koneksi.php";

@$id = $_GET['id'];
$query_delete_biodata = mysqli_query($con, "DELETE FROM isibiodata WHERE id='$id'");
if ($query_delete_biodata) {
echo "Data Berhasil Dihapus";
}
else {
echo mysqli_error($con);
}
?>